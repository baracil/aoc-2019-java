package perococco.aoc.day20._private;

import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;

import java.util.function.Predicate;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public enum Tile {
    WALL('#'),
    EMPTY('.'),
    SPACE(' '),
    LETTER(c -> c >= 'A' && c <= 'Z'),
    ;

    private final Predicate<Character> thisTileTypeTester;

    public static Tile getTile(char character) {
        for (Tile value : Holder.VALUES) {
            if (value.thisTileTypeTester.test(character)) {
                return value;
            }
        }
        throw new AOCException("Could not transform character '"+character+"' to a tile type");
    }

    public boolean isMyselfRepresentedByThisCharacter(char character) {
        return thisTileTypeTester.test(character);
    }

    Tile(char character) {
        this.thisTileTypeTester = c -> c == character;
    }

    private static class Holder {

        private static final ImmutableList<Tile> VALUES = ImmutableList.copyOf(values());
    }


}
