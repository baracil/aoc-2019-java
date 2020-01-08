package perococco.aoc.day21;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Part;

import java.util.function.Function;

public class Day21Part2Problem extends Day21Problem {

    public Day21Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    int solve(@NonNull Function<ImmutableList<String>,Result> executor) {
        final Result result = executor.apply(getLogicalProgram());
        return result.damage();
    }

    private ImmutableList<String> getLogicalProgram() {
        return ImmutableList.of(
          "NOT G T",
          "AND H T",
          "OR E T",
          "NOT F J",
          "OR J T",

          "NOT C J",
          "AND J T",
          "NOT B J",
          "OR J T",

          "AND D T",
          "NOT A J",

          "OR T J"
        );
    }

    @Override
    int sensorRange() {
        return 9;
    }

    @Override
    String launchCommand() {
        return "RUN";
    }
}
