package perococco.aoc.computer._private.generic.operations;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer._private.AddressingUpdater;
import perococco.aoc.computer._private.generic.ExecutionContext;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class JumpOperation<V> implements Operation<V> {

    @NonNull
    private final Predicate<V> predicate;

    @Override
    public @NonNull AddressingUpdater perform(@NonNull ExecutionContext<V> context) {
        final V p0 = context.getParameter(0);
        final V p1 = context.getParameter(1);
        final int address = context.convertToAddress(p1);
        if (predicate.test(p0)) {
            return AddressingUpdater.jumpAbsolute(address);
        }
        else {
            return AddressingUpdater.skipAbsolute(2);
        }
    }
}
