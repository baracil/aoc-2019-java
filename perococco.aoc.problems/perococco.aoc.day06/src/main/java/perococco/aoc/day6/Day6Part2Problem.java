package perococco.aoc.day6;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Part;

public class Day6Part2Problem extends Day6Problem {

    public Day6Part2Problem() {
        super(Part.PART_2);
    }

    public Day6Part2Problem(@NonNull ImmutableList<String> lines) {
        super(Part.PART_2, lines);
    }

    @Override
    protected int solve(@NonNull OrbitMap map) {
        final OrbitPath pathToYou = map.pathFromRoot("YOU");
        final OrbitPath pathToSanta = map.pathFromRoot("SAN");

        final String lastCommon = OrbitPath.lastCommonBody(pathToSanta,pathToYou);
        final int distance = map.distanceFromRoot(lastCommon);

        return pathToSanta.size()+pathToYou.size() - 2*distance - 4;
    }
}
