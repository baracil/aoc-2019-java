package perococco.aoc.day10.computation;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;

import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpaceMap<T> {

    @NonNull
    private final ImmutableList<T> items;

    @Getter
    private final int width;

    @Getter
    private final int height;

    public SpaceMap(@NonNull ImmutableList<T> items, int width, int height) {
        assert items.size() == width*height;
        this.items = items;
        this.width = width;
        this.height = height;
    }

    @NonNull
    public ImmutableList<Position> listPositionsMatching(@NonNull Predicate< ? super T> predicate) {
        return IntStream.range(0,items.size())
                 .filter(i -> predicate.test(items.get(i)))
                 .mapToObj(this::toPosition)
                 .collect(ImmutableList.toImmutableList());
    }

    @NonNull
    private Position toPosition(int itemIndex) {
        return Position.create(itemIndex%width,itemIndex/width);
    }

    @NonNull
    protected String toString(@NonNull T item) {
        return String.valueOf(item);
    }

    @NonNull
    public ImmutableList<String> dump() {
        return IntStream.range(0,height)
                        .map(h -> h*width)
                        .mapToObj(i -> IntStream.range(i, i+width)
                                  .mapToObj(items::get)
                                  .map(this::toString)
                                  .collect(Collectors.joining())
                        ).collect(ImmutableList.toImmutableList());
    }


    @NonNull
    public static <T> Collector<String,?,SpaceMap<T>> collector(@NonNull IntFunction<T> singleCharConverter) {
        return new SpaceMapCollector<>(singleCharConverter);
    }



    @RequiredArgsConstructor
    public static class SpaceMapCollector<T> implements Collector<String,SpaceMapCollector.Accumulator<T>,SpaceMap<T>> {


        private static final Set<Characteristics> CHARACTERISTICS = Set.of();

        @NonNull
        private final IntFunction<T> singleCharConverter;

        @Override
        public Supplier<Accumulator<T>> supplier() {
            return () -> new Accumulator<>(singleCharConverter);
        }

        @Override
        public BiConsumer<Accumulator<T>,String> accumulator() {
            return Accumulator::addLine;
        }

        @Override
        public BinaryOperator<Accumulator<T>> combiner() {
            return Accumulator::merge;
        }

        @Override
        public Function<Accumulator<T>,SpaceMap<T>> finisher() {
            return Accumulator::build;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return CHARACTERISTICS;
        }

        @RequiredArgsConstructor
        public static class Accumulator<T> {

            @NonNull
            private final IntFunction<T> singleCharConverter;

            private int width = -1;

            private int height = 0;

            private final ImmutableList.Builder<T> types = ImmutableList.builder();

            public void addLine(String str) {
                if (width>=0 && width != str.length()) {
                    throw new AOCException("Invalid input : lines with different width");
                }
                str.chars().mapToObj(singleCharConverter).forEach(types::add);
                width = str.length();
                height ++;
            }

            @NonNull
            public static <T> SpaceMap.SpaceMapCollector.Accumulator<T> merge(@NonNull SpaceMap.SpaceMapCollector.Accumulator<T> b1,@NonNull SpaceMap.SpaceMapCollector.Accumulator<T> b2) {
                if (b1.height == 0) {
                    return b2;
                }
                else if (b2.height == 0) {
                    return b1;
                }
                if (b1.width != b2.width) {
                    throw new AOCException("Invalid input : lines with different width");
                }
                b1.types.addAll(b2.types.build());
                b1.height+=b2.height;
                return b1;
            }

            @NonNull
            public SpaceMap<T> build() {
                return new SpaceMap<>(types.build(), width, height);
            }
        }
    }
}
