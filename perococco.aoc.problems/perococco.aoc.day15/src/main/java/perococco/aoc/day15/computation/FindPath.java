package perococco.aoc.day15.computation;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;

import java.util.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FindPath {

    public static ImmutableMap<Position,Integer> computeDistance(@NonNull ImmutableMap<Position,TileType> maze, @NonNull Position start, @NonNull Position end) {
        return new FindPath(maze,start,end).computeDistance();
    }

    private final ImmutableMap<Position,TileType> maze;

    private final Position start;

    private final Position end;

    private final Map<Position,Integer> distances = new HashMap<>();

    private final Deque<Position> queue = new LinkedList<>();

    @NonNull
    public ImmutableMap<Position,Integer> computeDistance() {
        queue.addLast(start);
        distances.put(start,0);

        while (!queue.isEmpty()) {
            final Position current = queue.removeFirst();
            final int dist = distances.get(current);
            getNeighbours(current).stream()
                                  .filter(this::usable)
            .forEach(p -> {
                distances.put(p,dist+1);
                queue.addLast(p);
            });
        }
        return ImmutableMap.copyOf(distances);
    }

    private boolean usable(Position position) {
        final TileType type = maze.getOrDefault(position,TileType.WALL);
        return !distances.containsKey(position) && type.canWalkThere();
    }

    @NonNull
    private ImmutableList<Position> getNeighbours(@NonNull Position center) {
        return ImmutableList.of(center.right(), center.up(), center.down(), center.left());
    }


}
