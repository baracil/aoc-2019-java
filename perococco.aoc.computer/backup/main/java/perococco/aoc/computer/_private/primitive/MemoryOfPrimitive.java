package perococco.aoc.computer._private.primitive;

import lombok.NonNull;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.MemoryAccessors;

public interface MemoryOfPrimitive {

    void setValue(int address, long value);

    void alter(@NonNull Alterations alterations);

    long getValueAt(int address);

    @NonNull
    MemoryAccessors hasMemoryAccessors();

}
