package perococco.aoc.computer._private.generic;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.IO;
import perococco.aoc.computer.Program;

import java.util.concurrent.Future;

@RequiredArgsConstructor
public class IntProgram<V> implements Program {

    @NonNull
    @Getter
    private final ImmutableList<V> compiledCode;

    private final PrivateComputer<V> computer;

    @Override
    public @NonNull ExecutionResult execute(
            @NonNull String executionName,
            @NonNull IO io,
            @NonNull Alterations alterations
    ) {
        return computer.execute(executionName, this.compiledCode, io, alterations);
    }

    @Override
    public @NonNull Future<ExecutionResult> executeAsync(
            @NonNull String executionName,
            @NonNull IO io,
            @NonNull Alterations alterations
    ) {
        return computer.schedule(executionName, this.compiledCode, io, alterations);
    }
}
