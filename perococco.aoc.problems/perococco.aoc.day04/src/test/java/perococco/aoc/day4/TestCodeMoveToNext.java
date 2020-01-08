package perococco.aoc.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestCodeMoveToNext {

    public static Object[][] initializeTest() {
        return new Object[][]{
                {"347312","347778"},
                {"122349","122355"},
                {"122999","123333"}
        };
    }

    @ParameterizedTest
    @MethodSource("initializeTest")
    public void initializationTest(String input, String expectedResult) {
        final Code code = Code.normalized(input);
        code.moveToNextCodeWithIncreasingDigit();

        Assertions.assertEquals(expectedResult,code.toString());
    }
}
