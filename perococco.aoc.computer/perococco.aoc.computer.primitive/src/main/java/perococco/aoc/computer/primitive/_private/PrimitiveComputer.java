package perococco.aoc.computer.primitive._private;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer.*;
import perococco.aoc.computer.common.ExecutionWithFuture;
import perococco.aoc.computer.io.ProgramIO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

@RequiredArgsConstructor
public class PrimitiveComputer implements Computer {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool(new ThreadFactoryBuilder()
                                                                                                  .setDaemon(true)
                                                                                                  .setNameFormat("Computer-%d")
                                                                                                  .build()
    );

    @NonNull
    private final Function<long[],Memory> memoryAllocator;

    @Override
    public @NonNull Program compile(@NonNull String code) {
        return new ProgramUsingLong(this,code);
    }

    @NonNull
    public <I,O> Execution<O,I> executeAsync(String executionName, long[] code, @NonNull ProgramIO<O,I> programIO, Alterations alterations) {
        final Memory memory = prepareMemory(code,alterations);
        final Future<ExecutionResult> future = submitProgram(executionName,memory,programIO);

        return new ExecutionWithFuture<>(executionName, future, programIO);
    }

    @NonNull
    private Memory prepareMemory(long[] values, @NonNull Alterations alterations) {
        final Memory memory = memoryAllocator.apply(values);
        memory.alter(alterations);
        return memory;
    }

    @NonNull
    private Future<ExecutionResult> submitProgram(String executionName, Memory memory, @NonNull ProgramIO<?,?> programIO) {
        return EXECUTOR_SERVICE.submit(()->Processor.execute(executionName, memory, programIO));
    }

}
