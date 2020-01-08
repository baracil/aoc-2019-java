package perococco.aoc.computer._private.generic.operations;

import lombok.NonNull;
import perococco.aoc.computer._private.AddressingUpdater;
import perococco.aoc.computer._private.generic.ExecutionContext;

public interface Operation<V> {

    @NonNull
    AddressingUpdater perform(@NonNull ExecutionContext<V> context);

    @NonNull
    static <V> Operation<V> nop() {
        return context -> AddressingUpdater.nop();
    }

}
