package perococco.aoc.day19;

import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.computer.Program;
import perococco.aoc.day19._private.BeamSizeProbe;

public class Day19Part1Problem extends Day19Problem {

    public Day19Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    int solve(@NonNull Program program) {
        return BeamSizeProbe.probe(program);
    }

}
