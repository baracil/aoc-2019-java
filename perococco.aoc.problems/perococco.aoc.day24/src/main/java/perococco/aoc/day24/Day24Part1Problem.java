package perococco.aoc.day24;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.day24._private.BugColony;
import perococco.aoc.day24._private.Position;
import perococco.aoc.day24._private.part1.Nature;
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
    int solve(@NonNull BugColony colony) {
        final Nature nature = Nature.create();
        final Set<Integer> seens = new HashSet<>();
        int current = colony.bugPositionsStream().mapToInt(this::positionToPower).reduce(0,Day24Part1Problem::or);
        do {
            if (!seens.add(current)) {
                return current;
            }
            current = nature.evolve(current);
        } while (true);

    }

    private int positionToPower(@NonNull Position position) {
        return 1<<(position.x()+5*position.y());
    }

    private static int or(int v1, int v2) {
        return v1|v2;
    }
}
