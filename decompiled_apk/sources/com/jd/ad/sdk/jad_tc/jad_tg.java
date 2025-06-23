package com.jd.ad.sdk.jad_tc;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.jd.ad.sdk.jad_ud.jad_cp;
import com.kwad.sdk.m.e;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class jad_tg {
    public static SparseArrayCompat<WeakReference<Interpolator>> jad_bo;
    public static final Interpolator jad_an = new LinearInterpolator();
    public static jad_cp.jad_an jad_cp = jad_cp.jad_an.jad_an("t", "s", e.TAG, "o", "i", IAdInterListener.AdReqParam.HEIGHT, "to", "ti");
    public static jad_cp.jad_an jad_dq = jad_cp.jad_an.jad_an("x", "y");

    public static Interpolator jad_an(PointF pointF, PointF pointF2) {
        WeakReference<Interpolator> weakReference;
        Interpolator create;
        float f = pointF.x;
        PointF pointF3 = com.jd.ad.sdk.jad_ve.jad_jt.jad_an;
        pointF.x = Math.max(-1.0f, Math.min(1.0f, f));
        pointF.y = Math.max(-100.0f, Math.min(100.0f, pointF.y));
        pointF2.x = Math.max(-1.0f, Math.min(1.0f, pointF2.x));
        float max = Math.max(-100.0f, Math.min(100.0f, pointF2.y));
        pointF2.y = max;
        float f2 = pointF.x;
        float f3 = pointF.y;
        float f4 = pointF2.x;
        ThreadLocal<PathMeasure> threadLocal = com.jd.ad.sdk.jad_ve.jad_hu.jad_an;
        int i = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        if (f4 != 0.0f) {
            i = (int) (i * 31 * f4);
        }
        if (max != 0.0f) {
            i = (int) (i * 31 * max);
        }
        synchronized (jad_tg.class) {
            try {
                if (jad_bo == null) {
                    jad_bo = new SparseArrayCompat<>();
                }
                weakReference = jad_bo.get(i);
            } finally {
            }
        }
        Interpolator interpolator = weakReference != null ? weakReference.get() : null;
        if (weakReference == null || interpolator == null) {
            try {
                create = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                create = "The Path cannot loop back on itself.".equals(e.getMessage()) ? PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = create;
            try {
                WeakReference<Interpolator> weakReference2 = new WeakReference<>(interpolator);
                synchronized (jad_tg.class) {
                    jad_bo.put(i, weakReference2);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    public static <T> com.jd.ad.sdk.jad_wf.jad_an<T> jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, com.jd.ad.sdk.jad_js.jad_jt jad_jtVar, float f, jad_mx<T> jad_mxVar, boolean z, boolean z2) {
        Interpolator jad_an2;
        T t;
        Interpolator interpolator;
        Interpolator jad_an3;
        Interpolator jad_an4;
        T t2;
        PointF pointF;
        T t3;
        float f2;
        float f3;
        if (!z || !z2) {
            if (z) {
                jad_cpVar.jad_cp();
                PointF pointF2 = null;
                PointF pointF3 = null;
                PointF pointF4 = null;
                boolean z3 = false;
                T t4 = null;
                float f4 = 0.0f;
                PointF pointF5 = null;
                T t5 = null;
                while (jad_cpVar.jad_jt()) {
                    switch (jad_cpVar.jad_an(jad_cp)) {
                        case 0:
                            f4 = (float) jad_cpVar.jad_iv();
                            break;
                        case 1:
                            t4 = jad_mxVar.jad_an(jad_cpVar, f);
                            break;
                        case 2:
                            t5 = jad_mxVar.jad_an(jad_cpVar, f);
                            break;
                        case 3:
                            pointF2 = jad_sf.jad_an(jad_cpVar, 1.0f);
                            break;
                        case 4:
                            pointF3 = jad_sf.jad_an(jad_cpVar, 1.0f);
                            break;
                        case 5:
                            if (jad_cpVar.jad_jw() != 1) {
                                z3 = false;
                                break;
                            } else {
                                z3 = true;
                                break;
                            }
                        case 6:
                            pointF4 = jad_sf.jad_an(jad_cpVar, f);
                            break;
                        case 7:
                            pointF5 = jad_sf.jad_an(jad_cpVar, f);
                            break;
                        default:
                            jad_cpVar.jad_ob();
                            break;
                    }
                }
                jad_cpVar.jad_er();
                if (z3) {
                    jad_an2 = jad_an;
                    t = t4;
                } else {
                    jad_an2 = (pointF2 == null || pointF3 == null) ? jad_an : jad_an(pointF2, pointF3);
                    t = t5;
                }
                com.jd.ad.sdk.jad_wf.jad_an<T> jad_anVar = new com.jd.ad.sdk.jad_wf.jad_an<>(jad_jtVar, t4, t, jad_an2, f4, null);
                jad_anVar.jad_ob = pointF4;
                jad_anVar.jad_pc = pointF5;
                return jad_anVar;
            }
            return new com.jd.ad.sdk.jad_wf.jad_an<>(jad_mxVar.jad_an(jad_cpVar, f));
        }
        jad_cpVar.jad_cp();
        PointF pointF6 = null;
        PointF pointF7 = null;
        boolean z4 = false;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        T t6 = null;
        PointF pointF11 = null;
        PointF pointF12 = null;
        PointF pointF13 = null;
        float f5 = 0.0f;
        T t7 = null;
        while (jad_cpVar.jad_jt()) {
            switch (jad_cpVar.jad_an(jad_cp)) {
                case 0:
                    pointF = pointF6;
                    f5 = (float) jad_cpVar.jad_iv();
                    break;
                case 1:
                    t6 = jad_mxVar.jad_an(jad_cpVar, f);
                    continue;
                case 2:
                    t7 = jad_mxVar.jad_an(jad_cpVar, f);
                    continue;
                case 3:
                    pointF = pointF6;
                    PointF pointF14 = pointF7;
                    if (jad_cpVar.jad_mz() == 3) {
                        jad_cpVar.jad_cp();
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        while (jad_cpVar.jad_jt()) {
                            int jad_an5 = jad_cpVar.jad_an(jad_dq);
                            if (jad_an5 == 0) {
                                t3 = t6;
                                if (jad_cpVar.jad_mz() == 7) {
                                    f8 = (float) jad_cpVar.jad_iv();
                                    t6 = t3;
                                    f6 = f8;
                                } else {
                                    jad_cpVar.jad_bo();
                                    f6 = (float) jad_cpVar.jad_iv();
                                    f8 = jad_cpVar.jad_mz() == 7 ? (float) jad_cpVar.jad_iv() : f6;
                                    jad_cpVar.jad_dq();
                                    t6 = t3;
                                }
                            } else if (jad_an5 != 1) {
                                jad_cpVar.jad_ob();
                            } else {
                                t3 = t6;
                                if (jad_cpVar.jad_mz() == 7) {
                                    f9 = (float) jad_cpVar.jad_iv();
                                    t6 = t3;
                                    f7 = f9;
                                } else {
                                    jad_cpVar.jad_bo();
                                    f7 = (float) jad_cpVar.jad_iv();
                                    f9 = jad_cpVar.jad_mz() == 7 ? (float) jad_cpVar.jad_iv() : f7;
                                    jad_cpVar.jad_dq();
                                    t6 = t3;
                                }
                            }
                        }
                        pointF10 = new PointF(f6, f7);
                        pointF11 = new PointF(f8, f9);
                        jad_cpVar.jad_er();
                    } else {
                        pointF8 = jad_sf.jad_an(jad_cpVar, f);
                    }
                    pointF7 = pointF14;
                    break;
                case 4:
                    if (jad_cpVar.jad_mz() != 3) {
                        pointF9 = jad_sf.jad_an(jad_cpVar, f);
                        break;
                    } else {
                        jad_cpVar.jad_cp();
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        float f12 = 0.0f;
                        float f13 = 0.0f;
                        while (jad_cpVar.jad_jt()) {
                            PointF pointF15 = pointF7;
                            int jad_an6 = jad_cpVar.jad_an(jad_dq);
                            PointF pointF16 = pointF6;
                            if (jad_an6 != 0) {
                                if (jad_an6 != 1) {
                                    jad_cpVar.jad_ob();
                                } else if (jad_cpVar.jad_mz() == 7) {
                                    f13 = (float) jad_cpVar.jad_iv();
                                    f11 = f13;
                                } else {
                                    jad_cpVar.jad_bo();
                                    float jad_iv = (float) jad_cpVar.jad_iv();
                                    if (jad_cpVar.jad_mz() == 7) {
                                        f3 = jad_iv;
                                        f13 = (float) jad_cpVar.jad_iv();
                                    } else {
                                        f3 = jad_iv;
                                        f13 = f3;
                                    }
                                    jad_cpVar.jad_dq();
                                    f11 = f3;
                                }
                            } else if (jad_cpVar.jad_mz() == 7) {
                                f12 = (float) jad_cpVar.jad_iv();
                                f10 = f12;
                            } else {
                                jad_cpVar.jad_bo();
                                float jad_iv2 = (float) jad_cpVar.jad_iv();
                                if (jad_cpVar.jad_mz() == 7) {
                                    f2 = jad_iv2;
                                    f12 = (float) jad_cpVar.jad_iv();
                                } else {
                                    f2 = jad_iv2;
                                    f12 = f2;
                                }
                                jad_cpVar.jad_dq();
                                f10 = f2;
                            }
                            pointF7 = pointF15;
                            pointF6 = pointF16;
                        }
                        pointF = pointF6;
                        PointF pointF17 = new PointF(f10, f11);
                        PointF pointF18 = new PointF(f12, f13);
                        jad_cpVar.jad_er();
                        pointF12 = pointF17;
                        pointF13 = pointF18;
                        break;
                    }
                case 5:
                    if (jad_cpVar.jad_jw() == 1) {
                        z4 = true;
                        break;
                    } else {
                        z4 = false;
                        continue;
                    }
                case 6:
                    pointF6 = jad_sf.jad_an(jad_cpVar, f);
                    continue;
                case 7:
                    pointF7 = jad_sf.jad_an(jad_cpVar, f);
                    continue;
                default:
                    jad_cpVar.jad_ob();
                    continue;
            }
            pointF6 = pointF;
        }
        PointF pointF19 = pointF6;
        PointF pointF20 = pointF7;
        T t8 = t6;
        jad_cpVar.jad_er();
        if (z4) {
            interpolator = jad_an;
            t2 = t8;
        } else {
            if (pointF8 != null && pointF9 != null) {
                interpolator = jad_an(pointF8, pointF9);
            } else {
                if (pointF10 != null && pointF11 != null && pointF12 != null && pointF13 != null) {
                    jad_an3 = jad_an(pointF10, pointF12);
                    jad_an4 = jad_an(pointF11, pointF13);
                    t2 = t7;
                    interpolator = null;
                    com.jd.ad.sdk.jad_wf.jad_an<T> jad_anVar2 = (jad_an3 != null || jad_an4 == null) ? new com.jd.ad.sdk.jad_wf.jad_an<>(jad_jtVar, t8, t2, interpolator, f5, null) : new com.jd.ad.sdk.jad_wf.jad_an<>(jad_jtVar, t8, t2, jad_an3, jad_an4, f5, null);
                    jad_anVar2.jad_ob = pointF19;
                    jad_anVar2.jad_pc = pointF20;
                    return jad_anVar2;
                }
                interpolator = jad_an;
            }
            t2 = t7;
        }
        jad_an3 = null;
        jad_an4 = null;
        if (jad_an3 != null) {
        }
        jad_anVar2.jad_ob = pointF19;
        jad_anVar2.jad_pc = pointF20;
        return jad_anVar2;
    }
}
