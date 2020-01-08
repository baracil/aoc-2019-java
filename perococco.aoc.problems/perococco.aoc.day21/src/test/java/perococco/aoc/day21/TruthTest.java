package perococco.aoc.day21;

import lombok.NonNull;
import perococco.aoc.day21._private.Node;
import perococco.aoc.day21._private.SensorRegistry;
import perococco.aoc.day21._private.TriBool;
import perococco.aoc.day21._private.TruthTable;

/**
 * @author perococco
 **/
public class TruthTest {

    private static final TruthTable t = new TruthTable() {
        @Override
        public int nbParameters() {
            return 2;
        }

        @Override
        public @NonNull TriBool value(int parameters) {
            return TriBool.TRUE;
        }
    };

    public static void main(String[] args) {
        Node node = new Node(t);
        Node simple = node.simplify();
        System.out.println(node.expression(SensorRegistry.parameterNames()));
        System.out.println(""+simple.expression(SensorRegistry.parameterNames()));
    }
}
