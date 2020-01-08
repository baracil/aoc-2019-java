package perococco.aoc.computer.primitive;

import lombok.NonNull;
import perococco.aoc.computer.BitSize;
import perococco.aoc.computer.Computer;
import perococco.aoc.computer.ComputerFactory;
import perococco.aoc.computer.MemoryType;
import perococco.aoc.computer.primitive._private.FixedSizeMemory;
import perococco.aoc.computer.primitive._private.PrimitiveComputer;

public class FixSizeLongValueComputerFactory implements ComputerFactory {

    @Override
    public boolean verifyAllProperties(@NonNull BitSize minimalBitSize,@NonNull MemoryType memoryType) {
        return (minimalBitSize == BitSize.BIT_32 || minimalBitSize == BitSize.BIT_64) && memoryType == MemoryType.FIXED;
    }

    @Override
    public @NonNull Computer create() {
        return new PrimitiveComputer(FixedSizeMemory::new);
    }
}
