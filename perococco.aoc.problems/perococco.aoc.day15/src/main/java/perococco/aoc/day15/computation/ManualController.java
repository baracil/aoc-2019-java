package perococco.aoc.day15.computation;

import lombok.NonNull;
import perococco.aoc.common.Orientation;
import perococco.aoc.common.Position;

import java.util.Optional;
import java.util.Scanner;

public class ManualController extends AbstractController {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    protected @NonNull Optional<Orientation> getFirstOrder(@NonNull Position currentPosition) {
        final String code = scanner.next();
        return Optional.of(Orientation.decode(code));
    }

    @Override
    protected @NonNull Optional<Orientation> evaluateNextOrder(
            @NonNull DroidState previousState,
            @NonNull Orientation sentOrder,
            @NonNull Reply replyToSentOrder,
            @NonNull DroidState updateState) {
        updateState.printMemory().forEach(System.err::println);
        return getFirstOrder(updateState.position());
    }
}
