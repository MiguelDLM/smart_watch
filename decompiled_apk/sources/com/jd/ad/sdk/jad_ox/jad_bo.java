package com.jd.ad.sdk.jad_ox;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes10.dex */
public class jad_bo {
    public final String jad_an;
    public final String jad_bo;
    public final float jad_cp;
    public final int jad_dq;
    public final int jad_er;
    public final float jad_fs;

    @ColorInt
    public final int jad_hu;

    @ColorInt
    public final int jad_iv;
    public final float jad_jt;
    public final float jad_jw;
    public final boolean jad_kx;

    public jad_bo(String str, String str2, float f, int i, int i2, float f2, float f3, @ColorInt int i3, @ColorInt int i4, float f4, boolean z) {
        this.jad_an = str;
        this.jad_bo = str2;
        this.jad_cp = f;
        this.jad_dq = i;
        this.jad_er = i2;
        this.jad_fs = f2;
        this.jad_jt = f3;
        this.jad_hu = i3;
        this.jad_iv = i4;
        this.jad_jw = f4;
        this.jad_kx = z;
    }

    public int hashCode() {
        int jad_an = ((com.jd.ad.sdk.jad_jt.jad_fs.jad_an(this.jad_dq) + (((int) (((this.jad_bo.hashCode() + (this.jad_an.hashCode() * 31)) * 31) + this.jad_cp)) * 31)) * 31) + this.jad_er;
        long floatToRawIntBits = Float.floatToRawIntBits(this.jad_fs);
        return (((jad_an * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.jad_hu;
    }
}
