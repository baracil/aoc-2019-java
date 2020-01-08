package perococco.aoc.computer;

import com.google.common.collect.ImmutableList;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class Alterations {

    private final ImmutableList<Alteration> actions;

    @NonNull
    public Alterations alterWith(int address, @NonNull String value) {
        return new Alterations(ImmutableList.<Alteration>builder()
                                         .addAll(actions)
                                         .add(new Alteration(address,value))
                                         .build());
    }

    @NonNull
    public Alterations alterWith(int address, @NonNull String value1, @NonNull String value2) {
        return new Alterations(ImmutableList.<Alteration>builder()
                                          .addAll(actions)
                                          .add(new Alteration(address,value1))
                                          .add(new Alteration(address+1,value2))
                                          .build());
    }

    public void forEach(@NonNull Consumer<Alteration> consumer) {
        actions.forEach(consumer);
    }

    @NonNull
    static Alterations none() {
        return new Alterations(ImmutableList.of());
    }

    @RequiredArgsConstructor
    @Getter
    public static class Alteration {

        private final int address;

        @NonNull
        private final String value;

    }

}
