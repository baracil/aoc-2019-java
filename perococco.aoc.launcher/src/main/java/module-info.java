import perococco.aoc.input.AOCProblem;

module perococco.aoc.launcher {
    requires static lombok;

    requires perococco.aoc.common;
    requires perococco.aoc.input;

    exports perococco.aoc.launcher;
    uses AOCProblem;
}
