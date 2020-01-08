package perococco.aoc.day12.computation;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class MoonFactory {

    @NonNull
    public static ImmutableList<Moon> createMoons(@NonNull ImmutableList<String> input) {
        return new MoonFactory(input).create();
    }

    @NonNull
    private final ImmutableList<String> input;

    @NonNull
    public ImmutableList<Moon> create() {
        return IntStream.range(0,input.size())
                 .mapToObj(this::createMoon)
                 .collect(ImmutableList.toImmutableList());
    }

    @NonNull
    private Moon createMoon(int index) {
        final Vector position = Vector.parse(input.get(index));
        return Moon.create(position);
    }

}
