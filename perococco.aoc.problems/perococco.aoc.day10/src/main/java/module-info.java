import perococco.aoc.input.AOCProblem;
import perococco.aoc.day10.Day10Part1Problem;
import perococco.aoc.day10.Day10Part2Problem;

module perococco.aoc.day10 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day10;

    provides AOCProblem with Day10Part1Problem, Day10Part2Problem;
}
