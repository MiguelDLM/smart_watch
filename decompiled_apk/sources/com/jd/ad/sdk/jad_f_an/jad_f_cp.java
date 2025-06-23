package com.jd.ad.sdk.jad_f_an;

import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;

/* loaded from: classes10.dex */
public class jad_f_cp implements JADExposureListener {
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_an jad_f_an;

    public jad_f_cp(com.jd.ad.sdk.feed.jad_f_an jad_f_anVar) {
        this.jad_f_an = jad_f_anVar;
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onDelayExposure(long j, String str, int i) {
        JADSlot jADSlot = this.jad_f_an.jad_f_bo;
        if (jADSlot != null) {
            jADSlot.setImm(i);
        }
        com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.jad_f_an;
        jad_f_anVar.jad_f_an(jad_f_anVar.jad_f_iv, true, str, i);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onExposure(String str) {
        JADSlot jADSlot = this.jad_f_an.jad_f_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
        }
        com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.jad_f_an;
        jad_f_anVar.jad_f_an(jad_f_anVar.jad_f_iv, false, str, CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onFinishExposure() {
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onPreExposure(String str) {
        JADSlot jADSlot = this.jad_f_an.jad_f_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
        }
        com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.jad_f_an;
        jad_f_anVar.jad_f_an(jad_f_anVar.jad_f_iv, false, str, CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
    }
}
