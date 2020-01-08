package perococco.aoc.computer.io._private.output;

import lombok.NonNull;
import perococco.aoc.computer.io.OutputTransformer;
import perococco.aoc.computer.io.ProgramOutput;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ControllerOutputPort<T> extends BaseOutputPort<ProgramOutput<T>,T> {

    private final BlockingDeque<T> bridge = new LinkedBlockingDeque<>();

    public ControllerOutputPort(@NonNull OutputTransformer<T> outputTransformer) {
        super(outputTransformer);
    }

    @Override
    public void write(@NonNull T value) {
        bridge.addLast(value);
    }

    @NonNull
    @Override
    public ProgramOutput<T> programOutputAccessor() {
        return bridge::takeFirst;
    }
}
