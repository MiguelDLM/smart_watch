package com.jd.ad.sdk.jad_qz;

import android.graphics.PointF;
import com.jd.ad.sdk.jad_js.jad_zm;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_na {
    public final List<com.jd.ad.sdk.jad_ox.jad_an> jad_an;
    public PointF jad_bo;
    public boolean jad_cp;

    public jad_na() {
        this.jad_an = new ArrayList();
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("ShapeData{numCurves=");
        jad_an.append(this.jad_an.size());
        jad_an.append("closed=");
        jad_an.append(this.jad_cp);
        jad_an.append('}');
        return jad_an.toString();
    }

    public jad_na(PointF pointF, boolean z, List<com.jd.ad.sdk.jad_ox.jad_an> list) {
        this.jad_bo = pointF;
        this.jad_cp = z;
        this.jad_an = new ArrayList(list);
    }
}
