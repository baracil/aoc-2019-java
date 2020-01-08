package perococco.aoc.computer.io._private.output;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer.io.OutputTransformer;
import perococco.aoc.computer.io._private.OutputPort;

@RequiredArgsConstructor
public abstract class BaseOutputPort<I,W> implements OutputPort<I,W> {

    @NonNull
    private final OutputTransformer<W> outputTransformer;

    @Override
    public void transformAndWrite(@NonNull String value) {
        write(outputTransformer.apply(value));
    }
}
