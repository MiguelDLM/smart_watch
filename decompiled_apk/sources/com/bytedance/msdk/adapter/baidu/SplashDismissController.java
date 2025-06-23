package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class SplashDismissController {

    /* renamed from: II0xO0, reason: collision with root package name */
    public WeakReference<Activity> f10465II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public CallBack f10466X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public WeakReference<Activity> f10468oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f10464I0Io = false;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f10469oxoX = false;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f10467XO = false;

    /* loaded from: classes8.dex */
    public interface CallBack {
        void onResume();
    }

    public SplashDismissController(Activity activity, Activity activity2) {
        this.f10468oIX0oI = new WeakReference<>(activity);
        if (activity2 != null) {
            this.f10465II0xO0 = new WeakReference<>(activity2);
        }
        I0Io();
    }

    public final void I0Io() {
        Activity activity = this.f10468oIX0oI.get();
        if (activity != null) {
            activity.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.adapter.baidu.SplashDismissController.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                    SplashDismissController.this.f10466X0o0xo = null;
                    if ((SplashDismissController.this.f10468oIX0oI == null || SplashDismissController.this.f10468oIX0oI.get() != activity2) && (SplashDismissController.this.f10465II0xO0 == null || SplashDismissController.this.f10465II0xO0.get() != activity2)) {
                        return;
                    }
                    activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity2) {
                    if ((SplashDismissController.this.f10468oIX0oI == null || SplashDismissController.this.f10468oIX0oI.get() != activity2) && (SplashDismissController.this.f10465II0xO0 == null || SplashDismissController.this.f10465II0xO0.get() != activity2)) {
                        return;
                    }
                    SplashDismissController.this.f10469oxoX = true;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity2) {
                    if (((SplashDismissController.this.f10468oIX0oI == null || SplashDismissController.this.f10468oIX0oI.get() != activity2) && (SplashDismissController.this.f10465II0xO0 == null || SplashDismissController.this.f10465II0xO0.get() != activity2)) || SplashDismissController.this.f10466X0o0xo == null) {
                        return;
                    }
                    SplashDismissController.this.f10466X0o0xo.onResume();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity2) {
                }
            });
        }
    }

    public boolean isCallDismiss() {
        return this.f10467XO;
    }

    public boolean jumpToAdPage() {
        return this.f10464I0Io && this.f10469oxoX;
    }

    public void setCallBack(CallBack callBack) {
        this.f10466X0o0xo = callBack;
    }

    public void setCallDismiss(boolean z) {
        this.f10467XO = z;
    }

    public void setClick(boolean z) {
        this.f10464I0Io = z;
    }
}
