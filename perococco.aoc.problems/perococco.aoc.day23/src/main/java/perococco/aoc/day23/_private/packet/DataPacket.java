package perococco.aoc.day23._private.packet;

import lombok.NonNull;
import lombok.Value;

/**
 * @author perococco
 **/
@Value
public class DataPacket implements Packet {

    @NonNull
    private final String x;

    @NonNull
    private final String y;

    @NonNull
    @Override
    public <T> T accept(@NonNull PacketVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @NonNull
    public DataPacket withSource() {
        return new DataPacket(x,y);
    }

}
