package com.baidu.navisdk.widget.photoview;

import android.annotation.TargetApi;
import android.view.View;

/* loaded from: classes8.dex */
class a {
    public static void a(View view, Runnable runnable) {
        b(view, runnable);
    }

    @TargetApi(16)
    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
