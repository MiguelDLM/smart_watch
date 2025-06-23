package com.vtrump.vtble;

/* loaded from: classes13.dex */
public class X0IIOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f27419I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f27420II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f27421oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f27422oxoX;

    public X0IIOO() {
    }

    public static X0IIOO oIX0oI(XI0IXoo xI0IXoo) {
        if (xI0IXoo.II0xO0() == null || xI0IXoo.II0xO0().length < 4) {
            return null;
        }
        return new X0IIOO(xI0IXoo);
    }

    public int I0Io() {
        return this.f27420II0xO0;
    }

    public int II0xO0() {
        return this.f27419I0Io;
    }

    public int X0o0xo() {
        return this.f27422oxoX;
    }

    public boolean XO(X0IIOO x0iioo) {
        return oxoX() == x0iioo.oxoX() && I0Io() == x0iioo.I0Io() && (II0xO0() == -1 || II0xO0() == x0iioo.II0xO0()) && (X0o0xo() == -1 || X0o0xo() == x0iioo.X0o0xo());
    }

    public int oxoX() {
        return this.f27421oIX0oI;
    }

    public X0IIOO(byte b, byte b2, byte b3, byte b4) {
        this.f27421oIX0oI = b;
        this.f27420II0xO0 = b2;
        this.f27419I0Io = b3;
        this.f27422oxoX = b4;
    }

    public X0IIOO(XI0IXoo xI0IXoo) {
        byte[] II0xO02 = xI0IXoo.II0xO0();
        this.f27421oIX0oI = II0xO02[0] & 255;
        this.f27420II0xO0 = II0xO02[1] & 255;
        this.f27419I0Io = II0xO02[2] & 255;
        this.f27422oxoX = II0xO02[3] & 255;
    }
}
