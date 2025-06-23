package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* loaded from: classes11.dex */
public class da {
    private static volatile da b;

    /* renamed from: a, reason: collision with root package name */
    private Context f18377a;
    private Application.ActivityLifecycleCallbacks c;
    private boolean d;

    private da(Context context) {
        this.f18377a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            Context context = this.f18377a;
            if (context == null) {
                return;
            }
            h a2 = h.a(context, "re_po_rt");
            if (a2.b(df.w, 0) == 0) {
                return;
            }
            final int[] iArr = {0};
            final int[] iArr2 = {a2.b(df.k, 1)};
            if (this.f18377a instanceof Application) {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.kuaishou.weapon.p0.da.2
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        try {
                            int[] iArr3 = iArr;
                            iArr3[0] = iArr3[0] + 1;
                            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (iArr[0] < 20 && iArr2[0] <= 0) {
                                        ((Application) da.this.f18377a).unregisterActivityLifecycleCallbacks(da.this.c);
                                        return;
                                    }
                                    iArr2[0] = r1[0] - 1;
                                    cx.a(da.this.f18377a).a(106);
                                    dd.a(da.this.f18377a).a(106);
                                    db.a(da.this.f18377a).a(106, 0);
                                    cy.a(da.this.f18377a).a(106);
                                    cz.a(da.this.f18377a).a(106);
                                    de.a(da.this.f18377a).a(106);
                                }
                            });
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }
                };
                this.c = activityLifecycleCallbacks;
                ((Application) this.f18377a).registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        } catch (Throwable unused) {
        }
    }

    public static da a(Context context) {
        if (b == null) {
            synchronized (da.class) {
                try {
                    if (b == null) {
                        b = new da(context);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a() {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        h a2 = h.a(da.this.f18377a, "re_po_rt");
                        boolean e = a2.e("a1_p_s_p_s");
                        boolean e2 = a2.e("a1_p_s_p_s_c_b");
                        if ((e || e2) && !da.this.d) {
                            da.this.d = true;
                            da.this.b();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
