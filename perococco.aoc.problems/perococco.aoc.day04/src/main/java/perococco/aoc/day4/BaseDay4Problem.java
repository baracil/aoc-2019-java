package perococco.aoc.day4;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;
import perococco.aoc.input.SingleLineAOCProblem;

import java.util.Arrays;

public abstract class BaseDay4Problem extends SingleLineAOCProblem<Integer> {

    public BaseDay4Problem(@NonNull Part part) {
        super(Day.DAY_4, part);
    }

    @NonNull
    @Override
    public Integer solution() {
        final String input = getInput();
        final ImmutableList<Code> codes = Arrays.stream(input.split("-")).map(Code::create).collect(ImmutableList.toImmutableList());
        return solve(codes.get(0),codes.get(1));
    }

    protected abstract int solve(@NonNull Code first,@NonNull Code last);

}
