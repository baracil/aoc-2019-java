package perococco.aoc.computer._private;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer.Output;

@RequiredArgsConstructor
public class SaveInListOutput implements Output {

    private final ImmutableList.Builder<String> builder = ImmutableList.builder();

    @Override
    public void writeToOutput(String value) {
        builder.add(value);
    }

    @NonNull
    public ImmutableList<String> listOfOutputs() {
        return builder.build();
    }
}
