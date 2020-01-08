package perococco.aoc.day18._private;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@EqualsAndHashCode(of = "id")
public class Key {

    public Key(@NonNull String id, long mask) {
        this.id = id;
        this.mask = mask;
    }

    @NonNull
    @Getter
    private final String id;

    @Getter
    private final long mask;

    @Override
    public String toString() {
        return "Key{" +
               "id='" + id + "'}";
    }

    public String displayedId() {
        return isStart()?"@":id;
    }

    public boolean isStart() {
        return id.startsWith("@");
    }
}
