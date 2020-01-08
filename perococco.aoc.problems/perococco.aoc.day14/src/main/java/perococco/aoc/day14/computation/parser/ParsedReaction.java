package perococco.aoc.day14.computation.parser;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Tools;
import perococco.aoc.day14.computation.Chemical;
import perococco.aoc.day14.computation.ChemicalReaction;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParsedReaction {

    @NonNull
    private final ReactionToken produced;

    @NonNull
    private final ImmutableList<ReactionToken> reactants;

    public ParsedReaction(String reaction) {
        try {
            final String[] inputOutputSplit = reaction.split("=>");
            this.produced = new ReactionToken(inputOutputSplit[1].trim());
            this.reactants = Arrays.stream(inputOutputSplit[0].split(",")).map(ReactionToken::new).collect(ImmutableList.toImmutableList());
        } catch (Exception e) {
            throw new AOCException("Could not parse reaction '"+reaction+"'");
        }
    }

    @NonNull
    public ChemicalReaction toChemicalReaction(@NonNull ImmutableMap<String,Chemical> chemicalByName) {
        return new ChemicalReaction(
                chemicalByName.get(produced.name()),
                produced.amount(),
                Tools.map(reactants, r ->r.toReactant(chemicalByName))
                );
    }

    @NonNull
    public Stream<String> reactantNames() {
        return reactants.stream().map(ReactionToken::name);
    }

    @NonNull
    public String producedChemicalName() {
        return produced.name();
    }

}
