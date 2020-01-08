package perococco.aoc.day10;

import perococco.aoc.input.Part;
import perococco.aoc.day10.computation.AsteroidField;
import perococco.aoc.day10.computation.Base;
import perococco.aoc.day10.computation.Position;
import perococco.aoc.day10.computation.VisibilityMap;

/**
 * @author perococco
 **/
public class Day10Part2Problem extends Day10Problem {

    public Day10Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    int solve(AsteroidField asteroidField) {
        final Base base = asteroidField.findOptimalBase();
        final VisibilityMap visibilityMap = asteroidField.createVisibilityMapFrom(base.position());

        final Position destroy200th = visibilityMap.destructionOrder().get(199);

        return destroy200th.x()*100+destroy200th.y();
    }
}
