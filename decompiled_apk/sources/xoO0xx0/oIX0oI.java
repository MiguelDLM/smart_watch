package xoO0xx0;

/* loaded from: classes9.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public float f35110I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public float f35111II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public float f35112oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final oIX0oI f35109oxoX = new oIX0oI(0.0f, 0.0f, 0.0f);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final oIX0oI f35107X0o0xo = new oIX0oI(1.0f, 0.0f, 0.0f);

    /* renamed from: XO, reason: collision with root package name */
    public static final oIX0oI f35108XO = new oIX0oI(0.0f, 1.0f, 0.0f);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final oIX0oI f35106Oxx0IOOO = new oIX0oI(0.0f, 0.0f, 1.0f);

    public oIX0oI() {
    }

    public final oIX0oI I0Io(oIX0oI oix0oi) {
        float f = this.f35111II0xO0;
        float f2 = oix0oi.f35110I0Io;
        float f3 = this.f35110I0Io;
        float f4 = oix0oi.f35111II0xO0;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = oix0oi.f35112oIX0oI;
        float f7 = this.f35112oIX0oI;
        return new oIX0oI(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6));
    }

    public final float II0XooXoX() {
        float f = this.f35112oIX0oI;
        float f2 = this.f35111II0xO0;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f35110I0Io;
        return f3 + (f4 * f4);
    }

    public final void II0xO0(oIX0oI oix0oi) {
        this.f35112oIX0oI += oix0oi.f35112oIX0oI;
        this.f35111II0xO0 += oix0oi.f35111II0xO0;
        this.f35110I0Io += oix0oi.f35110I0Io;
    }

    public final float OOXIXo() {
        float Oxx0IOOO2 = Oxx0IOOO();
        if (Oxx0IOOO2 != 0.0f) {
            this.f35112oIX0oI /= Oxx0IOOO2;
            this.f35111II0xO0 /= Oxx0IOOO2;
            this.f35110I0Io /= Oxx0IOOO2;
        }
        return Oxx0IOOO2;
    }

    public final void Oo() {
        ooOOo0oXI(0.0f, 0.0f, 0.0f);
    }

    public final float Oxx0IOOO() {
        return (float) Math.sqrt(II0XooXoX());
    }

    public final void X0o0xo(float f) {
        if (f != 0.0f) {
            this.f35112oIX0oI /= f;
            this.f35111II0xO0 /= f;
            this.f35110I0Io /= f;
        }
    }

    public final float XO(oIX0oI oix0oi) {
        return (this.f35112oIX0oI * oix0oi.f35112oIX0oI) + (this.f35111II0xO0 * oix0oi.f35111II0xO0) + (this.f35110I0Io * oix0oi.f35110I0Io);
    }

    public final void oIX0oI(float f, float f2, float f3) {
        this.f35112oIX0oI += f;
        this.f35111II0xO0 += f2;
        this.f35110I0Io += f3;
    }

    public final void oO(oIX0oI oix0oi) {
        this.f35112oIX0oI -= oix0oi.f35112oIX0oI;
        this.f35111II0xO0 -= oix0oi.f35111II0xO0;
        this.f35110I0Io -= oix0oi.f35110I0Io;
    }

    public final boolean oOoXoXO(oIX0oI oix0oi) {
        if (XO(oix0oi) > 0.0f) {
            return true;
        }
        return false;
    }

    public final void ooOOo0oXI(float f, float f2, float f3) {
        this.f35112oIX0oI = f;
        this.f35111II0xO0 = f2;
        this.f35110I0Io = f3;
    }

    public final float oxoX(oIX0oI oix0oi) {
        float f = this.f35112oIX0oI - oix0oi.f35112oIX0oI;
        float f2 = this.f35111II0xO0 - oix0oi.f35111II0xO0;
        float f3 = this.f35110I0Io - oix0oi.f35110I0Io;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public final void x0XOIxOo(oIX0oI oix0oi) {
        this.f35112oIX0oI = oix0oi.f35112oIX0oI;
        this.f35111II0xO0 = oix0oi.f35111II0xO0;
        this.f35110I0Io = oix0oi.f35110I0Io;
    }

    public final void x0xO0oo(oIX0oI oix0oi, float f) {
        this.f35112oIX0oI -= oix0oi.f35112oIX0oI * f;
        this.f35111II0xO0 -= oix0oi.f35111II0xO0 * f;
        this.f35110I0Io -= oix0oi.f35110I0Io * f;
    }

    public final void xoIox(oIX0oI oix0oi) {
        this.f35112oIX0oI *= oix0oi.f35112oIX0oI;
        this.f35111II0xO0 *= oix0oi.f35111II0xO0;
        this.f35110I0Io *= oix0oi.f35110I0Io;
    }

    public final void xxIXOIIO(float f) {
        this.f35112oIX0oI *= f;
        this.f35111II0xO0 *= f;
        this.f35110I0Io *= f;
    }

    public oIX0oI(float[] fArr) {
        ooOOo0oXI(fArr[0], fArr[1], fArr[2]);
    }

    public oIX0oI(float f, float f2, float f3) {
        ooOOo0oXI(f, f2, f3);
    }

    public oIX0oI(oIX0oI oix0oi) {
        x0XOIxOo(oix0oi);
    }
}
