package perococco.aoc.computer._private.operations;

import lombok.NonNull;
import perococco.aoc.common.Logger;
import perococco.aoc.computer._private.generic.ExecutionContext;

public class OutputOperation extends SequentialOperation {

    public OutputOperation() {
        super(1);
    }

    @Override
    protected void doPerform(@NonNull ExecutionContext context) {
        final int value = context.getParameterValue(0);
        Logger.get().log("[%s] write output value : %d", context.executionName(),value);
        context.writeToOutput(value);
    }
}
