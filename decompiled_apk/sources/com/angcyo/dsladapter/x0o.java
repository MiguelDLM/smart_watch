package com.angcyo.dsladapter;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes7.dex */
public final class x0o {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f5449I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f5450II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f5451X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f5452XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f5453oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f5454oxoX;

    public x0o() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ x0o II0XooXoX(x0o x0oVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = x0oVar.f5453oIX0oI;
        }
        if ((i7 & 2) != 0) {
            i2 = x0oVar.f5450II0xO0;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = x0oVar.f5449I0Io;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = x0oVar.f5454oxoX;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = x0oVar.f5451X0o0xo;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = x0oVar.f5452XO;
        }
        return x0oVar.Oxx0IOOO(i, i8, i9, i10, i11, i6);
    }

    public final int I0Io() {
        return this.f5449I0Io;
    }

    public final int II0xO0() {
        return this.f5450II0xO0;
    }

    public final void IXxxXO(int i) {
        this.f5454oxoX = i;
    }

    public final int OOXIXo() {
        return this.f5453oIX0oI;
    }

    public final void Oo(int i) {
        this.f5453oIX0oI = i;
    }

    @OXOo.OOXIXo
    public final x0o Oxx0IOOO(int i, int i2, int i3, int i4, int i5, int i6) {
        return new x0o(i, i2, i3, i4, i5, i6);
    }

    public final void Oxx0xo(int i) {
        this.f5451X0o0xo = i;
    }

    public final int X0o0xo() {
        return this.f5451X0o0xo;
    }

    public final int XO() {
        return this.f5452XO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0o)) {
            return false;
        }
        x0o x0oVar = (x0o) obj;
        return this.f5453oIX0oI == x0oVar.f5453oIX0oI && this.f5450II0xO0 == x0oVar.f5450II0xO0 && this.f5449I0Io == x0oVar.f5449I0Io && this.f5454oxoX == x0oVar.f5454oxoX && this.f5451X0o0xo == x0oVar.f5451X0o0xo && this.f5452XO == x0oVar.f5452XO;
    }

    public int hashCode() {
        return (((((((((this.f5453oIX0oI * 31) + this.f5450II0xO0) * 31) + this.f5449I0Io) * 31) + this.f5454oxoX) * 31) + this.f5451X0o0xo) * 31) + this.f5452XO;
    }

    public final void oI0IIXIo(int i) {
        this.f5452XO = i;
    }

    public final int oIX0oI() {
        return this.f5453oIX0oI;
    }

    public final void oO(int i) {
        this.f5449I0Io = i;
    }

    public final int oOoXoXO() {
        return this.f5454oxoX;
    }

    public final int ooOOo0oXI() {
        return this.f5451X0o0xo;
    }

    public final int oxoX() {
        return this.f5454oxoX;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "SpanParams(spanCount=" + this.f5453oIX0oI + ", itemPosition=" + this.f5450II0xO0 + ", indexInGroup=" + this.f5449I0Io + ", spanGroupIndex=" + this.f5454oxoX + ", spanIndex=" + this.f5451X0o0xo + ", spanSize=" + this.f5452XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final int x0XOIxOo() {
        return this.f5452XO;
    }

    public final void x0xO0oo(int i) {
        this.f5450II0xO0 = i;
    }

    public final int xoIox() {
        return this.f5450II0xO0;
    }

    public final int xxIXOIIO() {
        return this.f5449I0Io;
    }

    public x0o(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f5453oIX0oI = i;
        this.f5450II0xO0 = i2;
        this.f5449I0Io = i3;
        this.f5454oxoX = i4;
        this.f5451X0o0xo = i5;
        this.f5452XO = i6;
    }

    public /* synthetic */ x0o(int i, int i2, int i3, int i4, int i5, int i6, int i7, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 1 : i, (i7 & 2) != 0 ? -1 : i2, (i7 & 4) != 0 ? -1 : i3, (i7 & 8) != 0 ? -1 : i4, (i7 & 16) != 0 ? -1 : i5, (i7 & 32) == 0 ? i6 : -1);
    }
}
