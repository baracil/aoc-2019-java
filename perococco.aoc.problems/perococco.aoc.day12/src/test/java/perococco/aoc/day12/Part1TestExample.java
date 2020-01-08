package perococco.aoc.day12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import perococco.aoc.day12.computation.MoonSystem;
import perococco.aoc.day12.computation.Simulator;

public class Part1TestExample {

    public static Object[][] systems() {
        return new Object[][] {
                {new String[]{"<x=-1, y=0, z=2>", "<x=2, y=-10, z=-7>", "<x=4, y=-8, z=8>", "<x=3, y=5, z=-1>"},10,179},
                {new String[]{"<x=-8, y=-10, z=0>", "<x=5, y=5, z=10>", "<x=2, y=-7, z=3>", "<x=9, y=-8, z=-3>"},100,1940},

        };

    }


    @ParameterizedTest
    @MethodSource("systems")
    public void name(String[] input, int targetTime, int expectedEnergy) {
        final Simulator simulator = new Simulator(MoonSystem.build(input));
        final MoonSystem system = simulator.simulateToTime(targetTime);
        final int actualEnergy = system.totalEnergy();

        Assertions.assertEquals(expectedEnergy,actualEnergy);
    }
}
