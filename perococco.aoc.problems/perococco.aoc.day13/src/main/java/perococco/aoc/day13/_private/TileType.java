package perococco.aoc.day13._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.EnumHelper;

@RequiredArgsConstructor
public enum TileType {
    EMPTY("0"," "),
    WALL("1","|"),
    BLOCK("2","#"),
    HORIZONTAL_PADDLE("3","_"),
    BALL("4","o"),
    ;

    @NonNull
    private final String code;

    @NonNull
    @Getter
    private final String representation;

    @NonNull
    public static TileType decode(@NonNull String code) {
        return Holder.HELPER.get(code);
    }


    private static class Holder {

        private static final EnumHelper<String,TileType> HELPER = EnumHelper.create(TileType.class, t -> t.code);
    }
}
