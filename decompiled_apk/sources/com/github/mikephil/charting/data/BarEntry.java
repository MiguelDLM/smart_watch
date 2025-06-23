package com.github.mikephil.charting.data;

import XI0oooXX.xoIox;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes9.dex */
public class BarEntry extends Entry {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public float f16000IIXOooo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public xoIox[] f16001OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float[] f16002oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public float f16003xoXoI;

    public BarEntry(float f, float f2) {
        super(f, f2);
    }

    public static float ooOOo0oXI(float[] fArr) {
        float f = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    @Override // o0xxxXXxX.XO
    public float I0Io() {
        return super.I0Io();
    }

    public void IIXOooo(float[] fArr) {
        XO(ooOOo0oXI(fArr));
        this.f16002oI0IIXIo = fArr;
        OOXIXo();
        oOoXoXO();
    }

    public xoIox[] IXxxXO() {
        return this.f16001OxxIIOOXO;
    }

    public final void OOXIXo() {
        float[] fArr = this.f16002oI0IIXIo;
        if (fArr == null) {
            this.f16000IIXOooo = 0.0f;
            this.f16003xoXoI = 0.0f;
            return;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        for (float f3 : fArr) {
            if (f3 <= 0.0f) {
                f += Math.abs(f3);
            } else {
                f2 += f3;
            }
        }
        this.f16000IIXOooo = f;
        this.f16003xoXoI = f2;
    }

    public float Oo() {
        return this.f16003xoXoI;
    }

    public float Oxx0xo(int i) {
        float[] fArr = this.f16002oI0IIXIo;
        float f = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (int length = fArr.length - 1; length > i && length >= 0; length--) {
            f += this.f16002oI0IIXIo[length];
        }
        return f;
    }

    public boolean OxxIIOOXO() {
        if (this.f16002oI0IIXIo != null) {
            return true;
        }
        return false;
    }

    public float[] oI0IIXIo() {
        return this.f16002oI0IIXIo;
    }

    @Deprecated
    public float oO(int i) {
        return Oxx0xo(i);
    }

    public void oOoXoXO() {
        float[] oI0IIXIo2 = oI0IIXIo();
        if (oI0IIXIo2 != null && oI0IIXIo2.length != 0) {
            this.f16001OxxIIOOXO = new xoIox[oI0IIXIo2.length];
            float f = -x0xO0oo();
            int i = 0;
            float f2 = 0.0f;
            while (true) {
                xoIox[] xoioxArr = this.f16001OxxIIOOXO;
                if (i < xoioxArr.length) {
                    float f3 = oI0IIXIo2[i];
                    if (f3 < 0.0f) {
                        float f4 = f - f3;
                        xoioxArr[i] = new xoIox(f, f4);
                        f = f4;
                    } else {
                        float f5 = f3 + f2;
                        xoioxArr[i] = new xoIox(f2, f5);
                        f2 = f5;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.data.Entry
    /* renamed from: x0XOIxOo, reason: merged with bridge method [inline-methods] */
    public BarEntry Oxx0IOOO() {
        BarEntry barEntry = new BarEntry(xxIXOIIO(), I0Io(), oIX0oI());
        barEntry.IIXOooo(this.f16002oI0IIXIo);
        return barEntry;
    }

    public float x0xO0oo() {
        return this.f16000IIXOooo;
    }

    public BarEntry(float f, float f2, Object obj) {
        super(f, f2, obj);
    }

    public BarEntry(float f, float f2, Drawable drawable) {
        super(f, f2, drawable);
    }

    public BarEntry(float f, float f2, Drawable drawable, Object obj) {
        super(f, f2, drawable, obj);
    }

    public BarEntry(float f, float[] fArr) {
        super(f, ooOOo0oXI(fArr));
        this.f16002oI0IIXIo = fArr;
        OOXIXo();
        oOoXoXO();
    }

    public BarEntry(float f, float[] fArr, Object obj) {
        super(f, ooOOo0oXI(fArr), obj);
        this.f16002oI0IIXIo = fArr;
        OOXIXo();
        oOoXoXO();
    }

    public BarEntry(float f, float[] fArr, Drawable drawable) {
        super(f, ooOOo0oXI(fArr), drawable);
        this.f16002oI0IIXIo = fArr;
        OOXIXo();
        oOoXoXO();
    }

    public BarEntry(float f, float[] fArr, Drawable drawable, Object obj) {
        super(f, ooOOo0oXI(fArr), drawable, obj);
        this.f16002oI0IIXIo = fArr;
        OOXIXo();
        oOoXoXO();
    }
}
