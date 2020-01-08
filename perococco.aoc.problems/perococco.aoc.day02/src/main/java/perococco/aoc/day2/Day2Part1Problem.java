package perococco.aoc.day2;

import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.Program;

public class Day2Part1Problem extends Day2Problem {

    public Day2Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    protected String solve(@NonNull Program program) {
        final Alterations alterations = Alterations.none().addAlterations(1, "12", "2");
        final ExecutionResult result = program.launchAndWait("Day2 Part1", alterations);
        return result.getFirstValueOfMemory();
    }

}
