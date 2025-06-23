package com.baidu.ar;

/* loaded from: classes7.dex */
public class mw extends mg {
    private mr FD;

    public mw(String str, int i) {
        super(str, i);
    }

    public void a(mr mrVar) {
        this.FD = mrVar;
    }

    public void updateHeading(float f, float f2) {
        this.Fu = true;
        this.Fv = f;
        this.Fw = f2;
        mr mrVar = this.FD;
        if (mrVar != null) {
            mrVar.a(this);
        }
    }

    public void a(mz mzVar) {
        this.Fs = true;
        this.Ft = mzVar;
        mr mrVar = this.FD;
        if (mrVar != null) {
            mrVar.a(this);
        }
    }
}
