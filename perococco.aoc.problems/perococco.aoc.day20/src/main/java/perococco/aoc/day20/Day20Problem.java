package perococco.aoc.day20;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.day20._private.Maze;
import perococco.aoc.input.ArrayOfCharAOCProblem;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;
import perococco.aoc.input.StreamOfLinesFromSomeLines;

import java.util.function.Function;

public abstract class Day20Problem extends ArrayOfCharAOCProblem<Integer> {

    public Day20Problem(@NonNull Part part) {
        super(Day.DAY_20, part);
    }

    public Day20Problem(@NonNull Part part,
            @NonNull ImmutableList<String> lines) {
        super(Day.DAY_20, part, new StreamOfLinesFromSomeLines(lines));
    }

    @NonNull
    @Override
    public Integer solution() {
        final Maze maze = mazeBuilder().apply(getInput());
        return maze.findPathLength();
    }

    abstract Function<? super ArrayOfChar,? extends Maze> mazeBuilder();

}
