package perococco.aoc.day21;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import perococco.aoc.day21._private.TriBool;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public enum  Action {
    JUMP(TriBool.TRUE, "J"),
    DO_NOT_JUMP(TriBool.FALSE,"."),
    IT_DEPENDS(TriBool.ANY,"?"),
    ITS_OVER(TriBool.ANY,"X"),
    ;

    @Getter
    private final TriBool triBool;

    @Getter
    private final String representation;
}
