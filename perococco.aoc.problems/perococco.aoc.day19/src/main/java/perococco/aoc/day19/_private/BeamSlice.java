package perococco.aoc.day19._private;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public class BeamSlice {

    @NonNull
    @Getter
    private final Position start;

    @Getter
    private final int length;

    public int lengthBelow(int maximalX) {
        return Math.min(start.x()+length,maximalX)-start.x();
    }

    public boolean contain(int xStart, int length) {
        return start.x()<=xStart && xStart+length <= start.x()+this.length;
    }
}
