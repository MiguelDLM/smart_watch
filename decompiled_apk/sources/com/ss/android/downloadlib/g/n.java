package com.ss.android.downloadlib.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes11.dex */
public class n extends Handler {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<a> f26131a;

    /* loaded from: classes11.dex */
    public interface a {
        void a(Message message);
    }

    public n(Looper looper, a aVar) {
        super(looper);
        this.f26131a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f26131a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
