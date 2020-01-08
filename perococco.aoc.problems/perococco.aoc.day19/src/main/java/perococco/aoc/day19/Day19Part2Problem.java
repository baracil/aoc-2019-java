package perococco.aoc.day19;

import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.common.Position;
import perococco.aoc.computer.Program;
import perococco.aoc.day19._private.BeamExtract;
import perococco.aoc.day19._private.BeamSlice;
import perococco.aoc.day19._private.BeamSliceProbe;

public class Day19Part2Problem extends Day19Problem {

    public Day19Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    int solve(@NonNull Program program) {
        final BeamExtract beamExtract = new BeamExtract(100);
        Position start = Position.of(0,0);
        do {
            final BeamSlice slice = BeamSliceProbe.probe(program,start);
            beamExtract.push(slice);
            if (beamExtract.canFitTheShip()) {
                return slice.start().x()*10_000+(slice.start().y()-99);
            }
            start = slice.start().down();
        } while (true);

    }
}
