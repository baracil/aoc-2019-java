package perococco.aoc.day4;

import lombok.NonNull;
import perococco.aoc.input.Part;

public class Day4Part2Problem extends BaseDay4Problem {

    public Day4Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    protected int solve(@NonNull Code first, @NonNull Code last) {
        int count = 0;
        first.normalize();
        while (first.compareTo(last) < 0) {
            if (first.hasTwoIsolateIdenticalConsecutiveDigits()) {
                count++;
            }
            first.moveToNextCodeWithIncreasingDigit();
        }
        return count;
    }
}
