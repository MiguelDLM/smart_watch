package com.baidu.navisdk.ui.routeguide.navicenter;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.baidu.navisdk.framework.interfaces.pronavi.h;
import com.baidu.navisdk.framework.interfaces.pronavi.m;
import com.baidu.navisdk.module.pronavi.abs.b;
import com.baidu.navisdk.ui.routeguide.control.g;
import com.baidu.navisdk.ui.routeguide.control.j;
import com.baidu.navisdk.ui.routeguide.control.k;
import com.baidu.navisdk.ui.routeguide.control.o;
import com.baidu.navisdk.ui.routeguide.control.t;
import com.baidu.navisdk.ui.routeguide.control.v;
import com.baidu.navisdk.ui.routeguide.control.w;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class c<T extends com.baidu.navisdk.module.pronavi.abs.b> {
    private static final Object b = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<com.baidu.navisdk.module.pronavi.abs.b> f9064a = new SparseArray<>(32);

    public com.baidu.navisdk.ui.routeguide.control.c a() {
        return (com.baidu.navisdk.ui.routeguide.control.c) a(3, com.baidu.navisdk.ui.routeguide.control.c.class);
    }

    public g b() {
        return (g) a(2, g.class);
    }

    @Nullable
    public com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c(boolean z) {
        return (com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b) a(10, o.class, z);
    }

    public com.baidu.navisdk.pronavi.carlogooffset.i.b d() {
        return (com.baidu.navisdk.pronavi.carlogooffset.i.b) a(17, com.baidu.navisdk.pronavi.carlogooffset.a.class);
    }

    public h e() {
        return (h) a(4, j.class);
    }

    public com.baidu.navisdk.module.newguide.controllers.a f() {
        return (com.baidu.navisdk.module.newguide.controllers.a) a(7, com.baidu.navisdk.module.newguide.controllers.a.class);
    }

    public k g() {
        return (k) a(11, k.class);
    }

    public com.baidu.navisdk.pronavi.mapshow.i.b h() {
        return (com.baidu.navisdk.pronavi.mapshow.i.b) a(16, com.baidu.navisdk.pronavi.mapshow.a.class);
    }

    public t i() {
        return (t) a(9, t.class);
    }

    public com.baidu.navisdk.module.newguide.recommendvoice.b j() {
        return (com.baidu.navisdk.module.newguide.recommendvoice.b) a(12, com.baidu.navisdk.module.newguide.recommendvoice.b.class);
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.k k() {
        return (com.baidu.navisdk.framework.interfaces.pronavi.k) a(8, v.class);
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.control.b l() {
        return (com.baidu.navisdk.ui.routeguide.mapmode.control.b) a(1, com.baidu.navisdk.ui.routeguide.mapmode.control.b.class);
    }

    public m m() {
        return (m) a(6, w.class);
    }

    public void n() {
        SparseArray<com.baidu.navisdk.module.pronavi.abs.b> sparseArray = this.f9064a;
        if (sparseArray != null && sparseArray.size() > 0) {
            for (int i = 0; i < this.f9064a.size(); i++) {
                this.f9064a.valueAt(i).release();
            }
        }
        synchronized (b) {
            this.f9064a.clear();
        }
    }

    public com.baidu.navisdk.ui.routeguide.ar.a a(boolean z) {
        return (com.baidu.navisdk.ui.routeguide.ar.a) a(14, com.baidu.navisdk.ui.routeguide.ar.a.class, z);
    }

    public com.baidu.navisdk.pronavi.style.i.b b(boolean z) {
        return (com.baidu.navisdk.pronavi.style.i.b) a(15, com.baidu.navisdk.pronavi.style.b.class, z);
    }

    public com.baidu.navisdk.ui.routeguide.control.h c() {
        return (com.baidu.navisdk.ui.routeguide.control.h) a(13, com.baidu.navisdk.ui.routeguide.control.h.class);
    }

    public com.baidu.navisdk.pronavi.hd.normal.i.a d(boolean z) {
        return (com.baidu.navisdk.pronavi.hd.normal.i.a) a(18, com.baidu.navisdk.pronavi.hd.normal.logic.b.class, z);
    }

    private <T extends com.baidu.navisdk.module.pronavi.abs.b> T a(int i, Class<T> cls) {
        return a(i, cls, true);
    }

    @Nullable
    private <T extends com.baidu.navisdk.module.pronavi.abs.b> T a(int i, Class<T> cls, boolean z) {
        T t;
        T t2 = (T) this.f9064a.get(i);
        if (t2 != null && cls.isInstance(t2)) {
            return t2;
        }
        synchronized (b) {
            t = (T) this.f9064a.get(i);
            if (t == null && z) {
                try {
                    T newInstance = cls.newInstance();
                    try {
                        this.f9064a.put(i, newInstance);
                        t = newInstance;
                    } catch (Exception e) {
                        e = e;
                        t = newInstance;
                        if (LogUtil.LOGGABLE) {
                            e.printStackTrace();
                            LogUtil.printException("obtainController-controllerTag:" + i, e);
                        }
                        return t;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }
        return t;
    }
}
