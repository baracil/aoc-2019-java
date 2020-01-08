package perococco.aoc.day1;

import lombok.NonNull;
import perococco.aoc.input.Day;
import perococco.aoc.input.LineByLineAOCProblem;
import perococco.aoc.input.Part;

public class Day1Part1Problem extends LineByLineAOCProblem<Integer> {


    public Day1Part1Problem() {
        super(Day.DAY_1, Part.PART_1);
    }

    @NonNull
    @Override
    public Integer solution() {
        return getInput(Integer::parseInt)
                .mapToInt(FuelRequirement::basicFuelRequirement)
                .sum();
    }

}
