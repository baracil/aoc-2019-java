package perococco.aoc.launcher;

import lombok.RequiredArgsConstructor;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;
import perococco.aoc.launcher._private.Launcher;
import perococco.aoc.launcher._private.ProblemService;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
public class LaunchLastDay {

    public static void main(String[] args) {
        final Day lastDay = ProblemService.findLastDay();

        Arrays.stream(Part.values())
              .map(p -> ProblemService.findProgramById(lastDay,p))
              .flatMap(Optional::stream)
              .map(Launcher::new)
              .forEach(Launcher::launch);


    }

}

