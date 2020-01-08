package perococco.aoc.computer.primitive._private;

import lombok.NonNull;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.io.ProgramIO;
import perococco.aoc.computer.common.*;
import perococco.aoc.computer.primitive._private.operations.Operation;

public class Processor {

    @NonNull
    public static ExecutionResult execute(
            @NonNull String name,
            @NonNull Memory memory,
            @NonNull ProgramIO<?,?> programIo) {
        return new Processor(name, memory, programIo).execute();
    }

    @NonNull
    private final Memory memory;

    @NonNull
    private final ExecutionContext context;

    private Addressing addressing = new Addressing(0, 0);

    private boolean done = false;

    private Processor(
            @NonNull String name,
            @NonNull Memory memory,
            @NonNull ProgramIO<?,?> programIo) {
        this.memory = memory;
        this.context = new ExecutionContext(name, memory, programIo);
    }

    @NonNull
    public ExecutionResult execute() {
        while (!done) {
            executeOneInstruction();
        }
        return new ExecutionResult(memory.hasMemoryAccessors(),context.listOfOutputs());
    }

    private void executeOneInstruction() {
        if (done) {
            return;
        }
        final Operation operation;
        final Modes modes;
        final boolean stopInstruction;
        {
            final Instruction instruction = parseInstruction();
            operation = OpCode.get(instruction.opCode());
            modes = instruction.modes();
            stopInstruction = instruction.stopInstruction();
        }

        this.context.initBeforeExecution(addressing,modes);

        final AddressingUpdater cursorModifier = operation.perform(this.context);
        addressing = cursorModifier.updateAddressing(addressing);

        done = stopInstruction;
    }

    @NonNull
    private Instruction parseInstruction() {
        final long instructionCode = memory.getValueAt(addressing.absoluteBase());
        addressing = addressing.moveAbsoluteByOne();

        return new Instruction(Long.toString(instructionCode));
    }
}
