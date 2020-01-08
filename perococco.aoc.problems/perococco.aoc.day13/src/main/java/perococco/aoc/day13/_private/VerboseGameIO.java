package perococco.aoc.day13._private;

import lombok.NonNull;
import perococco.aoc.common.Position;
import perococco.aoc.common.Printer;

import java.util.HashMap;
import java.util.Map;

public class VerboseGameIO extends GameIO {

    private final Map<Position,TileType> tiles = new HashMap<>();

    private final Printer printer = new Printer(this::toPixel);


    private String toPixel(Position position) {
        final TileType type = tiles.get(position);
        return type == null ? " ":type.representation();
    }

    @NonNull
    @Override
    public String read() {
        System.out.println(printer.printOnOneLine(() -> tiles.keySet().stream()));
        return super.read();
    }

    @Override
    public void onTile(Tile tile) {
        super.onTile(tile);
        tiles.put(tile.position(),tile.type());
    }

}
