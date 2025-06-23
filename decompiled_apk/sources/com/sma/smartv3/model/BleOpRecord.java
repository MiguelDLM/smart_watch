package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BleOpRecord extends JsonFieldContainer {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    public static final String TYPE_AIR_PRESSURE = "1";

    @OOXIXo
    private String bleName;

    @OOXIXo
    private String mac;

    @OOXIXo
    private String markType;

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleOpRecord() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ BleOpRecord copy$default(BleOpRecord bleOpRecord, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleOpRecord.bleName;
        }
        if ((i & 2) != 0) {
            str2 = bleOpRecord.mac;
        }
        if ((i & 4) != 0) {
            str3 = bleOpRecord.markType;
        }
        return bleOpRecord.copy(str, str2, str3);
    }

    @OOXIXo
    public final String component1() {
        return this.bleName;
    }

    @OOXIXo
    public final String component2() {
        return this.mac;
    }

    @OOXIXo
    public final String component3() {
        return this.markType;
    }

    @OOXIXo
    public final BleOpRecord copy(@OOXIXo String bleName, @OOXIXo String mac, @OOXIXo String markType) {
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(mac, "mac");
        IIX0o.x0xO0oo(markType, "markType");
        return new BleOpRecord(bleName, mac, markType);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleOpRecord)) {
            return false;
        }
        BleOpRecord bleOpRecord = (BleOpRecord) obj;
        return IIX0o.Oxx0IOOO(this.bleName, bleOpRecord.bleName) && IIX0o.Oxx0IOOO(this.mac, bleOpRecord.mac) && IIX0o.Oxx0IOOO(this.markType, bleOpRecord.markType);
    }

    @OOXIXo
    public final String getBleName() {
        return this.bleName;
    }

    @OOXIXo
    public final String getMac() {
        return this.mac;
    }

    @OOXIXo
    public final String getMarkType() {
        return this.markType;
    }

    public int hashCode() {
        return (((this.bleName.hashCode() * 31) + this.mac.hashCode()) * 31) + this.markType.hashCode();
    }

    public final void setBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.bleName = str;
    }

    public final void setMac(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mac = str;
    }

    public final void setMarkType(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.markType = str;
    }

    @OOXIXo
    public String toString() {
        return "BleOpRecord(bleName=" + this.bleName + ", mac=" + this.mac + ", markType=" + this.markType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleOpRecord(String str, String str2, String str3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public BleOpRecord(@OOXIXo String bleName, @OOXIXo String mac, @OOXIXo String markType) {
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(mac, "mac");
        IIX0o.x0xO0oo(markType, "markType");
        this.bleName = bleName;
        this.mac = mac;
        this.markType = markType;
    }
}
