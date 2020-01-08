package perococco.aoc.day15;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import perococco.aoc.input.Part;
import perococco.aoc.common.Position;
import perococco.aoc.day15.computation.DroidState;
import perococco.aoc.day15.computation.FindPath;

public class Day15Part2Problem extends Day15Problem {
    public Day15Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    int solve(@NonNull DroidState state) {
        final Position start = state.startPosition();
        final Position oxygen = state.oxygenPosition();

        final ImmutableMap<Position,Integer> distance = FindPath.computeDistance(state.memory(), oxygen, start);


        return distance.values().stream().mapToInt(i ->i).max().orElseThrow();
    }
}
