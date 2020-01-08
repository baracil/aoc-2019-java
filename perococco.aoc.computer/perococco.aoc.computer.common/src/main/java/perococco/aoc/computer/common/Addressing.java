package perococco.aoc.computer.common;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Addressing {

    @Getter
    private final int absoluteBase;

    @Getter
    private final int relativeBase;

    @NonNull
    public Addressing moveAbsoluteByOne() {
        return addToAbsolute(1);
    }

    @NonNull
    public Addressing addToAbsolute(int steps) {
        return new Addressing(absoluteBase + steps, relativeBase);
    }

    @NonNull
    public Addressing addToRelative(int steps) {
        return new Addressing(absoluteBase, relativeBase + steps);
    }

    public Addressing jumpAbsolute(int newAbsolute) {
        return new Addressing(newAbsolute,relativeBase);
    }
}
