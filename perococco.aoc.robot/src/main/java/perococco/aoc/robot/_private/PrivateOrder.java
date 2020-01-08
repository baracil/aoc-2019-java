package perococco.aoc.robot._private;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PrivateOrder {

    @NonNull
    public static PrivateOrder stop() {
        return new PrivateOrder(Type.STOP, ImmutableList.of());
    }

    @NonNull
    public static PrivateOrder sendData(@NonNull ImmutableList<String> data) {
        return new PrivateOrder(Type.SEND_DATA, data);
    }

    @NonNull
    public static PrivateOrder sendData(@NonNull String... data) {
        return sendData(ImmutableList.copyOf(data));
    }


    public enum Type {
        STOP,
        SEND_DATA
    }

    @NonNull
    @Getter
    private final Type type;

    @Getter
    @NonNull
    private final ImmutableList<String> dataToSend;


}
