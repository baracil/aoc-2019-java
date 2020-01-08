package perococco.aoc.day5;

import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.ProgramIO;

public class Day5Part2Problem extends Day5Problem {

    public Day5Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    protected String solve(@NonNull Program program) {
        return program.launchAndWait("Day5 Part 2", ProgramIO.fromList("5").ignoreOutput()).getLastOutput();
    }

}
