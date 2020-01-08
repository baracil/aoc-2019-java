package perococco.aoc.computer;

import lombok.NonNull;
import perococco.aoc.computer._private.io.IOComposedWithInputAndOutput;

public interface IO {

    String readFromInput();

    void writeToOutput(String value);

    @NonNull
    IO replaceInput(@NonNull Input input);

    @NonNull
    IO replaceOutput(@NonNull Output output);

    @NonNull
    IO then(@NonNull Output output);

    @NonNull
    static IO with(@NonNull Input input, @NonNull Output output) {
        return new IOComposedWithInputAndOutput(input, output);
    }

    @NonNull
    static IO with(@NonNull Input input) {
        return new IOComposedWithInputAndOutput(input, Output.ignoreOutput());
    }

    @NonNull
    static IO defaultIO() {
        return new IOComposedWithInputAndOutput(Input.noInput(), Output.ignoreOutput());
    }

}
