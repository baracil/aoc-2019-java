package perococco.aoc.day22;

import lombok.NonNull;
import perococco.aoc.input.Part;

public class Day22Part1Problem extends Day22Problem {

    public Day22Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    protected long solve(@NonNull Deck deck) {
        return deck.positionOfCard(2019);
    }

    protected long deckSize() {
        return 10007L;
    }

    protected long numberOfRepetitions() {
        return 1L;
    }
}
