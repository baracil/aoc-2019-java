package perococco.aoc.day20._private;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.common.DeadEndFiller;
import perococco.aoc.common.Position;

import java.util.stream.Stream;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public class MazeBuilder {


    @NonNull
    public static Maze buildNormal(@NonNull ArrayOfChar data) {
        return new MazeBuilder(data,false).build();
    }

    @NonNull
    public static Maze buildRecursive(@NonNull ArrayOfChar data) {
        return new MazeBuilder(data,true).build();
    }

    @NonNull
    private final ArrayOfChar data;

    private final boolean recursive;

    private ImmutableMap<String,ImmutableList<Portal>> portals;

    private Position startingPosition;

    private Position targetPosition;

    private ImmutableList<Teletransporter> teletransporters;

    private boolean[] walls;

    private Maze build() {
        this.findPortals();
        this.verifyPortals();
        this.createWallArray();
        this.extractStartingPosition();
        this.extractTargetPosition();
        this.extractTeleporters();
        return new Maze(walls,data.width(),data.height(),recursive,startingPosition,targetPosition,teletransporters);
    }

    private void extractStartingPosition() {
        startingPosition = portals.get("AA").get(0).exit();
    }

    private void extractTargetPosition() {
        targetPosition = portals.get("ZZ").get(0).exit();
    }

    private void extractTeleporters() {
        teletransporters = portals.values()
                                  .stream()
                                  .filter(l -> l.size()==2)
                                  .flatMap(l -> link2Portals(l.get(0),l.get(1)))
                                  .collect(ImmutableList.toImmutableList());
    }

    private Stream<Teletransporter> link2Portals(@NonNull Portal side1, @NonNull Portal side2) {
        if (!side1.name().equals(side2.name())) {
            throw new AOCException("Invalid portals, they must have the same name");
        }
        if (side1.inside() == side2.inside()) {
            throw new AOCException("Invalid portal connection "+side1.name());
        }
        return Stream.of(
                new Teletransporter(side1.entrance(),side2.exit(), side1.inside()),
                new Teletransporter(side2.entrance(),side1.exit(), side2.inside())
        );
    }

    private void createWallArray() {
        final Tile[] maze = data.convert(Tile::getTile, Tile[]::new);
        DeadEndFiller.fill(maze,data.width(),data.height(),t -> t == Tile.EMPTY, t -> t == Tile.WALL, Tile.WALL);
        this.walls = new boolean[maze.length];
        for (int i = 0; i < maze.length; i++) {
            walls[i] = maze[i] != Tile.EMPTY;
        }
    }

    private void extractTeletransporter() {

    }

    private void verifyPortals() {
        for (String portalName : portals.keySet()) {
            final int expectedNumberOfPortals = evaluateNumberOfExpectedPortalsFromPortalName(portalName);
            final int actualNumberOfPortals = portals.get(portalName).size();
            if (expectedNumberOfPortals != actualNumberOfPortals) {
                throw new AOCException("Invalid number of portal for '"+portalName+"'");
            }
        }
    }

    private int evaluateNumberOfExpectedPortalsFromPortalName(String portalName) {
        switch (portalName) {
            case "AA" :
            case "ZZ" :
                return 1;
            default:
                return 2;
        }
    }

    private void findPortals() {
        this.portals = PortalFinder.find(data);
    }
}
