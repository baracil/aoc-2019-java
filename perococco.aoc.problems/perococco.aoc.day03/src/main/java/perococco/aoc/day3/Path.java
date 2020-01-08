package perococco.aoc.day3;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import lombok.NonNull;
import perococco.aoc.common.AOCException;
import perococco.aoc.common.Lazy;
import perococco.aoc.common.Tools;

import java.util.stream.Stream;

public class Path {

    @NonNull
    @Getter
    private final ImmutableList<Point> points;

    private final Lazy<ImmutableMap<Point,Integer>> numberOfStepsToPoint;

    public Path() {
        this(ImmutableList.of(Point.CENTRAL_PORT));
    }

    private Path(@NonNull ImmutableList<Point> points) {
        if (points.isEmpty()) {
            throw new AOCException("A Path is made of at least 1 point");
        }
        this.points = points;
        this.numberOfStepsToPoint = new Lazy<>(() -> Tools.mapSmallestIndexInList(points));
    }

    @NonNull
    private Point getLastPoint() {
        return points.get(points.size()-1);
    }

    @NonNull
    public Path complete(@NonNull Movement movement) {
        final ImmutableList<Point> newPoints = movement.getPointsFromThisMovement(getLastPoint());
        return new Path(Tools.mergeLists(points,newPoints));
    }

    public int numberOfStepsToReach(@NonNull Point point) {
        final Integer nbSteps = numberOfStepsToPoint.get().get(point);
        return nbSteps == null?Integer.MAX_VALUE/2:nbSteps;
    }

    @NonNull
    public static Stream<Point> intersectionStream(@NonNull Path path1, @NonNull Path path2) {
        final ImmutableSet<Point> path2Points = path2.numberOfStepsToPoint.get().keySet();
        return path1.points.stream()
                           .filter(Point::isNotCentralPort)
                           .filter(path2Points::contains);
    }



}
