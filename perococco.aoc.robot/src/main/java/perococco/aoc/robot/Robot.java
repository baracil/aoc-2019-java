package perococco.aoc.robot;

import lombok.NonNull;
import perococco.aoc.computer.Program;
import perococco.aoc.robot._private.PrivateRobot;

public interface Robot<S> {

    @NonNull
    static <O,S> Robot<S> create(@NonNull Program program, @NonNull StateUpdater<O,S> state, @NonNull Controller<O,S> controller) {
        return new PrivateRobot<>(program, state, controller);
    }

    void switchOn();

    void shutdown();

    void waitForShutdown();

    @NonNull
    S getState();

}
