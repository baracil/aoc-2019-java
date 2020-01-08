package perococco.aoc.day20;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.ArrayOfChar;
import perococco.aoc.day20._private.Maze;
import perococco.aoc.input.Part;

import java.util.function.Function;

public class Day20Part1Problem extends Day20Problem {

    public Day20Part1Problem() {
        super(Part.PART_1);
    }

    public Day20Part1Problem(@NonNull ImmutableList<String> lines) {
        super(Part.PART_1, lines);
    }

    @Override
    Function<? super ArrayOfChar,? extends Maze> mazeBuilder() {
        return Maze::createNormal;
    }
}
