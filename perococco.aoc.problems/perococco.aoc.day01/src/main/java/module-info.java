import perococco.aoc.input.AOCProblem;

module perococco.aoc.day1 {
    requires static lombok;
    requires perococco.aoc.common;
    requires perococco.aoc.input;

    exports perococco.aoc.day1;

    provides AOCProblem with perococco.aoc.day1.Day1Part1Problem,perococco.aoc.day1.Day1Part2Problem;
}
