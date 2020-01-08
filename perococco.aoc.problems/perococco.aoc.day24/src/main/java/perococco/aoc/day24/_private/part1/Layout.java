package perococco.aoc.day24._private.part1;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author perococco
 **/
@RequiredArgsConstructor
public class Layout {

    public static void dump(int layout) {
        new Layout(layout).dump();
    }

    @Getter
    private final int value;

    public Layout(ImmutableList<String> layout) {
        int mask = 1;
        int value = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                final boolean set = layout.get(i).charAt(j) == '#';
                value|=set?mask:0;
                mask=mask<<1;
            }
        }
        this.value = value;
    }

    public void dump() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                final boolean set = (value & (1 << (i*5+j))) != 0;
                System.out.print(set ? "#" : ".");
            }
            System.out.println();
        }
    }
}
