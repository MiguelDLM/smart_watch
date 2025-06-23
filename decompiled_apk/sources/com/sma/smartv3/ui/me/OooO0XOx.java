package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes11.dex */
public final class OooO0XOx {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23423II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23424oIX0oI;

    public OooO0XOx(@OXOo.OOXIXo String title, @OXOo.OOXIXo String content) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(title, "title");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        this.f23424oIX0oI = title;
        this.f23423II0xO0 = content;
    }

    public static /* synthetic */ OooO0XOx oxoX(OooO0XOx oooO0XOx, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oooO0XOx.f23424oIX0oI;
        }
        if ((i & 2) != 0) {
            str2 = oooO0XOx.f23423II0xO0;
        }
        return oooO0XOx.I0Io(str, str2);
    }

    @OXOo.OOXIXo
    public final OooO0XOx I0Io(@OXOo.OOXIXo String title, @OXOo.OOXIXo String content) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(title, "title");
        kotlin.jvm.internal.IIX0o.x0xO0oo(content, "content");
        return new OooO0XOx(title, content);
    }

    public final void II0XooXoX(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23424oIX0oI = str;
    }

    @OXOo.OOXIXo
    public final String II0xO0() {
        return this.f23423II0xO0;
    }

    public final void Oxx0IOOO(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23423II0xO0 = str;
    }

    @OXOo.OOXIXo
    public final String X0o0xo() {
        return this.f23423II0xO0;
    }

    @OXOo.OOXIXo
    public final String XO() {
        return this.f23424oIX0oI;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OooO0XOx)) {
            return false;
        }
        OooO0XOx oooO0XOx = (OooO0XOx) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23424oIX0oI, oooO0XOx.f23424oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23423II0xO0, oooO0XOx.f23423II0xO0);
    }

    public int hashCode() {
        return (this.f23424oIX0oI.hashCode() * 31) + this.f23423II0xO0.hashCode();
    }

    @OXOo.OOXIXo
    public final String oIX0oI() {
        return this.f23424oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "Item(title=" + this.f23424oIX0oI + ", content=" + this.f23423II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }
}
