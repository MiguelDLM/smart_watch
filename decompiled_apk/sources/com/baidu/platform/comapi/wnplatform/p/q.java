package com.baidu.platform.comapi.wnplatform.p;

import android.view.View;

/* loaded from: classes8.dex */
public abstract class q implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private static long f9966a;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f9966a > 300) {
            f9966a = currentTimeMillis;
            a(view);
        }
    }
}
