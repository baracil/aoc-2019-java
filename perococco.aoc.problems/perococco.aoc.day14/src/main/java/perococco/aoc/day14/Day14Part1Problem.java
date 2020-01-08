package perococco.aoc.day14;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.day14.computation.ChemicalBook;
import perococco.aoc.day14.computation.ReversedFactory;

public class Day14Part1Problem extends Day14Problem {
    public Day14Part1Problem() {
        super(Part.PART_1);
    }

    public Day14Part1Problem(@NonNull ImmutableList<String> lines) {
        super(Part.PART_1, lines);
    }

    @Override
    long solve(ChemicalBook chemicalBook) {
        final ReversedFactory reversedFactory = new ReversedFactory(chemicalBook);

        reversedFactory.clear();
        reversedFactory.produce(chemicalBook.fuel(), 1L);

        return reversedFactory.requiredOre();
    }
}
