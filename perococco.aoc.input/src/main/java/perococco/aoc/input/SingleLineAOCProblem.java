package perococco.aoc.input;

import lombok.NonNull;
import perococco.aoc.common.AOCException;

import java.util.function.Function;
import java.util.stream.Stream;

public abstract class SingleLineAOCProblem<T> extends BaseAOCProblem<T> {

    public SingleLineAOCProblem(@NonNull Day day, @NonNull Part part) {
        super(day,part);
    }

    public SingleLineAOCProblem(@NonNull Day day, @NonNull Part part,
            @NonNull String line) {
        super(day, part, () -> Stream.of(line));
    }

    @NonNull
    protected String getInput() {
        return getInputStream().findFirst().orElseThrow(() -> new AOCException("Input file seems empty"));
    }

    @NonNull
    protected <A> A getInput(@NonNull Function<? super String, ? extends A> lineMapper) {
        return lineMapper.apply(getInput());
    }




}
