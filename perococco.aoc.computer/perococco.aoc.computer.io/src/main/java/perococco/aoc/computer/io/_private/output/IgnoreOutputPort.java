package perococco.aoc.computer.io._private.output;

import lombok.NonNull;
import perococco.aoc.common.Nil;

public class IgnoreOutputPort extends BaseOutputPort<Nil,String> {

    public IgnoreOutputPort() {
        super(s -> s);
    }

    @NonNull
    @Override
    public Nil programOutputAccessor() {
        return Nil.NIL;
    }

    @Override
    public void write(@NonNull String value) {
        //ignored
    }

}
