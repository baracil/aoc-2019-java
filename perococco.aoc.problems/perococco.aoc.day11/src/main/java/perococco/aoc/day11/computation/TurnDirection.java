package perococco.aoc.day11.computation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.EnumHelper;

@RequiredArgsConstructor
public enum TurnDirection {
    LEFT("0", Instruction.TURN_LEFT),
    RIGHT("1", Instruction.TURN_RIGHT),
    ;

    @Getter
    private final String code;

    @NonNull
    @Getter
    private final Instruction instruction;

    @NonNull
    public static TurnDirection decode(String code) {
        return Holder.HELPER.get(code);
    }

    private static class Holder {

        private static final EnumHelper<String,TurnDirection> HELPER = EnumHelper.create(TurnDirection.class, t->t.code);
    }
}
