package perococco.aoc.day13;

import perococco.aoc.input.Part;
import perococco.aoc.computer.Alterations;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.ProgramIO;
import perococco.aoc.day13._private.GameIO;

public class Day13Part2Problem extends Day13Problem {

    public Day13Part2Problem() {
        super(Part.PART_2);
    }

    @Override
    String solve(Program program) {
        final Alterations alterations = Alterations.with(0,"2");
        final GameIO gameIO = new GameIO();
        program.launchAndWait("Game", ProgramIO.withSupplier(gameIO::read).consumeWith(gameIO::write), alterations);

        return gameIO.score();
    }

}
