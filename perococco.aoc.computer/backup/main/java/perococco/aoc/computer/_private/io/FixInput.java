package perococco.aoc.computer._private.io;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer.Input;

@RequiredArgsConstructor
public class FixInput implements Input {

    @NonNull
    private final ImmutableList<String> inputs;

    private int cursor;

    @Override
    public String readFromInput() {
        return inputs.get(cursor++);
    }
}
