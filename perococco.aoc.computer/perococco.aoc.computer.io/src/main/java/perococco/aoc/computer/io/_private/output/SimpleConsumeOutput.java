package perococco.aoc.computer.io._private.output;

import lombok.NonNull;
import perococco.aoc.common.Nil;

import java.util.function.Consumer;

public class SimpleConsumeOutput extends BaseOutputPort<Nil,String> {

    private final Consumer<? super String> consumer;

    public SimpleConsumeOutput(
            Consumer<? super String> consumer) {
        super(s -> s);
        this.consumer = consumer;
    }

    @Override
    public void write(@NonNull String value) {
        consumer.accept(value);
    }

    @NonNull
    @Override
    public Nil programOutputAccessor() {
        return Nil.NIL;
    }
}
