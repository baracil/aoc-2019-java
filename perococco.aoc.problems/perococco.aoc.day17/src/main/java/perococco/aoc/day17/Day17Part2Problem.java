package perococco.aoc.day17;

import lombok.NonNull;
import perococco.aoc.common.Nil;
import perococco.aoc.input.Part;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.Execution;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.InputMultiTransformer;
import perococco.aoc.computer.io.OutputPartBuilder;
import perococco.aoc.computer.io.ProgramIO;
import perococco.aoc.computer.io.ProgramInput;
import perococco.aoc.day17._private.*;

public class Day17Part2Problem extends Day17Problem {

    public Day17Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    protected String solve(@NonNull Program program) {
        final Camera camera = new Camera(program);
        final Picture picture = camera.takePicture();
        final Path path = FullPathConstructor.constructFrom(picture);
        final MovementRules rules = PathBreaker.breakPath(path);


        final Execution<ProgramInput<String>,Nil> execution = program.launch("Vacuum",
                                                                             createProgramIO(false),
                                                                             Alterations.with(0, "2")
                                                                             );

        rules.feedProgram(execution.programInputAccessor());
        execution.programInputAccessor().write("n\n");

        final ExecutionResult result = execution.waitTermination();

        return result.getLastOutput();
    }




    @NonNull
    private ProgramIO<ProgramInput<String>,Nil> createProgramIO(boolean showToOutput) {
        final OutputPartBuilder<ProgramInput<String>> builder = ProgramIO.controlledInput(InputMultiTransformer.TO_ASCII);
        if (showToOutput) {
            return builder.toStdout(v -> {
                if (v.length() > 2) {
                    return v;
                }
                return String.valueOf((char) Integer.parseInt(v));
            });
        }
        else {
            return builder.ignoreOutput();
        }
    }

}
