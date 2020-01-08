package perococco.aoc.day11.computation;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.Position;
import perococco.aoc.common.Printer;

import java.util.HashSet;
import java.util.Set;

public class Hull {

    private final Set<Position> panels = new HashSet<>();

    public void clear() {
        panels.clear();
    }

    @NonNull
    public Color getPanelColor(@NonNull Position position) {
        return panels.contains(position) ? Color.WHITE : Color.BLACK;
    }

    public void paint(@NonNull Position position, @NonNull Color color) {
        if (color == Color.BLACK) {
            panels.remove(position);
        }
        else {
            panels.add(position);
        }
    }

    @NonNull
    public ImmutableList<String> dump() {
        Printer print = new Printer(p -> panels.contains(p) ? "#" : " ", " ");

        return print.print(panels::stream);
    }

}
