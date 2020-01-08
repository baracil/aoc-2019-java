package perococco.aoc.computer;

import lombok.NonNull;
import perococco.aoc.computer._private.PrivateAlterations;

public interface Alterations {

    @NonNull
    static Alterations with(int address, @NonNull String value) {
        return none().addAlterations(address, value);
    }

    @NonNull
    static Alterations with(int address, @NonNull String value1, @NonNull String value2) {
        return none().addAlterations(address, value1, value2);
    }

    @NonNull
    static Alterations none() {
        return PrivateAlterations.none();
    }

    void handleAlterations(@NonNull AlterationConsumer consumer);

    @NonNull
    Alterations addAlterations(int address, @NonNull String value);

    @NonNull
    Alterations addAlterations(int address, @NonNull String value1, @NonNull String value2);

}
