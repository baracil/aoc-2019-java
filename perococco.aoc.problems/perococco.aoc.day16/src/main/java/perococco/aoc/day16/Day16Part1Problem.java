package perococco.aoc.day16;

import lombok.NonNull;
import perococco.aoc.input.Part;

public class Day16Part1Problem extends Day16Problem {

    public Day16Part1Problem() {
        super(Part.PART_1);
    }

    public Day16Part1Problem(@NonNull String line) {
        super(Part.PART_1, line);
    }

    @Override
    protected String solve(@NonNull Signal signal) {
        return signal.applyFFT(100).getFirstEightDigits();
    }
}
