package androidx.collection;

import java.lang.reflect.Array;

class ArraySetJvmUtil {
    private ArraySetJvmUtil() {
    }

    public static <T> T[] resizeForToArray(T[] tArr, int i) {
        if (tArr.length < i) {
            return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
        }
        if (tArr.length > i) {
            tArr[i] = null;
        }
        return tArr;
    }
}
