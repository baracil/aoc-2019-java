package perococco.aoc.computer.io._private.input;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Nil;
import perococco.aoc.computer.io._private.InputPort;

public class InputPortFromList implements InputPort<Nil> {

    @NonNull
    private final ImmutableList<String> data;

    private int cursor = 0;

    public InputPortFromList(@NonNull ImmutableList<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public String read() {
        if (cursor>=data.size()) {
            throw new AOCException("No more input available");
        };
        return data.get(cursor++);
    }

    @NonNull
    @Override
    public Nil programInputAccessor() {
        return Nil.NIL;
    }
}
