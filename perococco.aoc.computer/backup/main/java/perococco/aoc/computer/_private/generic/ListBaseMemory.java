package perococco.aoc.computer._private.generic;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListBaseMemory<V> extends BaseMemory<V> {

    @NonNull
    private final List<V> values;


    private ListBaseMemory(@NonNull ImmutableList<V> initialValue, @NonNull Parser<V> parser) {
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
