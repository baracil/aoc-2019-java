import perococco.aoc.input.AOCProblem;
import perococco.aoc.day3.Day3Part1Problem;
import perococco.aoc.day3.Day3Part2Problem;

module perococco.aoc.day3 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;

    exports perococco.aoc.day3;

    provides AOCProblem with Day3Part1Problem, Day3Part2Problem;
}
