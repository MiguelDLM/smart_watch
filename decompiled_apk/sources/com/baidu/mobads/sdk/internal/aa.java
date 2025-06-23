package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6214a = "LoadRemoteDex";
    private static aa i;
    private IXAdContainerFactory b;
    private bq c;
    private Runnable f;
    private Context g;
    private boolean k;
    private int d = 5000;
    private Handler e = new Handler(Looper.getMainLooper());
    private bv h = bv.a();
    private AtomicBoolean j = new AtomicBoolean(false);

    /* loaded from: classes7.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f6215a = 1;
        public static final int b = 2;

        void onFailure();

        void onSuccess();
    }

    private aa() {
    }

    private void f() {
        this.j.set(true);
        if (ao.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (aa.class) {
            try {
                bq bqVar = new bq(Class.forName(x.aQ, true, getClass().getClassLoader()), this.g);
                this.c = bqVar;
                this.b = bqVar.a();
                k();
            } catch (Exception unused) {
                a("反射调用remote失败");
            }
        }
    }

    private void h() {
        this.f = new ab(this);
        j();
        if (g.f6326a == null) {
            synchronized (cb.class) {
                try {
                    if (g.f6326a == null) {
                        g.f6326a = new cb(this.g);
                    }
                } finally {
                }
            }
        }
        if (this.b != null) {
            k();
            return;
        }
        if (g.f6326a != null) {
            this.h.a(f6214a, "start load apk");
            try {
                g.f6326a.a(new ac(this));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.h.a(f6214a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
    }

    private void i() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.e.removeCallbacks(runnable);
        }
        this.f = null;
    }

    private void j() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.e.postDelayed(runnable, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j.set(false);
        bn.a(this.g);
        i();
        q.a().a(1);
        cp.a(this.g).b();
        cp.a(this.g).a();
    }

    public IXAdContainerFactory c() {
        if (this.g == null) {
            return null;
        }
        if (this.b == null && !this.j.get()) {
            f();
        }
        return this.b;
    }

    public String d() {
        if (this.b != null) {
            return "_" + this.b.getRemoteVersion();
        }
        return "";
    }

    public boolean e() {
        return this.k;
    }

    public Context b() {
        return this.g;
    }

    public static aa a() {
        if (i == null) {
            synchronized (aa.class) {
                try {
                    if (i == null) {
                        i = new aa();
                    }
                } finally {
                }
            }
        }
        return i;
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.h.c(f6214a, "init Context is null,error");
            return;
        }
        this.g = context.getApplicationContext();
        q.a().a(aVar);
        if (this.b != null) {
            k();
        } else {
            if (this.j.get()) {
                return;
            }
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.h.a(f6214a, "加载dex失败原因=" + str);
        this.j.set(false);
        i();
        q.a().a(2);
    }
}
