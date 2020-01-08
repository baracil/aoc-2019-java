package perococco.aoc.computer._private.primitive;

import lombok.NonNull;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.MemoryAccessors;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public abstract class BaseMemoryOfPrimitive implements MemoryOfPrimitive {

    private final MemoryAccessors accessors;

    public BaseMemoryOfPrimitive() {
        this.accessors = new Accessors();
    }

    @Override
    public @NonNull MemoryAccessors hasMemoryAccessors() {
        return accessors;
    }

    @Override
    public void alter(@NonNull Alterations alterations) {
        alterations.forEach(this::alter);
    }

    private void alter(@NonNull Alterations.Alteration alteration) {
        setValue(alteration.address(), Long.parseLong(alteration.value()));
    }

    protected abstract LongStream streamOfValues();

    private class Accessors implements MemoryAccessors {

        @Override
        public String getValueAt(int address) {
            return String.valueOf(BaseMemoryOfPrimitive.this.getValueAt(address));
        }

        @Override
        public String dumpMemory() {
            return streamOfValues()
                         .mapToObj(String::valueOf)
                         .collect(Collectors.joining(","));
        }
    }

}
