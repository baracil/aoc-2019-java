package perococco.aoc.day22;

import lombok.NonNull;
import perococco.aoc.day22._private.DeckWithPermutationShuffle;
import perococco.aoc.day22._private.ShuffleTechniqueParser;
import perococco.aoc.input.Day;
import perococco.aoc.input.LineByLineAOCProblem;
import perococco.aoc.input.Part;

public abstract class Day22Problem extends LineByLineAOCProblem<Long> {

    public Day22Problem(@NonNull Part part) {
        super(Day.DAY_22, part);
    }

    @NonNull
    @Override
    public Long solution() {
        final long size = deckSize();
        final ShuffleTechniqueParser parser = new ShuffleTechniqueParser(size);
        final PermutationFactors permutationFactors = getInput(parser::parse)
                .reduce(PermutationFactors::then)
                .orElseGet(() -> PermutationFactors.identity(size));

        final Deck deck = new DeckWithPermutationShuffle(permutationFactors.pow(numberOfRepetitions()));

        return solve(deck);
    }

    protected abstract long solve(@NonNull Deck deck);

    protected abstract long deckSize();

    protected abstract long numberOfRepetitions();
}
