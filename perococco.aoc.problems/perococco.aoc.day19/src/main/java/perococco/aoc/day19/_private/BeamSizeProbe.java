package perococco.aoc.day19._private;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;
import perococco.aoc.common.Printer;
import perococco.aoc.computer.Program;

/**
 * @author perococco
 **/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BeamSizeProbe {

    public static int probe(@NonNull Program program) {
        return new BeamSizeProbe(program).probe();
    }

    @NonNull
    private final Program program;

    private int count = 0;

    private final Printer printer = new Printer(p -> "#",".");

    public int probe() {
        Position position = Position.of(0, 0);
        while (position.y() < 50) {
            final BeamSlice slice = probeSlice(position);

            count+=slice.lengthBelow(50);
            position = slice.start().down();

        }

        return count;
    }

    public BeamSlice probeSlice(@NonNull Position start) {
        return BeamSliceProbe.probe(program,start);
    }


}
