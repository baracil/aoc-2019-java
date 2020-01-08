package perococco.aoc.day23._private.packet;

import lombok.NonNull;

/**
 * @author perococco
 **/
public interface Packet {

    @NonNull
    <T> T accept(@NonNull PacketVisitor<T> visitor);
}
