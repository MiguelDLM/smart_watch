package com.jd.ad.sdk.jad_wf;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_js.jad_jt;
import com.jd.ad.sdk.jad_js.jad_zm;
import xoXoI.oIX0oI;

/* loaded from: classes10.dex */
public class jad_an<T> {

    @Nullable
    public final jad_jt jad_an;

    @Nullable
    public final T jad_bo;

    @Nullable
    public T jad_cp;

    @Nullable
    public final Interpolator jad_dq;

    @Nullable
    public final Interpolator jad_er;

    @Nullable
    public final Interpolator jad_fs;

    @Nullable
    public Float jad_hu;
    public float jad_iv;
    public final float jad_jt;
    public float jad_jw;
    public int jad_kx;
    public int jad_ly;
    public float jad_mz;
    public float jad_na;
    public PointF jad_ob;
    public PointF jad_pc;

    public jad_an(jad_jt jad_jtVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.jad_iv = -3987645.8f;
        this.jad_jw = -3987645.8f;
        this.jad_kx = oIX0oI.f35162IXxxXO;
        this.jad_ly = oIX0oI.f35162IXxxXO;
        this.jad_mz = Float.MIN_VALUE;
        this.jad_na = Float.MIN_VALUE;
        this.jad_ob = null;
        this.jad_pc = null;
        this.jad_an = jad_jtVar;
        this.jad_bo = t;
        this.jad_cp = t2;
        this.jad_dq = interpolator;
        this.jad_er = null;
        this.jad_fs = null;
        this.jad_jt = f;
        this.jad_hu = f2;
    }

    public float jad_an() {
        float f = 1.0f;
        if (this.jad_an == null) {
            return 1.0f;
        }
        if (this.jad_na == Float.MIN_VALUE) {
            if (this.jad_hu != null) {
                f = ((this.jad_hu.floatValue() - this.jad_jt) / this.jad_an.jad_bo()) + jad_bo();
            }
            this.jad_na = f;
        }
        return this.jad_na;
    }

    public float jad_bo() {
        jad_jt jad_jtVar = this.jad_an;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        if (this.jad_mz == Float.MIN_VALUE) {
            this.jad_mz = (this.jad_jt - jad_jtVar.jad_kx) / jad_jtVar.jad_bo();
        }
        return this.jad_mz;
    }

    public boolean jad_cp() {
        return this.jad_dq == null && this.jad_er == null && this.jad_fs == null;
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("Keyframe{startValue=");
        jad_an.append(this.jad_bo);
        jad_an.append(", endValue=");
        jad_an.append(this.jad_cp);
        jad_an.append(", startFrame=");
        jad_an.append(this.jad_jt);
        jad_an.append(", endFrame=");
        jad_an.append(this.jad_hu);
        jad_an.append(", interpolator=");
        jad_an.append(this.jad_dq);
        jad_an.append('}');
        return jad_an.toString();
    }

    public jad_an(jad_jt jad_jtVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f, @Nullable Float f2) {
        this.jad_iv = -3987645.8f;
        this.jad_jw = -3987645.8f;
        this.jad_kx = oIX0oI.f35162IXxxXO;
        this.jad_ly = oIX0oI.f35162IXxxXO;
        this.jad_mz = Float.MIN_VALUE;
        this.jad_na = Float.MIN_VALUE;
        this.jad_ob = null;
        this.jad_pc = null;
        this.jad_an = jad_jtVar;
        this.jad_bo = t;
        this.jad_cp = t2;
        this.jad_dq = null;
        this.jad_er = interpolator;
        this.jad_fs = interpolator2;
        this.jad_jt = f;
        this.jad_hu = null;
    }

    public jad_an(jad_jt jad_jtVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f, @Nullable Float f2) {
        this.jad_iv = -3987645.8f;
        this.jad_jw = -3987645.8f;
        this.jad_kx = oIX0oI.f35162IXxxXO;
        this.jad_ly = oIX0oI.f35162IXxxXO;
        this.jad_mz = Float.MIN_VALUE;
        this.jad_na = Float.MIN_VALUE;
        this.jad_ob = null;
        this.jad_pc = null;
        this.jad_an = jad_jtVar;
        this.jad_bo = t;
        this.jad_cp = t2;
        this.jad_dq = interpolator;
        this.jad_er = interpolator2;
        this.jad_fs = interpolator3;
        this.jad_jt = f;
        this.jad_hu = f2;
    }

    public jad_an(T t) {
        this.jad_iv = -3987645.8f;
        this.jad_jw = -3987645.8f;
        this.jad_kx = oIX0oI.f35162IXxxXO;
        this.jad_ly = oIX0oI.f35162IXxxXO;
        this.jad_mz = Float.MIN_VALUE;
        this.jad_na = Float.MIN_VALUE;
        this.jad_ob = null;
        this.jad_pc = null;
        this.jad_an = null;
        this.jad_bo = t;
        this.jad_cp = t;
        this.jad_dq = null;
        this.jad_er = null;
        this.jad_fs = null;
        this.jad_jt = Float.MIN_VALUE;
        this.jad_hu = Float.valueOf(Float.MAX_VALUE);
    }
}
