package perococco.aoc.computer._private.operations;

import lombok.NonNull;
import perococco.aoc.common.Logger;
import perococco.aoc.computer._private.generic.ExecutionContext;

public class InputOperation<V> extends SequentialOperation<V> {

    public InputOperation() {
        super(1);
    }

    @Override
    protected void doPerform(@NonNull ExecutionContext<V> context) {
        Logger.get().log("[%s] Reading input",context.executionName());
        final V value = context.readFromInput();
        Logger.get().log("[%s] Got input value : %d",context.executionName(),value);
        context.setParameter(0, value);
    }
}
