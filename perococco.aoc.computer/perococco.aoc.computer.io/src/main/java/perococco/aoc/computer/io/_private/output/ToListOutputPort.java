package perococco.aoc.computer.io._private.output;

import lombok.NonNull;
import perococco.aoc.computer.io.OutputTransformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToListOutputPort<R> extends BaseOutputPort<List<R>,R> {

    @NonNull
    private final List<R> result;

    public ToListOutputPort(@NonNull OutputTransformer<R> outputTransformer) {
        super(outputTransformer);
        this.result = new ArrayList<>();
    }

    @Override
    public void write(@NonNull R value) {
        result.add(value);
    }

    @NonNull
    @Override
    public List<R> programOutputAccessor() {
        return Collections.unmodifiableList(result);
    }
}
