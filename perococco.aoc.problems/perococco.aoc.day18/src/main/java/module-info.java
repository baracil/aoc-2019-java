import perococco.aoc.day18.Day18Part1Problem;
import perococco.aoc.day18.Day18Part2Problem;
import perococco.aoc.input.AOCProblem;

module perococco.aoc.day18 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;

    exports perococco.aoc.day18;

    provides AOCProblem with Day18Part1Problem, Day18Part2Problem;

}
