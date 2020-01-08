package perococco.aoc.computer;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.computer._private.io.BlockingInput;
import perococco.aoc.computer._private.io.FixInput;

import java.util.concurrent.BlockingDeque;

public interface Input {

    String readFromInput();

    @NonNull
    static Input noInput() {
        return () -> {throw new AOCException("No input available");};
    }

    @NonNull
    static Input fixInput(@NonNull ImmutableList<String> inputs) {
        return new FixInput(inputs);
    }

    @NonNull
    static Input blockingInput(@NonNull BlockingDeque<String> deque) {
        return new BlockingInput(deque);
    }
}
