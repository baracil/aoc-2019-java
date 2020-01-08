package perococco.aoc.day7;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.ProgramIO;

@RequiredArgsConstructor
public class LinearCircuit implements Circuit {

    @NonNull
    private final Program program;

    @NonNull
    public String launch(@NonNull Phase phase) {
        final int nbAmplifiers = phase.size();
        String result = "0";
        for (int i = 0; i < nbAmplifiers; i++) {
            final ExecutionResult executionResult = program.launchAndWait("Amp " + (i + 1),
                                                                          ProgramIO.fromList(phase.get(i),result)
                                                                                   .ignoreOutput()
            );
            result = executionResult.getLastOutput();
        }

        return result;
    }

}
