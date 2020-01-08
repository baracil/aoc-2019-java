package perococco.aoc.input;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.AOCException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class StreamOfLinesFromResource implements StreamOfLinesSupplier {

    @NonNull
    private final Class<?> resourceClass;

    @NonNull
    private final String resourceName;

    public StreamOfLinesFromResource(Day day) {
        this(AOCProblem.class,day.getInputFileName());
    }

    @Override
    public @NonNull Stream<String> lines() {
        final InputStream inputStream = resourceClass.getResourceAsStream(resourceName);
        if (inputStream == null) {
            throw new AOCException("Could not find input file '" + resourceName + "'");
        }

        final BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        try {
            final Stream<String> stream = bfr.lines();
            return stream.onClose(() -> {
                try {
                    bfr.close();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        } catch (RuntimeException | Error e) {
            try {
                bfr.close();
            } catch (IOException io) {
                e.addSuppressed(io);
            }
            throw e;
        }
    }
}
