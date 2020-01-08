package perococco.aoc.day20._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public class Portal {

    @NonNull
    @Getter
    private final String name;

    @NonNull
    @Getter
    private final Position entrance;

    @NonNull
    @Getter
    private final Position exit;

    @Getter
    private final boolean inside;

}
