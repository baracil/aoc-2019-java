package perococco.aoc.day21._private;

import lombok.NonNull;

/**
 * @author perococco
 **/
public interface TruthTable {

    int nbParameters();

    @NonNull
    TriBool value(int parameters);
}
