package com.jd.ad.sdk.fdt.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes10.dex */
public class ActLifecycle implements Application.ActivityLifecycleCallbacks {
    public static final CopyOnWriteArrayList<jad_an> jad_bo = new CopyOnWriteArrayList<>();
    public static final CopyOnWriteArrayList<OnLifecycleChangeListener> jad_cp = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<WeakReference<Activity>> jad_an = new CopyOnWriteArrayList<>();

    /* loaded from: classes10.dex */
    public interface OnLifecycleChangeListener {
        void onActivityDestroyed(@NonNull Activity activity);
    }

    /* loaded from: classes10.dex */
    public interface jad_an {
        void jad_an();

        void jad_bo();
    }

    public static void addLifecycleListener(OnLifecycleChangeListener onLifecycleChangeListener) {
        if (onLifecycleChangeListener == null) {
            return;
        }
        jad_cp.add(onLifecycleChangeListener);
    }

    public static void removeLifecycleListener(OnLifecycleChangeListener onLifecycleChangeListener) {
        if (onLifecycleChangeListener == null) {
            return;
        }
        jad_cp.remove(onLifecycleChangeListener);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        CopyOnWriteArrayList<OnLifecycleChangeListener> copyOnWriteArrayList = jad_cp;
        if (copyOnWriteArrayList.size() > 0) {
            Iterator<OnLifecycleChangeListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                OnLifecycleChangeListener next = it.next();
                if (next != null) {
                    next.onActivityDestroyed(activity);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        if (this.jad_an.size() == 0) {
            CopyOnWriteArrayList<jad_an> copyOnWriteArrayList = jad_bo;
            if (copyOnWriteArrayList.size() > 0) {
                Iterator<jad_an> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    jad_an next = it.next();
                    if (next != null) {
                        next.jad_an();
                    }
                }
            }
        }
        if (activity != null) {
            this.jad_an.add(new WeakReference<>(activity));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        if (this.jad_an.size() > 0) {
            Iterator<WeakReference<Activity>> it = this.jad_an.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.jad_an.remove(next);
                    break;
                }
            }
        }
        if (this.jad_an.size() == 0) {
            CopyOnWriteArrayList<jad_an> copyOnWriteArrayList = jad_bo;
            if (copyOnWriteArrayList.size() > 0) {
                Iterator<jad_an> it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    jad_an next2 = it2.next();
                    if (next2 != null) {
                        next2.jad_bo();
                    }
                }
            }
        }
    }
}
