package perococco.aoc.day23._private;

import lombok.NonNull;
import lombok.Value;
import perococco.aoc.day23._private.packet.DataPacket;

/**
 * @author perococco
 **/
@Value
public class Message {

    private final int sourceAddress;

    private final int destinationAddress;

    @NonNull
    private final DataPacket packet;

    @Override
    public String toString() {
        return String.format("Message{ %2d -> %2d : %s}",sourceAddress,destinationAddress,packet);
    }

    public String x() {
        return packet.x();
    }

    public String y() {
        return packet.y();
    }
}
