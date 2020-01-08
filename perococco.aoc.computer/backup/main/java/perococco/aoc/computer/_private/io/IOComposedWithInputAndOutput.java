package perococco.aoc.computer._private.io;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer.IO;
import perococco.aoc.computer.Input;
import perococco.aoc.computer.Output;

@RequiredArgsConstructor
public class IOComposedWithInputAndOutput implements IO {

    @NonNull
    private final Input input;

    @NonNull
    private final Output output;

    @Override
    public String readFromInput() {
        return input.readFromInput();
    }

    @Override
    public void writeToOutput(String value) {
        output.writeToOutput(value);
    }

    @Override
    public @NonNull IO then(@NonNull Output output) {
        return replaceOutput(this.output.then(output));
    }

    @Override
    public @NonNull IO replaceInput(@NonNull Input input) {
        return new IOComposedWithInputAndOutput(input, output);
    }

    @Override
    public @NonNull IO replaceOutput(@NonNull Output output) {
        return new IOComposedWithInputAndOutput(input, output);
    }

}
