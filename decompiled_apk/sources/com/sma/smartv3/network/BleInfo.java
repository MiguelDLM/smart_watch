package com.sma.smartv3.network;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BleInfo {

    @OOXIXo
    private String bleName;

    @OOXIXo
    private String bleVersion;

    @OOXIXo
    private String flag;

    @OOXIXo
    private String mac;

    @OOXIXo
    private String pVersion;
    private int phoneOs;

    @OOXIXo
    private String pid;

    @OOXIXo
    private String uid;

    public BleInfo() {
        this(null, null, null, null, null, null, null, 0, 255, null);
    }

    @OOXIXo
    public final String component1() {
        return this.uid;
    }

    @OOXIXo
    public final String component2() {
        return this.bleName;
    }

    @OOXIXo
    public final String component3() {
        return this.flag;
    }

    @OOXIXo
    public final String component4() {
        return this.pid;
    }

    @OOXIXo
    public final String component5() {
        return this.bleVersion;
    }

    @OOXIXo
    public final String component6() {
        return this.pVersion;
    }

    @OOXIXo
    public final String component7() {
        return this.mac;
    }

    public final int component8() {
        return this.phoneOs;
    }

    @OOXIXo
    public final BleInfo copy(@OOXIXo String uid, @OOXIXo String bleName, @OOXIXo String flag, @OOXIXo String pid, @OOXIXo String bleVersion, @OOXIXo String pVersion, @OOXIXo String mac, int i) {
        IIX0o.x0xO0oo(uid, "uid");
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(flag, "flag");
        IIX0o.x0xO0oo(pid, "pid");
        IIX0o.x0xO0oo(bleVersion, "bleVersion");
        IIX0o.x0xO0oo(pVersion, "pVersion");
        IIX0o.x0xO0oo(mac, "mac");
        return new BleInfo(uid, bleName, flag, pid, bleVersion, pVersion, mac, i);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleInfo)) {
            return false;
        }
        BleInfo bleInfo = (BleInfo) obj;
        return IIX0o.Oxx0IOOO(this.uid, bleInfo.uid) && IIX0o.Oxx0IOOO(this.bleName, bleInfo.bleName) && IIX0o.Oxx0IOOO(this.flag, bleInfo.flag) && IIX0o.Oxx0IOOO(this.pid, bleInfo.pid) && IIX0o.Oxx0IOOO(this.bleVersion, bleInfo.bleVersion) && IIX0o.Oxx0IOOO(this.pVersion, bleInfo.pVersion) && IIX0o.Oxx0IOOO(this.mac, bleInfo.mac) && this.phoneOs == bleInfo.phoneOs;
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

    @OOXIXo
    public final String getPVersion() {
        return this.pVersion;
    }

    public final int getPhoneOs() {
        return this.phoneOs;
    }

    @OOXIXo
    public final String getPid() {
        return this.pid;
    }

    @OOXIXo
    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((((((((this.uid.hashCode() * 31) + this.bleName.hashCode()) * 31) + this.flag.hashCode()) * 31) + this.pid.hashCode()) * 31) + this.bleVersion.hashCode()) * 31) + this.pVersion.hashCode()) * 31) + this.mac.hashCode()) * 31) + this.phoneOs;
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

    public final void setPVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.pVersion = str;
    }

    public final void setPhoneOs(int i) {
        this.phoneOs = i;
    }

    public final void setPid(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.pid = str;
    }

    public final void setUid(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.uid = str;
    }

    @OOXIXo
    public String toString() {
        return "BleInfo(uid=" + this.uid + ", bleName=" + this.bleName + ", flag=" + this.flag + ", pid=" + this.pid + ", bleVersion=" + this.bleVersion + ", pVersion=" + this.pVersion + ", mac=" + this.mac + ", phoneOs=" + this.phoneOs + HexStringBuilder.COMMENT_END_CHAR;
    }

    public BleInfo(@OOXIXo String uid, @OOXIXo String bleName, @OOXIXo String flag, @OOXIXo String pid, @OOXIXo String bleVersion, @OOXIXo String pVersion, @OOXIXo String mac, int i) {
        IIX0o.x0xO0oo(uid, "uid");
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(flag, "flag");
        IIX0o.x0xO0oo(pid, "pid");
        IIX0o.x0xO0oo(bleVersion, "bleVersion");
        IIX0o.x0xO0oo(pVersion, "pVersion");
        IIX0o.x0xO0oo(mac, "mac");
        this.uid = uid;
        this.bleName = bleName;
        this.flag = flag;
        this.pid = pid;
        this.bleVersion = bleVersion;
        this.pVersion = pVersion;
        this.mac = mac;
        this.phoneOs = i;
    }

    public /* synthetic */ BleInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) == 0 ? str7 : "", (i2 & 128) != 0 ? 0 : i);
    }
}
