package perococco.aoc.computer.io._private.input;

import lombok.NonNull;
import perococco.aoc.common.Nil;

import java.util.function.Supplier;

public class InputPortWithSupplier extends BaseInputPort<Nil> {

    @NonNull
    private final Supplier<? extends String> supplier;

    public InputPortWithSupplier(@NonNull Supplier<? extends String> supplier) {
        this.supplier = supplier;
    }

    @NonNull
    @Override
    public String read() {
        return supplier.get();
    }

    @NonNull
    @Override
    public Nil programInputAccessor() {
        return Nil.NIL;
    }
}
