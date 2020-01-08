import perococco.aoc.input.AOCProblem;
import perococco.aoc.day14.Day14Part1Problem;
import perococco.aoc.day14.Day14Part2Problem;

module perococco.aoc.day14 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;

    exports perococco.aoc.day14;

    provides AOCProblem with Day14Part1Problem, Day14Part2Problem;
}
