package perococco.aoc.day8;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;
import perococco.aoc.input.SingleLineAOCProblem;

public abstract class Day8Problem<T> extends SingleLineAOCProblem<T> {

    public Day8Problem(@NonNull Part part) {
        super(Day.DAY_8, part);
    }

    @NonNull
    @Override
    public T solution() {
        final EncodedLayers encodedLayers = new EncodedLayers(getInput(),25,6);

        return solve(encodedLayers.decode());
    }

    protected abstract T solve(@NonNull ImmutableList<Layer> layers);
}
