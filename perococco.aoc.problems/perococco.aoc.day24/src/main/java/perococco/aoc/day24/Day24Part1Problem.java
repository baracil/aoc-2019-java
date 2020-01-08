package perococco.aoc.day24;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Part;

import java.util.HashSet;
import java.util.Set;

/**
 * @author perococco
 **/
public class Day24Part1Problem extends Day24Problem {

    public Day24Part1Problem() {
        super(Part.PART_1);
    }

    public Day24Part1Problem(@NonNull ImmutableList<String> lines) {
        super(Part.PART_1, lines);
    }

    @Override
    protected int solve(int initialLayout) {
        final Nature nature = Nature.create();
        final Set<Integer> seens = new HashSet<>();
        int current = initialLayout;
        do {
            if (!seens.add(current)) {
                return current;
            }
            current = nature.evolve(current);
        } while (true);

    }
}
