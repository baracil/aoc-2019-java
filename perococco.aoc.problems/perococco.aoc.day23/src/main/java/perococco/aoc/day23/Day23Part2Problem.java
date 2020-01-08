package perococco.aoc.day23;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.day23._private.NetworkWithNAT;
import perococco.aoc.input.Part;

/**
 * @author perococco
 **/
public class Day23Part2Problem extends Day23Problem {

    public Day23Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    protected String solve(@NonNull Program program) {
        return new NetworkWithNAT(program).waitForResult();
    }
}
