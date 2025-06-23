package com.jd.ad.sdk.jad_f_an;

import android.view.View;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.feed.jad_f_an;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class jad_f_er implements View.OnClickListener {
    public final /* synthetic */ View jad_f_an;
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_an jad_f_bo;

    public jad_f_er(com.jd.ad.sdk.feed.jad_f_an jad_f_anVar, View view) {
        this.jad_f_bo = jad_f_anVar;
        this.jad_f_an = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        JADFeed.jad_f_jw jad_f_jwVar;
        WeakReference<JADFeed> weakReference;
        com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.jad_f_bo;
        View view2 = this.jad_f_an;
        jad_f_anVar.getClass();
        if (view2 != null) {
            JADMediator.getInstance().getExposureService().setViewForceExposure(jad_f_anVar.jad_f_dq);
            int onViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(view2.getContext(), view2, jad_f_anVar.jad_f_dq);
            jad_f_an.InterfaceC0677jad_f_an interfaceC0677jad_f_an = jad_f_anVar.jad_f_kx;
            if (interfaceC0677jad_f_an != null && (weakReference = (jad_f_jwVar = (JADFeed.jad_f_jw) interfaceC0677jad_f_an).jad_f_an) != null && weakReference.get() != null) {
                JADFeed jADFeed = jad_f_jwVar.jad_f_an.get();
                jADFeed.reportClickEvent(onViewClicked);
                jADFeed.callbackAdClickOnUiThread();
            }
        }
    }
}
