package perococco.aoc.computer._private.generic;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.util.concurrent.Future;

public interface PrivateComputer<V> extends Computer {

    @NonNull
    ExecutionResult execute(
            @NonNull String name,
            @NonNull ImmutableList<V> compiledCode,
            @NonNull IO io,
            @NonNull Alterations alterations
    );

    @NonNull
    Future<ExecutionResult> schedule(
            @NonNull String name,
            @NonNull ImmutableList<V> compiledCode,
            @NonNull IO io,
            @NonNull Alterations alterations
            );
}
