import perococco.aoc.input.AOCProblem;
import perococco.aoc.day20.Day20Part1Problem;
import perococco.aoc.day20.Day20Part2Problem;

module perococco.aoc.day20 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;

    exports perococco.aoc.day20;

    provides AOCProblem with Day20Part1Problem, Day20Part2Problem;

}
