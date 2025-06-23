package com.univocity.parsers.common;

import java.util.Arrays;

/* loaded from: classes13.dex */
public class x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final x0oox0.II0xO0[] f27094I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f27095II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String[] f27096II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int[] f27097OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public x0oox0.II0xO0 f27098Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final boolean f27099X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final String f27100XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f27101oIX0oI = 0;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public long f27102oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public String[] f27103ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final oxoX<?> f27104oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public String[] f27105xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f27106xxIXOIIO;

    public x0XOIxOo(oxoX<?> oxox) {
        this.f27098Oxx0IOOO = oxox.x0o();
        this.f27096II0xO0 = new String[oxox.x0XOIxOo()];
        x0oox0.II0xO0[] iI0xO0Arr = new x0oox0.II0xO0[oxox.x0XOIxOo()];
        this.f27094I0Io = iI0xO0Arr;
        Arrays.fill(iI0xO0Arr, this.f27098Oxx0IOOO);
        this.f27104oxoX = oxox;
        this.f27099X0o0xo = oxox.Oo();
        this.f27100XO = oxox.oO();
        this.f27095II0XooXoX = false;
        this.f27102oOoXoXO = 0L;
    }

    public int I0Io() {
        return this.f27101oIX0oI;
    }

    public void II0XooXoX() {
        this.f27095II0XooXoX = true;
        this.f27106xxIXOIIO = false;
        this.f27097OOXIXo = null;
        x0oox0.II0xO0 x0o2 = this.f27104oxoX.x0o();
        this.f27098Oxx0IOOO = x0o2;
        Arrays.fill(this.f27094I0Io, x0o2);
        String[] xoIox2 = this.f27104oxoX.xoIox();
        this.f27105xoIox = xoIox2;
        if (xoIox2 != null) {
            String[] strArr = (String[]) xoIox2.clone();
            this.f27105xoIox = strArr;
            Oxx0IOOO(strArr);
            return;
        }
        int i = this.f27101oIX0oI;
        if (i > 0) {
            Oxx0IOOO((String[]) Arrays.copyOf(this.f27096II0xO0, i));
            int i2 = this.f27101oIX0oI;
            String[] strArr2 = new String[i2];
            this.f27103ooOOo0oXI = strArr2;
            System.arraycopy(this.f27096II0xO0, 0, strArr2, 0, i2);
            if (this.f27104oxoX.IO()) {
                this.f27105xoIox = (String[]) this.f27103ooOOo0oXI.clone();
            }
        }
    }

    public void II0xO0() {
        String[] strArr = this.f27096II0xO0;
        int i = this.f27101oIX0oI;
        int i2 = i + 1;
        this.f27101oIX0oI = i2;
        strArr[i] = this.f27100XO;
        this.f27098Oxx0IOOO = this.f27094I0Io[i2];
    }

    public String[] OOXIXo() {
        if (this.f27101oIX0oI > 0) {
            if (!this.f27095II0XooXoX) {
                II0XooXoX();
                if (this.f27104oxoX.IO()) {
                    Arrays.fill(this.f27096II0xO0, (Object) null);
                    this.f27101oIX0oI = 0;
                    this.f27098Oxx0IOOO = this.f27094I0Io[0];
                    return null;
                }
            }
            this.f27102oOoXoXO++;
            if (this.f27106xxIXOIIO) {
                String[] strArr = new String[this.f27097OOXIXo.length];
                int i = 0;
                while (true) {
                    int[] iArr = this.f27097OOXIXo;
                    if (i < iArr.length) {
                        int i2 = iArr[i];
                        if (i2 >= this.f27101oIX0oI) {
                            strArr[i] = this.f27100XO;
                        } else {
                            strArr[i] = this.f27096II0xO0[i2];
                        }
                        i++;
                    } else {
                        this.f27101oIX0oI = 0;
                        this.f27098Oxx0IOOO = this.f27094I0Io[0];
                        return strArr;
                    }
                }
            } else {
                int i3 = this.f27101oIX0oI;
                String[] strArr2 = new String[i3];
                System.arraycopy(this.f27096II0xO0, 0, strArr2, 0, i3);
                this.f27101oIX0oI = 0;
                this.f27098Oxx0IOOO = this.f27094I0Io[0];
                return strArr2;
            }
        } else {
            if (this.f27099X0o0xo) {
                return null;
            }
            if (!this.f27095II0XooXoX) {
                II0XooXoX();
            }
            this.f27102oOoXoXO++;
            if (this.f27106xxIXOIIO) {
                String[] strArr3 = new String[this.f27097OOXIXo.length];
                Arrays.fill(strArr3, this.f27100XO);
                return strArr3;
            }
            return I0Io.f27012oIX0oI;
        }
    }

    public final void Oxx0IOOO(String[] strArr) {
        OXIOoo0X0.xoIox Oxx0IOOO2 = this.f27104oxoX.Oxx0IOOO();
        if (Oxx0IOOO2 != null) {
            int[] II0xO02 = Oxx0IOOO2.II0xO0(strArr);
            this.f27097OOXIXo = II0xO02;
            if (II0xO02 != null) {
                Arrays.fill(this.f27094I0Io, x0oox0.xxIXOIIO.OOXIXo());
                int i = 0;
                while (true) {
                    int[] iArr = this.f27097OOXIXo;
                    if (i >= iArr.length) {
                        break;
                    }
                    this.f27094I0Io[iArr[i]] = this.f27098Oxx0IOOO;
                    i++;
                }
                boolean Xx000oIo2 = this.f27104oxoX.Xx000oIo();
                this.f27106xxIXOIIO = Xx000oIo2;
                if (!Xx000oIo2) {
                    int length = strArr.length;
                    x0oox0.II0xO0[] iI0xO0Arr = this.f27094I0Io;
                    if (length < iI0xO0Arr.length) {
                        Arrays.fill(iI0xO0Arr, strArr.length, iI0xO0Arr.length, this.f27098Oxx0IOOO);
                    }
                }
            }
        }
    }

    public String[] X0o0xo() {
        return this.f27105xoIox;
    }

    public int[] XO() {
        return this.f27097OOXIXo;
    }

    public final void oIX0oI() {
        this.f27101oIX0oI = 0;
        this.f27098Oxx0IOOO = this.f27094I0Io[0];
    }

    public void oOoXoXO() {
        String[] strArr = this.f27096II0xO0;
        int i = this.f27101oIX0oI;
        this.f27101oIX0oI = i + 1;
        strArr[i] = this.f27098Oxx0IOOO.II0XooXoX();
        this.f27098Oxx0IOOO = this.f27094I0Io[this.f27101oIX0oI];
    }

    public long oxoX() {
        return this.f27102oOoXoXO;
    }

    public final void xoIox() {
        this.f27095II0XooXoX = false;
        this.f27102oOoXoXO = 0L;
        this.f27101oIX0oI = 0;
        this.f27105xoIox = null;
    }

    public boolean xxIXOIIO() {
        return this.f27106xxIXOIIO;
    }
}
