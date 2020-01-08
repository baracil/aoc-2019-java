package perococco.aoc.input;

import lombok.NonNull;
import perococco.aoc.common.ArrayOfChar;

/**
 * @author perococco
 **/
public abstract class ArrayOfCharAOCProblem<T> extends BaseAOCProblem<T> {

    public ArrayOfCharAOCProblem(@NonNull Day day, @NonNull Part part) {
        super(day, part);
    }

    public ArrayOfCharAOCProblem(@NonNull Day day, @NonNull Part part, int priority) {
        super(day, part, priority);
    }

    public ArrayOfCharAOCProblem(@NonNull Day day, @NonNull Part part,
            @NonNull StreamOfLinesSupplier inputSupplier) {
        super(day, part, inputSupplier);
    }

    public ArrayOfCharAOCProblem(@NonNull Day day, @NonNull Part part,
            @NonNull StreamOfLinesSupplier inputSupplier, int priority) {
        super(day, part, inputSupplier, priority);
    }

    @NonNull
    protected ArrayOfChar getInput(char filling) {
        return getInputStream().collect(ArrayOfChar.collector(filling));
    }

    @NonNull
    protected ArrayOfChar getInput() {
        return getInput(' ');
    }
}
