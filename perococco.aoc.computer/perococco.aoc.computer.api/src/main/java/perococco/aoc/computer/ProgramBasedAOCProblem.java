package perococco.aoc.computer;

import lombok.NonNull;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;
import perococco.aoc.input.SingleLineAOCProblem;

import java.util.function.Supplier;

/**
 * @author perococco
 **/
public abstract class ProgramBasedAOCProblem<T> extends SingleLineAOCProblem<T> {

    private final Supplier<Computer> computerSupplier;

    public ProgramBasedAOCProblem(@NonNull Day day, @NonNull Part part) {
        super(day, part);
        this.computerSupplier = Computer::create;
    }

    public ProgramBasedAOCProblem(
            @NonNull Day day, @NonNull Part part,
            @NonNull ComputerFactory computerFactory,
            @NonNull String line) {
        super(day, part, line);
        this.computerSupplier = computerFactory::create;
    }

    protected @NonNull Program getProgram() {
        final Computer computer = computerSupplier.get();
        return computer.compile(getInput());
    }
}
