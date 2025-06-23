package org.apache.commons.lang3;

/* loaded from: classes6.dex */
public class X0o0xo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f32517II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f32518oIX0oI;

    public X0o0xo(int i) {
        int numberOfTrailingZeros;
        this.f32518oIX0oI = i;
        if (i == 0) {
            numberOfTrailingZeros = 0;
        } else {
            numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
        }
        this.f32517II0xO0 = numberOfTrailingZeros;
    }

    public short I0Io(short s) {
        return (short) oIX0oI(s);
    }

    public boolean II0XooXoX(int i) {
        int i2 = this.f32518oIX0oI;
        if ((i & i2) == i2) {
            return true;
        }
        return false;
    }

    public byte II0xO0(byte b) {
        return (byte) oIX0oI(b);
    }

    public int OOXIXo(int i, boolean z) {
        if (z) {
            return xoIox(i);
        }
        return oIX0oI(i);
    }

    public int Oo(int i, int i2) {
        int i3 = this.f32518oIX0oI;
        return (i & (~i3)) | ((i2 << this.f32517II0xO0) & i3);
    }

    public int Oxx0IOOO(int i) {
        return oxoX(i) >> this.f32517II0xO0;
    }

    public short X0o0xo(short s) {
        return (short) oxoX(s);
    }

    public short XO(short s) {
        return (short) Oxx0IOOO(s);
    }

    public int oIX0oI(int i) {
        return i & (~this.f32518oIX0oI);
    }

    public short oO(short s, boolean z) {
        if (z) {
            return x0XOIxOo(s);
        }
        return I0Io(s);
    }

    public byte oOoXoXO(byte b) {
        return (byte) xoIox(b);
    }

    public byte ooOOo0oXI(byte b, boolean z) {
        if (z) {
            return oOoXoXO(b);
        }
        return II0xO0(b);
    }

    public int oxoX(int i) {
        return i & this.f32518oIX0oI;
    }

    public short x0XOIxOo(short s) {
        return (short) xoIox(s);
    }

    public short x0xO0oo(short s, short s2) {
        return (short) Oo(s, s2);
    }

    public int xoIox(int i) {
        return i | this.f32518oIX0oI;
    }

    public boolean xxIXOIIO(int i) {
        if ((i & this.f32518oIX0oI) != 0) {
            return true;
        }
        return false;
    }
}
