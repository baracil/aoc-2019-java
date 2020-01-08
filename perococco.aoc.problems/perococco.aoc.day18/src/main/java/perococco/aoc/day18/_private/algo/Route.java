package perococco.aoc.day18._private.algo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import lombok.*;
import perococco.aoc.day18._private.Door;
import perococco.aoc.day18._private.Key;
import perococco.aoc.day18._private.Keyring;

/**
 * A route between to key (forming a trip). A route is oriented (it has a start and an end). The orientation
 * is necessary because of possible doors on the route that might be opened while traveling the route.
 *
 * By construction, the doors on this route that might be opened while traveling
 * on this route are not listed in the {@link #doorsOnTheWay} set.
 *
 */
@RequiredArgsConstructor
@Builder(builderClassName = "Builder")
public class Route {

    @NonNull
    @Getter
    private final Trip trip;

    @Getter
    private final int length;

    @NonNull
    @Singular
    private final ImmutableList<Key> intermediaryKeys;

    @NonNull
    @Singular(value = "doorOnTheWay")
    private final ImmutableSet<Door> doorsOnTheWay;

    public boolean isNotBlocked(@NonNull Keyring keyring) {
        return keyring.canOpen(doorsOnTheWay);
    }

    @NonNull
    public Key start() {
        return trip.from();
    }

    @NonNull
    public Key destination() {
        return trip.to();
    }

    public boolean allIntermediaryKeysHaveBeenObtained(@NonNull Keyring keyring) {
        return keyring.areAlreadyObtained(intermediaryKeys);
    }
}
