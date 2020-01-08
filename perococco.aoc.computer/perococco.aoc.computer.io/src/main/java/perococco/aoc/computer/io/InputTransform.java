package perococco.aoc.computer.io;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.util.function.Function;

public interface InputTransform<R> extends Function<R,String> {

    InputTransform<String> NONE = s -> s;

    @Override
    default String apply(R value) {
        return transform(value);
    }

    @NonNull
    String transform(R value);

    @NonNull
    default InputMultiTransformer<R> toMulti() {
        return r -> ImmutableList.of(this.apply(r));
    }
}
