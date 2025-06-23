package com.jd.ad.sdk.jad_tc;

import android.graphics.PointF;
import com.jd.ad.sdk.jad_ud.jad_cp;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_gr implements jad_mx<com.jd.ad.sdk.jad_qz.jad_na> {
    public static final jad_gr jad_an = new jad_gr();
    public static final jad_cp.jad_an jad_bo = jad_cp.jad_an.jad_an("c", t.c, "i", "o");

    @Override // com.jd.ad.sdk.jad_tc.jad_mx
    public com.jd.ad.sdk.jad_qz.jad_na jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, float f) {
        if (jad_cpVar.jad_mz() == 1) {
            jad_cpVar.jad_bo();
        }
        jad_cpVar.jad_cp();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jad_cpVar.jad_jt()) {
            int jad_an2 = jad_cpVar.jad_an(jad_bo);
            if (jad_an2 != 0) {
                if (jad_an2 != 1) {
                    if (jad_an2 != 2) {
                        if (jad_an2 != 3) {
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                        } else {
                            list3 = jad_sf.jad_bo(jad_cpVar, f);
                        }
                    } else {
                        list2 = jad_sf.jad_bo(jad_cpVar, f);
                    }
                } else {
                    list = jad_sf.jad_bo(jad_cpVar, f);
                }
            } else {
                z = jad_cpVar.jad_hu();
            }
        }
        jad_cpVar.jad_er();
        if (jad_cpVar.jad_mz() == 2) {
            jad_cpVar.jad_dq();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new com.jd.ad.sdk.jad_qz.jad_na(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new com.jd.ad.sdk.jad_ox.jad_an(com.jd.ad.sdk.jad_ve.jad_jt.jad_an(list.get(i2), list3.get(i2)), com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new com.jd.ad.sdk.jad_ox.jad_an(com.jd.ad.sdk.jad_ve.jad_jt.jad_an(list.get(i3), list3.get(i3)), com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF3, list2.get(0)), pointF3));
            }
            return new com.jd.ad.sdk.jad_qz.jad_na(pointF, z, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
