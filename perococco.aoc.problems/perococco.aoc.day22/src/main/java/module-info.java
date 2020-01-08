import perococco.aoc.input.AOCProblem;
import perococco.aoc.day22.Day22Part1Problem;
import perococco.aoc.day22.Day22Part2Problem;

module perococco.aoc.day22 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.input;
    requires perococco.aoc.common;

    exports perococco.aoc.day22;

    provides AOCProblem with Day22Part1Problem, Day22Part2Problem;

}
