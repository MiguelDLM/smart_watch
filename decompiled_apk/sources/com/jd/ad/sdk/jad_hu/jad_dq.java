package com.jd.ad.sdk.jad_hu;

import android.content.Context;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper;

/* loaded from: classes10.dex */
public class jad_dq implements Runnable {
    public final /* synthetic */ Context jad_an;

    public jad_dq(Context context) {
        this.jad_an = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!DynamicRenderTemplateHelper.jad_an() && com.jd.ad.sdk.jad_ob.jad_hu.jad_dq(this.jad_an) && DynamicRenderTemplateHelper.jad_dq == null) {
            jad_bo jad_an = jad_bo.jad_an(this.jad_an, "jaddb.db", 2);
            DynamicRenderTemplateHelper.jad_dq = jad_an;
            jad_an.jad_cp();
        }
    }
}
