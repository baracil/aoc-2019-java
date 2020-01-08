package perococco.aoc.day22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.day22._private.BaseMath;

/**
 * @author perococco
 **/
public class BaseMathTest {

    public static Object[][] powerTests() {
        return new Object[][] {
                {10,1,10,1},
                {10,3,9,3},
        };
    }

    @Test
    public void invert63InBase10() {
        final BaseMath baseMath = BaseMath.create(10);
        final long i = baseMath.invert(63);
    }

    @ParameterizedTest
    @MethodSource("powerTests")
    public void testPower(long base, long value, long power, long expected) {
        final BaseMath b = BaseMath.create(base);
        final long actual = b.pow(value,power);
        Assertions.assertEquals(expected,actual);
    }
}
