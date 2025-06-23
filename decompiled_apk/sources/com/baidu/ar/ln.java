package com.baidu.ar;

/* loaded from: classes7.dex */
public class ln extends lj implements ll {
    private lb Ej;

    public ln(lm lmVar, lb lbVar, int i, int i2) {
        super(lmVar, i, i2);
        this.Ej = lbVar;
    }

    @Override // com.baidu.ar.lj, com.baidu.ar.ll
    public boolean i(float[] fArr) {
        int i;
        int i2;
        String[] split = this.Ej.hI().split(",");
        String a2 = this.DF.a(this.Ej);
        int i3 = this.mPreviewWidth / 2;
        int i4 = this.mPreviewHeight / 2;
        try {
            int[] a3 = this.DF.a(Float.parseFloat(split[0].trim()), Float.parseFloat(split[1].trim()));
            i3 = a3[0];
            i2 = a3[1];
            i = i3;
        } catch (NumberFormatException unused) {
            kf.cl("model position is not number !!!");
            i = i3;
            i2 = i4;
        }
        this.DF.a(a2, i, i2, lj.Eg, this.Ej.hJ());
        return true;
    }
}
