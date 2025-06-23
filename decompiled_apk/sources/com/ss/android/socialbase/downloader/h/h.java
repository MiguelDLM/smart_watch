package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes13.dex */
public class h extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<a> f26312a;

    /* loaded from: classes13.dex */
    public interface a {
        void a(Message message);
    }

    public h(Looper looper, a aVar) {
        super(looper);
        this.f26312a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f26312a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
