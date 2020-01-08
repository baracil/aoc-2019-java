import perococco.aoc.input.AOCProblem;
import perococco.aoc.day12.Day12Part1Problem;
import perococco.aoc.day12.Day12Part2Problem;

module perococco.aoc.day12 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;


    exports perococco.aoc.day12;

    provides AOCProblem with Day12Part1Problem, Day12Part2Problem;
}
