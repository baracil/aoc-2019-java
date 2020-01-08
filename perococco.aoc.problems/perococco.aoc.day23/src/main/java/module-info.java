import perococco.aoc.input.AOCProblem;
import perococco.aoc.day23.Day23Part1Problem;
import perococco.aoc.day23.Day23Part2Problem;

module perococco.aoc.day23 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.input;
    requires perococco.aoc.common;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day23;

    provides AOCProblem with Day23Part1Problem, Day23Part2Problem;

}
