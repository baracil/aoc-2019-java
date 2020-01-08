package perococco.aoc.day12;

import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.day12.computation.MoonSystem;
import perococco.aoc.day12.computation.Simulator;

public class Day12Part1Problem extends Day12Problem {

    public Day12Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    String solve(@NonNull MoonSystem moonSystem) {
        final Simulator simulator = new Simulator(moonSystem);
        final MoonSystem system = simulator.simulateToTime(1000);

        return ""+system.totalEnergy();

    }
}
