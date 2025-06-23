package com.baidu.platform.comapi.util;

import android.graphics.Color;

/* loaded from: classes8.dex */
public class e {
    public static int[] a(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            int[] iArr2 = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                iArr2[i] = Color.argb(Color.alpha(iArr[i]), Color.blue(iArr[i]), Color.green(iArr[i]), Color.red(iArr[i]));
            }
            return iArr2;
        }
        return null;
    }
}
