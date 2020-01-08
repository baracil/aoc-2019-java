package perococco.aoc.input;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class StreamOfLinesFromSomeLines implements StreamOfLinesSupplier {

    @NonNull
    private final ImmutableList<String> lines;

    @Override
    public @NonNull Stream<String> lines() {
        return lines.stream();
    }
}
