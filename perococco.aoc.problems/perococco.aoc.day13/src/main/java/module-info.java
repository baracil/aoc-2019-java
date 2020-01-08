import perococco.aoc.input.AOCProblem;
import perococco.aoc.day13.Day13Part1Problem;
import perococco.aoc.day13.Day13Part2Problem;

module perococco.aoc.day13 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day13;

    provides AOCProblem with Day13Part1Problem, Day13Part2Problem;
}
