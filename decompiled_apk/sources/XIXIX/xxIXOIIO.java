package XIXIX;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import java.util.List;

/* loaded from: classes9.dex */
public class xxIXOIIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public oOoXoXO f3802I0Io;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Matrix f3809oIX0oI = new Matrix();

    /* renamed from: II0xO0, reason: collision with root package name */
    public Matrix f3804II0xO0 = new Matrix();

    /* renamed from: oxoX, reason: collision with root package name */
    public float[] f3810oxoX = new float[1];

    /* renamed from: X0o0xo, reason: collision with root package name */
    public float[] f3807X0o0xo = new float[1];

    /* renamed from: XO, reason: collision with root package name */
    public float[] f3808XO = new float[1];

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public float[] f3806Oxx0IOOO = new float[1];

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public Matrix f3803II0XooXoX = new Matrix();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public float[] f3812xxIXOIIO = new float[2];

    /* renamed from: xoIox, reason: collision with root package name */
    public Matrix f3811xoIox = new Matrix();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public Matrix f3805OOXIXo = new Matrix();

    public xxIXOIIO(oOoXoXO oooxoxo) {
        this.f3802I0Io = oooxoxo;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    public float[] I0Io(IIxOXoOo0.XO xo2, float f, float f2, int i, int i2) {
        int i3 = (((int) ((i2 - i) * f)) + 1) * 2;
        if (this.f3808XO.length != i3) {
            this.f3808XO = new float[i3];
        }
        float[] fArr = this.f3808XO;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            ?? OOXIXo2 = xo2.OOXIXo((i4 / 2) + i);
            if (OOXIXo2 != 0) {
                fArr[i4] = OOXIXo2.xxIXOIIO();
                fArr[i4 + 1] = OOXIXo2.I0Io() * f2;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        xxIXOIIO().mapPoints(fArr);
        return fArr;
    }

    public Matrix II0XooXoX() {
        return this.f3809oIX0oI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float[] II0xO0(IIxOXoOo0.oxoX oxox, float f, float f2, int i, int i2) {
        int i3 = ((int) (((i2 - i) * f) + 1.0f)) * 2;
        if (this.f3806Oxx0IOOO.length != i3) {
            this.f3806Oxx0IOOO = new float[i3];
        }
        float[] fArr = this.f3806Oxx0IOOO;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            CandleEntry candleEntry = (CandleEntry) oxox.OOXIXo((i4 / 2) + i);
            if (candleEntry != null) {
                fArr[i4] = candleEntry.xxIXOIIO();
                fArr[i4 + 1] = candleEntry.x0XOIxOo() * f2;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        xxIXOIIO().mapPoints(fArr);
        return fArr;
    }

    public void IIXOooo(RectF rectF, float f) {
        rectF.left *= f;
        rectF.right *= f;
        this.f3809oIX0oI.mapRect(rectF);
        this.f3802I0Io.IXxxXO().mapRect(rectF);
        this.f3804II0xO0.mapRect(rectF);
    }

    public void IXxxXO(RectF rectF, float f) {
        rectF.top *= f;
        rectF.bottom *= f;
        this.f3809oIX0oI.mapRect(rectF);
        this.f3802I0Io.IXxxXO().mapRect(rectF);
        this.f3804II0xO0.mapRect(rectF);
    }

    public void OOXIXo(float f, float f2, XO xo2) {
        float[] fArr = this.f3812xxIXOIIO;
        fArr[0] = f;
        fArr[1] = f2;
        x0XOIxOo(fArr);
        float[] fArr2 = this.f3812xxIXOIIO;
        xo2.f3774IXxxXO = fArr2[0];
        xo2.f3775Oxx0xo = fArr2[1];
    }

    public void Oo(float f, float f2, float f3, float f4) {
        float OOXIXo2 = this.f3802I0Io.OOXIXo() / f2;
        float Oxx0IOOO2 = this.f3802I0Io.Oxx0IOOO() / f3;
        if (Float.isInfinite(OOXIXo2)) {
            OOXIXo2 = 0.0f;
        }
        if (Float.isInfinite(Oxx0IOOO2)) {
            Oxx0IOOO2 = 0.0f;
        }
        this.f3809oIX0oI.reset();
        this.f3809oIX0oI.postTranslate(-f, -f4);
        this.f3809oIX0oI.postScale(OOXIXo2, -Oxx0IOOO2);
    }

    public Matrix Oxx0IOOO() {
        xxIXOIIO().invert(this.f3805OOXIXo);
        return this.f3805OOXIXo;
    }

    public void Oxx0xo(RectF rectF, float f) {
        rectF.left *= f;
        rectF.right *= f;
        this.f3809oIX0oI.mapRect(rectF);
        this.f3802I0Io.IXxxXO().mapRect(rectF);
        this.f3804II0xO0.mapRect(rectF);
    }

    public void OxxIIOOXO(RectF rectF) {
        this.f3809oIX0oI.mapRect(rectF);
        this.f3802I0Io.IXxxXO().mapRect(rectF);
        this.f3804II0xO0.mapRect(rectF);
    }

    public Matrix X0o0xo() {
        return this.f3804II0xO0;
    }

    public XO XO(float f, float f2) {
        float[] fArr = this.f3812xxIXOIIO;
        fArr[0] = f;
        fArr[1] = f2;
        oO(fArr);
        float[] fArr2 = this.f3812xxIXOIIO;
        return XO.II0xO0(fArr2[0], fArr2[1]);
    }

    public void oI0IIXIo(RectF rectF) {
        this.f3809oIX0oI.mapRect(rectF);
        this.f3802I0Io.IXxxXO().mapRect(rectF);
        this.f3804II0xO0.mapRect(rectF);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    public float[] oIX0oI(IIxOXoOo0.I0Io i0Io, float f, int i, int i2) {
        int i3 = ((i2 - i) + 1) * 2;
        if (this.f3807X0o0xo.length != i3) {
            this.f3807X0o0xo = new float[i3];
        }
        float[] fArr = this.f3807X0o0xo;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            ?? OOXIXo2 = i0Io.OOXIXo((i4 / 2) + i);
            if (OOXIXo2 != 0) {
                fArr[i4] = OOXIXo2.xxIXOIIO();
                fArr[i4 + 1] = OOXIXo2.I0Io() * f;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        xxIXOIIO().mapPoints(fArr);
        return fArr;
    }

    public void oO(float[] fArr) {
        this.f3809oIX0oI.mapPoints(fArr);
        this.f3802I0Io.IXxxXO().mapPoints(fArr);
        this.f3804II0xO0.mapPoints(fArr);
    }

    public void oOoXoXO(Path path) {
        path.transform(this.f3809oIX0oI);
        path.transform(this.f3802I0Io.IXxxXO());
        path.transform(this.f3804II0xO0);
    }

    public void ooOOo0oXI(List<Path> list) {
        for (int i = 0; i < list.size(); i++) {
            oOoXoXO(list.get(i));
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    public float[] oxoX(IIxOXoOo0.OOXIXo oOXIXo, float f, float f2, int i, int i2) {
        int i3 = ((int) (((i2 - i) * f) + 1.0f)) * 2;
        if (this.f3810oxoX.length != i3) {
            this.f3810oxoX = new float[i3];
        }
        float[] fArr = this.f3810oxoX;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            ?? OOXIXo2 = oOXIXo.OOXIXo((i4 / 2) + i);
            if (OOXIXo2 != 0) {
                fArr[i4] = OOXIXo2.xxIXOIIO();
                fArr[i4 + 1] = OOXIXo2.I0Io() * f2;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        xxIXOIIO().mapPoints(fArr);
        return fArr;
    }

    public void x0XOIxOo(float[] fArr) {
        Matrix matrix = this.f3803II0XooXoX;
        matrix.reset();
        this.f3804II0xO0.invert(matrix);
        matrix.mapPoints(fArr);
        this.f3802I0Io.IXxxXO().invert(matrix);
        matrix.mapPoints(fArr);
        this.f3809oIX0oI.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void x0xO0oo(boolean z) {
        this.f3804II0xO0.reset();
        if (!z) {
            this.f3804II0xO0.postTranslate(this.f3802I0Io.IO(), this.f3802I0Io.x0XOIxOo() - this.f3802I0Io.X00IoxXI());
        } else {
            this.f3804II0xO0.setTranslate(this.f3802I0Io.IO(), -this.f3802I0Io.x0o());
            this.f3804II0xO0.postScale(1.0f, -1.0f);
        }
    }

    public XO xoIox(float f, float f2) {
        XO II0xO02 = XO.II0xO0(OOXIXo.f3760XO, OOXIXo.f3760XO);
        OOXIXo(f, f2, II0xO02);
        return II0xO02;
    }

    public void xoXoI(List<RectF> list) {
        Matrix xxIXOIIO2 = xxIXOIIO();
        for (int i = 0; i < list.size(); i++) {
            xxIXOIIO2.mapRect(list.get(i));
        }
    }

    public Matrix xxIXOIIO() {
        this.f3811xoIox.set(this.f3809oIX0oI);
        this.f3811xoIox.postConcat(this.f3802I0Io.f3792oIX0oI);
        this.f3811xoIox.postConcat(this.f3804II0xO0);
        return this.f3811xoIox;
    }
}
