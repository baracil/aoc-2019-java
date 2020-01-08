package perococco.aoc.computer._private.primitive;

import lombok.NonNull;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.IO;
import perococco.aoc.computer._private.Addressing;
import perococco.aoc.computer._private.AddressingUpdater;
import perococco.aoc.computer._private.Modes;
import perococco.aoc.computer._private.SaveInListOutput;
import perococco.aoc.computer._private.operations.Operation;

public class Execution {

    @NonNull
    public static <V> ExecutionResult execute(
            @NonNull String name,
            @NonNull MemoryOfPrimitive memory,
            @NonNull IO io) {
        return new Execution(name, memory, io).execute();
    }

    @NonNull
    private final MemoryOfPrimitive memory;

    @NonNull
    private final ExecutionContext context;

    @NonNull
    private final SaveInListOutput output;

    private Addressing addressing = new Addressing(0, 0);

    private boolean done = false;

    private Execution(
            @NonNull String name,
            @NonNull MemoryOfPrimitive memory,
            @NonNull IO io) {
        this.memory = memory;
        this.output = new SaveInListOutput();
        this.context = new ExecutionContext(name, memory, io.then(this.output));
    }

    @NonNull
    public ExecutionResult execute() {
        while (!done) {
            executeOneInstruction();
        }
        return new ExecutionResult(memory.hasMemoryAccessors(),output.listOfOutputs());
    }

    private void executeOneInstruction() {
        if (done) {
            return;
        }
        final Operation operation;
        final Modes modes;
        final boolean stopInstruction;
        {
            final Instruction<V> instruction = parseInstruction();
            operation = instruction.operation();
            modes = instruction.modes();
            stopInstruction = instruction.stopInstruction();
        }

        this.context.initBeforeExecution(addressing,modes);

        final AddressingUpdater cursorModifier = operation.perform(this.context);
        addressing = cursorModifier.updateAddressing(addressing);

        done = stopInstruction;
    }

    @NonNull
    private Instruction<V> parseInstruction() {
        final V instructionCode = memory.getValueAt(addressing.absoluteBase());
        addressing = addressing.moveAbsoluteByOne();

        return interpreter.parseInstruction(instructionCode);
    }
}
