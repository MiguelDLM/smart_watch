package com.jd.ad.sdk.jad_f_an;

import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.dl.common.CommonConstants;

/* loaded from: classes10.dex */
public class jad_f_bo implements View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_an jad_f_an;

    public jad_f_bo(com.jd.ad.sdk.feed.jad_f_an jad_f_anVar) {
        this.jad_f_an = jad_f_anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.jad_f_an;
        jad_f_anVar.jad_f_an(jad_f_anVar.jad_f_iv, CommonConstants.ClickFrom.CLOSE.ordinal());
        View view2 = this.jad_f_an.jad_f_iv;
        if (view2 != null && view2.getParent() != null && (this.jad_f_an.jad_f_iv.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.jad_f_an.jad_f_iv.getParent()).removeView(this.jad_f_an.jad_f_iv);
        }
        this.jad_f_an.jad_f_an();
    }
}
