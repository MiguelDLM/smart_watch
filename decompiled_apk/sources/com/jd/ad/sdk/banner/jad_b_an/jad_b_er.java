package com.jd.ad.sdk.banner.jad_b_an;

import android.view.View;
import com.jd.ad.sdk.banner.JADBanner;
import com.jd.ad.sdk.banner.jad_b_an;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class jad_b_er implements View.OnClickListener {
    public final /* synthetic */ View jad_b_an;
    public final /* synthetic */ com.jd.ad.sdk.banner.jad_b_an jad_b_bo;

    public jad_b_er(com.jd.ad.sdk.banner.jad_b_an jad_b_anVar, View view) {
        this.jad_b_bo = jad_b_anVar;
        this.jad_b_an = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        JADBanner.jad_b_jw jad_b_jwVar;
        WeakReference<JADBanner> weakReference;
        com.jd.ad.sdk.banner.jad_b_an jad_b_anVar = this.jad_b_bo;
        View view2 = this.jad_b_an;
        jad_b_anVar.getClass();
        if (view2 != null) {
            JADMediator.getInstance().getExposureService().setViewForceExposure(jad_b_anVar.jad_b_dq);
            int onViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(view2.getContext(), view2, jad_b_anVar.jad_b_dq);
            jad_b_an.jad_b_bo jad_b_boVar = jad_b_anVar.jad_b_iv;
            if (jad_b_boVar != null && (weakReference = (jad_b_jwVar = (JADBanner.jad_b_jw) jad_b_boVar).jad_b_an) != null && weakReference.get() != null) {
                JADBanner jADBanner = jad_b_jwVar.jad_b_an.get();
                jADBanner.reportClickEvent(onViewClicked);
                jADBanner.callbackAdClickOnUiThread();
            }
        }
    }
}
