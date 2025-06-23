package com.jieli.jl_bt_ota.tool;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public abstract class BaseCallbackHelper<T> {
    protected final ArrayList<T> callbacks = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    private final Handler f17736a = new Handler(Looper.getMainLooper());

    public boolean addCallback(T t) {
        if (t == null) {
            return false;
        }
        boolean contains = this.callbacks.contains(t);
        if (!contains) {
            return this.callbacks.add(t);
        }
        return contains;
    }

    public void callbackEvent(ICallbackHandler<T> iCallbackHandler) {
        if (iCallbackHandler == null) {
            return;
        }
        CallbackRunnable callbackRunnable = new CallbackRunnable(this.callbacks, iCallbackHandler);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            callbackRunnable.run();
        } else {
            this.f17736a.post(callbackRunnable);
        }
    }

    public void release() {
        this.callbacks.clear();
        this.f17736a.removeCallbacksAndMessages(null);
    }

    public boolean removeCallback(T t) {
        if (t != null && !this.callbacks.isEmpty()) {
            return this.callbacks.remove(t);
        }
        return false;
    }
}
