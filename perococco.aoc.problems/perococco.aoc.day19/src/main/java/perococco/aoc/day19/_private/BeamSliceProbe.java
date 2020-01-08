package perococco.aoc.day19._private;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.ProgramIO;

/**
 * @author perococco
 **/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BeamSliceProbe {

    @NonNull
    public static BeamSlice probe(@NonNull Program program, @NonNull Position start) {
        return new BeamSliceProbe(program, start).probe();
    }

    @NonNull
    private final Program program;

    private final Position start;

    private Position current;

    private Position first = null;

    private int length;

    private BeamSlice probe() {
        this.current = start;
        this.first = null;
        this.length = 0;

        do {
            final boolean pullFelt = probeSinglePosition();
            if (pullFelt) {
                length++;
                if (first == null) {
                    first = current;
                }
            } else if (this.first != null) {
                return new BeamSlice(first,length);
            }
            current = current.right();
        } while (this.first != null || current.x()-start.x()< 5);
        return new BeamSlice(start,0);
    }

    private boolean probeSinglePosition() {
        return program.launchAndWait(
                "probing",
                ProgramIO.fromList(Position::putXYInListOfString, current).ignoreOutput()
        ).getLastOutput().equals("1");

    }

}
