package perococco.aoc.day13._private;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;

@RequiredArgsConstructor
public class GameOutput {

    @NonNull
    private final OutputListener outputListener;

    private int count = 0;

    private int x;

    private int y;

    public void write(@NonNull String value) {
        switch (count) {
            case 0 :
                x = Integer.parseInt(value);
                break;
            case 1 :
                y = Integer.parseInt(value);
                break;
            case 2 :
                if (x==-1 && y==0) {
                    outputListener.onScore(value);
                } else {
                    outputListener.onTile(new Tile(Position.of(x,y),TileType.decode(value)));
                }
                break;
        }
        count = (count+1)%3;
    }
}
