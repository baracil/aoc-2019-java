package perococco.aoc.computer._private.generic.operations;

import lombok.NonNull;
import perococco.aoc.computer._private.AddressingUpdater;
import perococco.aoc.computer._private.generic.ExecutionContext;

public abstract class SequentialOperation<V> implements Operation<V> {

    private final int numberOfParameters;

    public SequentialOperation(int numberOfParameters) {
        this.numberOfParameters = numberOfParameters;
    }

    @Override
    public @NonNull AddressingUpdater perform(@NonNull ExecutionContext<V> context) {
        doPerform(context);
        return AddressingUpdater.skipAbsolute(numberOfParameters);
    }

    protected abstract void doPerform(@NonNull ExecutionContext<V> context);
}
