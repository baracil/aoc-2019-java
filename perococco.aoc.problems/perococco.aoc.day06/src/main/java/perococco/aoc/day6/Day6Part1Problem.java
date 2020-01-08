package perococco.aoc.day6;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Part;

public class Day6Part1Problem extends Day6Problem {

    public Day6Part1Problem() {
        super(Part.PART_1);
    }

    public Day6Part1Problem(@NonNull ImmutableList<String> lines) {
        super(Part.PART_1, lines);
    }

    @Override
    protected int solve(@NonNull OrbitMap map) {
        final OrbitCounter orbitCounter = new OrbitCounter();
        map.depthFirstWalk(orbitCounter);
        return orbitCounter.sumOfDirectAndIndirectOrbits();
    }
}
