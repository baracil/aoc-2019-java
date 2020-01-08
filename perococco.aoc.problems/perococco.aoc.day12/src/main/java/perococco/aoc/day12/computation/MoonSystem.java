package perococco.aoc.day12.computation;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;

public class MoonSystem {

    @NonNull
    public static MoonSystem build(ImmutableList<String> input) {
        return new MoonSystem(0, MoonFactory.createMoons(input));
    }
    @NonNull
    public static MoonSystem build(String... input) {
        return build(ImmutableList.copyOf(input));
    }

    @Getter
    private final int time;

    @NonNull
    @Singular
    @Getter
    private final ImmutableList<Moon> moons;

    private final int hascode;

    public MoonSystem(int time,
            @NonNull ImmutableList<Moon> moons) {
        this.time = time;
        this.moons = moons;
        hascode = moons.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoonSystem)) return false;
        MoonSystem system = (MoonSystem) o;
        return moons.equals(system.moons);
    }

    @Override
    public int hashCode() {
        return hascode;
    }

    public int numberOfMoons() {
        return moons.size();
    }

    @NonNull
    public Moon getMoon(int index) {
        return moons.get(index);
    }

    public int totalEnergy() {
        return moons.stream().mapToInt(Moon::totalEnergy).sum();
    }

    public void display() {
        System.out.format("After %d steps:%n",time);
        moons.forEach(System.out::println);
    }

}
