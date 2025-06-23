package com.jd.ad.sdk.mdt.servicemediator;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_xg.jad_dq;
import com.jd.ad.sdk.jad_xg.jad_er;
import com.jd.ad.sdk.jad_xg.jad_fs;
import com.jd.ad.sdk.jad_xg.jad_hu;
import com.jd.ad.sdk.jad_xg.jad_iv;
import com.jd.ad.sdk.jad_xg.jad_jt;
import com.jd.ad.sdk.mdt.service.JADAdService;
import com.jd.ad.sdk.mdt.service.JADDynamicRenderService;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.service.JADExposureService;
import com.jd.ad.sdk.mdt.service.JADFoundationService;
import com.jd.ad.sdk.mdt.service.JADInitService;
import com.jd.ad.sdk.mdt.service.JADTouchService;

/* loaded from: classes10.dex */
public class JADMediator {
    private com.jd.ad.sdk.jad_yh.jad_an mMediatorService;

    /* loaded from: classes10.dex */
    public static class jad_bo {
        public static final JADMediator jad_an = new JADMediator();
    }

    public static JADMediator getInstance() {
        return jad_bo.jad_an;
    }

    @NonNull
    public JADAdService getAdService() {
        com.jd.ad.sdk.jad_yh.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_bo == null) {
            jad_anVar.jad_bo = new com.jd.ad.sdk.jad_xg.jad_an();
        }
        return jad_anVar.jad_bo;
    }

    @NonNull
    public JADDynamicRenderService getDynamicRenderService() {
        com.jd.ad.sdk.jad_yh.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_jt == null) {
            jad_anVar.jad_jt = new jad_dq();
        }
        return jad_anVar.jad_jt;
    }

    @NonNull
    public JADEventService getEventService() {
        com.jd.ad.sdk.jad_yh.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_cp == null) {
            jad_anVar.jad_cp = new jad_er();
        }
        return jad_anVar.jad_cp;
    }

    @NonNull
    public JADExposureService getExposureService() {
        com.jd.ad.sdk.jad_yh.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_dq == null) {
            jad_anVar.jad_dq = new jad_fs();
        }
        return jad_anVar.jad_dq;
    }

    @NonNull
    public JADFoundationService getFoundationService() {
        com.jd.ad.sdk.jad_yh.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_er == null) {
            jad_anVar.jad_er = new jad_jt();
        }
        return jad_anVar.jad_er;
    }

    @NonNull
    public JADInitService getInitService() {
        com.jd.ad.sdk.jad_yh.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_an == null) {
            jad_anVar.jad_an = new jad_hu();
        }
        return jad_anVar.jad_an;
    }

    @NonNull
    public JADTouchService getTouchService() {
        com.jd.ad.sdk.jad_yh.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_fs == null) {
            jad_anVar.jad_fs = new jad_iv();
        }
        return jad_anVar.jad_fs;
    }

    private JADMediator() {
        if (this.mMediatorService == null) {
            this.mMediatorService = new com.jd.ad.sdk.jad_yh.jad_an();
        }
    }
}
