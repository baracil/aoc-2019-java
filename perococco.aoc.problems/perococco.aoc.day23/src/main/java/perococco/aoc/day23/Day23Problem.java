package perococco.aoc.day23;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.ProgramBasedAOCProblem;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;

/**
 * @author perococco
 **/
public abstract class Day23Problem extends ProgramBasedAOCProblem<String> {

    public Day23Problem(@NonNull Part part) {
        super(Day.DAY_23,part);
    }

    @NonNull
    @Override
    public String solution() {
        final Program program = getProgram();

        return solve(program);
    }

    protected abstract String solve(@NonNull Program program);

}
