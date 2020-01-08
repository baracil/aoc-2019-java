package perococco.aoc.computer.primitive._private.operations;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Tools;
import perococco.aoc.computer.common.AddressingUpdater;
import perococco.aoc.computer.primitive._private.ExecutionContext;

import java.util.function.LongPredicate;

@RequiredArgsConstructor
public class JumpOperation implements Operation {

    @NonNull
    private final LongPredicate predicate;

    @Override
    public @NonNull AddressingUpdater perform(@NonNull ExecutionContext context) {
        final long p0 = context.getParameter(0);
        final long p1 = context.getParameter(1);
        final int address = Tools.toInt(p1);
        if (predicate.test(p0)) {
            return AddressingUpdater.jumpAbsolute(address);
        }
        else {
            return AddressingUpdater.skipAbsolute(2);
        }
    }
}
