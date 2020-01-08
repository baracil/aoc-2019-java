package perococco.aoc.day7;

import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.computer.Computer;
import perococco.aoc.computer.primitive.FixSizeLongValueComputerFactory;

public class LinearCircuitExampleTest {


    public static Object[][] example() {
        return new Object[][]{
                {"3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0", Phase.with("43210"),"43210"},
                {"3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0", Phase.with("01234"),"54321"},
                {"3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0", Phase.with("10432"),"65210"},
        };
    }

    @ParameterizedTest
    @MethodSource("example")
    public void testExample(@NonNull String code, Phase phase, String expectedResult) {
        final Computer computer = new FixSizeLongValueComputerFactory().create();
        final Circuit circuit = new LinearCircuit(computer.compile(code));
        final String result = circuit.launch(phase);

        Assertions.assertEquals(expectedResult,result);
    }
}
