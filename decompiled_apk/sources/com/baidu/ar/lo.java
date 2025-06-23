package com.baidu.ar;

/* loaded from: classes7.dex */
public class lo extends lj implements ll {
    private lb Ej;
    private lc Ek;

    public lo(lm lmVar, lb lbVar, int i, int i2) {
        super(lmVar, i, i2);
        this.Ej = lbVar;
    }

    private int b(float[] fArr, int i) {
        return 90.0f - ((float) (((Math.acos((double) (-fArr[10])) * 180.0d) * 1.0d) / 3.141592653589793d)) > ((float) i) ? 0 : 1;
    }

    public void a(lc lcVar) {
        this.Ek = lcVar;
    }

    @Override // com.baidu.ar.lj, com.baidu.ar.ll
    public boolean i(float[] fArr) {
        float[] a2 = this.Ek.a(this.Ej.hK(), fArr);
        if (a2 != null) {
            String a3 = this.DF.a(this.Ej);
            int i = (int) a2[0];
            if (i == 0) {
                int b = b(fArr, this.Ej.hK());
                if (b == 0) {
                    this.DF.hP();
                } else if (b == 1) {
                    this.DF.hQ();
                }
                this.DF.j(new float[16]);
            } else if (i == 1) {
                this.DF.a(a3, (int) a2[1], (int) a2[2], lj.Eg, this.Ej.hJ());
                this.DF.hR();
                return true;
            }
        }
        return false;
    }
}
