package perococco.aoc.computer;

import lombok.NonNull;
import perococco.aoc.computer._private.io.BlockingOutput;

import java.util.concurrent.BlockingDeque;
import java.util.function.Consumer;

public interface Output {

    void writeToOutput(String value);

    @NonNull
    default Output then(@NonNull Output after) {
        return i -> {
            this.writeToOutput(i);
            after.writeToOutput(i);
        };
    }

    @NonNull
    static Output ignoreOutput() {
        return i -> {};
    }

    @NonNull
    static Output with(@NonNull Consumer<? super String> consumer) {
        return consumer::accept;
    }

    @NonNull
    static Output stdOutput() {
        return with(System.out::println);
    }

    @NonNull
    static Output blockingOutput(@NonNull BlockingDeque<String> deque) {
        return new BlockingOutput(deque);
    }

}
