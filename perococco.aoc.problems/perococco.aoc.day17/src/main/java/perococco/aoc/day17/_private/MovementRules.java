package perococco.aoc.day17._private;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.computer.io.ProgramInput;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class MovementRules {

    @NonNull
    private final ImmutableList<MovementFunction> routine;

    @NonNull
    private final ImmutableMap<MovementFunction,String> functions;

    @Override
    public String toString() {
        return "MovementRules{" +
               "routine=" + routine +
               ", functions=" + functions +
               '}';
    }

    @NonNull
    public String routineCommand() {
        return routine.stream().map(MovementFunction::code).collect(Collectors.joining(","));
    }

    @NonNull
    public Stream<String> functionCommand() {
        return Arrays.stream(MovementFunction.values()).map(functions::get).filter(Objects::nonNull);
    }

    public void feedProgram(@NonNull ProgramInput<String> programInputAccessor) {
        programInputAccessor.write(routineCommand());
        programInputAccessor.write("\n");
        functionCommand().forEach(f -> {
            programInputAccessor.write(f);
            programInputAccessor.write("\n");
        });
    }

//    @NonNull
//    public String[] createInput(boolean liveFeed) {
//        final String cmdRoutine = routine.stream().map(MovementFunction::code).collect(Collectors.joining(",","","\n"));
//        final String cmdFunctions = Arrays.stream(MovementFunction.values())
//                                          .map(functions::get)
//                                          .filter(Objects::nonNull)
//                                          .collect(Collectors.joining("\n","","\n"));
//
//        final String fullCommand = cmdRoutine+cmdFunctions+(liveFeed?"y":"n")+"\n";
//
//        return fullCommand.chars().mapToObj(String::valueOf).toArray(String[]::new);
//    }
}
