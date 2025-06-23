package com.jd.ad.sdk.jad_f_an;

import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.dl.common.CommonConstants;

/* loaded from: classes10.dex */
public class jad_f_an implements Runnable {
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_an jad_f_an;

    public jad_f_an(com.jd.ad.sdk.feed.jad_f_an jad_f_anVar) {
        this.jad_f_an = jad_f_anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view = this.jad_f_an.jad_f_iv;
        if (view != null && view.getParent() != null && (this.jad_f_an.jad_f_iv.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.jad_f_an.jad_f_iv.getParent()).removeView(this.jad_f_an.jad_f_iv);
            com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.jad_f_an;
            jad_f_anVar.jad_f_an(jad_f_anVar.jad_f_iv, CommonConstants.ClickFrom.CUSTOM_CLOSE.ordinal());
        }
    }
}
