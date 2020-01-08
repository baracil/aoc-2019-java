package perococco.aoc.computer._private.io;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;
import perococco.aoc.computer.Input;

import java.util.concurrent.BlockingDeque;

@RequiredArgsConstructor
public class BlockingInput implements Input {

    @NonNull
    private final BlockingDeque<String> queue;

    @Override
    public String readFromInput() {
        try {
            return queue.takeFirst();
        } catch (InterruptedException e) {
            throw new AOCException("Input reading interrupted",e);
        }
    }
}
