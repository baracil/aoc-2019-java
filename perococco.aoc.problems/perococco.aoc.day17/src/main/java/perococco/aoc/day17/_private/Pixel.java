package perococco.aoc.day17._private;

import lombok.Getter;
import lombok.NonNull;
import perococco.aoc.common.EnumHelper;
import perococco.aoc.common.Orientation;

public enum Pixel {
    SPACE(".",false),
    SCAFFOLD("#",true),
    ROBOT_UP("^",Orientation.NORTH),
    ROBOT_DOWN("v",Orientation.SOUTH),
    ROBOT_LEFT("<",Orientation.EAST),
    ROBOT_RIGHT(">",Orientation.WEST),
    ;

    @Getter
    private final String representation;

    private final Orientation orientation;

    Pixel(@NonNull String representation,@NonNull Orientation orientation) {
        this.representation = representation;
        this.scaffold = true;
        this.orientation = orientation;
    }

    Pixel(String representation, boolean scaffold) {
        this.representation = representation;
        this.scaffold = scaffold;
        this.orientation = null;
    }

    private final boolean scaffold;

    public boolean isRobot() {
        return orientation != null;
    }

    @NonNull
    public Orientation orientation() {
        return orientation == null ? Orientation.SOUTH : orientation;
    }

    @NonNull
    public static Pixel decode(@NonNull String pixel) {
        return Holder.HELPER.get(pixel);
    }

    public boolean isScaffold() {
        return scaffold;
    }

    private static class Holder {
        private static final EnumHelper<String,Pixel> HELPER = EnumHelper.create(Pixel.class, p -> String.valueOf((int)p.representation.charAt(0)));
    }
}
