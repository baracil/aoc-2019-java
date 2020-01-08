package perococco.aoc.computer._private.io;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;
import perococco.aoc.computer.Output;

import java.util.concurrent.BlockingDeque;

@RequiredArgsConstructor
public class BlockingOutput implements Output {

    @NonNull
    private final BlockingDeque<String> queue;

    @Override
    public void writeToOutput(@NonNull String value) {
        try {
            queue.putLast(value);
        } catch (InterruptedException e) {
            throw new AOCException("Output writing interrupted",e);
        }
    }

}
