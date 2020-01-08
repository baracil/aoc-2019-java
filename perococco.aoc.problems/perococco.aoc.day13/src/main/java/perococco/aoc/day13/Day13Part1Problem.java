package perococco.aoc.day13;

import perococco.aoc.input.Part;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.io.ProgramIO;
import perococco.aoc.day13._private.GameOutput;
import perococco.aoc.day13._private.OutputListener;
import perococco.aoc.day13._private.Tile;
import perococco.aoc.day13._private.TileType;

public class Day13Part1Problem extends Day13Problem {

    public Day13Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    String solve(Program program) {
        final Listener listener = new Listener();
        final GameOutput gameOutput = new GameOutput(listener);
        program.launchAndWait("Game", ProgramIO.noInput().consumeWith(gameOutput::write));
        return listener.nbBlocks+"";
    }

    private static class Listener implements OutputListener {

        private int nbBlocks;

        @Override
        public void onTile(Tile tile) {
            if (tile.type() == TileType.BLOCK) {
                nbBlocks++;
            }
        }

        @Override
        public void onScore(String score) {}
    }

}
