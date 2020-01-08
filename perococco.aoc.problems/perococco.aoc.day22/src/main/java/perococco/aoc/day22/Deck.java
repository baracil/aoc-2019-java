package perococco.aoc.day22;

import lombok.NonNull;
import perococco.aoc.day22._private.DeckWithPermutationShuffle;

/**
 * @author perococco
 **/
public interface Deck {

    @NonNull
    static Deck factorySetting(long size) {
        return new DeckWithPermutationShuffle(PermutationFactors.identity(size));
    }

    static Deck shuffled(@NonNull PermutationFactors permutationFactors) {
        return new DeckWithPermutationShuffle(permutationFactors);
    }

    long cardAtPosition(long position);

    long positionOfCard(long card);
}
