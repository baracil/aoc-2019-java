package perococco.aoc.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.day10.computation.*;

import java.util.Arrays;

public class Day10Part1ExamplesTest {


    private static Object[][] examples() {
        return new Object[][]{
                {
                  ".#..#\n" +
                  ".....\n" +
                  "#####\n" +
                  "....#\n" +
                  "...##",3,4,8
                },
                {"......#.#.\n" +
                 "#..#.#....\n" +
                 "..#######.\n" +
                 ".#.#.###..\n" +
                 ".#..#.....\n" +
                 "..#....#.#\n" +
                 "#..#....#.\n" +
                 ".##.#..###\n" +
                 "##...#..#.\n" +
                 ".#....####", 5,8,33},
                {
                    "#.#...#.#.\n" +
                    ".###....#.\n" +
                    ".#....#...\n" +
                    "##.#.#.#.#\n" +
                    "....#.#.#.\n" +
                    ".##..###.#\n" +
                    "..#...##..\n" +
                    "..##....##\n" +
                    "......#...\n" +
                    ".####.###.",1,2,35
                },
                {
                 ".#..#..###\n" +
                 "####.###.#\n" +
                 "....###.#.\n" +
                 "..###.##.#\n" +
                 "##.##.#.#.\n" +
                 "....###..#\n" +
                 "..#.#..#.#\n" +
                 "#..#.#.###\n" +
                 ".##...##.#\n" +
                 ".....#.#..", 6,3,41
                },
                {
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
                    "###.##.####.##.#..##",11,13,210
                }

        };
    }

    @ParameterizedTest
    @MethodSource("examples")
    public void testExample(String input, int x, int y, int nbVisible) {
        final AsteroidField asteroidField = createAsteroidField(input);
        final Base base = asteroidField.findOptimalBase();

        Assertions.assertEquals(Position.create(x,y), base.position(), "position");
        Assertions.assertEquals(nbVisible,base.numberOfVisibleAsteroids(),"nb visible");
    }

    private AsteroidField createAsteroidField(String input) {
        final SpaceMap<Type> spaceMap = Arrays.stream(input.split("\n")).collect(SpaceMap.collector(Type::getType));
        return new AsteroidField(spaceMap);
    }
}
