package perococco.aoc.day6;

import lombok.Value;

@Value
public class Relationship {

    public static Relationship parse(String line) {
        final int idx = line.indexOf(")");
        return new Relationship(line.substring(0,idx), line.substring(idx+1));
    }

    private final String idOfPlanet;

    private final String idOfMoon;
}
