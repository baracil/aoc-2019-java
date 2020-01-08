package perococco.aoc.day14.computation;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

import java.util.function.Consumer;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ChemicalReaction {

    @NonNull
    @Getter
    private final Chemical producedChemical;

    @Getter
    private final int producedAmount;

    @NonNull
    @Singular
    private final ImmutableList<Reactant> reactants;

    @Override
    public String toString() {
        return reactants.stream()
                        .map(Reactant::toString)
                        .collect(Collectors.joining(", ",""," => "))
                +producedAmount+" "+producedChemical.name();
    }


    public void forEachReactant(@NonNull Consumer<Reactant> reactantConsumer) {
        reactants.forEach(reactantConsumer);
    }
}
