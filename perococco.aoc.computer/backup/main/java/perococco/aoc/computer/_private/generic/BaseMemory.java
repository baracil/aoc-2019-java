package perococco.aoc.computer._private.generic;

import lombok.NonNull;
import perococco.aoc.common.Parser;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.MemoryAccessors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BaseMemory<V> implements Memory<V> {

    private final Parser<V> parser;

    private final MemoryAccessors accessors;

    public BaseMemory(Parser<V> parser) {
        this.parser = parser;
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
        setValue(alteration.address(), parser.toValue(alteration.value()));
    }

    protected abstract Stream<V> streamOfValues();

    private class Accessors implements MemoryAccessors {

        @Override
        public String getValueAt(int address) {
            return parser.toString(BaseMemory.this.getValueAt(address));
        }

        @Override
        public String dumpMemory() {
            return streamOfValues()
                         .map(parser::toString)
                         .collect(Collectors.joining(","));
        }
    }

}
