package perococco.aoc.day24._private.part1;

import lombok.Value;

/**
 * @author perococco
 **/
@Value
class Masks {

    private final int value;

    private final int one;

    private final int two;

    public void dump() {
        System.out.println("--- MASK ---");
        Layout.dump(value);
        System.out.println(" ONE ");
        Layout.dump(one);
        System.out.println(" TWO ");
        Layout.dump(two);
    }
}
