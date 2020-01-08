package perococco.aoc.day21;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.Nil;
import perococco.aoc.computer.Execution;
import perococco.aoc.computer.Program;
import perococco.aoc.computer.ProgramBasedAOCProblem;
import perococco.aoc.computer.io.InputMultiTransformer;
import perococco.aoc.computer.io.ProgramIO;
import perococco.aoc.computer.io.ProgramInput;
import perococco.aoc.day21._private.JumpTable;
import perococco.aoc.input.Day;
import perococco.aoc.input.Part;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class Day21Problem extends ProgramBasedAOCProblem<Integer> {

    public Day21Problem(@NonNull Part part) {
        super(Day.DAY_21, part);
    }

    @NonNull
    @Override
    public Integer solution() {
        printLogicalExpression();

        final Program program = getProgram();
        return solve(l -> execute(program,l));
    }

    private void printLogicalExpression() {
        final JumpTable jumpTable = JumpTable.create(sensorRange());
        System.out.println(jumpTable.createLogicalExpression());
    }

    abstract int solve(@NonNull Function<ImmutableList<String>,Result> executor);

    abstract int sensorRange();

    abstract String launchCommand();


    private Result execute(@NonNull Program program, @NonNull ImmutableList<String> commands) {
        final OutputConsumer outputConsumer = new OutputConsumer(sensorRange());
        final String launchCommand = launchCommand();

        final Execution<ProgramInput<String>,Nil> execution;
        execution = program.launch("Hull inspection", ProgramIO.controlledInput(InputMultiTransformer.TO_ASCII).consumeWith(outputConsumer));

        final ProgramInput<String> input = execution.programInputAccessor();

        Stream.concat(
                commands.stream(),
                Stream.of(launchCommand)
        ).forEach(s -> {
            input.write(s);
            input.write("\n");
        });

        execution.waitTermination();

        return outputConsumer.getResult();
    }

    @RequiredArgsConstructor
    public static class Result {

        @Getter
        private final int damage;

        @NonNull
        @Getter
        private final ImmutableList<String> outputLines;

        private final int lastSensor;

        public boolean isSuccess() {
            return lastSensor < 0;
        }

        @NonNull
        public OptionalInt lastSensor() {
            return lastSensor<0?OptionalInt.empty():OptionalInt.of(lastSensor);
        }

    }



    @RequiredArgsConstructor
    public static class OutputConsumer implements Consumer<String> {

        private final int size;

        @Getter
        private int damage = -1;

        private ByteArrayOutputStream out = new ByteArrayOutputStream(1000);

        @Override
        public void accept(String s) {
            onData(s);
        }

        public void onData(@NonNull String data) {
            final int v = Integer.parseInt(data);
            if (v >= 0 && v < 256) {
                out.write(v);
            }
            else {
                damage = v;
            }
        }

        private ImmutableList<String> lines() {
            final String[] lines = out.toString(StandardCharsets.US_ASCII).split("\n");
            return ImmutableList.copyOf(lines);
        }

        private int lastSensor(@NonNull ImmutableList<String> lines) {
            if (damage>0) {
                return -1;
            }
            final String line = lines.get(lines.size()-1);
            final int idx = line.indexOf("@");
            if (idx > 0) {
                final String sensor = line.substring(idx - size+1, idx - size+1 + size);
                return IntStream.range(0, size)
                                .filter(i -> (sensor.charAt(i) == '#'))
                                .map(i -> 1 << i)
                                .sum();
            }
            return -1;
        }

        private Result getResult() {
            final ImmutableList<String> lines = lines();
            return new Result(damage, lines, lastSensor(lines));
        }



    }

}
