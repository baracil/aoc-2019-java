package perococco.aoc.day11;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.ProgramBasedAOCProblem;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;

public abstract class Day11Problem extends ProgramBasedAOCProblem<String> {

    public Day11Problem(@NonNull Part part) {
        super(Day.DAY_11, part);
    }

    @NonNull
    @Override
    public String solution() {
        return solve(getProgram());
    }

    protected abstract String solve(@NonNull Program program);
}
