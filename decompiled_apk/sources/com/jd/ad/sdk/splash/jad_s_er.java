package com.jd.ad.sdk.splash;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public class jad_s_er implements Handler.Callback {
    public final float jad_s_bo;
    public jad_s_an jad_s_dq;
    public boolean jad_s_an = false;
    public Handler jad_s_cp = new Handler(Looper.getMainLooper(), this);

    /* loaded from: classes10.dex */
    public interface jad_s_an {
        void onCounterFinish();
    }

    public jad_s_er(float f) {
        this.jad_s_bo = f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        jad_s_an jad_s_anVar = this.jad_s_dq;
        if (jad_s_anVar != null) {
            jad_s_anVar.onCounterFinish();
        }
        jad_s_an();
        return true;
    }

    public void jad_s_an() {
        Handler handler = this.jad_s_cp;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.jad_s_cp = null;
        }
        this.jad_s_dq = null;
    }
}
