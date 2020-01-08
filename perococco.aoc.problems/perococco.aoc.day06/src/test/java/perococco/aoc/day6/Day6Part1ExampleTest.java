package perococco.aoc.day6;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.input.AOCProblem;

public class Day6Part1ExampleTest {


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
                                  "K)L")}
        };
    }

    @ParameterizedTest
    @MethodSource("example")
    public void testExample(ImmutableList<String> lines) {
        final AOCProblem<Integer> problem = new Day6Part1Problem(lines);
        System.out.println(problem.solution());
    }
}
