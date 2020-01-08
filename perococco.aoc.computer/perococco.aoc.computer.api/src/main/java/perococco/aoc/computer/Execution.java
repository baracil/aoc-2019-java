package perococco.aoc.computer;

import lombok.NonNull;
import perococco.aoc.computer.io.ProgramIOAccessors;

import java.util.concurrent.CompletionStage;

public interface Execution<I, O> extends ProgramIOAccessors<I,O> {

    @NonNull
    String name();

    @NonNull
    CompletionStage<Void> whenDone(@NonNull Runnable action);

    @NonNull
    ExecutionResult waitTermination();

    void interrupt();

    boolean isDone();


}
