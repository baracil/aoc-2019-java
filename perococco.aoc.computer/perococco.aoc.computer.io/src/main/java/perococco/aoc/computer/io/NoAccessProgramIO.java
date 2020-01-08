package perococco.aoc.computer.io;

import lombok.NonNull;
import perococco.aoc.common.Nil;

/**
 * @author perococco
 **/
public abstract class NoAccessProgramIO implements ProgramIO<Nil,Nil> {

    @NonNull
    @Override
    public Nil programInputAccessor() {
        return Nil.NIL;
    }

    @NonNull
    @Override
    public Nil programOutputAccessor() {
        return Nil.NIL;
    }
}
