package perococco.aoc.day2;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import perococco.aoc.input.Part;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.Program;

import java.util.Optional;
import java.util.stream.IntStream;

public class Day2Part2Problem extends Day2Problem {

    public Day2Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    protected String solve(@NonNull Program program) {
        return new Solver(program, "19690720").launch().orElseThrow();
    }

    @RequiredArgsConstructor
    private static class Solver {

        @NonNull
        private final Program program;

        private final String outputTarget;

        @NonNull
        public Optional<String> launch() {
            return IntStream.range(0,9999)
                            .parallel()
                            .mapToObj(this::computeResult)
                            .filter(r -> r.outputIs(outputTarget))
                            .findAny()
                            .map(Result::input);

        }

        private Result computeResult(int input) {
            final Alterations alterations = createAlteration(input);
            final String output = program.launchAndWait("Day2 Part2",alterations).getFirstValueOfMemory();
            return new Result(Integer.toString(input),output);
        }

        @NonNull
        private Alterations createAlteration(int nounVerb) {
            final int noun = nounVerb/100;
            final int verb = nounVerb%100;
            return Alterations.none().addAlterations(1, Long.toString(noun), Long.toString(verb));
        }

        @Value
        private static class Result {
            private final String input;
            private final String output;

            public boolean outputIs(String value) {
                return output.equals(value);
            }
        }

    }

}
