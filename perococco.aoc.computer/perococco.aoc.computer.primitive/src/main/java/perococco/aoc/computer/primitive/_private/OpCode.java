package perococco.aoc.computer.primitive._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.CodedEnumHelper;
import perococco.aoc.common.Encoded;
import perococco.aoc.computer.common.AddressingUpdater;
import perococco.aoc.computer.primitive._private.operations.Operation;
import perococco.aoc.computer.primitive._private.operations.Operations;

@RequiredArgsConstructor
public enum OpCode implements Operation, Encoded {
    ADD(1, Operations.ADD),
    MULTIPLY(2,Operations.MULTIPLY),
    INPUT(3,Operations.INPUT),
    OUTPUT(4,Operations.OUTPUT),
    JUMP_IF_TRUE(5,Operations.JUMP_IF_TRUE),
    JUMP_IF_FALSE(6,Operations.JUMP_IF_FALSE),
    LESS_THAN(7,Operations.LESS_THAN),
    EQUALS(8,Operations.EQUALS),
    ADJUST_RELATIVE_BASE(9,Operations.ADJUST_RELATIVE_BASE),

    STOP(99, Operation.nop())
    ;

    @Getter
    private final int code;

    @NonNull
    private final Operation operation;

    public static Operation get(String opCode) {
        return Holder.HELPER.get(Integer.parseInt(opCode));
    }

    @Override
    public @NonNull AddressingUpdater perform(@NonNull ExecutionContext context) {
        return operation.perform(context);
    }


    private static class Holder {

        private static final CodedEnumHelper<OpCode> HELPER = CodedEnumHelper.create(OpCode.class);
    }

}
