package com.adp.sdk.utils;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: classes.dex */
public class h {
    public static int a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int b(Context context, int i) {
        return (int) ((i / context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
