package perococco.aoc.day11;

import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.computer.Program;
import perococco.aoc.day11.computation.Hull;
import perococco.aoc.day11.computation.Robot;

public class Day11Part1Problem extends Day11Problem {

    public Day11Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    protected String solve(@NonNull Program program) {
        final Hull hull = new Hull();

        final Robot robot = Robot.create(program);

        robot.placeOnHull(hull);
        robot.switchOn();
        robot.waitUntilDone();
        return ""+robot.numberOfPaintedPanels();
    }
}
