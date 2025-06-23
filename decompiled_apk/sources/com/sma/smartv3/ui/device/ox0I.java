package com.sma.smartv3.ui.device;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes12.dex */
public final class ox0I {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f22762I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final String f22763II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final String f22764oIX0oI;

    public ox0I(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.OOXIXo String title) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(title, "title");
        this.f22764oIX0oI = str;
        this.f22763II0xO0 = str2;
        this.f22762I0Io = title;
    }

    public static /* synthetic */ ox0I X0o0xo(ox0I ox0i, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ox0i.f22764oIX0oI;
        }
        if ((i & 2) != 0) {
            str2 = ox0i.f22763II0xO0;
        }
        if ((i & 4) != 0) {
            str3 = ox0i.f22762I0Io;
        }
        return ox0i.oxoX(str, str2, str3);
    }

    @OXOo.OOXIXo
    public final String I0Io() {
        return this.f22762I0Io;
    }

    @OXOo.oOoXoXO
    public final String II0XooXoX() {
        return this.f22764oIX0oI;
    }

    @OXOo.oOoXoXO
    public final String II0xO0() {
        return this.f22763II0xO0;
    }

    @OXOo.oOoXoXO
    public final String Oxx0IOOO() {
        return this.f22763II0xO0;
    }

    @OXOo.OOXIXo
    public final String XO() {
        return this.f22762I0Io;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ox0I)) {
            return false;
        }
        ox0I ox0i = (ox0I) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f22764oIX0oI, ox0i.f22764oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f22763II0xO0, ox0i.f22763II0xO0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f22762I0Io, ox0i.f22762I0Io);
    }

    public int hashCode() {
        String str = this.f22764oIX0oI;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f22763II0xO0;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f22762I0Io.hashCode();
    }

    @OXOo.oOoXoXO
    public final String oIX0oI() {
        return this.f22764oIX0oI;
    }

    @OXOo.OOXIXo
    public final ox0I oxoX(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.OOXIXo String title) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(title, "title");
        return new ox0I(str, str2, title);
    }

    @OXOo.OOXIXo
    public String toString() {
        return "TransferFile(url=" + this.f22764oIX0oI + ", uri=" + this.f22763II0xO0 + ", title=" + this.f22762I0Io + HexStringBuilder.COMMENT_END_CHAR;
    }
}
