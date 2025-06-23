package com.baidu.ar;

import android.content.Context;

/* loaded from: classes7.dex */
public class kt {
    public static int Du = 1280;
    public static int Dv = 720;

    public static float a(Context context, float f) {
        return (w(context) * f) + 0.5f;
    }

    public static boolean isScreenOrientationLandscape(Context context) {
        return context != null && context.getResources().getConfiguration().orientation == 2;
    }

    public static float w(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().density;
        }
        return 0.0f;
    }
}
