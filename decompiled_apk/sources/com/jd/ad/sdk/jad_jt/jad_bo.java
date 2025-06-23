package com.jd.ad.sdk.jad_jt;

import android.text.TextUtils;
import android.util.Log;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.jad_kx.jad_er;
import com.jd.ad.sdk.logger.Logger;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_bo implements Runnable {
    public final /* synthetic */ JADSlot jad_an;
    public final /* synthetic */ String jad_bo;
    public final /* synthetic */ JADAdLoadListener jad_cp;
    public final /* synthetic */ jad_jt jad_dq;

    /* loaded from: classes10.dex */
    public class jad_an implements Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_bo jad_boVar = jad_bo.this;
            JADAdLoadListener jADAdLoadListener = jad_boVar.jad_cp;
            if (jADAdLoadListener == null) {
                return;
            }
            jad_jt.jad_an(jad_boVar.jad_dq, jADAdLoadListener, jad_boVar.jad_an.getAdDataRequestSourceType());
        }
    }

    public jad_bo(jad_jt jad_jtVar, JADSlot jADSlot, String str, JADAdLoadListener jADAdLoadListener) {
        this.jad_dq = jad_jtVar;
        this.jad_an = jADSlot;
        this.jad_bo = str;
        this.jad_cp = jADAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<com.jd.ad.sdk.jad_wj.jad_dq> list;
        com.jd.ad.sdk.jad_wj.jad_dq jad_dqVar;
        com.jd.ad.sdk.jad_wj.jad_cp jad_cpVar;
        try {
            jad_jt.jad_an(this.jad_dq, this.jad_an);
            String jad_an2 = jad_er.jad_an.jad_an.jad_an(JADYunSdk.getAppId() + this.jad_an.getSlotID());
            if (TextUtils.isEmpty(jad_an2)) {
                return;
            }
            jad_jt.jad_bo(this.jad_dq, this.jad_an);
            if (this.jad_an.getDynamicRenderTemplateHelper() != null) {
                this.jad_an.getDynamicRenderTemplateHelper().jad_an(jad_an2);
            }
            com.jd.ad.sdk.jad_wj.jad_jt jad_an3 = com.jd.ad.sdk.jad_wj.jad_jt.jad_an(jad_an2);
            com.jd.ad.sdk.jad_wj.jad_hu jad_huVar = jad_an3.jad_cp;
            if (jad_huVar != null && (list = jad_huVar.jad_an) != null && list.size() > 0 && (jad_dqVar = jad_an3.jad_cp.jad_an.get(0)) != null && (jad_cpVar = jad_dqVar.jad_bo) != null) {
                this.jad_an.setTemplateId(jad_cpVar.jad_dq);
                this.jad_an.setMediaSpecSetType(jad_dqVar.jad_bo.jad_cp);
                this.jad_an.setEventInteractionType(jad_dqVar.jad_bo.jad_er);
                this.jad_an.setModelClickAreaType(jad_dqVar.jad_bo.jad_fs);
            }
            jad_jt.jad_an(this.jad_dq, this.jad_bo, jad_an2);
            HandlerUtils.runOnUiThread(new jad_an());
        } catch (Exception e) {
            StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while preload ad load from cache failed:");
            jad_an4.append(Log.getStackTraceString(e));
            Logger.d(jad_an4.toString());
        }
    }
}
