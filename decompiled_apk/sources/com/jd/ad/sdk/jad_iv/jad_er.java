package com.jd.ad.sdk.jad_iv;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class jad_er extends Handler {
    public final WeakReference jad_an;

    /* loaded from: classes10.dex */
    public interface jad_an {
        void jad_an(Message message);
    }

    public jad_er(Looper looper, jad_an jad_anVar) {
        super(looper);
        this.jad_an = new WeakReference(jad_anVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        jad_an jad_anVar = (jad_an) this.jad_an.get();
        if (jad_anVar != null && message != null) {
            jad_anVar.jad_an(message);
        }
    }
}
