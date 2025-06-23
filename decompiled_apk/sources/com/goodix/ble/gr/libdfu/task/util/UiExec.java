package com.goodix.ble.gr.libdfu.task.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public class UiExec implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private Handler f16119a;

    public UiExec() {
        this(null);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f16119a.post(runnable);
    }

    public Handler getHandler() {
        return this.f16119a;
    }

    public UiExec(Handler handler) {
        this.f16119a = handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }
}
