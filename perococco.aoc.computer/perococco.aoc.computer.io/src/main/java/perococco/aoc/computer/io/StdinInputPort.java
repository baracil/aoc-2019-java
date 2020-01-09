package perococco.aoc.computer.io;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Nil;
import perococco.aoc.computer.io._private.InputPort;

import java.util.Scanner;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public class StdinInputPort implements InputPort<Nil> {

    @NonNull
    private final InputMultiTransformer<String> transformer;

    private final Scanner scanner = new Scanner(System.in);

    private ImmutableList<String> current = null;

    private int index = 0;

    @Override
    public @NonNull String read() {
        if (current == null || index>=current.size()) {
            index = 0;
            final String line = scanner.nextLine();
            if (line.equals("exit")) {
                throw new AOCException("Exit requested");
            }
            current = transformer.apply(line+"\n");
        }
        return current.get(index++);
    }

    @Override
    public Nil programInputAccessor() {
        return Nil.NIL;
    }
}
