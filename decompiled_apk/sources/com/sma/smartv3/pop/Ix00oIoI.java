package com.sma.smartv3.pop;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes12.dex */
public final class Ix00oIoI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f21296II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f21297oIX0oI;

    public Ix00oIoI(int i, int i2) {
        this.f21297oIX0oI = i;
        this.f21296II0xO0 = i2;
    }

    public static /* synthetic */ Ix00oIoI oxoX(Ix00oIoI ix00oIoI, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ix00oIoI.f21297oIX0oI;
        }
        if ((i3 & 2) != 0) {
            i2 = ix00oIoI.f21296II0xO0;
        }
        return ix00oIoI.I0Io(i, i2);
    }

    @OXOo.OOXIXo
    public final Ix00oIoI I0Io(int i, int i2) {
        return new Ix00oIoI(i, i2);
    }

    public final void II0XooXoX(int i) {
        this.f21297oIX0oI = i;
    }

    public final int II0xO0() {
        return this.f21296II0xO0;
    }

    public final void Oxx0IOOO(int i) {
        this.f21296II0xO0 = i;
    }

    public final int X0o0xo() {
        return this.f21296II0xO0;
    }

    public final int XO() {
        return this.f21297oIX0oI;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ix00oIoI)) {
            return false;
        }
        Ix00oIoI ix00oIoI = (Ix00oIoI) obj;
        return this.f21297oIX0oI == ix00oIoI.f21297oIX0oI && this.f21296II0xO0 == ix00oIoI.f21296II0xO0;
    }

    public int hashCode() {
        return (this.f21297oIX0oI * 31) + this.f21296II0xO0;
    }

    public final int oIX0oI() {
        return this.f21297oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "SingleChoiceItem(title=" + this.f21297oIX0oI + ", subTitle=" + this.f21296II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }
}
