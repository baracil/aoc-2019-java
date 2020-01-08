package perococco.aoc.computer._private.generic;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer._private.Modes;
import perococco.aoc.computer._private.operations.Operation;

@RequiredArgsConstructor
public class Instruction<V> {

    @NonNull
    @Getter
    private final Operation<V> operation;

    @Getter
    private final boolean stopInstruction;

    @NonNull
    @Getter
    private final Modes modes;


}
