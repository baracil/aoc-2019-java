package perococco.aoc.day7;

import lombok.NonNull;
import perococco.aoc.computer.ComputerFactory;
import perococco.aoc.computer.Program;
import perococco.aoc.input.Part;

public class Day7Part2Problem extends Day7Problem {

    public Day7Part2Problem() {
        super(Part.PART_2);
    }

    public Day7Part2Problem(@NonNull ComputerFactory computerFactory, @NonNull String line) {
        super(Part.PART_2, computerFactory, line);
    }

    @Override
    protected Circuit createCircuit(@NonNull Program program) {
        return new CircuitWithFeedback(program);
    }

    @Override
    protected String[] phaseValues() {
            return new String[]{"5","6","7","8","9"};
    }

}
