package perococco.aoc.day17._private;

import lombok.NonNull;
import lombok.Value;
import perococco.aoc.common.Command;

import java.util.stream.Stream;

@Value
public class PathElement {

    @NonNull
    private final Command command;

    private final int displacement;

    @NonNull
    public Stream<String> stream() {
        return Stream.of(command.code(),String.valueOf(displacement));
    }


}
