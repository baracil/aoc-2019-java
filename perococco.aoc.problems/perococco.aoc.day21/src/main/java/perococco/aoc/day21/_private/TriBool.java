package perococco.aoc.day21._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public enum  TriBool {
    TRUE("T"),
    FALSE("F"),
    ANY("A"),
    ;

    @Getter
    private final String code;

    public boolean isSimilarTo(TriBool value) {
        if (this == ANY || value == ANY) {
            return true;
        }
        return this == value;
    }

    @NonNull
    public TriBool compose(@NonNull TriBool other) {
        switch (other) {
            case TRUE: return TRUE;
            case FALSE: return FALSE;
            default:
                return this;
        }
    }
}
