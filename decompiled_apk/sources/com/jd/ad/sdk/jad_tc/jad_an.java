package com.jd.ad.sdk.jad_tc;

import android.graphics.PointF;
import com.jd.ad.sdk.jad_ud.jad_cp;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class jad_an {
    public static final jad_cp.jad_an jad_an = jad_cp.jad_an.jad_an(t.f18411a, "x", "y");

    public static com.jd.ad.sdk.jad_py.jad_er jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (jad_cpVar.jad_mz() == 1) {
            jad_cpVar.jad_bo();
            while (jad_cpVar.jad_jt()) {
                if (jad_cpVar.jad_mz() == 3) {
                    z = true;
                } else {
                    z = false;
                }
                arrayList.add(new com.jd.ad.sdk.jad_mv.jad_iv(jad_jtVar, jad_tg.jad_an(jad_cpVar, jad_jtVar, com.jd.ad.sdk.jad_ve.jad_hu.jad_an(), jad_yl.jad_an, z, false)));
            }
            jad_cpVar.jad_dq();
            jad_uh.jad_an(arrayList);
        } else {
            arrayList.add(new com.jd.ad.sdk.jad_wf.jad_an(jad_sf.jad_an(jad_cpVar, com.jd.ad.sdk.jad_ve.jad_hu.jad_an())));
        }
        return new com.jd.ad.sdk.jad_py.jad_er(arrayList);
    }

    public static com.jd.ad.sdk.jad_py.jad_mz<PointF, PointF> jad_bo(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
        jad_cpVar.jad_cp();
        com.jd.ad.sdk.jad_py.jad_er jad_erVar = null;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar = null;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar2 = null;
        boolean z = false;
        while (jad_cpVar.jad_mz() != 4) {
            int jad_an2 = jad_cpVar.jad_an(jad_an);
            if (jad_an2 != 0) {
                if (jad_an2 != 1) {
                    if (jad_an2 != 2) {
                        jad_cpVar.jad_na();
                        jad_cpVar.jad_ob();
                    } else if (jad_cpVar.jad_mz() != 6) {
                        jad_boVar2 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                    } else {
                        jad_cpVar.jad_ob();
                        z = true;
                    }
                } else if (jad_cpVar.jad_mz() == 6) {
                    jad_cpVar.jad_ob();
                    z = true;
                } else {
                    jad_boVar = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                }
            } else {
                jad_erVar = jad_an(jad_cpVar, jad_jtVar);
            }
        }
        jad_cpVar.jad_er();
        if (z) {
            jad_jtVar.jad_an("Lottie doesn't support expressions.");
        }
        if (jad_erVar != null) {
            return jad_erVar;
        }
        return new com.jd.ad.sdk.jad_py.jad_iv(jad_boVar, jad_boVar2);
    }
}
