package perococco.aoc.day23._private;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.day23._private.packet.DataPacket;

/**
 * @author perococco
 **/
public class FirstYNetwork extends AbstractNetwork {

    public FirstYNetwork(@NonNull Program program, int networkSize) {
        super(program,networkSize);
    }

    public FirstYNetwork(@NonNull Program program) {
        super(program);
    }

    @Override
    protected void handlePort255(@NonNull DataPacket packet) {
        setResult(packet.y());
    }

    @Override
    protected void handleIdleNetwork() {}
}
