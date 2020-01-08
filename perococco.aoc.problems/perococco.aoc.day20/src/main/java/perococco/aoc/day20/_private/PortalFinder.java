package perococco.aoc.day20._private;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.common.Position;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author perococco
 **/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PortalFinder {

    @NonNull
    public static ImmutableMap<String,ImmutableList<Portal>> find(@NonNull ArrayOfChar data) {
        return new PortalFinder(data).find();
    }

    @NonNull
    private final ArrayOfChar data;

    @NonNull
    public ImmutableMap<String,ImmutableList<Portal>> find() {
        return data.positionStream()
                   .map(this::createPortal)
                   .flatMap(Optional::stream)
                   .collect(
                           Collectors.collectingAndThen(
                                   Collectors.groupingBy(Portal::name, ImmutableList.toImmutableList()),
                                   ImmutableMap::copyOf
                           )
                   );
    }

    private Optional<Portal> createPortal(Position position) {
        return PortalSearchParty.valueStream()
                     .map(searchParty -> searchParty.checkForPortal(data, position))
                     .flatMap(Optional::stream)
                     .findAny();
    }

}
