package perococco.aoc.computer._private.generic.operations;

import lombok.NonNull;
import perococco.aoc.computer._private.generic.ExecutionContext;

import java.util.function.BinaryOperator;

public class BinaryOperation<V> extends SequentialOperation<V> {

    @NonNull
    private final BinaryOperator<V> operator;

    public BinaryOperation(@NonNull BinaryOperator<V> operator) {
        super(3);
        this.operator = operator;
    }

    @Override
    public void doPerform(@NonNull ExecutionContext<V> context) {
        final V p0 = context.getParameter(0);
        final V p1 = context.getParameter(1);
        final V result = operator.apply(p0,p1);
        context.setParameter(2,result);
    }
}
