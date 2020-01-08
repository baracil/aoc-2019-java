package perococco.aoc.computer.primitive._private.operations;

import lombok.NonNull;
import perococco.aoc.common.Tools;
import perococco.aoc.computer.common.AddressingUpdater;
import perococco.aoc.computer.primitive._private.ExecutionContext;

/**
 * @author perococco
 **/
public class AdjustRelativeBase implements Operation {

    public AdjustRelativeBase() {
    }

    @Override
    public @NonNull AddressingUpdater perform(@NonNull ExecutionContext context) {
        final long value = context.getParameter(0);
        return a -> a.addToAbsolute(1).addToRelative(Tools.toInt(value));
    }
}
