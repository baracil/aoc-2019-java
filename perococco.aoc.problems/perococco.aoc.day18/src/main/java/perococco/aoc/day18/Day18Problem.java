package perococco.aoc.day18;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Day;
import perococco.aoc.input.LineByLineAOCProblem;
import perococco.aoc.input.Part;
import perococco.aoc.day18._private.Maze;
import perococco.aoc.day18._private.algo.KeyCollector;

public abstract class Day18Problem extends LineByLineAOCProblem<Integer> {

    public Day18Problem(@NonNull Part part) {
        super(Day.DAY_18, part);
    }

    public Day18Problem(@NonNull Part part,
            @NonNull ImmutableList<String> lines) {
        super(Day.DAY_18, part, lines);
    }

    @NonNull
    @Override
    public Integer solution() {
        final Maze maze = getInput().collect(Maze.collector(part() == Part.PART_2));
        return KeyCollector.collectAll(maze);
    }

}
