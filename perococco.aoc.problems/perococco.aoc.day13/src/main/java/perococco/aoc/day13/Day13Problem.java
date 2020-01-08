package perococco.aoc.day13;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.ProgramBasedAOCProblem;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;

public abstract class Day13Problem extends ProgramBasedAOCProblem<String> {

    public Day13Problem(@NonNull Part part) {
        super(Day.DAY_13, part);
    }

    @NonNull
    @Override
    public String solution() {
        return solve(getProgram());
    }

    abstract String solve(Program program);

}
