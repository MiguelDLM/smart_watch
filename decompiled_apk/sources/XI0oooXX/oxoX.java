package XI0oooXX;

import com.github.mikephil.charting.components.YAxis;

/* loaded from: classes9.dex */
public class oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public float f3720I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public YAxis.AxisDependency f3721II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public float f3722II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3723Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f3724X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3725XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public float f3726oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public float f3727oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public float f3728xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public float f3729xxIXOIIO;

    public oxoX(float f, float f2, int i) {
        this.f3724X0o0xo = -1;
        this.f3723Oxx0IOOO = -1;
        this.f3726oIX0oI = f;
        this.f3722II0xO0 = f2;
        this.f3725XO = i;
    }

    public int I0Io() {
        return this.f3724X0o0xo;
    }

    public float II0XooXoX() {
        return this.f3726oIX0oI;
    }

    public YAxis.AxisDependency II0xO0() {
        return this.f3721II0XooXoX;
    }

    public float OOXIXo() {
        return this.f3727oxoX;
    }

    public int Oxx0IOOO() {
        return this.f3723Oxx0IOOO;
    }

    public float X0o0xo() {
        return this.f3729xxIXOIIO;
    }

    public float XO() {
        return this.f3728xoIox;
    }

    public boolean oIX0oI(oxoX oxox) {
        if (oxox == null || this.f3725XO != oxox.f3725XO || this.f3726oIX0oI != oxox.f3726oIX0oI || this.f3723Oxx0IOOO != oxox.f3723Oxx0IOOO || this.f3724X0o0xo != oxox.f3724X0o0xo) {
            return false;
        }
        return true;
    }

    public boolean oOoXoXO() {
        if (this.f3723Oxx0IOOO >= 0) {
            return true;
        }
        return false;
    }

    public void ooOOo0oXI(int i) {
        this.f3724X0o0xo = i;
    }

    public int oxoX() {
        return this.f3725XO;
    }

    public String toString() {
        return "Highlight, x: " + this.f3726oIX0oI + ", y: " + this.f3722II0xO0 + ", dataSetIndex: " + this.f3725XO + ", stackIndex (only stacked barentry): " + this.f3723Oxx0IOOO;
    }

    public void x0XOIxOo(float f, float f2) {
        this.f3729xxIXOIIO = f;
        this.f3728xoIox = f2;
    }

    public float xoIox() {
        return this.f3722II0xO0;
    }

    public float xxIXOIIO() {
        return this.f3720I0Io;
    }

    public oxoX(float f, int i, int i2) {
        this(f, Float.NaN, i);
        this.f3723Oxx0IOOO = i2;
    }

    public oxoX(float f, float f2, float f3, float f4, int i, YAxis.AxisDependency axisDependency) {
        this.f3724X0o0xo = -1;
        this.f3723Oxx0IOOO = -1;
        this.f3726oIX0oI = f;
        this.f3722II0xO0 = f2;
        this.f3720I0Io = f3;
        this.f3727oxoX = f4;
        this.f3725XO = i;
        this.f3721II0XooXoX = axisDependency;
    }

    public oxoX(float f, float f2, float f3, float f4, int i, int i2, YAxis.AxisDependency axisDependency) {
        this(f, f2, f3, f4, i, axisDependency);
        this.f3723Oxx0IOOO = i2;
    }
}
