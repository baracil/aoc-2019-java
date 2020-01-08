package perococco.aoc.computer._private.primitive;

public interface ParameterAccessor {

    long getParameter(int position);

    void setParameter(int position, long value);
}
