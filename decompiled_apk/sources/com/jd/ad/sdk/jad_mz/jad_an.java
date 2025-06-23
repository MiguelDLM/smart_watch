package com.jd.ad.sdk.jad_mz;

import android.text.TextUtils;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.jad_sf.jad_an;

/* loaded from: classes10.dex */
public class jad_an {
    public static long jad_an() {
        Object jad_an;
        long j;
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        Class cls = Long.TYPE;
        jad_anVar.getClass();
        if (TextUtils.isEmpty("cat")) {
            jad_an = null;
        } else {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("cat");
            jad_an2.append(JADYunSdk.getAppId());
            jad_an = jad_anVar.jad_an(jad_an2.toString(), (Class<Object>) cls);
        }
        if (jad_an != null && (jad_an instanceof Long)) {
            j = ((Long) jad_an).longValue();
        } else {
            j = 0;
        }
        if (!com.jd.ad.sdk.jad_pc.jad_an.jad_bo()) {
            return 0L;
        }
        return j;
    }
}
