package com.jd.ad.sdk.jad_s_an;

import android.view.View;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener;

/* loaded from: classes10.dex */
public class jad_s_bo implements IDynamicInteractionListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_bo jad_s_an;

    public jad_s_bo(com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar) {
        this.jad_s_an = jad_s_boVar;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener
    public void onAdClicked(int i, int i2) {
        com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar = this.jad_s_an;
        com.jd.ad.sdk.splash.jad_s_bo.jad_s_an(jad_s_boVar, jad_s_boVar.jad_s_bo(), this.jad_s_an.jad_s_jt, 3, i, i2);
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener
    public void onAdSkip(View view) {
        com.jd.ad.sdk.splash.jad_s_bo.jad_s_an(this.jad_s_an, view);
    }
}
