package perococco.aoc.day10.computation;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.Lazy;

import java.util.List;

public class VisibilityMap {

    @NonNull
    private final Position reference;

    @NonNull
    private final ImmutableList<Los> lineOfSights;

    private final Lazy<ImmutableList<Position>> destructionOrder = new Lazy<>(this::computeDestructionOrder);


    public VisibilityMap(@NonNull Position reference, @NonNull List<Los> lineOfSights) {
        this.reference = reference;
        this.lineOfSights = ImmutableList.sortedCopyOf(Los.COMPARE_DIRECTION,lineOfSights);
    }

    @NonNull
    public ImmutableList<Position> destructionOrder() {
        return destructionOrder.get();
    }

    @NonNull
    private ImmutableList<Position> computeDestructionOrder() {
        final ImmutableList.Builder<Position> builder = ImmutableList.builder();

        final int nbAsteroids = lineOfSights.stream().mapToInt(Los::numberOfAsteroid).sum();
        final int nbLineOfSights = lineOfSights.size();

        final int[] indexes = new int[nbLineOfSights];
        int nbDestroyedAsteroid = 0;
        while (nbDestroyedAsteroid < nbAsteroids){
            for (int losIndex = 0; losIndex < nbLineOfSights; losIndex++) {
                final Los los = lineOfSights.get(losIndex);
                final int asteroidIndexInLos = indexes[losIndex];
                if (asteroidIndexInLos < los.numberOfAsteroid()) {
                    builder.add(los.getAsteroid(asteroidIndexInLos).add(reference));
                    indexes[losIndex]+=1;
                    nbDestroyedAsteroid++;
                }
            }
        }

        return builder.build();
    }
}
