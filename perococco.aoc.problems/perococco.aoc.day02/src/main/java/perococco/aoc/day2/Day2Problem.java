package perococco.aoc.day2;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.ProgramBasedAOCProblem;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;

public abstract class Day2Problem extends ProgramBasedAOCProblem<String> {

    public Day2Problem(@NonNull Part part) {
        super(Day.DAY_2, part);
    }

    @NonNull
    @Override
    public String solution() {
        final Program program = getProgram();
        return solve(program);
    }

    protected abstract String solve(@NonNull Program program);


}
