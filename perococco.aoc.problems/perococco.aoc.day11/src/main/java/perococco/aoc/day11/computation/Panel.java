package perococco.aoc.day11.computation;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Position;

@RequiredArgsConstructor
public class Panel {

    @NonNull
    @Getter
    private final Position position;

    @NonNull
    @Getter
    private Color color = Color.BLACK;

    public void paint(@NonNull Color color) {
        this.color = color;
    }
}
