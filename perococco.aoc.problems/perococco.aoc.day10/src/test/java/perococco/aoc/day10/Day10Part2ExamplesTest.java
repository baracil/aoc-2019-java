package perococco.aoc.day10;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import perococco.aoc.day10.computation.*;

import java.util.Arrays;

public class Day10Part2ExamplesTest {


    private static String MAP =
                    ".#..##.###...#######\n" +
                    "##.############..##.\n" +
                    ".#.######.########.#\n" +
                    ".###.#######.####.#.\n" +
                    "#####.##.#.##.###.##\n" +
                    "..#####..#.#########\n" +
                    "####################\n" +
                    "#.####....###.#.#.##\n" +
                    "##.#################\n" +
                    "#####.##.###..####..\n" +
                    "..######..##.#######\n" +
                    "####.##.####...##..#\n" +
                    ".#####..#.######.###\n" +
                    "##...#.##########...\n" +
                    "#.##########.#######\n" +
                    ".####.#.###.###.#.##\n" +
                    "....##.##.###..#####\n" +
                    ".#.#.###########.###\n" +
                    "#.#.#.#####.####.###\n" +
                    "###.##.####.##.#..##";

    private VisibilityMap visibilityMap;

    @BeforeEach
    public void setUp() {
        final AsteroidField asteroidField = createAsteroidField(MAP);
        final Base base = asteroidField.findOptimalBase();
        visibilityMap = asteroidField.createVisibilityMapFrom(base.position());
    }

    @Test
    public void testExample() {
        final ImmutableList<Position> destructionOrder = visibilityMap.destructionOrder();
        test(1, 11, 12);
        test(2, 12, 1);
        test(3, 12, 2);
        test(10, 12, 8);
        test(20, 16, 0);
        test(50, 16, 9);
        test(100, 10, 16);
        test(199, 9, 6);
        test(200, 8, 2);
        test(201, 10, 9);
        test(299, 11, 1);
    }

    private void test(int position, int x, int y) {
        final ImmutableList<Position> destructionOrder = visibilityMap.destructionOrder();

        Assertions.assertEquals(Position.create(x,y), destructionOrder.get(position-1),"Position "+(position));
    }

    private AsteroidField createAsteroidField(String input) {
        final SpaceMap<Type> spaceMap = Arrays.stream(input.split("\n")).collect(SpaceMap.collector(Type::getType));
        return new AsteroidField(spaceMap);
    }
}
