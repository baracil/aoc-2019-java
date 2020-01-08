import perococco.aoc.input.AOCProblem;
import perococco.aoc.day6.Day6Part1Problem;
import perococco.aoc.day6.Day6Part2Problem;

module perococco.aoc.day6 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day6;

    provides AOCProblem with Day6Part1Problem, Day6Part2Problem;
}
