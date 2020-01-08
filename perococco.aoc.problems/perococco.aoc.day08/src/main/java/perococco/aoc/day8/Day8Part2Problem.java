package perococco.aoc.day8;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Part;

import java.util.stream.Collectors;

public class Day8Part2Problem extends Day8Problem<String> {

    public Day8Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    protected String solve(@NonNull ImmutableList<Layer> layers) {
        return layers.stream()
              .reduce(Layer::stack)
              .orElseThrow()
              .lines()
              .collect(Collectors.joining("\n","\n",""));
    }

}
