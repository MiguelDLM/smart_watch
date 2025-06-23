package com.garmin.fit;

import com.garmin.fit.Profile;
import java.util.ArrayList;

/* loaded from: classes9.dex */
public class X0xII0I extends XOxxooXI {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f13528I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f13529II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public ArrayList<xxOoXO> f13530OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public double f13531Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f13532X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public double f13533XO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public Profile.Type f13534oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f13535ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f13536oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public ArrayList<oXX0IoI> f13537xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f13538xxIXOIIO;

    public X0xII0I(X0xII0I x0xII0I) {
        super(x0xII0I);
        if (x0xII0I == null) {
            this.f13528I0Io = "unknown";
            this.f13536oxoX = 255;
            this.f13532X0o0xo = 0;
            this.f13534oOoXoXO = Profile.Type.ENUM;
            this.f13533XO = 1.0d;
            this.f13531Oxx0IOOO = XIXIX.OOXIXo.f3760XO;
            this.f13529II0XooXoX = "";
            this.f13538xxIXOIIO = false;
            this.f13924oIX0oI = new ArrayList<>();
            this.f13537xoIox = new ArrayList<>();
            this.f13530OOXIXo = new ArrayList<>();
            this.f13535ooOOo0oXI = false;
            return;
        }
        this.f13528I0Io = x0xII0I.f13528I0Io;
        this.f13536oxoX = x0xII0I.f13536oxoX;
        this.f13532X0o0xo = x0xII0I.f13532X0o0xo;
        this.f13534oOoXoXO = x0xII0I.f13534oOoXoXO;
        this.f13533XO = x0xII0I.f13533XO;
        this.f13531Oxx0IOOO = x0xII0I.f13531Oxx0IOOO;
        this.f13529II0XooXoX = x0xII0I.f13529II0XooXoX;
        this.f13538xxIXOIIO = x0xII0I.f13538xxIXOIIO;
        this.f13537xoIox = x0xII0I.f13537xoIox;
        this.f13530OOXIXo = x0xII0I.f13530OOXIXo;
        this.f13535ooOOo0oXI = x0xII0I.f13535ooOOo0oXI;
    }

    @Override // com.garmin.fit.XOxxooXI
    public xxOoXO IoIOOxIIo(String str) {
        for (int i = 0; i < this.f13530OOXIXo.size(); i++) {
            if (this.f13530OOXIXo.get(i).f15703oIX0oI.equals(str)) {
                return this.f13530OOXIXo.get(i);
            }
        }
        return null;
    }

    @Override // com.garmin.fit.XOxxooXI
    public double O00XxXI() {
        return this.f13533XO;
    }

    @Override // com.garmin.fit.XOxxooXI
    public String OIOoIIOIx() {
        return this.f13529II0XooXoX;
    }

    public Profile.Type OIx00oxx() {
        return this.f13534oOoXoXO;
    }

    public boolean OO0() {
        return this.f13535ooOOo0oXI;
    }

    @Override // com.garmin.fit.XOxxooXI
    public double OO0x0xX() {
        return this.f13531Oxx0IOOO;
    }

    public int OooI() {
        return this.f13536oxoX;
    }

    public boolean XoIxOXIXo() {
        return this.f13538xxIXOIIO;
    }

    @Override // com.garmin.fit.XOxxooXI
    public String oo0xXOI0I() {
        return this.f13528I0Io;
    }

    @Override // com.garmin.fit.XOxxooXI
    public int oxIIX0o() {
        return this.f13532X0o0xo;
    }

    @Override // com.garmin.fit.XOxxooXI
    public xxOoXO xI0oxI00(int i) {
        if (i >= 0 && i < this.f13530OOXIXo.size()) {
            return this.f13530OOXIXo.get(i);
        }
        return null;
    }

    public void xIXX(boolean z) {
        this.f13535ooOOo0oXI = z;
    }

    public X0xII0I(String str, int i, int i2, double d, double d2, String str2, boolean z, Profile.Type type) {
        this.f13528I0Io = str;
        this.f13536oxoX = i;
        this.f13532X0o0xo = i2;
        this.f13534oOoXoXO = type;
        this.f13533XO = d;
        this.f13531Oxx0IOOO = d2;
        this.f13529II0XooXoX = str2;
        this.f13538xxIXOIIO = z;
        this.f13537xoIox = new ArrayList<>();
        this.f13530OOXIXo = new ArrayList<>();
        this.f13535ooOOo0oXI = false;
    }
}
