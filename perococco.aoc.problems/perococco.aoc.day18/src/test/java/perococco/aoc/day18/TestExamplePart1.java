package perococco.aoc.day18;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestExamplePart1 {

    private static final ImmutableList<String> EXAMPLE1 = ImmutableList.of(
            "#########",
            "#b.A.@.a#",
            "#########"
    );

    private static final ImmutableList<String> EXAMPLE2 = ImmutableList.of(
            "########################",
            "#f.D.E.e.C.b.A.@.a.B.c.#",
            "######################.#",
            "#d.....................#",
            "########################"
    );

    private static final ImmutableList<String> EXAMPLE3 = ImmutableList.of(
            "########################" ,
            "#...............b.C.D.f#" ,
            "#.######################" ,
            "#.....@.a.B.c.d.A.e.F.g#" ,
            "########################"
    );

    private static final ImmutableList<String> EXAMPLE4 = ImmutableList.of(
            "#################" ,
            "#i.G..c...e..H.p#" ,
            "########.########" ,
            "#j.A..b...f..D.o#" ,
            "########@########" ,
            "#k.E..a...g..B.n#" ,
            "########.########" ,
            "#l.F..d...h..C.m#" ,
            "#################"   );

    private static final ImmutableList<String> EXAMPLE5 = ImmutableList.of(
            "########################",
            "#@..............ac.GI.b#",
            "###d#e#f################",
            "###A#B#C################",
            "###g#h#i################",
            "########################"   );

    public static Object[][] examples() {
            return new Object[][] {
                    {EXAMPLE1, 8},
                    {EXAMPLE2,86},
                    {EXAMPLE3,132},
                    {EXAMPLE4,136},
                    {EXAMPLE5,81}
            };

    }


    @ParameterizedTest
    @MethodSource("examples")
    public void solveExamples(ImmutableList<String> input, int expectedResult) {
        final Day18Problem problem = new Day18Part1Problem(input);
        final int actualResult = problem.solution();


        Assertions.assertEquals(expectedResult,actualResult);
    }
}
