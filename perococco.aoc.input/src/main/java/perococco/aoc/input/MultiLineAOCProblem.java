package perococco.aoc.input;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.*;

import java.util.function.Function;

public abstract class MultiLineAOCProblem<T> extends BaseAOCProblem<T> {

    private final int numberOfRequiredLines;

    public MultiLineAOCProblem(@NonNull Day day, @NonNull Part part, int numberOfRequiredLines) {
        super(day, part);
        this.numberOfRequiredLines = numberOfRequiredLines;
    }

    public MultiLineAOCProblem(@NonNull Day day, @NonNull Part part, int numberOfRequiredLines, @NonNull StreamOfLinesSupplier streamOfLinesSupplier) {
        super(day, part,streamOfLinesSupplier);
        this.numberOfRequiredLines = numberOfRequiredLines;
    }

    @NonNull
    protected ImmutableList<String> getInput() {
        return getInput(s -> s);
    }

    @NonNull
    protected <A> ImmutableList<A> getInput(@NonNull Function<? super String, ? extends A> lineMapper) {
        final ImmutableList<A> input = getInputStream().limit(numberOfRequiredLines)
                                                       .map(lineMapper)
                                                       .collect(ImmutableList.toImmutableList());
        if (input.size() != numberOfRequiredLines){
            throw new AOCException("Invalid input file. Needs " + numberOfRequiredLines + " lines. Got only " + input.size());
        }

        return input;
    }


}
