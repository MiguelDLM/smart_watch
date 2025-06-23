package com.jd.ad.sdk.jad_xg;

import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.jad_iv.jad_an;
import com.jd.ad.sdk.mdt.service.JADExposureService;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes10.dex */
public class jad_fs implements JADExposureService {
    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public ConcurrentHashMap<String, WeakReference<View>> getNativeExposureFeedShakeViewMap() {
        return jad_an.C0687jad_an.jad_an.jad_bo;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void registerExposureView(@NonNull String str) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = jad_an.C0687jad_an.jad_an;
        if (jad_anVar.jad_an.get(str) == null) {
            jad_anVar.jad_an.put(str, new com.jd.ad.sdk.jad_iv.jad_dq());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void registerNativeExposureFeedShakeView(@NonNull String str, @NonNull View view) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = jad_an.C0687jad_an.jad_an;
        jad_anVar.getClass();
        if (view != null && jad_anVar.jad_bo.get(str) == null) {
            jad_anVar.jad_bo.put(str, new WeakReference<>(view));
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void setViewExposureCallback(@NonNull String str, int i, @NonNull View view, @NonNull JADExposureListener jADExposureListener) {
        com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar = jad_an.C0687jad_an.jad_an.jad_an.get(str);
        if (jad_dqVar != null) {
            jad_dqVar.jad_fs = new WeakReference<>(str);
            jad_dqVar.jad_cp = jADExposureListener;
            jad_dqVar.jad_dq = i;
            jad_dqVar.jad_an = new WeakReference<>(view);
            View jad_bo = jad_dqVar.jad_bo();
            if (jad_bo != null) {
                jad_dqVar.jad_bo = new com.jd.ad.sdk.jad_iv.jad_er(Looper.getMainLooper(), jad_dqVar);
                if (ViewCompat.isAttachedToWindow(jad_bo)) {
                    jad_dqVar.jad_bo.sendEmptyMessage(1);
                    jad_bo.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_iv.jad_bo(jad_dqVar, jad_bo));
                } else {
                    jad_bo.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_iv.jad_cp(jad_dqVar, jad_bo));
                }
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void setViewForceExposure(@NonNull String str) {
        com.jd.ad.sdk.jad_wj.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar = jad_an.C0687jad_an.jad_an.jad_an.get(str);
        if (jad_dqVar != null && (jad_boVar = jad_dqVar.jad_er) != null && !jad_boVar.jad_cp) {
            jad_dqVar.jad_an(true, CommonConstants.ExposureType.EXPOSURE_FORCE.getIndex());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void unregisterExposureView(@NonNull String str) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = jad_an.C0687jad_an.jad_an;
        if (jad_anVar.jad_an.get(str) != null) {
            com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar = jad_anVar.jad_an.get(str);
            jad_dqVar.jad_cp = null;
            com.jd.ad.sdk.jad_iv.jad_er jad_erVar = jad_dqVar.jad_bo;
            if (jad_erVar != null) {
                jad_erVar.removeCallbacksAndMessages(null);
                jad_dqVar.jad_bo = null;
            }
            jad_anVar.jad_an.remove(str);
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void unregisterNativeExposureFeedShakeView(@NonNull String str) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = jad_an.C0687jad_an.jad_an;
        if (jad_anVar.jad_bo.get(str) != null) {
            jad_anVar.jad_bo.remove(str);
        }
    }
}
