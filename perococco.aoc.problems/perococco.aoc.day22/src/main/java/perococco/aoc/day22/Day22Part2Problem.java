package perococco.aoc.day22;

import lombok.NonNull;
import perococco.aoc.input.Part;

public class Day22Part2Problem extends Day22Problem {

    public Day22Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    protected long solve(@NonNull Deck deck) {
        return deck.cardAtPosition(2020);
    }

    @Override
    protected long numberOfRepetitions() {
        return 101741582076661L;
    }

    @Override
    protected long deckSize() {
        return 119_315_717_514_047L;
    }
}
