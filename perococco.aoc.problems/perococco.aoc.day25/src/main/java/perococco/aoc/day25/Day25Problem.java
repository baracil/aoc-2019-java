package perococco.aoc.day25;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.ProgramBasedAOCProblem;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;

/**
 * @author perococco
 **/
public abstract class Day25Problem extends ProgramBasedAOCProblem<Integer> {

    public Day25Problem(@NonNull Part part) {
        super(Day.DAY_25,part);
    }

    @NonNull
    @Override
    public Integer solution() {
        return solve(getProgram());
    }

    protected abstract int solve(Program program);


}
