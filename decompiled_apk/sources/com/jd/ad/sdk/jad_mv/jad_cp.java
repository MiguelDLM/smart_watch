package com.jd.ad.sdk.jad_mv;

import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_mv.jad_an;

/* loaded from: classes10.dex */
public class jad_cp implements jad_an.InterfaceC0697jad_an {
    public final jad_an.InterfaceC0697jad_an jad_an;
    public final com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_bo;
    public final com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_cp;
    public final com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_dq;
    public final com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_er;
    public final com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_fs;
    public boolean jad_jt = true;

    /* loaded from: classes10.dex */
    public class jad_an extends com.jd.ad.sdk.jad_wf.jad_cp<Float> {
        public final /* synthetic */ com.jd.ad.sdk.jad_wf.jad_cp jad_cp;

        public jad_an(jad_cp jad_cpVar, com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar2) {
            this.jad_cp = jad_cpVar2;
        }

        @Override // com.jd.ad.sdk.jad_wf.jad_cp
        @Nullable
        public Float jad_an(com.jd.ad.sdk.jad_wf.jad_bo<Float> jad_boVar) {
            Float f = (Float) this.jad_cp.jad_an(jad_boVar);
            if (f == null) {
                return null;
            }
            return Float.valueOf(f.floatValue() * 2.55f);
        }
    }

    public jad_cp(jad_an.InterfaceC0697jad_an interfaceC0697jad_an, com.jd.ad.sdk.jad_ra.jad_an jad_anVar, com.jd.ad.sdk.jad_tc.jad_jw jad_jwVar) {
        this.jad_an = interfaceC0697jad_an;
        com.jd.ad.sdk.jad_mv.jad_an<Integer, Integer> jad_an2 = jad_jwVar.jad_an().jad_an();
        this.jad_bo = jad_an2;
        jad_an2.jad_an(this);
        jad_anVar.jad_an(jad_an2);
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an3 = jad_jwVar.jad_dq().jad_an();
        this.jad_cp = jad_an3;
        jad_an3.jad_an(this);
        jad_anVar.jad_an(jad_an3);
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an4 = jad_jwVar.jad_bo().jad_an();
        this.jad_dq = jad_an4;
        jad_an4.jad_an(this);
        jad_anVar.jad_an(jad_an4);
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an5 = jad_jwVar.jad_cp().jad_an();
        this.jad_er = jad_an5;
        jad_an5.jad_an(this);
        jad_anVar.jad_an(jad_an5);
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an6 = jad_jwVar.jad_er().jad_an();
        this.jad_fs = jad_an6;
        jad_an6.jad_an(this);
        jad_anVar.jad_an(jad_an6);
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an.InterfaceC0697jad_an
    public void jad_an() {
        this.jad_jt = true;
        this.jad_an.jad_an();
    }

    public void jad_an(Paint paint) {
        if (this.jad_jt) {
            this.jad_jt = false;
            double floatValue = this.jad_dq.jad_fs().floatValue() * 0.017453292519943295d;
            float floatValue2 = this.jad_er.jad_fs().floatValue();
            float sin = ((float) Math.sin(floatValue)) * floatValue2;
            float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
            int intValue = this.jad_bo.jad_fs().intValue();
            paint.setShadowLayer(this.jad_fs.jad_fs().floatValue(), sin, cos, Color.argb(Math.round(this.jad_cp.jad_fs().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
        }
    }

    public void jad_an(@Nullable com.jd.ad.sdk.jad_wf.jad_cp<Float> jad_cpVar) {
        if (jad_cpVar == null) {
            this.jad_cp.jad_er = null;
        } else {
            this.jad_cp.jad_er = new jad_an(this, jad_cpVar);
        }
    }
}
