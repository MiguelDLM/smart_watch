package com.baidu.platform.comapi.wnplatform.p;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static int f9956a = 124;
    public static int b = 133;
    private static float c;
    private static int d;

    public static float a(Context context) {
        if (c == 0.0f) {
            c = context.getResources().getDisplayMetrics().density;
        }
        return c;
    }

    public static int b(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        return 0;
    }

    public static int c(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    public static int d(Context context) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static int e(Context context) {
        int c2;
        int d2;
        if (context == null) {
            return 0;
        }
        int i = d;
        if (i > 0) {
            return i;
        }
        if (context instanceof Activity) {
            View findViewById = ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
            if (findViewById != null && findViewById.getHeight() > 0) {
                return findViewById.getHeight();
            }
            c2 = c(context);
            d2 = d(context);
        } else {
            c2 = c(context);
            d2 = d(context);
        }
        return c2 - d2;
    }

    public static int a(Context context, int i) {
        return (int) ((a(context) * i) + 0.5f);
    }
}
