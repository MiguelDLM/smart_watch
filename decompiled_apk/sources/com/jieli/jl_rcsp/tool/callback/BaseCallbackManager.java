package com.jieli.jl_rcsp.tool.callback;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes10.dex */
public abstract class BaseCallbackManager<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<T> f18067a;
    public final Handler b;

    /* loaded from: classes10.dex */
    public interface CallbackImpl<T> {
        void onPost(T t);
    }

    /* loaded from: classes10.dex */
    public class CallbackRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final CallbackImpl<T> f18068a;

        public CallbackRunnable(CallbackImpl<T> callbackImpl) {
            this.f18068a = callbackImpl;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (!BaseCallbackManager.this.f18067a.isEmpty() && this.f18068a != null) {
                Iterator it = new ArrayList(BaseCallbackManager.this.f18067a).iterator();
                while (it.hasNext()) {
                    this.f18068a.onPost(it.next());
                }
            }
        }
    }

    public BaseCallbackManager() {
        this(new Handler(Looper.getMainLooper()));
    }

    public void callbackEvent(CallbackImpl<T> callbackImpl) {
        if (callbackImpl == null) {
            return;
        }
        CallbackRunnable callbackRunnable = new CallbackRunnable(callbackImpl);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.b.post(callbackRunnable);
        } else {
            callbackRunnable.run();
        }
    }

    public void registerCallback(T t) {
        if (t != null && !this.f18067a.contains(t)) {
            this.f18067a.add(t);
        }
    }

    public void release() {
        this.f18067a.clear();
        this.b.removeCallbacksAndMessages(null);
    }

    public void unregisterCallback(T t) {
        if (t != null && !this.f18067a.isEmpty()) {
            this.f18067a.remove(t);
        }
    }

    public BaseCallbackManager(Handler handler) {
        this.f18067a = new ArrayList<>();
        this.b = handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }
}
