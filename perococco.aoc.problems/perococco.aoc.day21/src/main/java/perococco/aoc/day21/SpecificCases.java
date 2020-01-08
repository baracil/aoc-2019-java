package perococco.aoc.day21;

import com.google.common.collect.ImmutableTable;

import java.util.Optional;

/**
 * @author perococco
 **/
public class SpecificCases {

    private static final ImmutableTable<Integer,Integer,Action> SPECIFIC_CASES = ImmutableTable.<Integer,Integer,Action>builder()
            .put(4, 0b1001, Action.JUMP)
            .put(4,0b1011, Action.JUMP)
            .put(9,0b110101011, Action.JUMP)
            .build();


    public static Optional<Action> getSpecificCases(int sensorRange, int ground) {
        return Optional.ofNullable(SPECIFIC_CASES.get(sensorRange,ground));
    }

}
