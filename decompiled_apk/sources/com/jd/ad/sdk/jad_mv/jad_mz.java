package com.jd.ad.sdk.jad_mv;

import android.graphics.Path;
import android.graphics.PointF;
import com.jd.ad.sdk.jad_js.jad_zm;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_mz extends jad_an<com.jd.ad.sdk.jad_qz.jad_na, Path> {
    public final com.jd.ad.sdk.jad_qz.jad_na jad_iv;
    public final Path jad_jw;

    public jad_mz(List<com.jd.ad.sdk.jad_wf.jad_an<com.jd.ad.sdk.jad_qz.jad_na>> list) {
        super(list);
        this.jad_iv = new com.jd.ad.sdk.jad_qz.jad_na();
        this.jad_jw = new Path();
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public Path jad_an(com.jd.ad.sdk.jad_wf.jad_an<com.jd.ad.sdk.jad_qz.jad_na> jad_anVar, float f) {
        boolean z;
        com.jd.ad.sdk.jad_qz.jad_na jad_naVar = jad_anVar.jad_bo;
        com.jd.ad.sdk.jad_qz.jad_na jad_naVar2 = jad_anVar.jad_cp;
        com.jd.ad.sdk.jad_qz.jad_na jad_naVar3 = this.jad_iv;
        if (jad_naVar3.jad_bo == null) {
            jad_naVar3.jad_bo = new PointF();
        }
        if (!jad_naVar.jad_cp && !jad_naVar2.jad_cp) {
            z = false;
        } else {
            z = true;
        }
        jad_naVar3.jad_cp = z;
        if (jad_naVar.jad_an.size() != jad_naVar2.jad_an.size()) {
            StringBuilder jad_an = jad_zm.jad_an("Curves must have the same number of control points. Shape 1: ");
            jad_an.append(jad_naVar.jad_an.size());
            jad_an.append("\tShape 2: ");
            jad_an.append(jad_naVar2.jad_an.size());
            com.jd.ad.sdk.jad_ve.jad_dq.jad_an(jad_an.toString());
        }
        int min = Math.min(jad_naVar.jad_an.size(), jad_naVar2.jad_an.size());
        if (jad_naVar3.jad_an.size() < min) {
            for (int size = jad_naVar3.jad_an.size(); size < min; size++) {
                jad_naVar3.jad_an.add(new com.jd.ad.sdk.jad_ox.jad_an());
            }
        } else if (jad_naVar3.jad_an.size() > min) {
            for (int size2 = jad_naVar3.jad_an.size() - 1; size2 >= min; size2--) {
                List<com.jd.ad.sdk.jad_ox.jad_an> list = jad_naVar3.jad_an;
                list.remove(list.size() - 1);
            }
        }
        PointF pointF = jad_naVar.jad_bo;
        PointF pointF2 = jad_naVar2.jad_bo;
        float jad_an2 = com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF.x, pointF2.x, f);
        float jad_an3 = com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF.y, pointF2.y, f);
        if (jad_naVar3.jad_bo == null) {
            jad_naVar3.jad_bo = new PointF();
        }
        jad_naVar3.jad_bo.set(jad_an2, jad_an3);
        for (int size3 = jad_naVar3.jad_an.size() - 1; size3 >= 0; size3--) {
            com.jd.ad.sdk.jad_ox.jad_an jad_anVar2 = jad_naVar.jad_an.get(size3);
            com.jd.ad.sdk.jad_ox.jad_an jad_anVar3 = jad_naVar2.jad_an.get(size3);
            PointF pointF3 = jad_anVar2.jad_an;
            PointF pointF4 = jad_anVar2.jad_bo;
            PointF pointF5 = jad_anVar2.jad_cp;
            PointF pointF6 = jad_anVar3.jad_an;
            PointF pointF7 = jad_anVar3.jad_bo;
            PointF pointF8 = jad_anVar3.jad_cp;
            jad_naVar3.jad_an.get(size3).jad_an.set(com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF3.x, pointF6.x, f), com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF3.y, pointF6.y, f));
            jad_naVar3.jad_an.get(size3).jad_bo.set(com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF4.x, pointF7.x, f), com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF4.y, pointF7.y, f));
            jad_naVar3.jad_an.get(size3).jad_cp.set(com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF5.x, pointF8.x, f), com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF5.y, pointF8.y, f));
        }
        com.jd.ad.sdk.jad_qz.jad_na jad_naVar4 = this.jad_iv;
        Path path = this.jad_jw;
        path.reset();
        PointF pointF9 = jad_naVar4.jad_bo;
        path.moveTo(pointF9.x, pointF9.y);
        com.jd.ad.sdk.jad_ve.jad_jt.jad_an.set(pointF9.x, pointF9.y);
        for (int i = 0; i < jad_naVar4.jad_an.size(); i++) {
            com.jd.ad.sdk.jad_ox.jad_an jad_anVar4 = jad_naVar4.jad_an.get(i);
            PointF pointF10 = jad_anVar4.jad_an;
            PointF pointF11 = jad_anVar4.jad_bo;
            PointF pointF12 = jad_anVar4.jad_cp;
            PointF pointF13 = com.jd.ad.sdk.jad_ve.jad_jt.jad_an;
            if (pointF10.equals(pointF13) && pointF11.equals(pointF12)) {
                path.lineTo(pointF12.x, pointF12.y);
            } else {
                path.cubicTo(pointF10.x, pointF10.y, pointF11.x, pointF11.y, pointF12.x, pointF12.y);
            }
            pointF13.set(pointF12.x, pointF12.y);
        }
        if (jad_naVar4.jad_cp) {
            path.close();
        }
        return this.jad_jw;
    }
}
