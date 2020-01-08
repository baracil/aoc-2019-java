package perococco.aoc.day14.computation;

import lombok.NonNull;
import lombok.Value;

@Value
public class Reactant {

    @NonNull
    private final Chemical chemical;

    private final int amount;

    @Override
    public String toString() {
        return String.format("%d %s",amount,chemical);
    }
}
