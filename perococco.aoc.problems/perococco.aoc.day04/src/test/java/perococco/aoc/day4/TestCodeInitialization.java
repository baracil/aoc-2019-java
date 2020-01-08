package perococco.aoc.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestCodeInitialization {

    public static Object[][] initializeTest() {
        return new Object[][]{
                {"206938","222222"},
                {"347312","347777"},
                {"347777","347777"},
                {"122348","122348"},
                {"122311","122333"}
        };
    }

    @ParameterizedTest
    @MethodSource("initializeTest")
    public void initializationTest(String input, String expectedResult) {
        final Code code = Code.normalized(input);

        Assertions.assertEquals(expectedResult,code.toString());
    }
}
