package perococco.aoc.day14;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Day;
import perococco.aoc.input.LineByLineAOCProblem;
import perococco.aoc.input.Part;
import perococco.aoc.day14.computation.ChemicalBook;

public abstract class Day14Problem extends LineByLineAOCProblem<Long> {

    public Day14Problem(@NonNull Part part) {
        super(Day.DAY_14, part);
    }

    public Day14Problem(@NonNull Part part,
            @NonNull ImmutableList<String> lines) {
        super(Day.DAY_14, part, lines);
    }

    @NonNull
    @Override
    public Long solution() {
        final ChemicalBook chemicalBook = getInput().collect(ChemicalBook.collector());
        return solve(chemicalBook);
    }

    abstract long solve(ChemicalBook chemicalBook);
}
