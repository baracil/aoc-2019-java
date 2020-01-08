import perococco.aoc.input.AOCProblem;
import perococco.aoc.day24.Day24Part1Problem;
import perococco.aoc.day24.Day24Part2Problem;

module perococco.aoc.day24 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.input;
    requires perococco.aoc.common;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day24;

    provides AOCProblem with Day24Part1Problem, Day24Part2Problem;

}
