package com.adp.sdk.utils;

import android.content.Context;
import android.util.TypedValue;

public class h {
    public static int a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int b(Context context, int i) {
        return (int) ((((float) i) / context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
