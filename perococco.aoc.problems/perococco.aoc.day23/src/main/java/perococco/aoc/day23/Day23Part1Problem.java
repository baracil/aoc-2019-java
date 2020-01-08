package perococco.aoc.day23;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.day23._private.FirstYNetwork;
import perococco.aoc.input.Part;

/**
 * @author perococco
 **/
public class Day23Part1Problem extends Day23Problem {

    public Day23Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    protected String solve(@NonNull Program program) {
        return new FirstYNetwork(program).waitForResult();
    }
}
