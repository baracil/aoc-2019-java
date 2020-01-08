import perococco.aoc.input.AOCProblem;
import perococco.aoc.day9.Day9Part1Problem;
import perococco.aoc.day9.Day9Part2Problem;

module perococco.aoc.day9 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day9;

    provides AOCProblem with Day9Part1Problem, Day9Part2Problem;
}
