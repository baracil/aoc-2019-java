package perococco.aoc.day6;

import lombok.NonNull;

public interface OrbitWalker {

    void enter(@NonNull Body body);

    void leave(@NonNull Body body);
}
