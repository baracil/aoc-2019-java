package perococco.aoc.input;

import lombok.NonNull;

import java.util.Comparator;

public interface AOCProblem<T> {

    Comparator<AOCProblem<?>> AOC_PROBLEM_COMPARATOR =
            Comparator.<AOCProblem<?>, AOCProblemId>comparing(AOCProblem::id, AOCProblemId.PROBLEM_ID_COMPARATOR)
                    .thenComparing(AOCProblem::priority);


    @NonNull
    AOCProblemId id();

    int priority();

    @NonNull
    T solution();

    @NonNull
    default String problemName() {
        return id().day()+ " "+id().part();
    }
}
