package perococco.aoc.day11.computation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.EnumHelper;

@RequiredArgsConstructor
public enum Color {
    BLACK("0", Instruction.PAINT_BLACK),
    WHITE("1", Instruction.PAINT_WHITE),
    ;

    @Getter
    @NonNull
    private final String code;

    @NonNull
    @Getter
    private final Instruction instruction;

    @NonNull
    public static Color decode(@NonNull String code) {
        return Holder.HELPER.get(code);
    }

    private static class Holder {

        private static final EnumHelper<String,Color> HELPER = EnumHelper.create(Color.class,c -> c.code);
    }
}
