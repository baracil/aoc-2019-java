import perococco.aoc.input.AOCProblem;
import perococco.aoc.day16.Day16Part1Problem;
import perococco.aoc.day16.Day16Part2Problem;

module perococco.aoc.day16 {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.input;

    exports perococco.aoc.day16;

    provides AOCProblem with Day16Part1Problem, Day16Part2Problem;

}
