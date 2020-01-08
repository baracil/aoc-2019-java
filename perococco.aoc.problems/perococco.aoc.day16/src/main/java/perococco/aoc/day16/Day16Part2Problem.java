package perococco.aoc.day16;

import lombok.NonNull;
import perococco.aoc.input.Part;

public class Day16Part2Problem extends Day16Problem {

    public Day16Part2Problem() {
        super(Part.PART_2);
    }

    public Day16Part2Problem(@NonNull String line) {
        super(Part.PART_2, line);
    }

    @Override
    protected String solve(@NonNull Signal signal) {
        final int offset = Integer.parseInt(signal.getFirstSeventhDigits());
        final Signal signal1 = signal.duplicate(10000).truncate(offset).applyFFT(100);

        return signal1.getFirstEightDigits();

    }
}
