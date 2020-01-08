package perococco.aoc.input;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.util.function.Function;
import java.util.stream.Stream;

public abstract class LineByLineAOCProblem<T> extends BaseAOCProblem<T> {

    public LineByLineAOCProblem(@NonNull Day day, @NonNull Part part) {
        super(day,part);
    }

    public LineByLineAOCProblem(@NonNull Day day, @NonNull Part part,
            @NonNull ImmutableList<String> lines) {
        super(day, part, new StreamOfLinesFromSomeLines(lines));
    }

    @NonNull
    protected Stream<String> getInput() {
        return getInputStream();
    }

    @NonNull
    protected <A> Stream<A> getInput(@NonNull Function<? super String, ? extends A> lineMapper) {
        return getInputStream().map(lineMapper);
    }




}
