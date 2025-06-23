package com.baidu.navisdk.framework.vmsr;

import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class j {
    public static boolean a(float[][] fArr, float f) {
        return a(fArr) <= f;
    }

    public static float a(float[][] fArr) {
        float[] a2 = b.a(-126.0f, 3);
        float[] a3 = b.a(127.0f, 3);
        int length = fArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            for (int i2 = 1; i2 < 4; i2++) {
                float[] fArr2 = fArr[i];
                float f = fArr2[i2];
                int i3 = i2 - 1;
                if (f > a2[i3]) {
                    a2[i3] = f;
                }
                float f2 = fArr2[i2];
                if (f2 < a3[i3]) {
                    a3[i3] = f2;
                }
            }
            i++;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "xDiff:" + (a2[0] - a3[0]) + ", yDiff:" + (a2[1] - a3[1]) + ",zDiff:" + (a2[2] - a3[2]));
        }
        return Math.max(Math.max(a2[0] - a3[0], a2[1] - a3[1]), a2[2] - a3[2]);
    }
}
