package perococco.aoc.input;

import lombok.Getter;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class BaseAOCProblem<T> implements AOCProblem<T> {

    @NonNull
    @Getter
    private final AOCProblemId id;

    @Getter
    private final int priority;

    private final StreamOfLinesSupplier inputSupplier;

    public BaseAOCProblem(@NonNull Day day, @NonNull Part part) {
        this(day,part,0);
    }

    public BaseAOCProblem(@NonNull Day day, @NonNull Part part, int priority) {
        this.id = new AOCProblemId(day,part);
        this.priority = priority;
        this.inputSupplier = new StreamOfLinesFromResource(day);
    }

    public BaseAOCProblem(@NonNull Day day, @NonNull Part part, @NonNull StreamOfLinesSupplier inputSupplier) {
        this(day,part,inputSupplier,0);
    }

    public BaseAOCProblem(@NonNull Day day, @NonNull Part part, @NonNull StreamOfLinesSupplier inputSupplier, int priority) {
        this.id = new AOCProblemId(day,part);
        this.priority = priority;
        this.inputSupplier = inputSupplier;
    }

    @NonNull
    public Part part() {
        return id.part();
    }

    @Override
    public abstract @NonNull T solution();

    @NonNull
    protected Stream<String> getInputStream() {
        return inputSupplier.lines();
    }

}
