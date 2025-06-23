package com.jd.ad.sdk.splash;

import android.view.View;
import com.jd.ad.sdk.splash.JADSplashSkipView;

/* loaded from: classes10.dex */
public class jad_s_dq implements View.OnClickListener {
    public final /* synthetic */ JADSplashSkipView jad_s_an;

    public jad_s_dq(JADSplashSkipView jADSplashSkipView) {
        this.jad_s_an = jADSplashSkipView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        JADSplashSkipView.jad_s_bo jad_s_boVar = this.jad_s_an.jad_s_bo;
        if (jad_s_boVar != null) {
            jad_s_an jad_s_anVar = (jad_s_an) jad_s_boVar;
            jad_s_bo.jad_s_an(jad_s_anVar.jad_s_an, view);
            JADSplashSkipView jADSplashSkipView = jad_s_anVar.jad_s_an.jad_s_kx;
            if (jADSplashSkipView != null) {
                jADSplashSkipView.removeCallbacks(null);
            }
        }
    }
}
