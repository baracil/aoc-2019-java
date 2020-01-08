package perococco.aoc.day15;

import lombok.NonNull;
import perococco.aoc.common.Orientation;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.ProgramBasedAOCProblem;
import perococco.aoc.day15.computation.DroidState;
import perococco.aoc.day15.computation.DroidStateUpdater;
import perococco.aoc.day15.computation.MapperController;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;
import perococco.aoc.robot.Controller;
import perococco.aoc.robot.Robot;

public abstract class Day15Problem extends ProgramBasedAOCProblem<Integer> {

    public Day15Problem(@NonNull Part part) {
        super(Day.DAY_15, part);
    }

    @NonNull
    @Override
    public Integer solution() {
        final Program program = getProgram();

        final Controller<Orientation,DroidState>controller = new MapperController();
        final Robot<DroidState> robot = Robot.create(program, new DroidStateUpdater(), controller);

        robot.switchOn();
        robot.waitForShutdown();

        DroidState state = robot.getState();

        return solve(state);
    }

    abstract int solve(@NonNull DroidState droidState);
}
