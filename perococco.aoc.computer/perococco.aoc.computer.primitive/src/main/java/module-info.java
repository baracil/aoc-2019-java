import perococco.aoc.computer.ComputerFactory;
import perococco.aoc.computer.primitive.FixSizeLongValueComputerFactory;
import perococco.aoc.computer.primitive.VariableSizeLongValueComputerFactory;

module perococco.aoc.computer.primitive {
    requires static lombok;

    requires com.google.common;
    requires perococco.aoc.common;
    requires perococco.aoc.computer.api;
    requires perococco.aoc.computer.commom;

    exports perococco.aoc.computer.primitive;

    provides ComputerFactory with FixSizeLongValueComputerFactory, VariableSizeLongValueComputerFactory;
}
