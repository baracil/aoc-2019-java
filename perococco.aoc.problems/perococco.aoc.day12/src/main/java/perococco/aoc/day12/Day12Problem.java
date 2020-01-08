package perococco.aoc.day12;

import lombok.NonNull;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;
import perococco.aoc.day12.computation.MoonSystem;
import perococco.aoc.input.MultiLineAOCProblem;

public abstract class Day12Problem extends MultiLineAOCProblem<String> {

    public Day12Problem(@NonNull Part part) {
        super(Day.DAY_12, part,4);
    }

    @NonNull
    @Override
    public String solution() {
        final MoonSystem moonSystem = MoonSystem.build(getInput());
        return solve(moonSystem);
    }

    abstract String solve(@NonNull MoonSystem moonSystem);

}
