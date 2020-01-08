package perococco.aoc.day19;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.ProgramBasedAOCProblem;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;

public abstract class Day19Problem extends ProgramBasedAOCProblem<Integer> {

    public Day19Problem(@NonNull Part part) {
        super(Day.DAY_19, part);
    }

    @NonNull
    @Override
    public Integer solution() {
        final Program program = getProgram();
        return solve(program);
    }

    abstract int solve(@NonNull Program program);

}
