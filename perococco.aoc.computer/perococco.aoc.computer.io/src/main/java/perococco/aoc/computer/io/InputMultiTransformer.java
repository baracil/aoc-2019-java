package perococco.aoc.computer.io;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.Tools;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface InputMultiTransformer<R> extends Function<R,ImmutableList<String>> {

    InputMultiTransformer<String> TO_ASCII = Tools::convertToAscii;

    @Override
    @NonNull
    default ImmutableList<String> apply(@NonNull R r) {
        return transform(r);
    }

    @NonNull
    ImmutableList<String> transform(@NonNull R r);

    @NonNull
    default InputMultiTransformer<R> before(UnaryOperator<R> preparator) {
        return r -> transform(preparator.apply(r));
    }
}
