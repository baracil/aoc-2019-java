package perococco.aoc.day22._private;

import lombok.NonNull;
import perococco.aoc.day22.Deck;
import perococco.aoc.day22.PermutationFactors;

/**
 * @author perococco
 **/
public class DeckWithPermutationShuffle implements Deck {

    @NonNull
    private final PermutationFactors permutation;

    @NonNull
    private final PermutationFactors invertedPermutation;

    public DeckWithPermutationShuffle(@NonNull PermutationFactors permutation) {
        this.permutation = permutation;
        this.invertedPermutation = permutation.invert();
    }

    @Override
    public long cardAtPosition(long position) {
        return invertedPermutation.permute(position);
    }

    @Override
    public long positionOfCard(long card) {
        return permutation.permute(card);
    }
}
