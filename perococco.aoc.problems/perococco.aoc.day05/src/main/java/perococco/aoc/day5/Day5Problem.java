package perococco.aoc.day5;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.ProgramBasedAOCProblem;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;

public abstract class Day5Problem extends ProgramBasedAOCProblem<String> {

    public Day5Problem(@NonNull Part part) {
        super(Day.DAY_5,part);
    }

    @NonNull
    @Override
    public String solution() {
        final Program program = getProgram();

        return solve(program);
    }

    protected abstract String solve(@NonNull Program program);

}
