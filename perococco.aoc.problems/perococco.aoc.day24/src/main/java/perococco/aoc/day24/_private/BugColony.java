package perococco.aoc.day24._private;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import perococco.aoc.day24._private.part2.Nature;

import java.io.PrintStream;
import java.util.IntSummaryStatistics;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public class BugColony {

    @NonNull
    public static BugColony create(@NonNull ImmutableList<String> input) {
        final IntFunction<Stream<Position>> lineParser = y -> {
            final String line = input.get(y);
            return IntStream.range(0,5).filter(x -> line.charAt(x) == '#').mapToObj(x -> Position.create(0,x,y));
        };

        return IntStream.range(0,5)
                 .mapToObj(lineParser)
                 .flatMap(s -> s)
                 .collect(Collectors.collectingAndThen(ImmutableSet.toImmutableSet(),BugColony::new));

    }

    @NonNull
    @Singular
    private final ImmutableSet<Position> bugPositions;

    @NonNull
    public Stream<Position> bugPositionsStream() {
        return bugPositions.stream();
    }

    public boolean hasBugAt(@NonNull Position position) {
        return bugPositions.contains(position);
    }

    public int size() {
        return bugPositions.size();
    }

    @NonNull
    public BugColony evolve() {
        return evolve(1);
    }

    @NonNull
    public BugColony evolve(int nbMinutes) {
        BugColony current = this;
        for (int i = 0; i < nbMinutes; i++) {
            current = Nature.evolve(current);
        }
        return current;
    }

    public void dump(@NonNull PrintStream ps) {
        final IntSummaryStatistics levelStat = bugPositions.stream().mapToInt(Position::level).summaryStatistics();
        IntStream.rangeClosed(levelStat.getMin(),levelStat.getMax()).forEach(lvl -> dumpOneLevel(ps,lvl));
    }

    public void dumpOneLevel(@NonNull PrintStream ps, int level) {
        ps.println("Depth "+level+":");
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (x==2 && y==2) {
                    ps.print('?');
                } else {
                    ps.print(hasBugAt(Position.create(level, x, y)) ? '#' : '.');
                }
            }
            ps.println();
        }
        ps.println();
    }
}
