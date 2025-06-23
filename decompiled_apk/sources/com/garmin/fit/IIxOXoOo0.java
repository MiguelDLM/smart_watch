package com.garmin.fit;

import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes9.dex */
public class IIxOXoOo0 extends XOxxooXI {

    /* renamed from: I0Io, reason: collision with root package name */
    public I0 f11462I0Io;

    public IIxOXoOo0(I0 i0) {
        this.f11462I0Io = i0;
    }

    @Override // com.garmin.fit.XOxxooXI
    public xxOoXO IoIOOxIIo(String str) {
        return null;
    }

    public int O00() {
        return this.f11462I0Io.xxIXOIIO();
    }

    @Override // com.garmin.fit.XOxxooXI
    public double O00XxXI() {
        return this.f11462I0Io.OOXIXo();
    }

    @Override // com.garmin.fit.XOxxooXI
    public String OIOoIIOIx() {
        return this.f11462I0Io.ooOOo0oXI();
    }

    public short OIx00oxx() {
        return this.f11462I0Io.XO();
    }

    public UUID OO0() {
        Byte[] I0Io2 = this.f11462I0Io.I0Io();
        byte[] bArr = new byte[I0Io2.length];
        for (byte b = 0; b < I0Io2.length; b = (byte) (b + 1)) {
            bArr[b] = I0Io2[b].byteValue();
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    @Override // com.garmin.fit.XOxxooXI
    public double OO0x0xX() {
        return this.f11462I0Io.xoIox();
    }

    public long OooI() {
        return this.f11462I0Io.oxoX();
    }

    public Byte[] XoIxOXIXo() {
        return this.f11462I0Io.I0Io();
    }

    @Override // com.garmin.fit.XOxxooXI
    public String oo0xXOI0I() {
        return this.f11462I0Io.Oxx0IOOO();
    }

    @Override // com.garmin.fit.XOxxooXI
    public int oxIIX0o() {
        return this.f11462I0Io.oOoXoXO();
    }

    @Override // com.garmin.fit.XOxxooXI
    public xxOoXO xI0oxI00(int i) {
        return null;
    }

    public I0 xIXX() {
        return this.f11462I0Io;
    }

    public boolean xOOxIO() {
        return this.f11462I0Io.x0XOIxOo();
    }

    public short xxxI() {
        return this.f11462I0Io.II0XooXoX();
    }

    public IIxOXoOo0(Oxx oxx, XI0oooXX xI0oooXX) {
        this.f11462I0Io = new I0(oxx, xI0oooXX);
    }

    public IIxOXoOo0(IIxOXoOo0 iIxOXoOo0) {
        super(iIxOXoOo0);
        this.f11462I0Io = iIxOXoOo0.f11462I0Io;
    }
}
