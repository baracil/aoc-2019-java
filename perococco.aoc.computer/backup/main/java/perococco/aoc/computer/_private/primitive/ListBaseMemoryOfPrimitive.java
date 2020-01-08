package perococco.aoc.computer._private.primitive;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListBaseMemoryOfPrimitive<V> extends BaseMemoryOfPrimitive<V> {

    @NonNull
    private final List<V> values;


    private ListBaseMemoryOfPrimitive(@NonNull ImmutableList<V> initialValue, @NonNull Parser<V> parser) {
        super(parser);
        this.values = new ArrayList<>(initialValue);
    }

    @Override
    public void setValue(int address, @NonNull V value) {
        values.set(address,value);
    }

    @NonNull
    @Override
    public V getValueAt(int address) {
        return values.get(address);
    }

    @Override
    protected Stream<V> streamOfValues() {
        return values.stream();
    }
}
