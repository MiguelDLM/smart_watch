package com.jd.ad.sdk.jad_pc;

import com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig;
import com.jd.ad.sdk.jad_ob.jad_hu;
import com.jd.ad.sdk.jad_sf.jad_an;
import com.jd.ad.sdk.jad_sf.jad_bo;
import com.jd.ad.sdk.jad_sf.jad_dq;
import com.jd.ad.sdk.jad_vi.jad_fs;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_bo implements Runnable {
    public final /* synthetic */ JADYunSdkConfig jad_an;

    public jad_bo(JADYunSdkConfig jADYunSdkConfig) {
        this.jad_an = jADYunSdkConfig;
    }

    @Override // java.lang.Runnable
    public void run() {
        jad_an.jad_bo.jad_an.getClass();
        com.jd.ad.sdk.jad_sf.jad_bo jad_boVar = jad_bo.jad_an.jad_an;
        jad_boVar.getClass();
        if (jad_hu.jad_dq(com.jd.ad.sdk.jad_do.jad_bo.jad_an())) {
            jad_boVar.jad_cp = jad_dq.jad_an("jadyunsdk");
            jad_boVar.jad_bo.readLock().lock();
            try {
                Map<String, ?> all = jad_boVar.jad_cp.jad_an.getAll();
                if (all != null && !all.isEmpty()) {
                    jad_boVar.jad_an.putAll(all);
                }
            } catch (Exception e) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_LOAD_DISC_TO_MEMORY_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            } finally {
                jad_boVar.jad_bo.readLock().unlock();
            }
        }
        jad_an.jad_bo.jad_an.jad_an("AppId", this.jad_an.getAppId());
    }
}
