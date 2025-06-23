package com.adp.sdk.utils.k;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private List<Activity> f746a;

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f747a = new a();
    }

    private boolean a(Activity activity) {
        return false;
    }

    public static a b() {
        return b.f747a;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!a(activity) && !this.f746a.contains(activity)) {
            this.f746a.add(activity);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.f746a.remove(activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (!a(activity) && !this.f746a.contains(activity)) {
            this.f746a.add(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (!a(activity) && !this.f746a.contains(activity)) {
            this.f746a.add(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
    }

    private a() {
        this.f746a = new CopyOnWriteArrayList();
    }

    public void a(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
        application.registerActivityLifecycleCallbacks(this);
    }

    public Activity a() {
        List<Activity> list = this.f746a;
        if (list != null && !list.isEmpty()) {
            for (int size = this.f746a.size() - 1; size >= 0; size--) {
                Activity activity = this.f746a.get(size);
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    return activity;
                }
            }
        }
        return null;
    }
}
