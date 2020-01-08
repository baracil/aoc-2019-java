import perococco.aoc.input.AOCProblem;
import perococco.aoc.day8.Day8Part1Problem;
import perococco.aoc.day8.Day8Part2Problem;

module perococco.aoc.day8 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day8;

    provides AOCProblem with Day8Part1Problem, Day8Part2Problem;
}
