package com.jd.ad.sdk.jad_lu;

import android.graphics.Path;
import android.graphics.PathMeasure;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_bo {
    public final List<jad_sf> jad_an = new ArrayList();

    public void jad_an(Path path) {
        for (int size = this.jad_an.size() - 1; size >= 0; size--) {
            jad_sf jad_sfVar = this.jad_an.get(size);
            ThreadLocal<PathMeasure> threadLocal = com.jd.ad.sdk.jad_ve.jad_hu.jad_an;
            if (jad_sfVar != null && !jad_sfVar.jad_bo) {
                com.jd.ad.sdk.jad_ve.jad_hu.jad_an(path, ((com.jd.ad.sdk.jad_mv.jad_dq) jad_sfVar.jad_er).jad_hu() / 100.0f, ((com.jd.ad.sdk.jad_mv.jad_dq) jad_sfVar.jad_fs).jad_hu() / 100.0f, ((com.jd.ad.sdk.jad_mv.jad_dq) jad_sfVar.jad_jt).jad_hu() / 360.0f);
            }
        }
    }
}
