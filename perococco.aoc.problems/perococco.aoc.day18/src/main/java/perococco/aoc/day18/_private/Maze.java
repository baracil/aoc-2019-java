package perococco.aoc.day18._private;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Tools;
import perococco.aoc.day18._private.algo.FastestRouteFinder;
import perococco.aoc.day18._private.algo.Route;
import perococco.aoc.day18._private.algo.Trip;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Maze {

    @NonNull
    public static Collector<String,?,Maze> collector(boolean splitInput) {
        return Collectors.collectingAndThen(
                ImmutableList.toImmutableList(),
                splitInput?MazeBuilder::splitAndCreate:MazeBuilder::create
        );
    }

    private final Pos[] cache;

    @NonNull
    private final boolean[] walls;

    @Getter
    private final int width;

    private final int height;

    @NonNull
    private final ImmutableMap<Pos,Door> doorPositions;

    @NonNull
    private final ImmutableBiMap<Pos,Key> keyPositions;

    @Getter
    @NonNull
    private final ImmutableList<Key> startingKeys;

    public Maze(@NonNull boolean[] walls, int width, int height, ImmutableMap<Door,Integer> doorIndexes, ImmutableMap<Key,Integer> keyIndexes) {
        this.cache = IntStream.range(0,width*height).mapToObj(i -> new Pos(this,i)).toArray(Pos[]::new);
        this.walls = walls;
        this.width = width;
        this.height = height;

        this.doorPositions = doorIndexes.entrySet()
                                        .stream()
                                        .collect(ImmutableMap.toImmutableMap(e -> cache[e.getValue()],
                                                                             Map.Entry::getKey));

        this.keyPositions = keyIndexes.entrySet()
                                      .stream()
                                      .collect(ImmutableBiMap.toImmutableBiMap(e -> cache[e.getValue()],
                                                                               Map.Entry::getKey));

        this.startingKeys = keyPositions.values().stream().filter(Key::isStart).collect(ImmutableList.toImmutableList());
    }

    public void printToStandardOutput() {
        print(System.out);
    }

    public void print(@NonNull PrintStream ps) {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                final int idx = h*width+w;
                final Pos pos = toPosition(idx);
                final String c;
                if (walls[idx]) {
                    c = "#";
                } else {
                    final Door door = doorPositions.get(pos);
                    final Key key = keyPositions.get(pos);
                    if (door != null) {
                        c = door.idOfItsKey().toUpperCase();
                    } else if (key != null) {
                        c = key.isStart()?"@":key.id();
                    } else {
                        c =" ";
                    }
                }
                ps.print(c);
            }
            ps.println();
        }
    }

    public Pos toPosition(int idx) {
        return cache[idx];
    }

    public Pos aboveOf(Pos pos) {
        return cache[pos.idx()-width];
    }

    public Pos belowOf(Pos pos) {
        return cache[pos.idx()+width];
    }

    public Pos rightTo(@NonNull Pos pos) {
        return cache[pos.idx()+1];
    }

    public Pos leftTo(@NonNull Pos pos) {
        return cache[pos.idx()-1];
    }

    public boolean isWall(@NonNull Pos pos) {
        return walls[pos.idx()];
    }

    public boolean isKeyAndNotStartingPoint(@NonNull Pos pos) {
        final Key key = keyPositions.get(pos);
        return key != null && !key.isStart();
    }

    public boolean isNotAStartingPoint(@NonNull Pos pos) {
        final Key key = keyPositions.get(pos);
        return key == null || !key.isStart();

    }

    public boolean isDoor(@NonNull Pos pos) {
        return doorPositions.containsKey(pos);
    }

    @NonNull
    public Optional<Door> getDoorAt(@NonNull Pos pos) {
        final Door door = doorPositions.get(pos);
        return Optional.ofNullable(door);
    }

    @NonNull
    public Optional<Key> getKeyAt(Pos pos) {
        final Key key = keyPositions.get(pos);
        return Optional.ofNullable(key);
    }

    @NonNull
    public ImmutableMap<Trip,Route> findFastedRouteBetweenKeys() {
        return keyPositions.values()
                           .stream()
                           .map(this::findFastestRouteToOtherKeys)
                           .flatMap(Collection::stream)
                           .collect(Tools.toImmutableMap(Route::trip));
    }

    @NonNull
    private ImmutableList<Route> findFastestRouteToOtherKeys(@NonNull Key reference) {
        return FastestRouteFinder.findFastestRouteToOtherKeys(this, reference);
    }

    public int numberOfKeys() {
        return keyPositions.size();
    }

    public ImmutableSet<Key> allKeys() {
        return keyPositions.inverse().keySet();
    }

    public Pos keyPosition(Key key) {
        final Pos pos = keyPositions.inverse().get(key);
        if (pos == null) {
            throw new AOCException("Could not find key '"+key.id()+"'");
        }
        return pos;
    }

}
