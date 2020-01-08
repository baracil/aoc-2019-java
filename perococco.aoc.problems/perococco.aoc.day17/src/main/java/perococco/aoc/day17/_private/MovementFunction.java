package perococco.aoc.day17._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;

@RequiredArgsConstructor
public enum MovementFunction {
    A("A"),
    B("B"),
    C("C"),
;

    public boolean hasNext() {
        return this!=C;
    }

    @NonNull
    public MovementFunction next() {
        switch (this) {
            case A: return B;
            case B: return C;
            default:
                throw new AOCException("No more function available");
        }
    }
    @Getter
    private final String code;

    public MovementFunction nextOrNull() {
        if (hasNext()) {
            return next();
        }
        return null;
    }
}
