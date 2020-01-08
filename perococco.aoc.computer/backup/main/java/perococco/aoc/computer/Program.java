package perococco.aoc.computer;

import lombok.NonNull;

import java.util.concurrent.Future;

public interface Program {

    @NonNull
    ExecutionResult execute(
            @NonNull String executionName,
            @NonNull IO io,
            @NonNull Alterations alterations
    );

    @NonNull
    Future<ExecutionResult> executeAsync(
            @NonNull String executionName,
            @NonNull IO io,
            @NonNull Alterations alterations
    );


}
