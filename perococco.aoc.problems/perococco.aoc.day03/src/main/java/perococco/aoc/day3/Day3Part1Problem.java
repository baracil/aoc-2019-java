package perococco.aoc.day3;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.input.Part;

public class Day3Part1Problem extends BaseDay3Problem {

    public Day3Part1Problem() {
        super(Part.PART_1);
    }

    public Day3Part1Problem(@NonNull ImmutableList<String> lines) {
        super(Part.PART_1,lines);
    }

    @Override
    protected int compute(@NonNull Path path1, @NonNull Path path2) {
        return Path.intersectionStream(path1,path2)
                   .mapToInt(Point::distanceToCentralPort)
                   .min()
                   .orElseThrow(() -> new AOCException("No point of intersection found"));
    }
}
