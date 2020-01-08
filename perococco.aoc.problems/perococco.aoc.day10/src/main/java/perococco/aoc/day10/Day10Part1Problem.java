package perococco.aoc.day10;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.day10.computation.AsteroidField;
import perococco.aoc.day10.computation.Base;

/**
 * @author perococco
 **/
public class Day10Part1Problem extends Day10Problem {

    public Day10Part1Problem() {
        super(Part.PART_1);
    }

    public Day10Part1Problem(@NonNull ImmutableList<String> lines) {
        super(Part.PART_1, lines);
    }

    @Override
    int solve(AsteroidField asteroidField) {
        final Base base = asteroidField.findOptimalBase();
        return base.numberOfVisibleAsteroids();
    }
}
