package perococco.aoc.computer.io._private.input;

import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Nil;
import perococco.aoc.computer.io._private.InputPort;

public class NoInputPort implements InputPort<Nil> {

    @Override
    public @NonNull String read() {
        throw new AOCException("No input available");
    }

    @NonNull
    @Override
    public Nil programInputAccessor() {
        return Nil.NIL;
    }

}
