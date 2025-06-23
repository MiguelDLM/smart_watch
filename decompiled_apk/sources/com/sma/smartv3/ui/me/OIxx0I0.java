package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;

/* loaded from: classes11.dex */
public final class OIxx0I0 extends JsonFieldContainer {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23405IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23406Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23407XO;

    public OIxx0I0() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ OIxx0I0 II0xO0(OIxx0I0 oIxx0I0, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oIxx0I0.f23407XO;
        }
        if ((i & 2) != 0) {
            str2 = oIxx0I0.f23406Oo;
        }
        if ((i & 4) != 0) {
            str3 = oIxx0I0.f23405IXxxXO;
        }
        return oIxx0I0.oIX0oI(str, str2, str3);
    }

    @OXOo.OOXIXo
    public final String I0Io() {
        return this.f23405IXxxXO;
    }

    @OXOo.OOXIXo
    public final String component1() {
        return this.f23407XO;
    }

    @OXOo.OOXIXo
    public final String component2() {
        return this.f23406Oo;
    }

    @OXOo.OOXIXo
    public final String component3() {
        return this.f23405IXxxXO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OIxx0I0)) {
            return false;
        }
        OIxx0I0 oIxx0I0 = (OIxx0I0) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23407XO, oIxx0I0.f23407XO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23406Oo, oIxx0I0.f23406Oo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23405IXxxXO, oIxx0I0.f23405IXxxXO);
    }

    @OXOo.OOXIXo
    public final String getBleName() {
        return this.f23407XO;
    }

    @OXOo.OOXIXo
    public final String getMac() {
        return this.f23406Oo;
    }

    public int hashCode() {
        return (((this.f23407XO.hashCode() * 31) + this.f23406Oo.hashCode()) * 31) + this.f23405IXxxXO.hashCode();
    }

    @OXOo.OOXIXo
    public final OIxx0I0 oIX0oI(@OXOo.OOXIXo String bleName, @OXOo.OOXIXo String mac, @OXOo.OOXIXo String imei) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mac, "mac");
        kotlin.jvm.internal.IIX0o.x0xO0oo(imei, "imei");
        return new OIxx0I0(bleName, mac, imei);
    }

    public final void oxoX(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23405IXxxXO = str;
    }

    public final void setBleName(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23407XO = str;
    }

    public final void setMac(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23406Oo = str;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "IMEICheckAvailableData(bleName=" + this.f23407XO + ", mac=" + this.f23406Oo + ", imei=" + this.f23405IXxxXO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ OIxx0I0(String str, String str2, String str3, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public OIxx0I0(@OXOo.OOXIXo String bleName, @OXOo.OOXIXo String mac, @OXOo.OOXIXo String imei) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mac, "mac");
        kotlin.jvm.internal.IIX0o.x0xO0oo(imei, "imei");
        this.f23407XO = bleName;
        this.f23406Oo = mac;
        this.f23405IXxxXO = imei;
    }
}
