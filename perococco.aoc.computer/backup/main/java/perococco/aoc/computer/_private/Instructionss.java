package perococco.aoc.computer._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.CodedEnumHelper;
import perococco.aoc.computer._private.generic.ExecutionContext;
import perococco.aoc.computer._private.operations.Operation;
import perococco.aoc.computer._private.operations.Operations;

@RequiredArgsConstructor
public enum Instructionss {
    ADD(1, Operations.ADD),
    MULTIPLY(2,Operations.MULTIPLY),
    INPUT(3, Operations.INPUT),
    OUTPUT(4, Operations.OUTPUT),
    JUMP_IF_TRUE(5,Operations.JUMP_IF_TRUE),
    JUMP_IF_FALSE(6,Operations.JUMP_IF_FALSE),
    LESS_THAN(7,Operations.LESS_THAN),
    EQUALS(8,Operations.EQUALS),


    STOP(99, Operation.nop())
    ;

    @Getter
    private final int opCode;

    @NonNull
    private final Operation operation;

    public AddressingUpdater execute(@NonNull ExecutionContext context) {
        return operation.perform(context);
    }

    public boolean isStop() {
        return this==STOP;
    }

    @NonNull
    public static Instructionss getInstruction(int opCode) {
        return Holder.HELPER.get(opCode);
    }


    private static class Holder {

        private static final CodedEnumHelper<Instructionss> HELPER = new CodedEnumHelper<>(Instructionss.class, i -> i.opCode);

    }
}
