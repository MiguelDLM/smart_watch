package com.jd.ad.sdk.jad_xg;

import android.view.View;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: classes10.dex */
public class jad_bo extends com.jd.ad.sdk.jad_hu.jad_an {
    public final /* synthetic */ IDynamicInteractionListener jad_er;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_bo(jad_dq jad_dqVar, String str, IDynamicInteractionListener iDynamicInteractionListener) {
        super(str);
        this.jad_er = iDynamicInteractionListener;
    }

    @Override // com.jd.ad.sdk.jad_hu.jad_an
    public void jad_an(View view) {
        Logger.d("click sdkSkipArea");
        IDynamicInteractionListener iDynamicInteractionListener = this.jad_er;
        if (iDynamicInteractionListener != null) {
            iDynamicInteractionListener.onAdSkip(view);
        }
    }
}
