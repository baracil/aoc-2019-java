package perococco.aoc.day24;

import lombok.NonNull;
import perococco.aoc.day24._private.BugColony;
import perococco.aoc.input.Part;

/**
 * @author perococco
 **/
public class Day24Part2Problem extends Day24Problem {

    public Day24Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    int solve(@NonNull BugColony colony) {
        BugColony current = colony.evolve(200);
        return current.size();
    }
}
