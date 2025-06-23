package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: classes.dex */
public class DimenUtil implements NotConfused {
    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float dpToPixel(float f) {
        return f * Resources.getSystem().getDisplayMetrics().density;
    }

    public static float px2dp(Context context, int i) {
        return (i / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
