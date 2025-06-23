package androidx.collection;

import com.szabh.smable3.entity.BleWatchFaceId;

/* loaded from: classes.dex */
public final class PackingUtilsKt {
    public static final long packFloats(float f, float f2) {
        return (Float.floatToRawIntBits(f2) & BleWatchFaceId.WATCHFACE_ID_INVALID) | (Float.floatToRawIntBits(f) << 32);
    }

    public static final long packInts(int i, int i2) {
        return (i2 & BleWatchFaceId.WATCHFACE_ID_INVALID) | (i << 32);
    }
}
