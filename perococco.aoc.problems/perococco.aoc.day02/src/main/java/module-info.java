import perococco.aoc.input.AOCProblem;
import perococco.aoc.day2.Day2Part1Problem;
import perococco.aoc.day2.Day2Part2Problem;

module perococco.aoc.day2 {
    requires static lombok;

    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day2;

    provides AOCProblem with Day2Part1Problem, Day2Part2Problem;
}
