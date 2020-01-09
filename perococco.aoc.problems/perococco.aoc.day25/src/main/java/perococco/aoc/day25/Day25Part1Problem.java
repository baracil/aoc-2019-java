package perococco.aoc.day25;

import perococco.aoc.computer.Execution;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.*;
import perococco.aoc.input.Part;

/**
 * @author perococco
 **/
public class Day25Part1Problem extends Day25Problem {

    public Day25Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    protected int solve(Program program) {
        final Execution<ProgramInput<String>,ProgramOutput<String>> io = program.launch("o", ProgramIO.duplex(InputTransform.ADD_NEW_LINE.then(InputMultiTransformer.TO_ASCII), OutputTransformer.TO_ASCII));

        return 0;
    }

}
