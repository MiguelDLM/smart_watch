package com.jd.ad.sdk.fdt.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class HandlerUtils {

    /* loaded from: classes10.dex */
    public static class jad_an extends Handler {
        public WeakReference<jad_bo> jad_an;

        public jad_an(jad_bo jad_boVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            jad_bo jad_boVar;
            WeakReference<jad_bo> weakReference = this.jad_an;
            if (weakReference == null || (jad_boVar = weakReference.get()) == null) {
                return;
            }
            jad_boVar.jad_an(message);
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_bo {
        void jad_an(Message message);
    }

    private HandlerUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new jad_an(null, Looper.getMainLooper()).postDelayed(runnable, 0L);
        }
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        new jad_an(null, Looper.getMainLooper()).postDelayed(runnable, j);
    }
}
