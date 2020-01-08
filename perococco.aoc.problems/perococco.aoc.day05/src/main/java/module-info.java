import perococco.aoc.input.AOCProblem;
import perococco.aoc.day5.Day5Part1Problem;
import perococco.aoc.day5.Day5Part2Problem;

module perococco.aoc.day5 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day5;

    provides AOCProblem with Day5Part1Problem, Day5Part2Problem;
}
