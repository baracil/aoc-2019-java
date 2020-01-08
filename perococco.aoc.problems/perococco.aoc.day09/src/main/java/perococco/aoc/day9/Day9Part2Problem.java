package perococco.aoc.day9;

import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Nil;
import perococco.aoc.input.Part;
import perococco.aoc.computer.Execution;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.ProgramIO;

public class Day9Part2Problem extends Day9Problem {

    public Day9Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    protected String solve(@NonNull Program program) {
        final Execution<Nil,Nil> execution = program.launch(problemName(), ProgramIO.fromList("2").ignoreOutput());

        final ExecutionResult result = execution.waitTermination();

        if (result.numberOfOutput() != 1) {
            System.out.println("Opcode error :");
            result.forEachOutput(System.out::println);
            throw new AOCException("Invalid IntComputer");
        } else {
            return result.getLastOutput();
        }
    }
}
