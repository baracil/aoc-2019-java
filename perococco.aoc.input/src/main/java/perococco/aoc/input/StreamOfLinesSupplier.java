package perococco.aoc.input;

import lombok.NonNull;

import java.util.stream.Stream;

public interface StreamOfLinesSupplier {

    @NonNull
    Stream<String> lines();

}
