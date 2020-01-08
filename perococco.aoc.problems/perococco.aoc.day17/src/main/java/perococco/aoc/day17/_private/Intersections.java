package perococco.aoc.day17._private;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;

@RequiredArgsConstructor
public class Intersections {


    @NonNull
    public static Intersections findOnPicture(@NonNull Picture picture) {
        final ImmutableList<Position> intersections = picture.allScaffoldPositions()
                                                             .filter(p -> picture.scaffoldNextTo(p).count()==4)
                                                             .collect(ImmutableList.toImmutableList());
        return new Intersections(intersections);
    }

    @NonNull
    private final ImmutableList<Position> positions;

    public int sumOfAlignments() {
        return positions.stream().mapToInt(p -> p.y()*p.x()).sum();
    }

}
