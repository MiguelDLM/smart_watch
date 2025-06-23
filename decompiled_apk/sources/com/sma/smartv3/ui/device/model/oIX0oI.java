package com.sma.smartv3.ui.device.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public String f22709II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public String f22710oIX0oI;

    public oIX0oI(@OOXIXo String title, @OOXIXo String size) {
        IIX0o.x0xO0oo(title, "title");
        IIX0o.x0xO0oo(size, "size");
        this.f22710oIX0oI = title;
        this.f22709II0xO0 = size;
    }

    public static /* synthetic */ oIX0oI oxoX(oIX0oI oix0oi, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oix0oi.f22710oIX0oI;
        }
        if ((i & 2) != 0) {
            str2 = oix0oi.f22709II0xO0;
        }
        return oix0oi.I0Io(str, str2);
    }

    @OOXIXo
    public final oIX0oI I0Io(@OOXIXo String title, @OOXIXo String size) {
        IIX0o.x0xO0oo(title, "title");
        IIX0o.x0xO0oo(size, "size");
        return new oIX0oI(title, size);
    }

    public final void II0XooXoX(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f22710oIX0oI = str;
    }

    @OOXIXo
    public final String II0xO0() {
        return this.f22709II0xO0;
    }

    public final void Oxx0IOOO(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f22709II0xO0 = str;
    }

    @OOXIXo
    public final String X0o0xo() {
        return this.f22709II0xO0;
    }

    @OOXIXo
    public final String XO() {
        return this.f22710oIX0oI;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oIX0oI)) {
            return false;
        }
        oIX0oI oix0oi = (oIX0oI) obj;
        return IIX0o.Oxx0IOOO(this.f22710oIX0oI, oix0oi.f22710oIX0oI) && IIX0o.Oxx0IOOO(this.f22709II0xO0, oix0oi.f22709II0xO0);
    }

    public int hashCode() {
        return (this.f22710oIX0oI.hashCode() * 31) + this.f22709II0xO0.hashCode();
    }

    @OOXIXo
    public final String oIX0oI() {
        return this.f22710oIX0oI;
    }

    @OOXIXo
    public String toString() {
        return "ResourceRenewalData(title=" + this.f22710oIX0oI + ", size=" + this.f22709II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }
}
