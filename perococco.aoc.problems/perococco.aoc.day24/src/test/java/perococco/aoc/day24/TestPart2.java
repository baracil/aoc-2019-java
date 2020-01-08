package perococco.aoc.day24;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import perococco.aoc.day24._private.BugColony;

/**
 * @author perococco
 **/
public class TestPart2 {

    private static final ImmutableList<String> LINES = ImmutableList.of(
            "....#",
            "#..#.",
            "#.?##",
            "..#..",
            "#...."
    );

    @Test
    public void testPart2() {
        BugColony bugColony = BugColony.create(LINES).evolve(10);

        Assertions.assertEquals(99,bugColony.size());
    }
}
