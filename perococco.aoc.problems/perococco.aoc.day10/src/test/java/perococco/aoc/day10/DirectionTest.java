package perococco.aoc.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.day10.computation.Direction;

public class DirectionTest {

    private static Object[][] directions() {
        return new Object[][]{
                {0,-10,0.0},
                {10, -10, 0.5},
                {10, 0, 1.0},
                {10, 10, 1.5},
                {0, 10, 2},
                {-10, 10, 2.5},
                {-10, 0, 3},
                {-10, -10, 3.5},
        };
    }

    @ParameterizedTest
    @MethodSource("directions")
    public void testUpDirection(int dx, int dy, double angle) {
        final Direction direction = Direction.create(dx,dy);
        Assertions.assertEquals(angle,direction.angle(),1e-6);
    }
}
