package perococco.aoc.day6;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.input.AOCProblem;

public class Day6Part2ExampleTest {


    public static Object[][] example() {
        return new Object[][]{
                {ImmutableList.of("COM)B",
                                  "B)C",
                                  "C)D",
                                  "D)E",
                                  "E)F",
                                  "B)G",
                                  "G)H",
                                  "D)I",
                                  "E)J",
                                  "J)K",
                                  "K)L",
                                  "K)YOU",
                                  "I)SAN"),4}
        };
    }

    @ParameterizedTest
    @MethodSource("example")
    public void testExample(ImmutableList<String> lines, int expectedValue) {
        final AOCProblem<Integer> problem = new Day6Part2Problem(lines);
        final int nbTransfers = problem.solution();
        Assertions.assertEquals(expectedValue, nbTransfers);
    }
}
