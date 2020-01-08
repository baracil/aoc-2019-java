package perococco.aoc.computer._private.primitive;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.Computer;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.IO;

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
