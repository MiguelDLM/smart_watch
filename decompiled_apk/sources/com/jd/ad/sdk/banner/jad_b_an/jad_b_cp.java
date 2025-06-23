package com.jd.ad.sdk.banner.jad_b_an;

import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.dl.common.CommonConstants;

/* loaded from: classes10.dex */
public class jad_b_cp implements View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.banner.jad_b_an jad_b_an;

    public jad_b_cp(com.jd.ad.sdk.banner.jad_b_an jad_b_anVar) {
        this.jad_b_an = jad_b_anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.jd.ad.sdk.banner.jad_b_an jad_b_anVar = this.jad_b_an;
        jad_b_anVar.jad_b_an(jad_b_anVar.jad_b_jt, CommonConstants.ClickFrom.CLOSE.ordinal());
        View view2 = this.jad_b_an.jad_b_jt;
        if (view2 != null && view2.getParent() != null) {
            ((ViewGroup) this.jad_b_an.jad_b_jt.getParent()).removeView(this.jad_b_an.jad_b_jt);
        }
    }
}
