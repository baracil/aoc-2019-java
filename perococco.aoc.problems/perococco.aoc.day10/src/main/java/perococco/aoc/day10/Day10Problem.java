package perococco.aoc.day10;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Day;
import perococco.aoc.input.LineByLineAOCProblem;
import perococco.aoc.input.Part;
import perococco.aoc.day10.computation.AsteroidField;
import perococco.aoc.day10.computation.SpaceMap;
import perococco.aoc.day10.computation.Type;

/**
 * @author perococco
 **/
public abstract class Day10Problem extends LineByLineAOCProblem<Integer> {

    public Day10Problem(@NonNull Part part) {
        super(Day.DAY_10, part);
    }

    public Day10Problem(@NonNull Part part,
            @NonNull ImmutableList<String> lines) {
        super(Day.DAY_10, part, lines);
    }

    @NonNull
    @Override
    public Integer solution() {
        final SpaceMap<Type> map = getInput().collect(SpaceMap.collector(Type::getType));
        return solve(new AsteroidField(map));
    }

    abstract int solve(AsteroidField presenceField);
}
