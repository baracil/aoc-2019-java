package perococco.aoc.day13._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;

@RequiredArgsConstructor
public class Tile {

    @NonNull
    @Getter
    private final Position position;

    @NonNull
    @Getter
    private final TileType type;

}
