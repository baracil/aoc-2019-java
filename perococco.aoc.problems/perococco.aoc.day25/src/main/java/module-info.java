import perococco.aoc.input.AOCProblem;
import perococco.aoc.day25.Day25Part1Problem;
import perococco.aoc.day25.Day25Part2Problem;

module perococco.aoc.day25 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.input;
    requires perococco.aoc.common;
    requires perococco.aoc.computer.api;

    exports perococco.aoc.day25;

    provides AOCProblem with Day25Part1Problem, Day25Part2Problem;

}
