package perococco.aoc.day17;

import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.computer.Program;
import perococco.aoc.day17._private.Camera;
import perococco.aoc.day17._private.Intersections;

public class Day17Part1Problem extends Day17Problem {

    public Day17Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    protected String solve(@NonNull Program program) {
        final Camera camera = new Camera(program);

        return ""+Intersections.findOnPicture(camera.takePicture()).sumOfAlignments();
    }
}
