package com.sma.smartv3.util;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes12.dex */
public final class IIX0o {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f24248I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f24249II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f24250oIX0oI;

    public IIX0o(int i, int i2, int i3) {
        this.f24250oIX0oI = i;
        this.f24249II0xO0 = i2;
        this.f24248I0Io = i3;
    }

    public static /* synthetic */ IIX0o X0o0xo(IIX0o iIX0o, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = iIX0o.f24250oIX0oI;
        }
        if ((i4 & 2) != 0) {
            i2 = iIX0o.f24249II0xO0;
        }
        if ((i4 & 4) != 0) {
            i3 = iIX0o.f24248I0Io;
        }
        return iIX0o.oxoX(i, i2, i3);
    }

    public final int I0Io() {
        return this.f24248I0Io;
    }

    public final int II0XooXoX() {
        return this.f24250oIX0oI;
    }

    public final int II0xO0() {
        return this.f24249II0xO0;
    }

    public final int Oxx0IOOO() {
        return this.f24249II0xO0;
    }

    public final int XO() {
        return this.f24248I0Io;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IIX0o)) {
            return false;
        }
        IIX0o iIX0o = (IIX0o) obj;
        return this.f24250oIX0oI == iIX0o.f24250oIX0oI && this.f24249II0xO0 == iIX0o.f24249II0xO0 && this.f24248I0Io == iIX0o.f24248I0Io;
    }

    public int hashCode() {
        return (((this.f24250oIX0oI * 31) + this.f24249II0xO0) * 31) + this.f24248I0Io;
    }

    public final int oIX0oI() {
        return this.f24250oIX0oI;
    }

    @OXOo.OOXIXo
    public final IIX0o oxoX(int i, int i2, int i3) {
        return new IIX0o(i, i2, i3);
    }

    @OXOo.OOXIXo
    public String toString() {
        return "HijrahDate(year=" + this.f24250oIX0oI + ", month=" + this.f24249II0xO0 + ", day=" + this.f24248I0Io + HexStringBuilder.COMMENT_END_CHAR;
    }
}
