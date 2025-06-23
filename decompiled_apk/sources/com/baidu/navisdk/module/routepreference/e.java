package com.baidu.navisdk.module.routepreference;

import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class e {
    public static int a(int i, int i2, boolean z) {
        int i3;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNPreferenceUtil", "calcPreferenceValue(), lastPreferValue = " + i + " changePrefer = " + i2 + " isPreferOpen = " + z);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNPreferenceUtil", "calcPreferenceValue(), lastPreferValue = " + i + " changePrefer = " + i2 + " isPreferOpen = " + z);
        }
        if (!z && (i & i2) == 0) {
            return i;
        }
        int i4 = 33;
        if (i == 1) {
            i = 0;
        } else if (i == 33) {
            i = 32;
        }
        if (z) {
            i3 = i | i2;
        } else {
            i3 = i ^ i2;
        }
        if (i3 != 32) {
            i4 = i3;
        }
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }
}
