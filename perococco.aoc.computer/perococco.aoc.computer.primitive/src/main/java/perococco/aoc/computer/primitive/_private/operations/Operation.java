package perococco.aoc.computer.primitive._private.operations;

import lombok.NonNull;
import perococco.aoc.computer.common.AddressingUpdater;
import perococco.aoc.computer.primitive._private.ExecutionContext;

public interface Operation {

    @NonNull
    AddressingUpdater perform(@NonNull ExecutionContext context);

    @NonNull
    static <V> Operation nop() {
        return context -> AddressingUpdater.nop();
    }

}
