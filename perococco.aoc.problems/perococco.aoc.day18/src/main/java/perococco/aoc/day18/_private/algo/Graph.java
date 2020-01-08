package perococco.aoc.day18._private.algo;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import perococco.aoc.day18._private.Key;
import perococco.aoc.day18._private.Keyring;
import perococco.aoc.day18._private.Maze;

import java.util.Optional;

public class Graph {

    @NonNull
    private final ImmutableMap<Trip,Route> fastestRoutes;


    public Graph(@NonNull Maze maze) {
        this.fastestRoutes = maze.findFastedRouteBetweenKeys();
    }

    public Optional<Route> findTravelableRoute(Key from, Key to, Keyring keyring) {
        final Trip trip = new Trip(from,to);
        final Route route = fastestRoutes.get(trip);
        if (route!=null&&route.allIntermediaryKeysHaveBeenObtained(keyring) && route.isNotBlocked(keyring)) {
            return Optional.of(route);
        }
        return Optional.empty();
    }

}
