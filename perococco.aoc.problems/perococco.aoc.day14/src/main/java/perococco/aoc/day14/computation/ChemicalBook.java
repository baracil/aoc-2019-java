package perococco.aoc.day14.computation;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.day14.computation.parser.ParsedChemicalBook;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ChemicalBook {

    @NonNull
    private final ImmutableMap<String,Chemical> chemicalByName;

    @NonNull
    private final ImmutableMap<Chemical,ChemicalReaction> reactions;


    @NonNull
    public Chemical getOre() {
        return chemicalByName.get("ORE");
    }

    @NonNull
    public Chemical fuel() {
        return chemicalByName.get("FUEL");
    }

    @NonNull
    public ChemicalReaction getReactionProducing(@NonNull Chemical chemical) {
        return reactions.get(chemical);
    }

    public static Collector<String,?,ChemicalBook> collector() {
        return Collectors.collectingAndThen(
                ParsedChemicalBook.collector(),
                ParsedChemicalBook::createBook
        );
    }


}
