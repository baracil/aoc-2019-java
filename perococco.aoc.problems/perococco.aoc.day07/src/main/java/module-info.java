import perococco.aoc.input.AOCProblem;
import perococco.aoc.day7.Day7Part1Problem;
import perococco.aoc.day7.Day7Part2Problem;

module perococco.aoc.day7 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day7;

    provides AOCProblem with Day7Part1Problem, Day7Part2Problem;
}
