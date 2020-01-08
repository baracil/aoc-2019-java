import perococco.aoc.input.AOCProblem;
import perococco.aoc.day21.Day21Part1Problem;
import perococco.aoc.day21.Day21Part2Problem;

module perococco.aoc.day21 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;
    requires perococco.aoc.robot;

    exports perococco.aoc.day21;

    provides AOCProblem with Day21Part1Problem, Day21Part2Problem;

}
