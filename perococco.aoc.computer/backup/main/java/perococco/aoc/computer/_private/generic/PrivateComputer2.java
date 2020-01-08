package perococco.aoc.computer._private.generic;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.IO;
import perococco.aoc.computer.Program;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RequiredArgsConstructor
public class PrivateComputer2<V> implements PrivateComputer<V> {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool(new ThreadFactoryBuilder()
                                                                                                  .setDaemon(true)
                                                                                                  .setNameFormat("Computer %d")
                                                                                                  .build());
    @NonNull
    private final Interpreter<V> interpreter;

    @Override
    public @NonNull Program compile(@NonNull String code) {
        final ImmutableList<V> compiledCode = Arrays. stream(code.split(",")).map(interpreter::toValue).collect(ImmutableList.toImmutableList());
        return new IntProgram<>(compiledCode, this);
    }

    @Override
    public @NonNull ExecutionResult execute(
            @NonNull String name,
            @NonNull ImmutableList<V> program,
            @NonNull IO io,
            @NonNull Alterations alterations) {
        //TODO
        return null;
    }

    @Override
    public @NonNull Future<ExecutionResult> schedule(@NonNull String name, @NonNull ImmutableList<V> compiledCode,
            @NonNull IO io, @NonNull Alterations alterations) {
        return EXECUTOR_SERVICE.submit(() -> execute(name,compiledCode,io,alterations));
    }
}
