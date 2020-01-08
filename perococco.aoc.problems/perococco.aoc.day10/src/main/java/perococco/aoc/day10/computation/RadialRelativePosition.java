package perococco.aoc.day10.computation;

import com.google.common.math.IntMath;
import lombok.NonNull;
import lombok.Value;

import java.util.Comparator;

@Value
public class RadialRelativePosition {

    public static Comparator<RadialRelativePosition> COMPARE_RADIUS = Comparator.comparingInt(RadialRelativePosition::radius);

    @NonNull
    public static RadialRelativePosition create(int dx, int dy) {
        final int radius = IntMath.gcd(Math.abs(dx),Math.abs(dy));
        return new RadialRelativePosition(radius,Direction.create(dx,dy));
   }


    private final int radius;

    @NonNull
    private final Direction direction;

    public boolean isNotNil() {
        return radius != 0;
    }

    @NonNull
    public Position add(@NonNull Position reference) {
        return Position.create(
                reference.x()+radius*direction.dx(),
                reference.y()+radius*direction.dy()
        );
    }
}
