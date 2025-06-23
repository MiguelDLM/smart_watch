package com.jd.ad.sdk.jad_i_an;

import android.app.Dialog;

/* loaded from: classes10.dex */
public class jad_i_er implements Runnable {
    public final /* synthetic */ com.jd.ad.sdk.interstitial.jad_i_an jad_i_an;

    public jad_i_er(com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar) {
        this.jad_i_an = jad_i_anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jad_i_an.jad_i_jw = false;
        this.jad_i_an.jad_i_kx = true;
        Dialog dialog = this.jad_i_an.jad_i_iv;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
