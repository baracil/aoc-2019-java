package perococco.aoc.computer.primitive._private.operations;

import lombok.NonNull;
import perococco.aoc.common.Logger;
import perococco.aoc.computer.primitive._private.ExecutionContext;

public class InputOperation extends SequentialOperation {

    public InputOperation() {
        super(1);
    }

    @Override
    protected void doPerform(@NonNull ExecutionContext context) {
        Logger.get().log("[%s] Reading input",context.executionName());
        final long value = context.readFromInput();
        Logger.get().log("[%s] Got input value : %d", context.executionName(), value);
        context.setParameter(0, value);
    }
}
