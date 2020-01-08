package perococco.aoc.day11;

import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.common.Position;
import perococco.aoc.computer.Program;
import perococco.aoc.day11.computation.Color;
import perococco.aoc.day11.computation.Hull;
import perococco.aoc.day11.computation.Robot;

import java.util.stream.Collectors;

public class Day11Part2Problem extends Day11Problem {

    public Day11Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    protected String solve(@NonNull Program program) {
        final Hull hull = new Hull();
        final Robot robot = Robot.create(program);

        hull.paint(Position.of(0,0), Color.WHITE);

        robot.placeOnHull(hull);
        robot.switchOn();
        robot.waitUntilDone();



        return hull.dump().stream().collect(Collectors.joining("\n","\n",""));
    }
}
