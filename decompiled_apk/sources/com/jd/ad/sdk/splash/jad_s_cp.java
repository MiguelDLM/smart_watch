package com.jd.ad.sdk.splash;

import android.view.View;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.splash.JADSplash;
import com.jd.ad.sdk.splash.jad_s_bo;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class jad_s_cp implements Runnable {
    public final /* synthetic */ jad_s_bo jad_s_an;

    public jad_s_cp(jad_s_bo jad_s_boVar) {
        this.jad_s_an = jad_s_boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        JADSplash.jad_s_kx jad_s_kxVar;
        WeakReference<JADSplash> weakReference;
        JADSplash jADSplash;
        View view = this.jad_s_an.jad_s_jt;
        if (view != null && view.getParent() != null) {
            JADMediator.getInstance().getExposureService().setViewForceExposure(this.jad_s_an.jad_s_dq);
            jad_s_bo.jad_s_cp jad_s_cpVar = this.jad_s_an.jad_s_hu;
            if (jad_s_cpVar != null && (weakReference = (jad_s_kxVar = (JADSplash.jad_s_kx) jad_s_cpVar).jad_s_an) != null && weakReference.get() != null && (jADSplash = jad_s_kxVar.jad_s_an.get()) != null) {
                jADSplash.reportCloseEvent(CommonConstants.ClickFrom.CUSTOM_CLOSE.ordinal());
                jADSplash.callbackAdCloseOnUiThread();
                jADSplash.destroy();
            }
        }
    }
}
