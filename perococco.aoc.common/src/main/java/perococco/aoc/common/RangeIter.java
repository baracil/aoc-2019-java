package perococco.aoc.common;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public class RangeIter {

    public static RangeIter with(int size) {
        return new RangeIter(size);
    }

    private final int size;

    @NonNull
    public <T> Stream<T> map(@NonNull IntFunction<? extends T> mapper) {
        return IntStream.range(0,size).mapToObj(mapper);
    }
}
