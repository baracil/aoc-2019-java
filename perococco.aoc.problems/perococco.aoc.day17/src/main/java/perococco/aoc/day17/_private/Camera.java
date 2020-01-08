package perococco.aoc.day17._private;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer.ExecutionResult;
import perococco.aoc.computer.Program;

@RequiredArgsConstructor
public class Camera {

    @NonNull
    private final Program program;

    @NonNull
    public Picture takePicture() {
        final ExecutionResult execution = program.launchAndWait("Camera");

        return execution.outputs().stream().collect(Picture.collector());
    }

}
