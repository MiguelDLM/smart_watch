package com.bytedance.sdk.openadsdk.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes8.dex */
class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f10657a = false;
    private int b = 0;
    private InterfaceC0565a c;

    /* renamed from: com.bytedance.sdk.openadsdk.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0565a {
        void a();

        void b();
    }

    public Boolean a() {
        return Boolean.valueOf(f10657a);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.b++;
        f10657a = false;
        InterfaceC0565a interfaceC0565a = this.c;
        if (interfaceC0565a != null) {
            interfaceC0565a.b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.b - 1;
        this.b = i;
        if (i == 0) {
            f10657a = true;
            InterfaceC0565a interfaceC0565a = this.c;
            if (interfaceC0565a != null) {
                interfaceC0565a.a();
            }
        }
    }

    public void a(InterfaceC0565a interfaceC0565a) {
        this.c = interfaceC0565a;
    }
}
