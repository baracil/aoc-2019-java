package perococco.aoc.computer.io._private.output;

import lombok.NonNull;
import perococco.aoc.common.Nil;
import perococco.aoc.computer.io.OutputTransformer;

public class ToSdtOutputPort<T> extends BaseOutputPort<Nil,T> {

    public ToSdtOutputPort(@NonNull OutputTransformer<T> outputTransformer) {
        super(outputTransformer);
    }

    @Override
    public void write(@NonNull T value) {
        System.out.print(value);
    }

    @NonNull
    @Override
    public Nil programOutputAccessor() {
        return Nil.NIL;
    }

}
