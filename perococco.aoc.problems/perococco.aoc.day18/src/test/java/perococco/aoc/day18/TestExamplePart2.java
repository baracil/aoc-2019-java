package perococco.aoc.day18;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestExamplePart2 {

    private static final ImmutableList<String> EXAMPLE0 = ImmutableList.of(
            "#######",
            "#a.#Cd#",
            "##...##",
            "##.@.##",
            "##...##",
            "#cB#.b#",
            "#######"
    );

    private static final ImmutableList<String> EXAMPLE1 = ImmutableList.of(
            "###############",
            "#d.ABC.#.....a#",
            "######...######",
            "######.@.######",
            "######...######",
            "#b.....#.....c#",
            "###############"
    );

    private static final ImmutableList<String> EXAMPLE2 = ImmutableList.of(
            "#############",
            "#DcBa.#.GhKl#",
            "#.###...#I###",
            "#e#d#.@.#j#k#",
            "###C#...###J#",
            "#fEbA.#.FgHi#",
            "#############"
    );

    private static final ImmutableList<String> EXAMPLE3 = ImmutableList.of(
            "#############",
            "#g#f.D#..h#l#",
            "#F###e#E###.#",
            "#dCba...BcIJ#",
            "#####.@.#####",
            "#nK.L...G...#",
            "#M###N#H###.#",
            "#o#m..#i#jk.#",
            "#############"
    );


    public static Object[][] examples() {
            return new Object[][] {
                    {EXAMPLE0, 8},
                    {EXAMPLE1, 24},
                    {EXAMPLE2, 32},
                    {EXAMPLE3, 72},
            };

    }


    @ParameterizedTest
    @MethodSource("examples")
    public void solveExamples(ImmutableList<String> input, int expectedResult) {
        final Day18Problem problem = new Day18Part2Problem(input);
        final int actualResult = problem.solution();


        Assertions.assertEquals(expectedResult,actualResult);
    }
}
