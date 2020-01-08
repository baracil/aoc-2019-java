package perococco.aoc.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.computer.Computer;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.primitive.FixSizeLongValueComputerFactory;

public class Day2Part1ExampleTest {


    public static Object[][] examples() {
        return new Object[][]{
                {"1,0,0,0,99","2,0,0,0,99"},
                {"2,3,0,3,99","2,3,0,6,99"},
                {"2,4,4,5,99,0","2,4,4,5,99,9801"},
                {"1,1,1,4,99,5,6,0,99","30,1,1,4,2,5,6,0,99"}
        };
    }

    @ParameterizedTest
    @MethodSource("examples")
    public void testExamples(String code, String expectedMemory) {
        final Computer computer = new FixSizeLongValueComputerFactory().create();
        final Program program = computer.compile(code);
        final ExecutionResult result = program.launchAndWait("Test");
        final String dumpedMemory = result.dumpMemory();

        Assertions.assertEquals(expectedMemory,dumpedMemory);
    }
}
