package perococco.aoc.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Command {
    LEFT("L"),
    RIGHT("R"),
    ;

    @Getter
    private final String code;

}
