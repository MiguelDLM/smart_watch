package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;

/* loaded from: classes11.dex */
public final class IxI extends JsonFieldContainer {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23364IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23365Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23366Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23367OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public int f23368XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23369oI0IIXIo;

    public IxI() {
        this(0, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ IxI II0xO0(IxI ixI, int i, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ixI.f23368XO;
        }
        if ((i2 & 2) != 0) {
            str = ixI.f23365Oo;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = ixI.f23364IXxxXO;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = ixI.f23366Oxx0xo;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = ixI.f23369oI0IIXIo;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = ixI.f23367OxxIIOOXO;
        }
        return ixI.oIX0oI(i, str6, str7, str8, str9, str5);
    }

    @OXOo.OOXIXo
    public final String I0Io() {
        return this.f23369oI0IIXIo;
    }

    public final void X0o0xo(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23369oI0IIXIo = str;
    }

    public final void XO(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23366Oxx0xo = str;
    }

    public final int component1() {
        return this.f23368XO;
    }

    @OXOo.OOXIXo
    public final String component2() {
        return this.f23365Oo;
    }

    @OXOo.OOXIXo
    public final String component3() {
        return this.f23364IXxxXO;
    }

    @OXOo.OOXIXo
    public final String component4() {
        return this.f23366Oxx0xo;
    }

    @OXOo.OOXIXo
    public final String component5() {
        return this.f23369oI0IIXIo;
    }

    @OXOo.OOXIXo
    public final String component6() {
        return this.f23367OxxIIOOXO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IxI)) {
            return false;
        }
        IxI ixI = (IxI) obj;
        return this.f23368XO == ixI.f23368XO && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23365Oo, ixI.f23365Oo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23364IXxxXO, ixI.f23364IXxxXO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23366Oxx0xo, ixI.f23366Oxx0xo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23369oI0IIXIo, ixI.f23369oI0IIXIo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23367OxxIIOOXO, ixI.f23367OxxIIOOXO);
    }

    @OXOo.OOXIXo
    public final String getBleName() {
        return this.f23365Oo;
    }

    public final int getId() {
        return this.f23368XO;
    }

    @OXOo.OOXIXo
    public final String getInfo() {
        return this.f23367OxxIIOOXO;
    }

    @OXOo.OOXIXo
    public final String getMac() {
        return this.f23364IXxxXO;
    }

    public int hashCode() {
        return (((((((((this.f23368XO * 31) + this.f23365Oo.hashCode()) * 31) + this.f23364IXxxXO.hashCode()) * 31) + this.f23366Oxx0xo.hashCode()) * 31) + this.f23369oI0IIXIo.hashCode()) * 31) + this.f23367OxxIIOOXO.hashCode();
    }

    @OXOo.OOXIXo
    public final IxI oIX0oI(int i, @OXOo.OOXIXo String bleName, @OXOo.OOXIXo String mac, @OXOo.OOXIXo String uuid, @OXOo.OOXIXo String tuYaKey, @OXOo.OOXIXo String info) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mac, "mac");
        kotlin.jvm.internal.IIX0o.x0xO0oo(uuid, "uuid");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tuYaKey, "tuYaKey");
        kotlin.jvm.internal.IIX0o.x0xO0oo(info, "info");
        return new IxI(i, bleName, mac, uuid, tuYaKey, info);
    }

    @OXOo.OOXIXo
    public final String oxoX() {
        return this.f23366Oxx0xo;
    }

    public final void setBleName(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23365Oo = str;
    }

    public final void setId(int i) {
        this.f23368XO = i;
    }

    public final void setInfo(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23367OxxIIOOXO = str;
    }

    public final void setMac(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23364IXxxXO = str;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "TuyaData(id=" + this.f23368XO + ", bleName=" + this.f23365Oo + ", mac=" + this.f23364IXxxXO + ", uuid=" + this.f23366Oxx0xo + ", tuYaKey=" + this.f23369oI0IIXIo + ", info=" + this.f23367OxxIIOOXO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ IxI(int i, String str, String str2, String str3, String str4, String str5, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) == 0 ? str5 : "");
    }

    public IxI(int i, @OXOo.OOXIXo String bleName, @OXOo.OOXIXo String mac, @OXOo.OOXIXo String uuid, @OXOo.OOXIXo String tuYaKey, @OXOo.OOXIXo String info) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mac, "mac");
        kotlin.jvm.internal.IIX0o.x0xO0oo(uuid, "uuid");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tuYaKey, "tuYaKey");
        kotlin.jvm.internal.IIX0o.x0xO0oo(info, "info");
        this.f23368XO = i;
        this.f23365Oo = bleName;
        this.f23364IXxxXO = mac;
        this.f23366Oxx0xo = uuid;
        this.f23369oI0IIXIo = tuYaKey;
        this.f23367OxxIIOOXO = info;
    }
}
