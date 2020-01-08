package perococco.aoc.day6;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Day;
import perococco.aoc.input.LineByLineAOCProblem;
import perococco.aoc.input.Part;
import perococco.aoc.day6._private.MutableOrbitMap;

public abstract class Day6Problem extends LineByLineAOCProblem<Integer> {

    public Day6Problem(@NonNull Part part) {
        super(Day.DAY_6,part);
    }

    public Day6Problem(@NonNull Part part, ImmutableList<String> lines) {
        super(Day.DAY_6,part, lines);
    }

    @NonNull
    @Override
    public Integer solution() {
        final MutableOrbitMap map = new MutableOrbitMap();
        getInput()
                .map(Relationship::parse)
                .forEach(map::addRelationShip);

        return solve(map);
    }

    protected abstract int solve(@NonNull OrbitMap map);


}
