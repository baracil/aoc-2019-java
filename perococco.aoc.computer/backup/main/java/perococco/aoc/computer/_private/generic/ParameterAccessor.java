package perococco.aoc.computer._private.generic;

import lombok.NonNull;

public interface ParameterAccessor<V> {

    V getParameter(int position);

    void setParameter(int position, @NonNull V value);
}
