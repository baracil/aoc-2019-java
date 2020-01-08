package perococco.aoc.computer.primitive._private;

import lombok.NonNull;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.MemoryAccessors;

public interface Memory {

    void setValue(int address, long value);

    void alter(@NonNull Alterations alterations);

    long getValueAt(int address);

    @NonNull
    MemoryAccessors hasMemoryAccessors();

}
