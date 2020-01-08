package perococco.aoc.day16;

import lombok.NonNull;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;
import perococco.aoc.input.SingleLineAOCProblem;

public abstract class Day16Problem extends SingleLineAOCProblem<String> {

    public Day16Problem(@NonNull Part part) {
        super(Day.DAY_16, part);
    }

    public Day16Problem(@NonNull Part part, @NonNull String line) {
        super(Day.DAY_16, part, line);
    }

    @NonNull
    @Override
    public String solution() {
        final Signal signal = new Signal(getInput());
        return solve(signal);
    }

    protected abstract String solve(@NonNull Signal signal);
}
