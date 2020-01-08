import perococco.aoc.input.AOCProblem;
import perococco.aoc.day11.Day11Part1Problem;
import perococco.aoc.day11.Day11Part2Problem;

module perococco.aoc.day11 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;
    requires perococco.aoc.robot;


    exports perococco.aoc.day11;

    provides AOCProblem with Day11Part1Problem, Day11Part2Problem;
}
