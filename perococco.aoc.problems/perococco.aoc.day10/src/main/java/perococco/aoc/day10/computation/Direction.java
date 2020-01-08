package perococco.aoc.day10.computation;

import com.google.common.math.IntMath;
import lombok.*;

@Value
@EqualsAndHashCode(of = {"dx","dy"})
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Direction {

    @NonNull
    public static Direction create(int x, int y) {
        if (x==0&&y==0){
            return new Direction(0,0,0);
        }

        final int gcd = IntMath.gcd(Math.abs(x),Math.abs(y));
        return new Direction(x/gcd,y/gcd,(4+2*Math.atan2(x,-y)/Math.PI)%4);
    }

    private final int dx;

    private final int dy;

    private final double angle;

    public boolean isNotNil() {
        return dx != 0 || dy != 0;
    }


}
