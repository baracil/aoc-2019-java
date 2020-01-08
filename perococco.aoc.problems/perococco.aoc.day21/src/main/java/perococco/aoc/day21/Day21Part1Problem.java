package perococco.aoc.day21;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Part;

import java.util.function.Function;

public class Day21Part1Problem extends Day21Problem {

    public Day21Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    int solve(@NonNull Function<ImmutableList<String>,Day21Problem.Result> executor) {
        final Result result = executor.apply(getLogicalProgram());
        return result.damage();
    }

    @Override
    int sensorRange() {
        return 4;
    }

    @Override
    String launchCommand() {
        return "WALK";
    }

    @NonNull
    public ImmutableList<String> getLogicalProgram() {
        return ImmutableList.of(
                "NOT C T",
                "AND D T",
                "NOT A J",
                "OR T J"
                                );
    }

}
