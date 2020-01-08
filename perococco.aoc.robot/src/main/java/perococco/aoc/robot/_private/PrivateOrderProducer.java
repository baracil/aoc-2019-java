package perococco.aoc.robot._private;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.robot.Order;
import perococco.aoc.robot.OrderProducer;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public class PrivateOrderProducer<T> implements OrderProducer<T> {

    private final Order<?> STOP_ORDER = new Order<>() {
        @Override
        public boolean stopRobot() {
            return true;
        }

        @Override
        public @NonNull Optional<Object> source() {
            return Optional.empty();
        }

        @Override
        public @NonNull ImmutableList<String> dataToSend() {
            return ImmutableList.of();
        }
    };

    @NonNull
    private final Function<? super T, ? extends ImmutableList<String>> dataTransformer;


    @SuppressWarnings("unchecked")
    @Override
    public @NonNull Order<T> stop() {
        return (Order<T>)STOP_ORDER;
    }

    @Override
    public @NonNull Order<T> sendData(@NonNull T data) {
        return new Order<T>() {
            @Override
            public boolean stopRobot() {
                return false;
            }

            @Override
            public @NonNull Optional<T> source() {
                return Optional.of(data);
            }

            @Override
            public @NonNull ImmutableList<String> dataToSend() {
                return PrivateOrderProducer.this.dataTransformer.apply(data);
            }
        };
    }
}
