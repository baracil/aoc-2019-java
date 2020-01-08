package perococco.aoc.day3;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;

import java.util.Arrays;
import java.util.function.UnaryOperator;

@RequiredArgsConstructor
public enum Direction {
    UP("U", Point::pointAbove),
    DOWN("D", Point::pointBelow),
    LEFT("L", Point::pointOnTheLeft),
    RIGHT("R", Point::pointOnTheRight),
    ;

    @NonNull
    private final String abbreviation;

    private final UnaryOperator<Point> singleStepMovement;

    @NonNull
    public Point move(@NonNull Point point) {
        return singleStepMovement.apply(point);
    }

    @NonNull
    public static Direction parseDirection(@NonNull String abbreviation) {
        final Direction direction = Holder.DIRECTIONS_BY_ABBREVIATION.get(abbreviation.toUpperCase());
        if (direction == null) {
            throw new AOCException("Invalid abbreviation '"+abbreviation+"' for a direction");
        }
        return direction;
    }

    private static class Holder {

        private static final ImmutableMap<String,Direction> DIRECTIONS_BY_ABBREVIATION;

        static  {
            DIRECTIONS_BY_ABBREVIATION = Arrays.stream(values()).collect(ImmutableMap.toImmutableMap(d -> d.abbreviation, d -> d));
        }
    }
}
