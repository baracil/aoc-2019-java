package perococco.aoc.computer.primitive._private.operations;

import lombok.NonNull;
import perococco.aoc.common.Logger;
import perococco.aoc.computer.primitive._private.ExecutionContext;

public class OutputOperation extends SequentialOperation {

    public OutputOperation() {
        super(1);
    }

    @Override
    protected void doPerform(@NonNull ExecutionContext context) {
        final long value = context.getParameter(0);
        Logger.get().log("[%s] write output value : %d", context.executionName(),value);
        context.writeToOutput(value);
    }
}
