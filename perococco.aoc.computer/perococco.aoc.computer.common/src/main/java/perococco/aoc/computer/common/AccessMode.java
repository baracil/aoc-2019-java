package perococco.aoc.computer.common;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import perococco.aoc.common.CodedEnumHelper;
import perococco.aoc.common.Encoded;

@RequiredArgsConstructor
public enum AccessMode implements Encoded {
    POSITION(0){
        @Override
        public int accept(AccessModeVisitor visitor, int parameter) {
            return visitor.visitPosition(parameter);
        }
    },
    IMMEDIATE(1){
        @Override
        public int accept(AccessModeVisitor visitor, int parameter) {
            return visitor.visitImmediate(parameter);
        }
    },
    RELATIVE(2){
        @Override
        public int accept(AccessModeVisitor visitor, int parameter) {
            return visitor.visitRelative(parameter);
        }
    },
    ;

    @Getter
    private final int code;

    public abstract int accept(AccessModeVisitor visitor, int parameter);

    @NonNull
    public static AccessMode get(int code) {
        return Holder.HELPER.get(code);
    }

    private static class  Holder {

        private static final CodedEnumHelper<AccessMode> HELPER = CodedEnumHelper.create(AccessMode.class);

    }

}
