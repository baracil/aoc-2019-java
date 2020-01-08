import perococco.aoc.computer.ComputerFactory;

module perococco.aoc.computer.api {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires transitive perococco.aoc.computer.io;
    requires perococco.aoc.input;

    exports perococco.aoc.computer;

    uses ComputerFactory;
}
