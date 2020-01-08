package perococco.aoc.computer.primitive._private.operations;

import lombok.NonNull;
import perococco.aoc.computer.common.AddressingUpdater;
import perococco.aoc.computer.primitive._private.ExecutionContext;

public abstract class SequentialOperation implements Operation {

    private final int numberOfParameters;

    public SequentialOperation(int numberOfParameters) {
        this.numberOfParameters = numberOfParameters;
    }

    @Override
    public @NonNull AddressingUpdater perform(@NonNull ExecutionContext context) {
        doPerform(context);
        return AddressingUpdater.skipAbsolute(numberOfParameters);
    }

    protected abstract void doPerform(@NonNull ExecutionContext context);
}
