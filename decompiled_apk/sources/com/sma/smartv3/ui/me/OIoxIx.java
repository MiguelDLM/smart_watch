package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;

/* loaded from: classes11.dex */
public final class OIoxIx extends JsonFieldContainer {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23397IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23398Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23399Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23400OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23401XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23402oI0IIXIo;

    public OIoxIx() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ OIoxIx II0xO0(OIoxIx oIoxIx, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oIoxIx.f23401XO;
        }
        if ((i & 2) != 0) {
            str2 = oIoxIx.f23398Oo;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = oIoxIx.f23397IXxxXO;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = oIoxIx.f23399Oxx0xo;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = oIoxIx.f23402oI0IIXIo;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = oIoxIx.f23400OxxIIOOXO;
        }
        return oIoxIx.oIX0oI(str, str7, str8, str9, str10, str6);
    }

    @OXOo.OOXIXo
    public final String I0Io() {
        return this.f23400OxxIIOOXO;
    }

    public final void II0XooXoX(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23402oI0IIXIo = str;
    }

    public final void Oxx0IOOO(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23400OxxIIOOXO = str;
    }

    @OXOo.OOXIXo
    public final String X0o0xo() {
        return this.f23399Oxx0xo;
    }

    @OXOo.OOXIXo
    public final String XO() {
        return this.f23397IXxxXO;
    }

    @OXOo.OOXIXo
    public final String component1() {
        return this.f23401XO;
    }

    @OXOo.OOXIXo
    public final String component2() {
        return this.f23398Oo;
    }

    @OXOo.OOXIXo
    public final String component3() {
        return this.f23397IXxxXO;
    }

    @OXOo.OOXIXo
    public final String component4() {
        return this.f23399Oxx0xo;
    }

    @OXOo.OOXIXo
    public final String component5() {
        return this.f23402oI0IIXIo;
    }

    @OXOo.OOXIXo
    public final String component6() {
        return this.f23400OxxIIOOXO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OIoxIx)) {
            return false;
        }
        OIoxIx oIoxIx = (OIoxIx) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23401XO, oIoxIx.f23401XO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23398Oo, oIoxIx.f23398Oo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23397IXxxXO, oIoxIx.f23397IXxxXO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23399Oxx0xo, oIoxIx.f23399Oxx0xo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23402oI0IIXIo, oIoxIx.f23402oI0IIXIo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23400OxxIIOOXO, oIoxIx.f23400OxxIIOOXO);
    }

    @OXOo.OOXIXo
    public final String getBleName() {
        return this.f23401XO;
    }

    @OXOo.OOXIXo
    public final String getMac() {
        return this.f23398Oo;
    }

    public int hashCode() {
        return (((((((((this.f23401XO.hashCode() * 31) + this.f23398Oo.hashCode()) * 31) + this.f23397IXxxXO.hashCode()) * 31) + this.f23399Oxx0xo.hashCode()) * 31) + this.f23402oI0IIXIo.hashCode()) * 31) + this.f23400OxxIIOOXO.hashCode();
    }

    @OXOo.OOXIXo
    public final OIoxIx oIX0oI(@OXOo.OOXIXo String bleName, @OXOo.OOXIXo String mac, @OXOo.OOXIXo String uuid, @OXOo.OOXIXo String tuYaKey, @OXOo.OOXIXo String sn, @OXOo.OOXIXo String macOld) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mac, "mac");
        kotlin.jvm.internal.IIX0o.x0xO0oo(uuid, "uuid");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tuYaKey, "tuYaKey");
        kotlin.jvm.internal.IIX0o.x0xO0oo(sn, "sn");
        kotlin.jvm.internal.IIX0o.x0xO0oo(macOld, "macOld");
        return new OIoxIx(bleName, mac, uuid, tuYaKey, sn, macOld);
    }

    @OXOo.OOXIXo
    public final String oxoX() {
        return this.f23402oI0IIXIo;
    }

    public final void setBleName(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23401XO = str;
    }

    public final void setMac(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23398Oo = str;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "TuyaKeyCheckAvailableData(bleName=" + this.f23401XO + ", mac=" + this.f23398Oo + ", uuid=" + this.f23397IXxxXO + ", tuYaKey=" + this.f23399Oxx0xo + ", sn=" + this.f23402oI0IIXIo + ", macOld=" + this.f23400OxxIIOOXO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void xoIox(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23397IXxxXO = str;
    }

    public final void xxIXOIIO(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23399Oxx0xo = str;
    }

    public /* synthetic */ OIoxIx(String str, String str2, String str3, String str4, String str5, String str6, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6);
    }

    public OIoxIx(@OXOo.OOXIXo String bleName, @OXOo.OOXIXo String mac, @OXOo.OOXIXo String uuid, @OXOo.OOXIXo String tuYaKey, @OXOo.OOXIXo String sn, @OXOo.OOXIXo String macOld) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mac, "mac");
        kotlin.jvm.internal.IIX0o.x0xO0oo(uuid, "uuid");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tuYaKey, "tuYaKey");
        kotlin.jvm.internal.IIX0o.x0xO0oo(sn, "sn");
        kotlin.jvm.internal.IIX0o.x0xO0oo(macOld, "macOld");
        this.f23401XO = bleName;
        this.f23398Oo = mac;
        this.f23397IXxxXO = uuid;
        this.f23399Oxx0xo = tuYaKey;
        this.f23402oI0IIXIo = sn;
        this.f23400OxxIIOOXO = macOld;
    }
}
