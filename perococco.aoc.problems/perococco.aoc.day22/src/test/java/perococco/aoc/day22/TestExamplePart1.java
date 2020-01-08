package perococco.aoc.day22;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.day22._private.ShuffleTechniqueParser;

/**
 * @author perococco
 **/
public class TestExamplePart1 {

    public static Object[][] examples1() {
        return new Object[][]{
                {
                        ImmutableList.of(
                                "deal with increment 7",
                                "deal into new stack",
                                "deal into new stack"
                        ), new int[]{0, 3, 6, 9, 2, 5, 8, 1, 4, 7}
                },
                {
                        ImmutableList.of(
                                "cut 6",
                                "deal with increment 7",
                                "deal into new stack"
                        ), new int[]{3, 0, 7, 4, 1, 8, 5, 2, 9, 6}
                },
                {
                        ImmutableList.of(
                                "deal with increment 7",
                                "deal with increment 9",
                                "cut -2"
                        ), new int[]{6, 3, 0, 7, 4, 1, 8, 5, 2, 9}
                },
                {
                        ImmutableList.of(
                                "deal into new stack",
                                "cut -2",
                                "deal with increment 7",
                                "cut 8",
                                "cut -4",
                                "deal with increment 7",
                                "cut 3",
                                "deal with increment 9",
                                "deal with increment 3",
                                "cut -1"
                        ), new int[]{9, 2, 5, 8, 1, 4, 7, 0, 3, 6}
                },
        };
    }

    @ParameterizedTest
    @MethodSource("examples1")
    public void part1(@NonNull ImmutableList<String> lines, int[] result) {
        final ShuffleTechniqueParser parser = new ShuffleTechniqueParser(result.length);
        final Deck deck = lines.stream().map(parser::parse)
                               .reduce(PermutationFactors::then)
                               .map(Deck::shuffled)
                               .orElseGet(() -> Deck.factorySetting(result.length));

        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(result[i],deck.cardAtPosition(i));
        }
    }

}
