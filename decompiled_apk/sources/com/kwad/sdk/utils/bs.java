package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes11.dex */
public final class bs extends Handler {
    private WeakReference<a> aSj;

    /* loaded from: classes11.dex */
    public interface a {
        void a(Message message);
    }

    public bs(a aVar) {
        this.aSj = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        WeakReference<a> weakReference;
        a aVar;
        try {
            weakReference = this.aSj;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }
}
