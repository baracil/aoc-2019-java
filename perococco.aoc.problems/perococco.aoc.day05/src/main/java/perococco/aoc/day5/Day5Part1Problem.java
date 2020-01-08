package perococco.aoc.day5;

import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.ProgramIO;

public class Day5Part1Problem extends Day5Problem {

    public Day5Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    protected String solve(@NonNull Program program) {
        return program.launchAndWait("Day5 Part 1", ProgramIO.fromList("1").ignoreOutput()).getLastOutput();
    }

}
