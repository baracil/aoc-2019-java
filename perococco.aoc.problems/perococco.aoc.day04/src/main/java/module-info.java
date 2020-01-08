import perococco.aoc.input.AOCProblem;
import perococco.aoc.day4.Day4Part1Problem;
import perococco.aoc.day4.Day4Part2Problem;

module perococco.aoc.day4 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;

    exports perococco.aoc.day4;

    provides AOCProblem with Day4Part1Problem, Day4Part2Problem;
}
