package com.jd.ad.sdk.jad_s_an;

import com.jd.ad.sdk.splash.JADSplashSkipView;

/* loaded from: classes10.dex */
public class jad_s_er implements Runnable {
    public final /* synthetic */ JADSplashSkipView jad_s_an;

    public jad_s_er(com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar, JADSplashSkipView jADSplashSkipView) {
        this.jad_s_an = jADSplashSkipView;
    }

    @Override // java.lang.Runnable
    public void run() {
        JADSplashSkipView jADSplashSkipView = this.jad_s_an;
        if (jADSplashSkipView != null) {
            int i = jADSplashSkipView.jad_s_an;
            if (i < 1 || i > 30) {
                jADSplashSkipView.jad_s_an = 5;
            }
            jADSplashSkipView.post(jADSplashSkipView.jad_s_er);
        }
    }
}
