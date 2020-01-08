package perococco.aoc.common;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.UnaryOperator;

@RequiredArgsConstructor
public enum Orientation {
    NORTH("1", Position::up),
    SOUTH("2", Position::down),
    WEST("3", Position::left),
    EAST("4", Position::right),
    ;

    @Getter
    private final String code;

    private final UnaryOperator<Position> operator;

    @NonNull
    public static Orientation decode(@NonNull String code) {
        return Orientation.Holder.HELPER.get(code);
    }

    @NonNull
    public Position moveForward(@NonNull Position position) {
        return operator.apply(position);
    }

    @NonNull
    public Orientation reverse() {
        return getOrder(SOUTH, EAST, NORTH, WEST);
    }

    @NonNull
    public Orientation rotateWest() {
        return getOrder(WEST, SOUTH, EAST, NORTH);
    }

    @NonNull
    public Orientation rotateEast() {
        return getOrder(EAST, NORTH, WEST, SOUTH);
    }

    @NonNull
    private Orientation getOrder(Orientation forNorth, Orientation forWest, Orientation forSouth, Orientation forEast) {
        switch (this) {
            case NORTH: return forNorth;
            case WEST: return forWest;
            case SOUTH: return forSouth;
            case EAST: return forEast;
        }
        throw new AOCException("Unknown order " + this);
    }

    @NonNull
    public Command commandToSwitchTo(@NonNull Orientation target) {
        if (rotateEast() == target) {
            return Command.RIGHT;
        }
        else if (rotateWest() == target) {
            return Command.LEFT;
        }
        throw new AOCException("Cannot find command to switch from "+this+" to "+target);
    }


    private static class Holder {

        private static final EnumHelper<String,Orientation> HELPER = EnumHelper.create(Orientation.class, r->r.code);
    }

}
