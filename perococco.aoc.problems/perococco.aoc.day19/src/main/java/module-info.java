import perococco.aoc.input.AOCProblem;
import perococco.aoc.day19.Day19Part1Problem;
import perococco.aoc.day19.Day19Part2Problem;

module perococco.aoc.day19 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;
    requires perococco.aoc.robot;

    exports perococco.aoc.day19;

    provides AOCProblem with Day19Part1Problem, Day19Part2Problem;

}
