package perococco.aoc.computer._private.primitive;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;
import perococco.aoc.computer.IO;
import perococco.aoc.computer._private.Addressing;
import perococco.aoc.computer._private.Modes;

@RequiredArgsConstructor
public class ExecutionContext<V> implements ParameterAccessor<V> {

    @Getter
    private final String executionName;

    @NonNull
    private final MemoryOfPrimitive memory;

    private final IO io;

    private Modes modes;

    private Addressing addressing;

    @Override
    public V getParameter(int position) {
        //TODO
        throw new AOCException("Not implemented");
    }


    @Override
    public void setParameter(int position,@NonNull V value) {
        //TODO
        throw new AOCException("Not implemented");
    }

    public int convertToAddress(V value) {
        return interpreter.convertToAddress(value);
    }

    public void initBeforeExecution(@NonNull Addressing addressing, @NonNull Modes modes) {
        this.modes = modes;
        this.addressing = addressing;
    }

    public V readFromInput() {
        return interpreter.toValue(io.readFromInput());
    }
}
