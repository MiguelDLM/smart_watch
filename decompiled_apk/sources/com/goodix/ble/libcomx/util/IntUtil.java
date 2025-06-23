package com.goodix.ble.libcomx.util;

import com.szabh.smable3.entity.BleWatchFaceId;

/* loaded from: classes9.dex */
public class IntUtil {
    public static int compareUnsignedInt(int i, int i2) {
        long j = (i & BleWatchFaceId.WATCHFACE_ID_INVALID) - (i2 & BleWatchFaceId.WATCHFACE_ID_INVALID);
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }

    public static boolean memoryOverlap(int i, int i2, int i3, int i4) {
        long j = i3 & BleWatchFaceId.WATCHFACE_ID_INVALID;
        long j2 = (i4 & BleWatchFaceId.WATCHFACE_ID_INVALID) + j;
        long j3 = i & BleWatchFaceId.WATCHFACE_ID_INVALID;
        return (((long) i2) & BleWatchFaceId.WATCHFACE_ID_INVALID) + j3 > j && j3 < j2;
    }

    public static boolean rangeOverlap(int i, int i2, int i3, int i4) {
        if (!valueInRange(i, i2, i3) && !valueInRange(i, i2, i4)) {
            return false;
        }
        return true;
    }

    public static boolean rangeOverlapUnsignedInt(int i, int i2, int i3, int i4) {
        if (!valueInRangeUnsignedInt(i, i2, i3) && !valueInRangeUnsignedInt(i, i2, i4)) {
            return false;
        }
        return true;
    }

    public static boolean valueInRange(int i, int i2, int i3) {
        return i3 >= i && i3 <= i2;
    }

    public static boolean valueInRangeUnsignedInt(int i, int i2, int i3) {
        long j = i & BleWatchFaceId.WATCHFACE_ID_INVALID;
        long j2 = i2 & BleWatchFaceId.WATCHFACE_ID_INVALID;
        long j3 = BleWatchFaceId.WATCHFACE_ID_INVALID & i3;
        return j3 >= j && j3 <= j2;
    }
}
