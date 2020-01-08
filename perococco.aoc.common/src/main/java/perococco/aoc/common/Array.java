package perococco.aoc.common;

import lombok.NonNull;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collector;

/**
 * @author perococco
 **/
public class Array<T> extends BaseArray {

    @NonNull
    private final T[] data;

    @NonNull
    private final T filling;

    public Array(@NonNull T[] data, @NonNull T filling, int width, int height) {
        super(width, height);
        this.data = data;
        this.filling = filling;
    }

    @NonNull
    public T get(@NonNull Position position) {
        if (isPositionInRange(position)) {
            return data[positionToIndex(position)];
        }
        return filling;
    }

    @Override
    protected void printSingleElement(@NonNull PrintStream printStream, int elementIndex) {
        System.out.print(data[elementIndex]);
    }

    @NonNull
    public static <T> Collector<String,?,Array<T>> collector(
            @NonNull Function<? super String, ? extends T[]> lineTransformer,
            @NonNull T filling,
            @NonNull IntFunction<? extends T[]> arrayCreator) {
        return baseCollector(lineTransformer,
                             a -> a.length, arrayCreator,
                             a -> Arrays.fill(a,filling),
                             (s,d,o) ->System.arraycopy(s,0,d,o,s.length),
                             (a,w,h) -> new Array<>(a,filling,w,h)
        );
    }
}
