package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;

/* loaded from: classes11.dex */
public final class XxXX extends JsonFieldContainer {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23512IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23513Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23514Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f23515OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23516XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f23517oI0IIXIo;

    public XxXX() {
        this(null, null, null, null, 0, 0, 63, null);
    }

    public static /* synthetic */ XxXX II0xO0(XxXX xxXX, String str, String str2, String str3, String str4, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = xxXX.f23516XO;
        }
        if ((i3 & 2) != 0) {
            str2 = xxXX.f23513Oo;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = xxXX.f23512IXxxXO;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = xxXX.f23514Oxx0xo;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            i = xxXX.f23517oI0IIXIo;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = xxXX.f23515OxxIIOOXO;
        }
        return xxXX.oIX0oI(str, str5, str6, str7, i4, i2);
    }

    @OXOo.OOXIXo
    public final String I0Io() {
        return this.f23512IXxxXO;
    }

    public final void II0XooXoX(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23514Oxx0xo = str;
    }

    public final void Oxx0IOOO(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23512IXxxXO = str;
    }

    public final int X0o0xo() {
        return this.f23515OxxIIOOXO;
    }

    @OXOo.OOXIXo
    public final String XO() {
        return this.f23516XO;
    }

    @OXOo.OOXIXo
    public final String component1() {
        return this.f23516XO;
    }

    @OXOo.OOXIXo
    public final String component2() {
        return this.f23513Oo;
    }

    @OXOo.OOXIXo
    public final String component3() {
        return this.f23512IXxxXO;
    }

    @OXOo.OOXIXo
    public final String component4() {
        return this.f23514Oxx0xo;
    }

    public final int component5() {
        return this.f23517oI0IIXIo;
    }

    public final int component6() {
        return this.f23515OxxIIOOXO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XxXX)) {
            return false;
        }
        XxXX xxXX = (XxXX) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23516XO, xxXX.f23516XO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23513Oo, xxXX.f23513Oo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23512IXxxXO, xxXX.f23512IXxxXO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23514Oxx0xo, xxXX.f23514Oxx0xo) && this.f23517oI0IIXIo == xxXX.f23517oI0IIXIo && this.f23515OxxIIOOXO == xxXX.f23515OxxIIOOXO;
    }

    @OXOo.OOXIXo
    public final String getBleName() {
        return this.f23513Oo;
    }

    public final int getFlag() {
        return this.f23517oI0IIXIo;
    }

    public int hashCode() {
        return (((((((((this.f23516XO.hashCode() * 31) + this.f23513Oo.hashCode()) * 31) + this.f23512IXxxXO.hashCode()) * 31) + this.f23514Oxx0xo.hashCode()) * 31) + this.f23517oI0IIXIo) * 31) + this.f23515OxxIIOOXO;
    }

    @OXOo.OOXIXo
    public final XxXX oIX0oI(@OXOo.OOXIXo String userPin, @OXOo.OOXIXo String bleName, @OXOo.OOXIXo String macAddress, @OXOo.OOXIXo String macAddressOld, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(userPin, "userPin");
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(macAddress, "macAddress");
        kotlin.jvm.internal.IIX0o.x0xO0oo(macAddressOld, "macAddressOld");
        return new XxXX(userPin, bleName, macAddress, macAddressOld, i, i2);
    }

    @OXOo.OOXIXo
    public final String oxoX() {
        return this.f23514Oxx0xo;
    }

    public final void setBleName(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23513Oo = str;
    }

    public final void setFlag(int i) {
        this.f23517oI0IIXIo = i;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "MacOtaToolsData(userPin=" + this.f23516XO + ", bleName=" + this.f23513Oo + ", macAddress=" + this.f23512IXxxXO + ", macAddressOld=" + this.f23514Oxx0xo + ", flag=" + this.f23517oI0IIXIo + ", state=" + this.f23515OxxIIOOXO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void xoIox(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23516XO = str;
    }

    public final void xxIXOIIO(int i) {
        this.f23515OxxIIOOXO = i;
    }

    public /* synthetic */ XxXX(String str, String str2, String str3, String str4, int i, int i2, int i3, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) == 0 ? str4 : "", (i3 & 16) != 0 ? 1 : i, (i3 & 32) != 0 ? 2 : i2);
    }

    public XxXX(@OXOo.OOXIXo String userPin, @OXOo.OOXIXo String bleName, @OXOo.OOXIXo String macAddress, @OXOo.OOXIXo String macAddressOld, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(userPin, "userPin");
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(macAddress, "macAddress");
        kotlin.jvm.internal.IIX0o.x0xO0oo(macAddressOld, "macAddressOld");
        this.f23516XO = userPin;
        this.f23513Oo = bleName;
        this.f23512IXxxXO = macAddress;
        this.f23514Oxx0xo = macAddressOld;
        this.f23517oI0IIXIo = i;
        this.f23515OxxIIOOXO = i2;
    }
}
