package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.socialbase.downloader.i.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Application f26209a;
    private c b;
    private final List<InterfaceC1053a> c;
    private int d;
    private WeakReference<Activity> e;
    private volatile int f;
    private volatile boolean g;
    private final Application.ActivityLifecycleCallbacks h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC1053a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes13.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f26211a = new a();
    }

    /* loaded from: classes13.dex */
    public interface c {
    }

    private Object[] d() {
        Object[] objArr;
        synchronized (this.c) {
            try {
                if (this.c.size() > 0) {
                    objArr = this.c.toArray();
                } else {
                    objArr = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f = 1;
        Object[] d = d();
        if (d != null) {
            for (Object obj : d) {
                ((InterfaceC1053a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f = 0;
        Object[] d = d();
        if (d != null) {
            for (Object obj : d) {
                ((InterfaceC1053a) obj).c();
            }
        }
    }

    private boolean g() {
        try {
            Application application = this.f26209a;
            if (application == null) {
                return false;
            }
            return TextUtils.equals(application.getPackageName(), f.d(application));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private a() {
        this.c = new ArrayList();
        this.f = -1;
        this.g = false;
        this.h = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.g = true;
                if (a.this.d == 0 && activity != null) {
                    a.this.d = activity.hashCode();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i;
                int i2 = a.this.d;
                a.this.g = false;
                a aVar = a.this;
                if (activity != null) {
                    i = activity.hashCode();
                } else {
                    i = i2;
                }
                aVar.d = i;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                int i;
                a.this.e = new WeakReference(activity);
                int i2 = a.this.d;
                a aVar = a.this;
                if (activity != null) {
                    i = activity.hashCode();
                } else {
                    i = i2;
                }
                aVar.d = i;
                a.this.g = false;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.d) {
                    a.this.d = 0;
                    a.this.f();
                }
                a.this.g = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [int, boolean] */
    public boolean b() {
        int i = this.f;
        int i2 = i;
        if (i == -1) {
            ?? g = g();
            this.f = g;
            i2 = g;
        }
        return i2 == 1;
    }

    public boolean c() {
        return b() && !this.g;
    }

    public static a a() {
        return b.f26211a;
    }

    public void b(InterfaceC1053a interfaceC1053a) {
        synchronized (this.c) {
            this.c.remove(interfaceC1053a);
        }
    }

    public void a(Context context) {
        if (this.f26209a == null && (context instanceof Application)) {
            synchronized (this) {
                try {
                    if (this.f26209a == null) {
                        Application application = (Application) context;
                        this.f26209a = application;
                        application.registerActivityLifecycleCallbacks(this.h);
                    }
                } finally {
                }
            }
        }
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    public void a(InterfaceC1053a interfaceC1053a) {
        if (interfaceC1053a == null) {
            return;
        }
        synchronized (this.c) {
            try {
                if (!this.c.contains(interfaceC1053a)) {
                    this.c.add(interfaceC1053a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
