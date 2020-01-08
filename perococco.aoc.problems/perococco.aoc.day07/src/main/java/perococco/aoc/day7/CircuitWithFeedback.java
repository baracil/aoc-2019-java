package perococco.aoc.day7;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;
import perococco.aoc.computer.Execution;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.Pipe;
import perococco.aoc.computer.io.ProgramIO;
import perococco.aoc.computer.io.ProgramInput;
import perococco.aoc.computer.io.ProgramOutput;

import java.util.Arrays;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class CircuitWithFeedback implements Circuit {

    @NonNull
    private final Program program;

    @Override
    @NonNull
    public String launch(@NonNull Phase phase) {
        final Launcher launcher = new Launcher(phase);
        final ExecutionResult results = launcher.launch();

        return results.getLastOutput();
    }

    private class Launcher {

        @NonNull
        private final Phase phase;

        private final int nbAmplifiers;

        private Pipe[] pipes;

        private ImmutableList<Execution<ProgramInput<String>,ProgramOutput<String>>> executions;

        public Launcher(@NonNull Phase phase) {
            this.phase = phase;
            this.nbAmplifiers = phase.size();
        }

        public ExecutionResult launch() {
            this.launchAllPrograms();
            this.initializeInputs();
            this.linkIOOffAmplifiers();

            return this.retrieveAllResults().get(nbAmplifiers-1);
        }

        private void linkIOOffAmplifiers() {
            final Pipe[] pipes =new Pipe[nbAmplifiers];

            for (int current = 0; current < executions.size(); current++) {
                final int next = (current+1)%nbAmplifiers;

                final ProgramOutput<String> currentOutput = executions.get(current).programOutputAccessor();
                final ProgramInput<String> nextInput = executions.get(next).programInputAccessor();

                pipes[current] = currentOutput.pipeTo(nextInput);
            }

            this.pipes = pipes;
        }

        private void initializeInputs() {
            for (int i = 0; i < nbAmplifiers; i++) {
                executions.get(i).programInputAccessor().write(phase.get(i));
            }
            executions.get(0).programInputAccessor().write("0");
        }

        private void launchAllPrograms() {
            this.executions = IntStream.range(0,nbAmplifiers)
                                       .mapToObj(i -> "Amp "+i)
                                       .map(name -> program.launch(name, ProgramIO.duplex()))
                                       .collect(ImmutableList.toImmutableList());
        }

        private ImmutableList<ExecutionResult> retrieveAllResults() {
            try {
                return executions.stream()
                                 .map(e -> {
                                     try {
                                         return e.waitTermination();
                                     } catch (Throwable ex) {
                                         throw new AOCException("Processor failed", ex);
                                     }
                                 }).collect(ImmutableList.toImmutableList());
            } finally {
                Arrays.stream(pipes).forEach(Pipe::close);
            }
        }


    }



}
