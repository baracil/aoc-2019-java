package perococco.aoc.common;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;

import java.util.stream.Stream;

@Value
public class Position {

    private final int x;

    private final int y;

    public static Position of(int x, int y) {
        return new Position(x,y);
    }

    @NonNull
    public Position shift(int amountX, int amountY) {
        return amountX == 0 && amountY == 0?this:new Position(x+amountX,y+amountY);
    }

    @NonNull
    public Position shiftX(int amount) {
        return shift(amount,0);
    }

    @NonNull
    public Position shiftY(int amount) {
        return shift(0,amount);
    }

    @NonNull
    public Position up() {
        return shiftY(-1);
    }
    @NonNull
    public Position down() {
        return shiftY(1);
    }
    @NonNull
    public Position down(int numberOfTimes) {
        return shiftY(numberOfTimes);
    }
    @NonNull
    public Position left() {
        return shiftX(-1);
    }
    @NonNull
    public Position right() {
        return shiftX(1);
    }
    @NonNull
    public Position right(int numberOfTimes) {
        return shiftX(numberOfTimes);
    }

    @NonNull
    public Position leftUp() {
        return shift(-1,-1);
    }
    @NonNull
    public Position leftDown() {
        return shift(-1,1);
    }
    @NonNull
    public Position rightUp() {
        return shift(1,-1);
    }
    @NonNull
    public Position rightDown() {
        return shift(1,1);
    }

    @NonNull
    public Orientation orientationOf(@NonNull Position target) {
        if (this.equals(target)) {
            throw new IllegalArgumentException("Same position");
        }
        if (x == target.x) {
            return y<target.y ? Orientation.SOUTH : Orientation.NORTH;
        }
        else if (y == target.y) {
            return x<target.x ? Orientation.EAST : Orientation.WEST;
        }
        throw new IllegalArgumentException("Positions not vertically or horizontally aligned "+this+" "+target);
    }

    @NonNull
    public ImmutableList<String> putXYInListOfString() {
        return ImmutableList.of(String.valueOf(x),String.valueOf(y));
    }

    @NonNull
    public Stream<Position> neighbourStream() {
        return Stream.of(right(),up(),down(),left());
    }

    @NonNull
    public Stream<Position> surrounding() {
        final Position right = right();
        final Position left = left();
        return Stream.of(right(),up(),down(),left(),leftUp(), leftDown(), rightUp(),rightDown());
    }

    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ")";
    }
}
