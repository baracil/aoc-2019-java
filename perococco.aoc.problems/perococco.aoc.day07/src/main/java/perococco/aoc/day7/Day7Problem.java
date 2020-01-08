package perococco.aoc.day7;

import lombok.NonNull;
import perococco.aoc.common.NumericalStrings;
import perococco.aoc.common.Permutation;
import perococco.aoc.computer.ComputerFactory;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.ProgramBasedAOCProblem;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;

public abstract class Day7Problem extends ProgramBasedAOCProblem<String> {

    public Day7Problem(@NonNull Part part) {
        super(Day.DAY_7, part);
    }

    public Day7Problem(@NonNull Part part, @NonNull ComputerFactory computerFactory, @NonNull String line) {
        super(Day.DAY_7, part, computerFactory, line);
    }

    @NonNull
    @Override
    public String solution() {
        final Program program = getProgram();
        final Circuit circuit = createCircuit(program);
        final Permutation<Phase> phases = Permutation.create(phaseValues(),Phase::new);


        return phases.stream().map(circuit::launch)
                     .max(NumericalStrings::compare)
                     .orElseThrow();
    }

    protected abstract Circuit createCircuit(@NonNull Program program);

    protected abstract String[] phaseValues();

}
