package perococco.aoc.launcher._private;

import lombok.NonNull;
import perococco.aoc.common.*;
import perococco.aoc.input.AOCProblem;
import perococco.aoc.input.AOCProblemId;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;

import java.util.Optional;
import java.util.ServiceLoader;

import static perococco.aoc.input.AOCProblem.AOC_PROBLEM_COMPARATOR;

public class ProblemService {

    public static AOCProblem<?> findLastDefinedProblem() {
        return ServiceLoader.load(AOCProblem.class)
                            .stream()
                            .map(ServiceLoader.Provider::get)
                            .map(p -> (AOCProblem<?>)p)
                            .max(AOC_PROBLEM_COMPARATOR)
                            .orElseThrow(() -> new AOCException("No AOCProgram could be found"));
    }

    @NonNull
    public static Day findLastDay() {
        return ServiceLoader.load(AOCProblem.class)
                            .stream()
                            .map(ServiceLoader.Provider::get)
                            .map(p -> (AOCProblem<?>)p)
                .map(AOCProblem::id)
                .map(AOCProblemId::day)
                .max(Day.DAY_COMPARATOR).orElseThrow();
    }

    public static Optional<? extends AOCProblem<?>> findProgramById(@NonNull String dayAsString,@NonNull String partAsString) {
        final Day day = Day.parse(dayAsString);
        final Part part = Part.parse(partAsString);
        return findProgramById(day, part);
    }

    public static Optional<? extends AOCProblem<?>> findProgramById(@NonNull Day day, @NonNull Part part) {
        final AOCProblemId problemId = new AOCProblemId(day, part);

        return ServiceLoader.load(AOCProblem.class)
                            .stream()
                            .map(ServiceLoader.Provider::get)
                            .filter(p -> p.id().equals(problemId))
                            .map(p -> (AOCProblem<?>)p)
                            .findFirst();

    }

    public static AOCProblem<?> getProgramById(@NonNull String dayAsString,@NonNull String partAsString) {
        final Day day = Day.parse(dayAsString);
        final Part part = Part.parse(partAsString);
        return getProgramById(day, part);
    }

    public static AOCProblem<?> getProgramById(@NonNull Day day, @NonNull Part part) {
        final AOCProblemId problemId = new AOCProblemId(day, part);
        return findProgramById(day,part).orElseThrow(() -> new AOCException("Could not find a problem with id "+problemId));
    }

}
