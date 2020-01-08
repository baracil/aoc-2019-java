package perococco.aoc.day18._private.algo;

import lombok.Getter;
import lombok.NonNull;
import lombok.Value;
import perococco.aoc.day18._private.Key;

@Value
public class Trip {

    @NonNull
    @Getter
    private final Key from;

    @NonNull
    @Getter
    private final Key to;

    @Override
    public String toString() {
        return "Trip( " + from.id() + " -> " + to.id() +" )";
    }
}
