package perococco.aoc.robot;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.robot._private.PrivateOrderProducer;

import java.util.Optional;
import java.util.function.Function;

public interface Order<T> {

    @NonNull
    static <T> OrderProducer<T> createMulti(@NonNull Function<? super T, ? extends ImmutableList<String>> dataTransformer) {
        return new PrivateOrderProducer<>(dataTransformer);
    }

    @NonNull
    static <T> OrderProducer<T> create(@NonNull Function<? super T, ? extends String> dataTransformer) {
        return createMulti(data -> ImmutableList.of(dataTransformer.apply(data)));
    }

    boolean stopRobot();

    @NonNull
    Optional<T> source();

    @NonNull
    ImmutableList<String> dataToSend();


}
