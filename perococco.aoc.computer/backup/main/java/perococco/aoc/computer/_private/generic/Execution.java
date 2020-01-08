package perococco.aoc.computer._private.generic;

import lombok.NonNull;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.IO;
import perococco.aoc.computer._private.operations.Operation;

public class Execution<V> {

    @NonNull
    public static <V> ExecutionResult execute(
            @NonNull String name,
            @NonNull Memory<V> memory,
            @NonNull IO io,
            @NonNull Interpreter<V> interpreter) {
        return new Execution<>(name, memory, io, interpreter).execute();
    }

    @NonNull
    private final Memory<V> memory;

    @NonNull
    private final ExecutionContext<V> context;

    @NonNull
    private final Interpreter<V> interpreter;

    @NonNull
    private final SaveInListOutput output;

    private Addressing addressing = new Addressing(0, 0);

    private boolean done = false;

    private Execution(
            @NonNull String name,
            @NonNull Memory<V> memory,
            @NonNull IO io,
            @NonNull Interpreter<V> interpreter) {
        this.memory = memory;
        this.output = new SaveInListOutput();
        this.interpreter = interpreter;
        this.context = new ExecutionContext<>(name, memory, interpreter, io.then(this.output));
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
        final Operation<V> operation;
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
