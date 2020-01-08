import perococco.aoc.input.AOCProblem;
import perococco.aoc.day17.Day17Part1Problem;
import perococco.aoc.day17.Day17Part2Problem;

module perococco.aoc.day17 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day17;

    provides AOCProblem with Day17Part1Problem, Day17Part2Problem;

}
