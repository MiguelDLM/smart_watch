package com.jd.ad.sdk.jad_s_an;

import android.view.View;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.splash.JADSplashSkipView;

/* loaded from: classes10.dex */
public class jad_s_an implements JADExposureListener {
    public final /* synthetic */ int jad_s_an;
    public final /* synthetic */ View jad_s_bo;
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_bo jad_s_cp;

    /* renamed from: com.jd.ad.sdk.jad_s_an.jad_s_an$jad_s_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0714jad_s_an implements IDynamicCountdownListener {
        public C0714jad_s_an() {
        }

        @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener
        public void onAdCountdown(int i) {
            com.jd.ad.sdk.splash.jad_s_bo.jad_s_an(jad_s_an.this.jad_s_cp, i);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_s_bo implements Runnable {
        public jad_s_bo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplashSkipView jADSplashSkipView;
            com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar = jad_s_an.this.jad_s_cp;
            View view = jad_s_boVar.jad_s_jt;
            if (view != null && (jADSplashSkipView = (JADSplashSkipView) view.findViewById(ResourceUtils.getResourceId(jad_s_boVar.jad_s_bo(), "jad_splash_skip_btn", "id"))) != null) {
                HandlerUtils.runOnUiThread(new jad_s_er(jad_s_boVar, jADSplashSkipView));
            }
        }
    }

    public jad_s_an(com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar, int i, View view) {
        this.jad_s_cp = jad_s_boVar;
        this.jad_s_an = i;
        this.jad_s_bo = view;
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onDelayExposure(long j, String str, int i) {
        JADSlot jADSlot = this.jad_s_cp.jad_s_bo;
        if (jADSlot != null) {
            jADSlot.setImm(i);
        }
        com.jd.ad.sdk.splash.jad_s_bo.jad_s_an(this.jad_s_cp, this.jad_s_bo, true, str, i, this.jad_s_an);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onExposure(String str) {
        JADSlot jADSlot = this.jad_s_cp.jad_s_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
        }
        com.jd.ad.sdk.splash.jad_s_bo.jad_s_an(this.jad_s_cp, this.jad_s_bo, false, str, CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex(), this.jad_s_an);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onFinishExposure() {
        JADSplashSkipView jADSplashSkipView;
        if (this.jad_s_an == 1 && (jADSplashSkipView = this.jad_s_cp.jad_s_kx) != null) {
            jADSplashSkipView.removeCallbacks(null);
        }
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onPreExposure(String str) {
        int i = this.jad_s_an;
        if (i == 3) {
            View view = this.jad_s_bo;
            if (view != null && (view instanceof DynamicRenderView)) {
                ((DynamicRenderView) view).play();
                if (this.jad_s_cp.jad_s_ly != null) {
                    ((DynamicRenderView) this.jad_s_bo).startCount(new C0714jad_s_an());
                }
            }
        } else if (i == 1) {
            WorkExecutor.execute(new jad_s_bo());
        }
        JADSlot jADSlot = this.jad_s_cp.jad_s_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
        }
        com.jd.ad.sdk.splash.jad_s_bo.jad_s_an(this.jad_s_cp, this.jad_s_bo, false, str, CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex(), this.jad_s_an);
    }
}
