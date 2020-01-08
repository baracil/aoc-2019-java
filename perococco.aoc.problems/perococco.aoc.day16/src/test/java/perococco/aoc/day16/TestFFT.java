package perococco.aoc.day16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestFFT {

    @Test
    public void example1() {
        final Signal s = new Signal("12345678");
        final Signal s1 = s.applyFFT();
        final Signal s2 = s1.applyFFT();
        final Signal s3 = s2.applyFFT();
        final Signal s4 = s3.applyFFT();

        Assertions.assertEquals("48226158",s1.getFirstEightDigits());
        Assertions.assertEquals("34040438",s2.getFirstEightDigits());
        Assertions.assertEquals("03415518",s3.getFirstEightDigits());
        Assertions.assertEquals("01029498",s4.getFirstEightDigits());
    }

    private static Object[][] example2Source() {
        return new Object[][] {
                {"80871224585914546619083218645595","24176176"},
                {"19617804207202209144916044189917","73745418"},
                {"69317163492948606335995924319873","52432133"},
        };
    }




    @ParameterizedTest
    @MethodSource("example2Source")
    public void example2(String input, String expected) {
        final Signal signal = new Signal(input).applyFFT(100);

        Assertions.assertEquals(expected,signal.getFirstEightDigits());


    }
}
