package perococco.aoc.input;

import lombok.NonNull;
import lombok.Value;

import java.util.Comparator;

@Value
public class AOCProblemId {

    public static final Comparator<AOCProblemId> PROBLEM_ID_COMPARATOR
            = Comparator
            .comparing(AOCProblemId::day, Day.DAY_COMPARATOR)
            .thenComparing(AOCProblemId::part, Part.PART_COMPARATOR);

    @NonNull
    private final Day day;

    @NonNull
    private final Part part;

}
