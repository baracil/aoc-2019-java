package perococco.aoc.day24;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.day24._private.BugColony;
import perococco.aoc.input.Day;
import perococco.aoc.input.MultiLineAOCProblem;
import perococco.aoc.input.Part;

/**
 *
 *   .......  0   -    6
 *   .xxxxx.  7  8-12 13
 *   .xxxxx. 14 15-19 20
 *   .xxxxx. 21 22-36 27
 *   .xxxxx. 28 29-33 34
 *   .xxxxx. 35 36-40 41
 *   ....... 42   -   48
 *
 * @author perococco
 **/
public abstract class Day24Problem extends MultiLineAOCProblem<Integer> {

    public Day24Problem(@NonNull Part part) {
        super(Day.DAY_24,part,5);
    }
    public Day24Problem(@NonNull Part part,@NonNull ImmutableList<String> lines) {
        super(Day.DAY_24, part, 5, lines::stream);
    }

    @NonNull
    @Override
    public Integer solution() {
        final BugColony colony = BugColony.create(getInput());
        return solve(colony);
    }

    abstract int solve(@NonNull BugColony initialLayout);


}
