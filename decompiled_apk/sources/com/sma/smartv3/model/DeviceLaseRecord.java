package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class DeviceLaseRecord {

    @OOXIXo
    private String bleName;

    @OOXIXo
    private String bleVersion;

    @OOXIXo
    private String flag;

    @OOXIXo
    private String mac;

    public DeviceLaseRecord() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DeviceLaseRecord copy$default(DeviceLaseRecord deviceLaseRecord, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceLaseRecord.bleName;
        }
        if ((i & 2) != 0) {
            str2 = deviceLaseRecord.flag;
        }
        if ((i & 4) != 0) {
            str3 = deviceLaseRecord.bleVersion;
        }
        if ((i & 8) != 0) {
            str4 = deviceLaseRecord.mac;
        }
        return deviceLaseRecord.copy(str, str2, str3, str4);
    }

    @OOXIXo
    public final String component1() {
        return this.bleName;
    }

    @OOXIXo
    public final String component2() {
        return this.flag;
    }

    @OOXIXo
    public final String component3() {
        return this.bleVersion;
    }

    @OOXIXo
    public final String component4() {
        return this.mac;
    }

    @OOXIXo
    public final DeviceLaseRecord copy(@OOXIXo String bleName, @OOXIXo String flag, @OOXIXo String bleVersion, @OOXIXo String mac) {
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(flag, "flag");
        IIX0o.x0xO0oo(bleVersion, "bleVersion");
        IIX0o.x0xO0oo(mac, "mac");
        return new DeviceLaseRecord(bleName, flag, bleVersion, mac);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceLaseRecord)) {
            return false;
        }
        DeviceLaseRecord deviceLaseRecord = (DeviceLaseRecord) obj;
        return IIX0o.Oxx0IOOO(this.bleName, deviceLaseRecord.bleName) && IIX0o.Oxx0IOOO(this.flag, deviceLaseRecord.flag) && IIX0o.Oxx0IOOO(this.bleVersion, deviceLaseRecord.bleVersion) && IIX0o.Oxx0IOOO(this.mac, deviceLaseRecord.mac);
    }

    @OOXIXo
    public final String getBleName() {
        return this.bleName;
    }

    @OOXIXo
    public final String getBleVersion() {
        return this.bleVersion;
    }

    @OOXIXo
    public final String getFlag() {
        return this.flag;
    }

    @OOXIXo
    public final String getMac() {
        return this.mac;
    }

    public int hashCode() {
        return (((((this.bleName.hashCode() * 31) + this.flag.hashCode()) * 31) + this.bleVersion.hashCode()) * 31) + this.mac.hashCode();
    }

    public final void setBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.bleName = str;
    }

    public final void setBleVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.bleVersion = str;
    }

    public final void setFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.flag = str;
    }

    public final void setMac(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mac = str;
    }

    @OOXIXo
    public String toString() {
        return "DeviceLaseRecord(bleName=" + this.bleName + ", flag=" + this.flag + ", bleVersion=" + this.bleVersion + ", mac=" + this.mac + HexStringBuilder.COMMENT_END_CHAR;
    }

    public DeviceLaseRecord(@OOXIXo String bleName, @OOXIXo String flag, @OOXIXo String bleVersion, @OOXIXo String mac) {
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(flag, "flag");
        IIX0o.x0xO0oo(bleVersion, "bleVersion");
        IIX0o.x0xO0oo(mac, "mac");
        this.bleName = bleName;
        this.flag = flag;
        this.bleVersion = bleVersion;
        this.mac = mac;
    }

    public /* synthetic */ DeviceLaseRecord(String str, String str2, String str3, String str4, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
