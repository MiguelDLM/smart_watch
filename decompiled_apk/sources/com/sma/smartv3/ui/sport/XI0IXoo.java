package com.sma.smartv3.ui.sport;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes12.dex */
public final class XI0IXoo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f23886II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f23887oIX0oI;

    public XI0IXoo(int i, int i2) {
        this.f23887oIX0oI = i;
        this.f23886II0xO0 = i2;
    }

    public static /* synthetic */ XI0IXoo oxoX(XI0IXoo xI0IXoo, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = xI0IXoo.f23887oIX0oI;
        }
        if ((i3 & 2) != 0) {
            i2 = xI0IXoo.f23886II0xO0;
        }
        return xI0IXoo.I0Io(i, i2);
    }

    @OXOo.OOXIXo
    public final XI0IXoo I0Io(int i, int i2) {
        return new XI0IXoo(i, i2);
    }

    public final void II0XooXoX(int i) {
        this.f23887oIX0oI = i;
    }

    public final int II0xO0() {
        return this.f23886II0xO0;
    }

    public final void Oxx0IOOO(int i) {
        this.f23886II0xO0 = i;
    }

    public final int X0o0xo() {
        return this.f23886II0xO0;
    }

    public final int XO() {
        return this.f23887oIX0oI;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XI0IXoo)) {
            return false;
        }
        XI0IXoo xI0IXoo = (XI0IXoo) obj;
        return this.f23887oIX0oI == xI0IXoo.f23887oIX0oI && this.f23886II0xO0 == xI0IXoo.f23886II0xO0;
    }

    public int hashCode() {
        return (this.f23887oIX0oI * 31) + this.f23886II0xO0;
    }

    public final int oIX0oI() {
        return this.f23887oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "MinuteData(total=" + this.f23887oIX0oI + ", num=" + this.f23886II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }
}
