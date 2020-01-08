package perococco.aoc.day24._private.part1;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *  *  *   f(i) = 1 + !1.2.!i = 1 + 2.!i
 * @author perococco
 **/
@RequiredArgsConstructor
public class SubLayout {

    private final int mask;
    private final int borderMask;

    @NonNull
    private final ImmutableMap<Integer,Masks> cacheMap;

    public int apply(int layout) {
        final int border = layout&borderMask;
        final int subLayout = layout&mask;
        final Masks cache = cacheMap.get(border);

        return cache.one() | ( cache.two() & ~subLayout );
    }
}
