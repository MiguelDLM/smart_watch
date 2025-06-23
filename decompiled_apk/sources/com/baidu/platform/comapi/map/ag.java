package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.SurfaceHolder;
import com.baidu.platform.comapi.map.ah;

/* loaded from: classes8.dex */
interface ag extends SurfaceHolder.Callback2 {
    Bitmap a(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config);

    void a(int i);

    void a(SurfaceRenderer surfaceRenderer);

    void a(Runnable runnable);

    ah.a b();

    void b(int i);

    void d(int i);

    int e();

    int f();

    int g();

    void h();

    void i();

    void j();

    void k();

    void l();
}
