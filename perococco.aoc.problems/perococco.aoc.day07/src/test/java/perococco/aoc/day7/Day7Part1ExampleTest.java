package perococco.aoc.day7;

import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.input.AOCProblem;
import perococco.aoc.computer.primitive.FixSizeLongValueComputerFactory;

public class Day7Part1ExampleTest {


    public static Object[][] example() {
        return new Object[][]{
                {"3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0", "43210"},
                {"3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0", "54321"},
                {"3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0", "65210"},
        };
    }

    @ParameterizedTest
    @MethodSource("example")
    public void testExample(@NonNull String code, @NonNull String expectedResult) {
        final AOCProblem<String> problem = new Day7Part1Problem(new FixSizeLongValueComputerFactory(), code);
        final String result = problem.solution();

        Assertions.assertEquals(expectedResult,result);
    }
}
