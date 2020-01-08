package perococco.aoc.day20._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public class Teletransporter {

    @NonNull
    @Getter
    private final Position from;

    @NonNull
    @Getter
    private final Position to;

    @Getter
    private final boolean goesDeeper;

}
