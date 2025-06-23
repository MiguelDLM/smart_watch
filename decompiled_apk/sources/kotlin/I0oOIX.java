package kotlin;

import com.szabh.smable3.entity.BleWatchFaceId;

/* loaded from: classes6.dex */
public final /* synthetic */ class I0oOIX {
    public static /* synthetic */ int oIX0oI(int i, int i2) {
        return (int) ((i & BleWatchFaceId.WATCHFACE_ID_INVALID) % (i2 & BleWatchFaceId.WATCHFACE_ID_INVALID));
    }
}
