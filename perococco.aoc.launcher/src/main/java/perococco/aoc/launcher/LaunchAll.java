package perococco.aoc.launcher;

import lombok.RequiredArgsConstructor;
import perococco.aoc.input.AOCProblem;
import perococco.aoc.launcher._private.Launcher;

import java.util.ServiceLoader;

@RequiredArgsConstructor
public class LaunchAll {

    public static void main(String[] args) {
        ServiceLoader.load(AOCProblem.class)
                     .stream()
                     .map(ServiceLoader.Provider::get)
                     .map(p -> (AOCProblem<?>)p)
                     .sorted(AOCProblem.AOC_PROBLEM_COMPARATOR)
                     .map(Launcher::new)
                     .forEach(Launcher::launch);

    }

}

