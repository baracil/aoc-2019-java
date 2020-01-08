package perococco.aoc.computer.primitive;

import lombok.NonNull;
import perococco.aoc.computer.BitSize;
import perococco.aoc.computer.Computer;
import perococco.aoc.computer.ComputerFactory;
import perococco.aoc.computer.MemoryType;
import perococco.aoc.computer.primitive._private.PrimitiveComputer;
import perococco.aoc.computer.primitive._private.VariableSizeMemory;

public class VariableSizeLongValueComputerFactory implements ComputerFactory {

    @Override
    public boolean verifyAllProperties(@NonNull BitSize minimalBitSize,@NonNull MemoryType memoryType) {
        return (minimalBitSize == BitSize.BIT_32 || minimalBitSize == BitSize.BIT_64) && memoryType == MemoryType.VARIABLE;
    }

    @Override
    public @NonNull Computer create() {
        return new PrimitiveComputer(VariableSizeMemory::new);
    }
}
