package com.garmin.fit;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes9.dex */
public class XXXI extends I0xX0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f13980I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f13981II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f13982oIX0oI;

    public XXXI() {
        this.f13982oIX0oI = 255;
        this.f13981II0xO0 = 0;
    }

    public int I0Io() {
        return this.f13982oIX0oI;
    }

    @Override // com.garmin.fit.I0xX0
    public void II0xO0(int i) {
        this.f13981II0xO0 = i;
    }

    public void X0o0xo(OutputStream outputStream) {
        try {
            outputStream.write(this.f13982oIX0oI);
            outputStream.write(this.f13981II0xO0);
            outputStream.write(this.f13980I0Io);
        } catch (IOException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XXXI)) {
            return false;
        }
        XXXI xxxi = (XXXI) obj;
        if (this.f13982oIX0oI == xxxi.f13982oIX0oI && this.f13981II0xO0 == xxxi.f13981II0xO0 && this.f13980I0Io == xxxi.f13980I0Io) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((47 + new Integer(this.f13982oIX0oI).hashCode()) * 31) + new Integer(this.f13981II0xO0).hashCode()) * 19) + new Integer(this.f13980I0Io).hashCode();
    }

    @Override // com.garmin.fit.I0xX0
    public int oIX0oI() {
        return this.f13981II0xO0;
    }

    public int oxoX() {
        return this.f13980I0Io;
    }

    public XXXI(X0xII0I x0xII0I) {
        this.f13982oIX0oI = x0xII0I.OooI();
        this.f13981II0xO0 = x0xII0I.xOOOX();
        this.f13980I0Io = x0xII0I.oxIIX0o();
    }
}
