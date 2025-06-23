package com.jd.ad.sdk.jad_i_an;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import com.jd.ad.sdk.interstitial.jad_i_an;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* loaded from: classes10.dex */
public class jad_i_cp implements View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.interstitial.jad_i_an jad_i_an;

    public jad_i_cp(com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar) {
        this.jad_i_an = jad_i_anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jad_i_an.jad_i_jw = false;
        com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar = this.jad_i_an;
        ImageView imageView = jad_i_anVar.jad_i_mz;
        if (jad_i_anVar.jad_i_jt != null) {
            JADMediator.getInstance().getExposureService().setViewForceExposure(jad_i_anVar.jad_i_dq);
            int onViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(jad_i_anVar.jad_i_jt.getContext(), imageView, jad_i_anVar.jad_i_dq);
            jad_i_an.jad_i_cp jad_i_cpVar = jad_i_anVar.jad_i_hu;
            if (jad_i_cpVar != null) {
                jad_i_cpVar.onAdClicked(imageView, onViewClicked);
            }
        }
        Dialog dialog = this.jad_i_an.jad_i_iv;
        if (dialog != null) {
            dialog.dismiss();
        }
        JADMediator.getInstance().getTouchService().unregisterTouchView(this.jad_i_an.jad_i_dq);
    }
}
