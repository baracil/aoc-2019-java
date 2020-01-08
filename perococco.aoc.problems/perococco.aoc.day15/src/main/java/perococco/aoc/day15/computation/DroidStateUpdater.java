package perococco.aoc.day15.computation;

import lombok.NonNull;
import perococco.aoc.common.Orientation;
import perococco.aoc.common.Position;
import perococco.aoc.robot.Order;
import perococco.aoc.robot.StateUpdater;

public class DroidStateUpdater implements StateUpdater<Orientation,DroidState> {

    @NonNull
    @Override
    public DroidState createInitialState() {
        return new DroidState();
    }

    @NonNull
    @Override
    public DroidState updateStateOnReply(
            @NonNull DroidState current,
            @NonNull Order<Orientation> lastSendOrder,
            @NonNull String replyAsString) {
        final Orientation orientation = lastSendOrder.source().orElse(null);

        if (orientation != null) {
            final Reply reply = Reply.decode(replyAsString);
            final Position targetedPosition = orientation.moveForward(current.position());
            return reply.update(current,targetedPosition);
        }

        return current;
    }
}
