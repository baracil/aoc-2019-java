package perococco.aoc.day3;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.input.Day;
import perococco.aoc.input.MultiLineAOCProblem;
import perococco.aoc.input.Part;
import perococco.aoc.input.StreamOfLinesFromSomeLines;

import java.util.Arrays;

public abstract class BaseDay3Problem extends MultiLineAOCProblem<Integer> {

    public BaseDay3Problem(@NonNull Part part) {
        super(Day.DAY_3, part, 2);
    }

    public BaseDay3Problem(@NonNull Part part, @NonNull ImmutableList<String> lines) {
        super(Day.DAY_3, part,2, new StreamOfLinesFromSomeLines(lines));
    }

    @NonNull
    @Override
    public Integer solution() {
        final ImmutableList<Path> paths = getInput(this::convertOneLine);
        final Path path1 = paths.get(0);
        final Path path2 = paths.get(1);

        return compute(path1,path2);
    }


    protected abstract int compute(@NonNull Path path1,@NonNull Path path2);


    @NonNull
    private Path convertOneLine(@NonNull String line) {
        return Arrays.stream(line.split(","))
              .map(Movement::parse)
              .sequential()
              .reduce(new Path(), Path::complete, (p1,p2) -> {throw new AOCException("Cannot combine path");});
    }
}
