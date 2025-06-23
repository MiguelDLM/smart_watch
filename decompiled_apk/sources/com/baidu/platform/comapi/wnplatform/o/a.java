package com.baidu.platform.comapi.wnplatform.o;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.wnplatform.j.g;

/* loaded from: classes8.dex */
public abstract class a extends com.baidu.platform.comapi.walknavi.a implements com.baidu.platform.comapi.wnplatform.c.a, com.baidu.platform.comapi.wnplatform.i.a, com.baidu.platform.comapi.wnplatform.i.b, g {
    public void a(Context context, View view, int i, int i2, int i3, int i4) {
        if (view == null || !(view instanceof MapView)) {
            return;
        }
        ((MapView) view).getMap().setViewPadding(a(context, i), a(context, i2), a(context, i3), a(context, i4));
    }

    public abstract void a(com.baidu.platform.comapi.walknavi.h.c.a aVar);

    public abstract void a(String str);

    public abstract void a(boolean z);

    public abstract void b(int i);

    public abstract void c(int i);

    public abstract boolean e();

    public abstract void f();

    public abstract void g();

    public abstract int h();

    public abstract int i();

    public abstract View j();

    public abstract void k();

    public abstract int l();

    public abstract void n();

    public abstract int p();

    public abstract int q();

    public abstract void r();

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
    }

    public abstract void t();

    public abstract float u();

    public abstract void v();

    public abstract void w();

    public abstract Handler z();

    private int a(Context context, int i) {
        return (int) ((context.getResources().getDisplayMetrics().density * i) + 0.5f);
    }
}
