package perococco.aoc.day14.computation.parser;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.day14.computation.Chemical;
import perococco.aoc.day14.computation.ChemicalBook;
import perococco.aoc.day14.computation.ChemicalReaction;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ParsedChemicalBook {

    private static final Collector<Map.Entry<String,Integer>,?,ImmutableMap<String,Chemical>> CHEMICAL_COLLECTOR =
            ImmutableMap.toImmutableMap(Map.Entry::getKey, e -> new Chemical(e.getKey(), e.getValue()));


    @NonNull
    private ImmutableMap<String, ParsedReaction> reactions;

    @NonNull
    public ChemicalBook createBook() {
        final ImmutableMap<String,Chemical> chemicalByName = createChemicals();
        final ImmutableMap<Chemical, ChemicalReaction> chemicalReactions;
        {

            chemicalReactions = reactions.values()
                                         .stream()
                                         .map(r -> r.toChemicalReaction(chemicalByName))
                                         .collect(ImmutableMap.toImmutableMap(ChemicalReaction::producedChemical,
                                                                              r -> r));
        }

        return new ChemicalBook(chemicalByName,chemicalReactions);



    }

    private ImmutableMap<String,Chemical> createChemicals() {
        final Map<String,Integer> complexities = new HashMap<>();
        complexities.put("ORE",0);
        computeComplexity("FUEL",complexities);

        return  complexities.entrySet()
                            .stream()
                            .collect(CHEMICAL_COLLECTOR);
    }

    private int computeComplexity(@NonNull String chemicalName, @NonNull Map<String,Integer> complexities) {
        Integer complexity = complexities.get(chemicalName);
        if (complexity == null) {
            complexity = reactions.get(chemicalName)
                                  .reactantNames()
                                  .mapToInt(n -> computeComplexity(n, complexities))
                                  .max()
                                  .orElseThrow() + 1;

            complexities.put(chemicalName, complexity);
        }
        return complexity;
    }


    public static Collector<String,?,ParsedChemicalBook> collector() {
        return Collectors.collectingAndThen(
                Collectors.mapping(
                        ParsedReaction::new,
                        ImmutableMap.toImmutableMap(ParsedReaction::producedChemicalName, r->r)
                ),
                ParsedChemicalBook::new
        );
    }

}
