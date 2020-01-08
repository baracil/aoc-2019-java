package perococco.aoc.day21;

import perococco.aoc.day21._private.JumpTable;
import perococco.aoc.day21._private.Node;
import perococco.aoc.day21._private.SensorRegistry;

/**
 * @author perococco
 **/
public class NodeTest {

    public static void main(String[] args) {
        JumpTable j = JumpTable.create(9);
        j.print(System.out);
        Node node = new Node(j);
        Node simple = node.simplify();
        System.out.println(simple.expression(SensorRegistry.parameterNames()));
    }
}
