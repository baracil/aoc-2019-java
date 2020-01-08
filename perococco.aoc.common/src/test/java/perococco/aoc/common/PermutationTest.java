package perococco.aoc.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mapstruct.ap.internal.util.Strings;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PermutationTest {

    public static Object[][] permutations() {
        return new Object[][] {
                { new String[]{"A","B"}, Set.of("A,B","B,A")},
                { new String[]{"A","B","C"}, Set.of("A,B,C","A,C,B","B,A,C","B,C,A","C,A,B","C,B,A")},
        };
    }

    @ParameterizedTest
    @MethodSource("permutations")
    public void name(String[] references, Set<String> expected) {
        final Permutation<String> permutation = Permutation.create(references,r -> Strings.join(Arrays.asList(r),","));

        final Set<String> actual = permutation.stream().collect(Collectors.toSet());
        Assertions.assertEquals(expected,actual);

    }
}
