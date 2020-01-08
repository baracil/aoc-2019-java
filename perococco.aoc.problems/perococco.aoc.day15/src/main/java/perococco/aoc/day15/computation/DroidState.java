package perococco.aoc.day15.computation;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;
import perococco.aoc.common.Printer;
import perococco.aoc.common.Tools;

import java.util.Map;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DroidState {

    public static final Position START = Position.of(0,0);

    @Getter
    private final Position position;

    @Getter
    private final ImmutableMap<Position,TileType> memory;

    public DroidState() {
        this.position = START;
        this.memory = ImmutableMap.of(position,TileType.START);
    }

    @NonNull
    public DroidState updateWhenHittingWall(@NonNull Position position) {
        return update(this.position, position, TileType.WALL);
    }

    @NonNull
    public DroidState updateWhenMovingOnEmptySpace(@NonNull Position position) {
        return update(position,position,TileType.EMPTY);
    }

    @NonNull
    public DroidState updateWhenMovingOnOxygen(@NonNull Position position) {
        return update(position,position,TileType.OXYGEN);
    }

    @NonNull
    private DroidState update(@NonNull Position newPosition, @NonNull Position position, @NonNull TileType newTile) {
        return update(newPosition,Tools.addValue(memory,position,newTile));
    }

    @NonNull
    private DroidState update(@NonNull Position newPosition, @NonNull ImmutableMap<Position,TileType> memory) {
        if (this.position.equals(newPosition) && this.memory.equals(memory)){
            return this;
        }
        return new DroidState(newPosition,memory);
    }


    @NonNull
    public ImmutableList<String> printMemory() {
        return new Printer(this::getRepresentation, " ").print(() -> memory.keySet().stream());
    }

    @NonNull
    public Position startPosition() {
        return START;
    }

    public Position oxygenPosition() {
        return memory.entrySet()
                     .stream()
                     .filter(e -> TileType.OXYGEN.equals(e.getValue()))
                     .map(Map.Entry::getKey)
                     .findFirst()
                     .orElseThrow();
    }

    @NonNull
    public TileType tileTypeFromMemory(@NonNull Position position) {
        return memory.getOrDefault(position,TileType.UNKNOWN);
    }

    private String getRepresentation(Position position) {
        final TileType tileType = memory.get(position);
        if (position.equals(this.position)) {
            if (tileType == TileType.OXYGEN) {
                return "X";
            }
            return "D";
        }
        return tileType == null? " ":tileType.representation();
    }


    public boolean samePosition(DroidState updatedState) {
        return position.equals(updatedState.position);
    }

    @NonNull
    public Maze createMazeFromMemory() {
        return Maze.create(memory);
    }
}
