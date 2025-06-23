package androidx.collection;

import com.szabh.smable3.entity.BleWatchFaceId;

public final class PackingUtilsKt {
    public static final long packFloats(float f, float f2) {
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f);
        return (((long) Float.floatToRawIntBits(f2)) & BleWatchFaceId.WATCHFACE_ID_INVALID) | (floatToRawIntBits << 32);
    }

    public static final long packInts(int i, int i2) {
        return (((long) i2) & BleWatchFaceId.WATCHFACE_ID_INVALID) | (((long) i) << 32);
    }
}
