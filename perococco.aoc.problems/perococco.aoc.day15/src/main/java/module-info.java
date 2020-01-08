import perococco.aoc.input.AOCProblem;
import perococco.aoc.day15.Day15Part1Problem;
import perococco.aoc.day15.Day15Part2Problem;

module perococco.aoc.day15 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;
    requires perococco.aoc.robot;

    exports perococco.aoc.day15;

    provides AOCProblem with Day15Part1Problem, Day15Part2Problem;
}
