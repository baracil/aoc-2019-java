package perococco.aoc.computer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.CodedEnumHelper;

@RequiredArgsConstructor
public enum AccessMode {
    POSITION(0){
        @Override
        public int getValue(int[] values, int position) {
            return values[values[position]];
        }

        @Override
        public void setValue(int[] values, int position, int value) {
            values[values[position]] = value;
        }
    },
    IMMEDIATE(1){
        @Override
        public int getValue(int[] values, int position) {
            return values[position];
        }

        @Override
        public void setValue(int[] values, int position, int value) {
            values[position] = value;
        }
    },
    ;

    private final int code;

    public abstract int getValue(int[] values, int position);

    public abstract void setValue(int[] values, int position,int value);

    @NonNull
    public static AccessMode get(int code) {
        return Holder.HELPER.get(code);
    }

    private static class  Holder {

        private static final CodedEnumHelper<AccessMode> HELPER = new CodedEnumHelper<>(AccessMode.class, p -> p.code);

    }

}
