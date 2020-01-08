package perococco.aoc.day9;

import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.ProgramIO;
import perococco.aoc.input.Part;

public class Day9Part1Problem extends Day9Problem {

    public Day9Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    protected String solve(@NonNull Program program) {
        final ExecutionResult result = program.launch(problemName(), ProgramIO.fromList("1").ignoreOutput()).waitTermination();

        if (result.numberOfOutput() != 1) {
            System.out.println("Opcode error :");
            result.forEachOutput(System.out::println);
            throw new AOCException("Invalid IntComputer");
        } else {
            return result.getLastOutput();
        }
    }
}
