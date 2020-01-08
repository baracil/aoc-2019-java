package perococco.aoc.computer._private.generic;

import lombok.NonNull;
import perococco.aoc.common.Parser;

public interface Interpreter<V> extends Parser<V> {

    int convertToAddress(V value);

    @NonNull
    Instruction<V> parseInstruction(V value);
}
