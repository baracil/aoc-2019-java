package perococco.aoc.day15.computation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.EnumHelper;
import perococco.aoc.common.Position;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public enum Reply {
    HIT_WALL("0", DroidState::updateWhenHittingWall),
    MOVE("1", DroidState::updateWhenMovingOnEmptySpace),
    MOVE_REACH_OXYGEN("2", DroidState::updateWhenMovingOnOxygen),
    ;

    private final String code;

    @NonNull
    private final BiFunction<? super DroidState, ? super Position, ? extends DroidState> updater;

    public static Reply decode(@NonNull String code) {
        return Holder.HELPER.get(code);
    }

    @NonNull
    public DroidState update(@NonNull DroidState state, @NonNull Position targetPosition) {
        return updater.apply(state,targetPosition);
    }

    private static class Holder {

        private static final EnumHelper<String,Reply> HELPER = EnumHelper.create(Reply.class, r->r.code);
    }
}
