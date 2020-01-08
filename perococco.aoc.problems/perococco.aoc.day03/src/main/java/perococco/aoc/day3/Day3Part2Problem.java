package perococco.aoc.day3;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Part;

public class Day3Part2Problem extends BaseDay3Problem {

    public Day3Part2Problem() {
        super(Part.PART_2);
    }

    public Day3Part2Problem(@NonNull ImmutableList<String> lines) {
        super(Part.PART_2,lines);
    }

    @Override
    protected int compute(@NonNull Path path1, @NonNull Path path2) {
        return Path.intersectionStream(path1,path2)
                .mapToInt(pt -> path1.numberOfStepsToReach(pt)+path2.numberOfStepsToReach(pt))
                .min()
                .orElseThrow();
    }
}
