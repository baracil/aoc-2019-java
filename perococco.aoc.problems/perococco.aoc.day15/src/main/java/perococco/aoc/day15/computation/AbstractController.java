package perococco.aoc.day15.computation;

import lombok.NonNull;
import perococco.aoc.common.Orientation;
import perococco.aoc.common.Position;
import perococco.aoc.robot.Controller;
import perococco.aoc.robot.Order;
import perococco.aoc.robot.OrderProducer;

import java.util.Optional;

public abstract class AbstractController implements Controller<Orientation,DroidState> {

    private DroidState previousState = null;

    private Orientation lastSentOrder = null;

    private Reply lastReply = null;

    private final OrderProducer<Orientation> orderProducer = Order.create(Orientation::code);

    @Override
    public @NonNull Order<Orientation> evaluateNextOrders(@NonNull DroidState currentState) {
        final Optional<Orientation> movement;

        if (lastSentOrder == null) {
            movement = getFirstOrder(currentState.position());
        }
        else {
            movement = evaluateNextOrder(previousState, lastSentOrder, lastReply, currentState);
        }

        lastSentOrder = movement.orElse(null);

        return movement.map(orderProducer::sendData)
                       .orElseGet(orderProducer::stop);
    }

    @Override
    public void updateOnReply(@NonNull String reply, @NonNull DroidState previousState, @NonNull DroidState currentState) {
        this.lastReply = Reply.decode(reply);
        this.previousState = previousState;
    }

    @NonNull
    protected abstract Optional<Orientation> getFirstOrder(@NonNull Position currentPosition);

    @NonNull
    protected abstract Optional<Orientation> evaluateNextOrder(
            @NonNull DroidState previousState,
            @NonNull Orientation sentOrder,
            @NonNull Reply replyToSentOrder,
            @NonNull DroidState updatedState);
}
