package perococco.aoc.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author perococco
 **/
public class NumericalStringsTest {

    public static Object[][] stringToCompare() {
        return new Object[][] {
                { "1234","4321",-1},
                { "5234","4321",1},
                { "1234","432",1},
        };

    }

    @ParameterizedTest
    @MethodSource("stringToCompare")
    public void testComparison(String s1, String s2, int resultSign) {
        final int actualSign = Integer.signum(NumericalStrings.compare(s1,s2));
        Assertions.assertEquals(resultSign,actualSign);
    }
}
