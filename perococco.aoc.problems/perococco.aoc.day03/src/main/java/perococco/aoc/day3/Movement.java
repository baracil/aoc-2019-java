package perococco.aoc.day3;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;

@Value
public class Movement {

    @NonNull
    public static Movement parse(String abbreviatedMovement) {
        final Direction direction = Direction.parseDirection(abbreviatedMovement.substring(0,1));
        final int numberOfSteps = Integer.parseInt(abbreviatedMovement.substring(1));
        return new Movement(direction,numberOfSteps);
    }

    @NonNull
    private final Direction direction;

    private final int numberOfSteps;

    @NonNull
    public ImmutableList<Point> getPointsFromThisMovement(@NonNull Point startingPoint) {
        final ImmutableList.Builder<Point> points = ImmutableList.builder();
        Point current = startingPoint;
        for (int i = 0; i < numberOfSteps; i++) {
            current = direction.move(current);
            points.add(current);
        }
        return points.build();
    }
}
