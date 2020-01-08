package perococco.aoc.day7;

import lombok.NonNull;

public interface Circuit {

    @NonNull
    String launch(@NonNull Phase phase);

}
