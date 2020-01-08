package perococco.aoc.day9;

import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.computer.Computer;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.primitive.VariableSizeLongValueComputerFactory;

/**
 * @author perococco
 **/
public class Day9Part1ExampleTest {

    public static Object[][] examples() {
        return new Object[][] {
                {"109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99","109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99","109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99","109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99"},
                {"1102,34915192,34915192,7,4,7,99,0","1219070632396864"},
                {"104,1125899906842624,99","1125899906842624"}

        };
    }

    @ParameterizedTest
    @MethodSource("examples")
    public void testPart1Examples(@NonNull String code, @NonNull String expectedOutput) {
        final Computer computer = new VariableSizeLongValueComputerFactory().create();
        final Program program = computer.compile(code);
        final ExecutionResult result = program.launchAndWait("Test");

        final String actualOutput = String.join(",", result.outputs());
        Assertions.assertEquals(actualOutput,expectedOutput);
    }
}
