package perococco.aoc.day8;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.input.Part;

import java.util.Comparator;

public class Day8Part1Problem extends Day8Problem<Integer> {

    public Day8Part1Problem() {
        super(Part.PART_1);
    }

    @Override
    protected Integer solve(@NonNull ImmutableList<Layer> layers) {
        return layers.stream()
                     .min(Comparator.comparingInt(Layer::numberOfZeroDigit))
                     .map(this::computeProductOfNumberOf1And2Digits)
                     .orElseThrow();
    }

    private int computeProductOfNumberOf1And2Digits(Layer layer) {
        return layer.numberOf(Pixel.D1_WHITE) * layer.numberOf(Pixel.D2_TRANSPARENT);
    }
}
