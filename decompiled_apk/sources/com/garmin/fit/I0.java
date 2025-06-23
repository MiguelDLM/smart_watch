package com.garmin.fit;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes9.dex */
public class I0 extends I0xX0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f11252I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public XI0oooXX f11253II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public short f11254X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Oxx f11255oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f11256oxoX;

    public I0() {
        this.f11255oIX0oI = null;
        this.f11256oxoX = 2;
    }

    public Byte[] I0Io() {
        if (x0XOIxOo()) {
            return this.f11253II0xO0.OX();
        }
        return null;
    }

    public short II0XooXoX() {
        Short O002;
        if (x0XOIxOo() && (O002 = this.f11255oIX0oI.O00()) != null) {
            return O002.shortValue();
        }
        return Fit.f11224oxxXoxO.shortValue();
    }

    @Override // com.garmin.fit.I0xX0
    public void II0xO0(int i) {
        this.f11252I0Io = i;
    }

    public void IXxxXO(OutputStream outputStream) {
        try {
            outputStream.write(this.f11255oIX0oI.OO0().shortValue());
            outputStream.write(this.f11252I0Io);
            outputStream.write(this.f11255oIX0oI.XoIxOXIXo().shortValue());
        } catch (IOException e) {
            throw new FitRuntimeException(e);
        }
    }

    public short OOXIXo() {
        if (x0XOIxOo() && this.f11255oIX0oI.XO0o() != null && !this.f11255oIX0oI.XO0o().equals(Fit.f11224oxxXoxO)) {
            return this.f11255oIX0oI.XO0o().shortValue();
        }
        return (short) 1;
    }

    public void Oo(short s) {
        this.f11254X0o0xo = s;
    }

    public String Oxx0IOOO() {
        if (x0XOIxOo()) {
            return this.f11255oIX0oI.OooI(0);
        }
        return null;
    }

    public IIxOXoOo0 X0o0xo() {
        return new IIxOXoOo0(this);
    }

    public short XO() {
        Short sh;
        if (x0XOIxOo()) {
            sh = this.f11255oIX0oI.XoIxOXIXo();
        } else {
            sh = null;
        }
        if (sh == null) {
            return Fit.f11224oxxXoxO.shortValue();
        }
        return sh.shortValue();
    }

    @Override // com.garmin.fit.I0xX0
    public int oIX0oI() {
        return this.f11252I0Io;
    }

    public void oO(XI0oooXX xI0oooXX) {
        this.f11253II0xO0 = xI0oooXX;
    }

    public int oOoXoXO() {
        return this.f11256oxoX;
    }

    public String ooOOo0oXI() {
        if (x0XOIxOo()) {
            return this.f11255oIX0oI.oX0I0O(0);
        }
        return null;
    }

    public long oxoX() {
        Long l;
        if (x0XOIxOo()) {
            l = this.f11253II0xO0.oXIoO();
        } else {
            l = null;
        }
        if (l == null) {
            return Fit.f11230x0xO.longValue();
        }
        return l.longValue();
    }

    public boolean x0XOIxOo() {
        if (this.f11255oIX0oI != null && this.f11253II0xO0 != null) {
            return true;
        }
        return false;
    }

    public void x0xO0oo(Oxx oxx) {
        this.f11255oIX0oI = oxx;
        this.f11254X0o0xo = oxx.OO0().shortValue();
        this.f11256oxoX = this.f11255oIX0oI.xIXX().shortValue();
    }

    public short xoIox() {
        if (x0XOIxOo() && this.f11255oIX0oI.IxX00() != null && !this.f11255oIX0oI.IxX00().equals(Fit.f11148Io)) {
            return this.f11255oIX0oI.IxX00().byteValue();
        }
        return (short) 0;
    }

    public short xxIXOIIO() {
        return this.f11254X0o0xo;
    }

    public I0(Oxx oxx, XI0oooXX xI0oooXX) {
        x0xO0oo(oxx);
        this.f11253II0xO0 = xI0oooXX;
    }

    public I0(IIxOXoOo0 iIxOXoOo0) {
        this(iIxOXoOo0.xIXX());
        this.f11252I0Io = iIxOXoOo0.xOOOX();
    }

    public I0(I0 i0) {
        x0xO0oo(i0.f11255oIX0oI);
        this.f11253II0xO0 = i0.f11253II0xO0;
        this.f11252I0Io = i0.oIX0oI();
    }
}
