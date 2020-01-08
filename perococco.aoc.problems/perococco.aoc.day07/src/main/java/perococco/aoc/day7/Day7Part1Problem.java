package perococco.aoc.day7;

import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.computer.ComputerFactory;
import perococco.aoc.computer.Program;

public class Day7Part1Problem extends Day7Problem {

    public Day7Part1Problem() {
        super(Part.PART_1);
    }

    public Day7Part1Problem(@NonNull ComputerFactory computerFactory, @NonNull String line) {
        super(Part.PART_1, computerFactory, line);
    }

    @Override
    protected Circuit createCircuit(@NonNull Program program) {
        return new LinearCircuit(program);
    }

    @Override
    protected String[] phaseValues() {
        return new String[]{"0","1","2","3","4"};
    }

}
