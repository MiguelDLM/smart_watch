package XIXIX;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes9.dex */
public class oOoXoXO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Matrix f3792oIX0oI = new Matrix();

    /* renamed from: II0xO0, reason: collision with root package name */
    public RectF f3786II0xO0 = new RectF();

    /* renamed from: I0Io, reason: collision with root package name */
    public float f3784I0Io = 0.0f;

    /* renamed from: oxoX, reason: collision with root package name */
    public float f3796oxoX = 0.0f;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public float f3790X0o0xo = 1.0f;

    /* renamed from: XO, reason: collision with root package name */
    public float f3791XO = Float.MAX_VALUE;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public float f3789Oxx0IOOO = 1.0f;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public float f3785II0XooXoX = Float.MAX_VALUE;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public float f3800xxIXOIIO = 1.0f;

    /* renamed from: xoIox, reason: collision with root package name */
    public float f3799xoIox = 1.0f;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public float f3787OOXIXo = 0.0f;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public float f3794oOoXoXO = 0.0f;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public float f3795ooOOo0oXI = 0.0f;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public float f3797x0XOIxOo = 0.0f;

    /* renamed from: oO, reason: collision with root package name */
    public float[] f3793oO = new float[9];

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public Matrix f3798x0xO0oo = new Matrix();

    /* renamed from: Oo, reason: collision with root package name */
    public final float[] f3788Oo = new float[9];

    public boolean I0Io() {
        if (this.f3800xxIXOIIO > this.f3789Oxx0IOOO) {
            return true;
        }
        return false;
    }

    public Matrix I0X0x0oIo(float f, float f2) {
        Matrix matrix = new Matrix();
        Xo0(f, f2, matrix);
        return matrix;
    }

    public Matrix I0oOIX(float f, float f2) {
        Matrix matrix = new Matrix();
        IoOoo(f, f2, matrix);
        return matrix;
    }

    public void I0oOoX(float f) {
        this.f3797x0XOIxOo = OOXIXo.X0o0xo(f);
    }

    public float II0XooXoX() {
        return this.f3786II0xO0.left;
    }

    public boolean II0xO0() {
        if (this.f3799xoIox < this.f3791XO) {
            return true;
        }
        return false;
    }

    public boolean IIX0o(float f, float f2) {
        if (IoOoX(f) && oOXoIIIo(f2)) {
            return true;
        }
        return false;
    }

    public float IIXOooo() {
        return this.f3790X0o0xo;
    }

    public float IO() {
        return this.f3786II0xO0.left;
    }

    public Matrix IXxxXO() {
        return this.f3792oIX0oI;
    }

    public void Io(float f, float f2, float f3, float f4) {
        this.f3786II0xO0.set(f, f2, this.f3784I0Io - f3, this.f3796oxoX - f4);
    }

    public boolean IoOoX(float f) {
        if (xI(f) && oo0xXOI0I(f)) {
            return true;
        }
        return false;
    }

    public void IoOoo(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f3792oIX0oI);
        matrix.postScale(f, f2);
    }

    public void O0Xx(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f3792oIX0oI);
        matrix.postTranslate(-(fArr[0] - IO()), -(fArr[1] - x0o()));
    }

    public float O0xOxO() {
        return this.f3787OOXIXo;
    }

    public void OI0(Matrix matrix) {
        matrix.reset();
        matrix.set(this.f3792oIX0oI);
        matrix.postScale(1.0f, 1.0f, 0.0f, 0.0f);
    }

    public void OO(float f, float f2, float f3, float f4, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f3792oIX0oI);
        matrix.postScale(f, f2, f3, f4);
    }

    public Matrix OO0x0xX(float f, float f2) {
        Matrix matrix = new Matrix();
        XIo0oOXIx(f, f2, matrix);
        return matrix;
    }

    public float OOXIXo() {
        return this.f3786II0xO0.width();
    }

    public RectF Oo() {
        return this.f3786II0xO0;
    }

    public float OxI() {
        return Math.min(this.f3786II0xO0.width(), this.f3786II0xO0.height());
    }

    public float Oxx0IOOO() {
        return this.f3786II0xO0.height();
    }

    public float Oxx0xo() {
        return this.f3785II0XooXoX;
    }

    public float OxxIIOOXO() {
        return this.f3789Oxx0IOOO;
    }

    public float X00IoxXI() {
        return this.f3796oxoX - this.f3786II0xO0.bottom;
    }

    public float X0IIOO() {
        return this.f3794oOoXoXO;
    }

    public void X0o0xo(float[] fArr, View view) {
        Matrix matrix = this.f3798x0xO0oo;
        matrix.reset();
        matrix.set(this.f3792oIX0oI);
        matrix.postTranslate(-(fArr[0] - IO()), -(fArr[1] - x0o()));
        XOxIOxOx(matrix, view, true);
    }

    public boolean XI0IXoo() {
        if (this.f3796oxoX > 0.0f && this.f3784I0Io > 0.0f) {
            return true;
        }
        return false;
    }

    public void XIo0oOXIx(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f3792oIX0oI);
        matrix.postScale(0.7f, 0.7f, f, f2);
    }

    public boolean XIxXXX0x0() {
        if (this.f3795ooOOo0oXI <= 0.0f && this.f3797x0XOIxOo <= 0.0f) {
            return true;
        }
        return false;
    }

    public float XO() {
        return this.f3786II0xO0.bottom;
    }

    public Matrix XOxIOxOx(Matrix matrix, View view, boolean z) {
        this.f3792oIX0oI.set(matrix);
        Xx000oIo(this.f3792oIX0oI, this.f3786II0xO0);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.f3792oIX0oI);
        return matrix;
    }

    public void XX(float f) {
        this.f3795ooOOo0oXI = OOXIXo.X0o0xo(f);
    }

    public void XX0(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.f3790X0o0xo = f;
        Xx000oIo(this.f3792oIX0oI, this.f3786II0xO0);
    }

    public void Xo0(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f3792oIX0oI);
        matrix.setScale(f, f2);
    }

    public Matrix XoI0Ixx0(float[] fArr) {
        Matrix matrix = new Matrix();
        O0Xx(fArr, matrix);
        return matrix;
    }

    public void XoX(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.f3791XO = f;
        Xx000oIo(this.f3792oIX0oI, this.f3786II0xO0);
    }

    public void Xx000oIo(Matrix matrix, RectF rectF) {
        float f;
        float f2;
        matrix.getValues(this.f3788Oo);
        float[] fArr = this.f3788Oo;
        float f3 = fArr[2];
        float f4 = fArr[0];
        float f5 = fArr[5];
        float f6 = fArr[4];
        this.f3800xxIXOIIO = Math.min(Math.max(this.f3789Oxx0IOOO, f4), this.f3785II0XooXoX);
        this.f3799xoIox = Math.min(Math.max(this.f3790X0o0xo, f6), this.f3791XO);
        if (rectF != null) {
            f = rectF.width();
            f2 = rectF.height();
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.f3787OOXIXo = Math.min(Math.max(f3, ((-f) * (this.f3800xxIXOIIO - 1.0f)) - this.f3795ooOOo0oXI), this.f3795ooOOo0oXI);
        float max = Math.max(Math.min(f5, (f2 * (this.f3799xoIox - 1.0f)) + this.f3797x0XOIxOo), -this.f3797x0XOIxOo);
        this.f3794oOoXoXO = max;
        float[] fArr2 = this.f3788Oo;
        fArr2[2] = this.f3787OOXIXo;
        fArr2[0] = this.f3800xxIXOIIO;
        fArr2[5] = max;
        fArr2[4] = this.f3799xoIox;
        matrix.setValues(fArr2);
    }

    public boolean XxX0x0xxx() {
        float f = this.f3800xxIXOIIO;
        float f2 = this.f3789Oxx0IOOO;
        if (f <= f2 && f2 <= 1.0f) {
            return true;
        }
        return false;
    }

    public void o0(float f, float f2) {
        float IO2 = IO();
        float x0o2 = x0o();
        float xII2 = xII();
        float X00IoxXI2 = X00IoxXI();
        this.f3796oxoX = f2;
        this.f3784I0Io = f;
        Io(IO2, x0o2, xII2, X00IoxXI2);
    }

    public float o00() {
        return this.f3799xoIox;
    }

    public float oI0IIXIo() {
        return this.f3791XO;
    }

    public boolean oIX0oI() {
        if (this.f3800xxIXOIIO < this.f3785II0XooXoX) {
            return true;
        }
        return false;
    }

    public float oO() {
        return this.f3784I0Io;
    }

    public boolean oOXoIIIo(float f) {
        if (oo(f) && ooXIXxIX(f)) {
            return true;
        }
        return false;
    }

    public Matrix oOoXoXO() {
        Matrix matrix = new Matrix();
        ooOOo0oXI(matrix);
        return matrix;
    }

    public Matrix oX(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.set(this.f3792oIX0oI);
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    public boolean oo(float f) {
        if (this.f3786II0xO0.top <= f) {
            return true;
        }
        return false;
    }

    public boolean oo0xXOI0I(float f) {
        if (this.f3786II0xO0.right >= (((int) (f * 100.0f)) / 100.0f) - 1.0f) {
            return true;
        }
        return false;
    }

    public void ooOOo0oXI(Matrix matrix) {
        this.f3789Oxx0IOOO = 1.0f;
        this.f3790X0o0xo = 1.0f;
        matrix.set(this.f3792oIX0oI);
        float[] fArr = this.f3793oO;
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        matrix.getValues(fArr);
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        matrix.setValues(fArr);
    }

    public boolean ooXIXxIX(float f) {
        if (this.f3786II0xO0.bottom >= ((int) (f * 100.0f)) / 100.0f) {
            return true;
        }
        return false;
    }

    public void oxXx0IX(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.f3789Oxx0IOOO = f;
        this.f3785II0XooXoX = f2;
        Xx000oIo(this.f3792oIX0oI, this.f3786II0xO0);
    }

    public boolean oxoX() {
        if (this.f3799xoIox > this.f3790X0o0xo) {
            return true;
        }
        return false;
    }

    public void oxxXoxO(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.f3785II0XooXoX = f;
        Xx000oIo(this.f3792oIX0oI, this.f3786II0xO0);
    }

    public float x0XOIxOo() {
        return this.f3796oxoX;
    }

    public float x0o() {
        return this.f3786II0xO0.top;
    }

    public void x0xO(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f3792oIX0oI);
        matrix.postScale(1.4f, 1.4f, f, f2);
    }

    public Oxx0IOOO x0xO0oo() {
        return Oxx0IOOO.I0Io(this.f3786II0xO0.centerX(), this.f3786II0xO0.centerY());
    }

    public boolean xI(float f) {
        if (this.f3786II0xO0.left <= f + 1.0f) {
            return true;
        }
        return false;
    }

    public float xII() {
        return this.f3784I0Io - this.f3786II0xO0.right;
    }

    public void xXOx(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.f3789Oxx0IOOO = f;
        Xx000oIo(this.f3792oIX0oI, this.f3786II0xO0);
    }

    public boolean xXxxox0I() {
        float f = this.f3799xoIox;
        float f2 = this.f3790X0o0xo;
        if (f <= f2 && f2 <= 1.0f) {
            return true;
        }
        return false;
    }

    public void xo0x(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.f3790X0o0xo = f;
        this.f3791XO = f2;
        Xx000oIo(this.f3792oIX0oI, this.f3786II0xO0);
    }

    public float xoIox() {
        return this.f3786II0xO0.top;
    }

    public Matrix xoIxX(float f, float f2) {
        Matrix matrix = new Matrix();
        x0xO(f, f2, matrix);
        return matrix;
    }

    public float xoXoI() {
        return this.f3800xxIXOIIO;
    }

    public Matrix xoxXI(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        OO(f, f2, f3, f4, matrix);
        return matrix;
    }

    public float xxIXOIIO() {
        return this.f3786II0xO0.right;
    }

    public boolean xxX() {
        if (XxX0x0xxx() && xXxxox0I()) {
            return true;
        }
        return false;
    }
}
