package perococco.aoc.day10.computation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.CodedEnumHelper;
import perococco.aoc.common.Encoded;

@RequiredArgsConstructor
public enum Type implements Encoded {
    EMPTY('.'),
    ASTEROID('#'),
    ;

    @Getter
    private final int code;

    @Getter
    private final String representation;

    Type(char code) {
        this.code = code;
        this.representation = String.valueOf(code);
    }

    @NonNull
    public static Type getType(int code) {
        return Holder.HELPER.get(code);
    }

    private static class Holder {
        private static final CodedEnumHelper<Type> HELPER = CodedEnumHelper.create(Type.class);

    }
}
