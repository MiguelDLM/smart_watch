package com.jd.ad.sdk.jad_i_an;

import android.view.View;

/* loaded from: classes10.dex */
public class jad_i_an implements View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.interstitial.jad_i_an jad_i_an;

    public jad_i_an(com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar) {
        this.jad_i_an = jad_i_anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar = this.jad_i_an;
        if (jad_i_anVar.jad_i_iv != null) {
            jad_i_anVar.jad_i_jw = true;
            this.jad_i_an.jad_i_iv.dismiss();
        }
    }
}
