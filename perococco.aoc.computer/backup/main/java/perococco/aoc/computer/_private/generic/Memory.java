package perococco.aoc.computer._private.generic;

import lombok.NonNull;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.MemoryAccessors;

public interface Memory<V> {

    void setValue(int address,@NonNull V value);

    void alter(@NonNull Alterations alterations);

    @NonNull
    V getValueAt(int address);

    @NonNull
    MemoryAccessors hasMemoryAccessors();



}
