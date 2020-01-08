package perococco.aoc.day6;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import perococco.aoc.common.AOCException;

public class OrbitPath {

    @NonNull
    private final ImmutableList<String> pathFromRoot;

    public OrbitPath(@NonNull ImmutableList<String> pathFromRoot) {
        this.pathFromRoot = pathFromRoot;
    }

    public int size() {
        return pathFromRoot.size();
    }

    @NonNull
    private String bodyIdAt(int position) {
        return pathFromRoot.get(position);
    }

    @NonNull
    public static String lastCommonBody(@NonNull OrbitPath path1,@NonNull OrbitPath path2) {
        final int size1 = path1.pathFromRoot.size();
        final int size2 = path2.pathFromRoot.size();

        String lastCommon = null;
        for (int i = 0; i < Math.min(size1, size2); i++) {
            if (path1.bodyIdAt(i).equals(path2.bodyIdAt(i))) {
                lastCommon = path1.bodyIdAt(i);
            } else {
                break;
            }
        }

        if (lastCommon == null) {
            throw new AOCException("Bug. COM is always common between path");
        }
        return lastCommon;
    }

}
