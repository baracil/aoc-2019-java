package perococco.aoc.day3;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Day3Part1Test {


    public static Object[][] examples() {
        return new Object[][]{
                {"R8,U5,L5,D3", "U7,R6,D4,L4", 6},
                {"R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83", 159},
                {"R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7", 135},
        };
    }

    @ParameterizedTest
    @MethodSource("examples")
    public void testExamples(@NonNull String line1, @NonNull String line2, int expectedResult) {
        final Day3Part1Problem problem = new Day3Part1Problem(ImmutableList.of(line1,line2));
        final int actualResult = problem.solution();

        Assertions.assertEquals(expectedResult,actualResult);
    }
}
