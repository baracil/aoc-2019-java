package perococco.aoc.day15.computation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum  TileType {
    WALL("\u2588"),
    EMPTY(" "),
    START("*"),
    OXYGEN("o"),
    UNKNOWN("?")
    ;

    public boolean canWalkThere() {
        return this == EMPTY || this == OXYGEN || this == START;
    }

    @NonNull
    @Getter
    private final String representation;
}
