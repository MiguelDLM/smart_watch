package com.adp.sdk.utils.k;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private List<Activity> f4740a;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f4741a = new a();
    }

    private boolean a(Activity activity) {
        return false;
    }

    public static a b() {
        return b.f4741a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!a(activity) && !this.f4740a.contains(activity)) {
            this.f4740a.add(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.f4740a.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (!a(activity) && !this.f4740a.contains(activity)) {
            this.f4740a.add(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (!a(activity) && !this.f4740a.contains(activity)) {
            this.f4740a.add(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    private a() {
        this.f4740a = new CopyOnWriteArrayList();
    }

    public void a(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
        application.registerActivityLifecycleCallbacks(this);
    }

    public Activity a() {
        List<Activity> list = this.f4740a;
        if (list != null && !list.isEmpty()) {
            for (int size = this.f4740a.size() - 1; size >= 0; size--) {
                Activity activity = this.f4740a.get(size);
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    return activity;
                }
            }
        }
        return null;
    }
}
