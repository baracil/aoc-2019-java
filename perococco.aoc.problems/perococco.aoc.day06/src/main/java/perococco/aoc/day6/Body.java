package perococco.aoc.day6;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class Body {

    @NonNull
    @Getter
    private final String id;

    private Body parent;

    @NonNull
    private final List<Body> moons = new ArrayList<>();

    public boolean isRoot() {
        return id.equals("COM");
    }

    public void addMoon(Body moon) {
        if (moon.parent != null) {
            throw new AOCException("Moon '"+moon.id+"' is alread orbiting '"+moon.parent.id+"'");
        }
        moon.parent = this;
        moons.add(moon);
    }

    public void forEachMoon(@NonNull Consumer<Body> consumer) {
        moons.forEach(consumer);
    }

    public Body parent() {
        return parent;
    }
}
