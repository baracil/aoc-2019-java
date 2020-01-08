package perococco.aoc.computer;

import lombok.NonNull;

public interface Computer {

    @NonNull
    Program compile(@NonNull String code);

}
