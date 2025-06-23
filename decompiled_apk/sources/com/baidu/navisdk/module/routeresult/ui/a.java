package com.baidu.navisdk.module.routeresult.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import com.baidu.navisdk.module.routeresult.interfaces.a;
import com.baidu.navisdk.module.routeresult.model.a;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.u;
import com.baidu.navisdk.util.jar.JarUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public abstract class a<T extends com.baidu.navisdk.module.routeresult.model.a> implements com.baidu.navisdk.module.routeresult.interfaces.a<T> {

    /* renamed from: a, reason: collision with root package name */
    protected Context f7502a;
    protected T b;
    protected ViewGroup c;
    protected ViewGroup d;
    private boolean e;
    protected View f;
    private int j;
    private Message k;
    private Message l;
    private Message m;
    protected a.b n;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private volatile boolean i = false;
    private final Handler o = new HandlerC0286a("BaseView", this);

    /* renamed from: com.baidu.navisdk.module.routeresult.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class HandlerC0286a extends com.baidu.navisdk.util.worker.loop.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<com.baidu.navisdk.module.routeresult.interfaces.a> f7503a;

        public HandlerC0286a(String str, com.baidu.navisdk.module.routeresult.interfaces.a aVar) {
            super(str);
            this.f7503a = new WeakReference<>(aVar);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            ((a.InterfaceC0284a) message.obj).a(this.f7503a.get());
                            return;
                        }
                        return;
                    }
                    ((a.c) message.obj).a(this.f7503a.get());
                    return;
                }
                ((a.d) message.obj).a(this.f7503a.get());
                return;
            }
            ((a.e) message.obj).a(this.f7503a.get());
        }
    }

    public a(Context context, T t) {
        this.f7502a = context;
        this.b = t;
        a((a<T>) t);
        u.a(this);
    }

    private void b(Bundle bundle) {
        if (this.g) {
            return;
        }
        int p = p();
        this.j = p;
        e(p);
        a(bundle);
        this.g = true;
        h();
    }

    private void e(int i) {
    }

    private int p() {
        int i;
        Context context = this.f7502a;
        if (context != null) {
            i = context.getResources().getConfiguration().orientation;
        } else {
            i = 0;
        }
        LogUtil.e("BaseView", "getPreloadOrientation = " + i);
        return i;
    }

    private void q() {
        Message message = this.m;
        if (message != null) {
            Message.obtain(message).sendToTarget();
        }
    }

    private void r() {
        Message message = this.l;
        if (message != null) {
            Message.obtain(message).sendToTarget();
        }
    }

    private void s() {
        Message message = this.k;
        if (message != null) {
            Message.obtain(message).sendToTarget();
        }
    }

    public void a(Bundle bundle) {
    }

    public final void c(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseView", "hide --> isHasAnimation = " + z + ", mShowing = " + this.h);
        }
        if (this.d == null || this.f == null) {
            return;
        }
        if (!this.h) {
            this.d.setVisibility(8);
            return;
        }
        if (z && this.e) {
            n();
        } else {
            this.d.setVisibility(8);
        }
        this.h = false;
        i();
        r();
    }

    public final boolean d(boolean z) {
        return a(z, null);
    }

    public final void f() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseView", "create --> mCreated = " + this.g);
        }
        if (!this.g) {
            b((Bundle) null);
        }
    }

    public boolean g() {
        return this.h;
    }

    public void h() {
    }

    public void i() {
    }

    public boolean j() {
        return true;
    }

    public void k() {
    }

    public boolean l() {
        return true;
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
    }

    private void a(T t) {
        if (t != null) {
            this.c = t.g();
            this.d = t.a();
            this.e = t.h();
            a(t.f());
            a(t.d());
            a(t.c());
            a(t.b());
            a(t.e());
        }
    }

    public void d(int i) {
        this.f = JarUtils.inflate(this.f7502a, i, null);
    }

    public boolean e() {
        View view;
        View view2 = this.f;
        if (view2 != null && this.d != null) {
            ViewParent parent = view2.getParent();
            ViewGroup viewGroup = this.d;
            if (parent == viewGroup || this.f == viewGroup) {
                return true;
            }
        }
        if (this.d == null || (view = this.f) == null) {
            return false;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f.getParent()).removeAllViews();
        }
        this.d.setVisibility(8);
        this.d.removeAllViews();
        this.d.addView(this.f, new ViewGroup.LayoutParams(-1, -2));
        return true;
    }

    public final void b(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseView", "dismiss --> isHasAnimation = " + z + " mShowing = " + this.h);
        }
        if (this.f == null || this.d == null) {
            return;
        }
        m();
        if (!this.h) {
            if (this.f.getParent() != null) {
                ((ViewGroup) this.f.getParent()).removeAllViews();
            }
            this.d.removeAllViews();
            this.f = null;
            this.g = false;
            return;
        }
        if (z && this.e) {
            n();
        } else {
            if (this.f.getParent() != null) {
                ((ViewGroup) this.f.getParent()).removeAllViews();
            }
            this.d.setVisibility(8);
            this.d.removeAllViews();
            this.f = null;
        }
        this.g = false;
        this.h = false;
        q();
    }

    public final boolean a(boolean z, Bundle bundle) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseView", "show --> isHasAnimation = " + z);
            LogUtil.e("BaseView", "show --> mShowing = " + this.h + ", mCreated = " + this.g + ", mCanceled = " + this.i);
        }
        if (this.h) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BaseView", "show --> mContainerView = " + this.d + ", mMainView = " + this.f);
            }
            if (this.d != null && this.f != null) {
                boolean j = j();
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BaseView", "show --> isOnResumeSuccess = " + j);
                }
                if (!j) {
                    this.d.setVisibility(8);
                    return false;
                }
                this.d.setVisibility(0);
                return true;
            }
        }
        this.i = false;
        if (!this.g) {
            b(bundle);
        }
        boolean l = l();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseView", "show --> isStartSuccess = " + l);
        }
        if (!l) {
            return false;
        }
        if (!this.i) {
            boolean e = e();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BaseView", "show --> isAddViewSuccess = " + e);
            }
            if (!e) {
                return false;
            }
            boolean j2 = j();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BaseView", "show --> isOnResumeSuccess = " + j2);
            }
            if (!j2) {
                return false;
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BaseView", "show --> mContainerView = " + this.d + ", mMainView = " + this.f + ", mCanceled = " + this.i);
        }
        if (this.d == null || this.f == null || this.i) {
            return false;
        }
        if (z && this.e) {
            o();
        } else {
            this.d.setVisibility(0);
        }
        this.h = true;
        k();
        s();
        return true;
    }

    @Nullable
    public <K extends View> K c(int i) {
        View view = this.f;
        if (view == null) {
            if (!LogUtil.LOGGABLE) {
                return null;
            }
            LogUtil.e("BaseView", "findViewById --> mMainView is null!!!");
            return null;
        }
        return (K) view.findViewById(i);
    }

    private void a(a.e eVar) {
        if (eVar != null) {
            this.k = this.o.obtainMessage(1, eVar);
        } else {
            this.k = null;
        }
    }

    private void a(a.d dVar) {
        if (dVar != null) {
            this.l = this.o.obtainMessage(2, dVar);
        } else {
            this.l = null;
        }
    }

    private void a(a.InterfaceC0284a interfaceC0284a) {
        if (interfaceC0284a != null) {
            this.o.obtainMessage(4, interfaceC0284a);
        }
    }

    private void a(a.c cVar) {
        if (cVar != null) {
            this.m = this.o.obtainMessage(3, cVar);
        } else {
            this.m = null;
        }
    }

    private void a(a.b bVar) {
        if (bVar != null) {
            this.n = bVar;
        }
    }
}
