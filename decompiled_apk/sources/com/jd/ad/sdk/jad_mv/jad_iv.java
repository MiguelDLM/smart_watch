package com.jd.ad.sdk.jad_mv;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* loaded from: classes10.dex */
public class jad_iv extends com.jd.ad.sdk.jad_wf.jad_an<PointF> {

    @Nullable
    public Path jad_qd;
    public final com.jd.ad.sdk.jad_wf.jad_an<PointF> jad_re;

    public jad_iv(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar, com.jd.ad.sdk.jad_wf.jad_an<PointF> jad_anVar) {
        super(jad_jtVar, jad_anVar.jad_bo, jad_anVar.jad_cp, jad_anVar.jad_dq, jad_anVar.jad_er, jad_anVar.jad_fs, jad_anVar.jad_jt, jad_anVar.jad_hu);
        this.jad_re = jad_anVar;
        jad_dq();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void jad_dq() {
        boolean z;
        T t;
        T t2;
        T t3;
        T t4 = this.jad_cp;
        if (t4 != 0 && (t3 = this.jad_bo) != 0) {
            PointF pointF = (PointF) t4;
            if (((PointF) t3).equals(pointF.x, pointF.y)) {
                z = true;
                t = this.jad_bo;
                if (t == 0 && (t2 = this.jad_cp) != 0 && !z) {
                    PointF pointF2 = (PointF) t;
                    PointF pointF3 = (PointF) t2;
                    com.jd.ad.sdk.jad_wf.jad_an<PointF> jad_anVar = this.jad_re;
                    PointF pointF4 = jad_anVar.jad_ob;
                    PointF pointF5 = jad_anVar.jad_pc;
                    ThreadLocal<PathMeasure> threadLocal = com.jd.ad.sdk.jad_ve.jad_hu.jad_an;
                    Path path = new Path();
                    path.moveTo(pointF2.x, pointF2.y);
                    if (pointF4 != null && pointF5 != null && (pointF4.length() != 0.0f || pointF5.length() != 0.0f)) {
                        float f = pointF4.x + pointF2.x;
                        float f2 = pointF2.y + pointF4.y;
                        float f3 = pointF3.x;
                        float f4 = f3 + pointF5.x;
                        float f5 = pointF3.y;
                        path.cubicTo(f, f2, f4, f5 + pointF5.y, f3, f5);
                    } else {
                        path.lineTo(pointF3.x, pointF3.y);
                    }
                    this.jad_qd = path;
                    return;
                }
                return;
            }
        }
        z = false;
        t = this.jad_bo;
        if (t == 0) {
        }
    }
}
