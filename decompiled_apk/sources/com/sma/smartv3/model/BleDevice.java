package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BleDevice extends JsonFieldContainer {

    @OOXIXo
    private String address;
    private int agpsType;

    @OOXIXo
    private String extraInfo;

    @OOXIXo
    private String firmwareFlag;

    @OOXIXo
    private String name;

    @OOXIXo
    private String platform;

    @OOXIXo
    private String prototype;

    @OOXIXo
    private String settings;

    @OOXIXo
    private String version;

    public BleDevice() {
        this(null, null, null, null, null, 0, null, null, null, 511, null);
    }

    @OOXIXo
    public final String component1() {
        return this.name;
    }

    @OOXIXo
    public final String component2() {
        return this.address;
    }

    @OOXIXo
    public final String component3() {
        return this.platform;
    }

    @OOXIXo
    public final String component4() {
        return this.prototype;
    }

    @OOXIXo
    public final String component5() {
        return this.firmwareFlag;
    }

    public final int component6() {
        return this.agpsType;
    }

    @OOXIXo
    public final String component7() {
        return this.version;
    }

    @OOXIXo
    public final String component8() {
        return this.extraInfo;
    }

    @OOXIXo
    public final String component9() {
        return this.settings;
    }

    @OOXIXo
    public final BleDevice copy(@OOXIXo String name, @OOXIXo String address, @OOXIXo String platform, @OOXIXo String prototype, @OOXIXo String firmwareFlag, int i, @OOXIXo String version, @OOXIXo String extraInfo, @OOXIXo String settings) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(address, "address");
        IIX0o.x0xO0oo(platform, "platform");
        IIX0o.x0xO0oo(prototype, "prototype");
        IIX0o.x0xO0oo(firmwareFlag, "firmwareFlag");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(extraInfo, "extraInfo");
        IIX0o.x0xO0oo(settings, "settings");
        return new BleDevice(name, address, platform, prototype, firmwareFlag, i, version, extraInfo, settings);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleDevice)) {
            return false;
        }
        BleDevice bleDevice = (BleDevice) obj;
        return IIX0o.Oxx0IOOO(this.name, bleDevice.name) && IIX0o.Oxx0IOOO(this.address, bleDevice.address) && IIX0o.Oxx0IOOO(this.platform, bleDevice.platform) && IIX0o.Oxx0IOOO(this.prototype, bleDevice.prototype) && IIX0o.Oxx0IOOO(this.firmwareFlag, bleDevice.firmwareFlag) && this.agpsType == bleDevice.agpsType && IIX0o.Oxx0IOOO(this.version, bleDevice.version) && IIX0o.Oxx0IOOO(this.extraInfo, bleDevice.extraInfo) && IIX0o.Oxx0IOOO(this.settings, bleDevice.settings);
    }

    @OOXIXo
    public final String getAddress() {
        return this.address;
    }

    public final int getAgpsType() {
        return this.agpsType;
    }

    @OOXIXo
    public final String getExtraInfo() {
        return this.extraInfo;
    }

    @OOXIXo
    public final String getFirmwareFlag() {
        return this.firmwareFlag;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    @OOXIXo
    public final String getPlatform() {
        return this.platform;
    }

    @OOXIXo
    public final String getPrototype() {
        return this.prototype;
    }

    @OOXIXo
    public final String getSettings() {
        return this.settings;
    }

    @OOXIXo
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((this.name.hashCode() * 31) + this.address.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.prototype.hashCode()) * 31) + this.firmwareFlag.hashCode()) * 31) + this.agpsType) * 31) + this.version.hashCode()) * 31) + this.extraInfo.hashCode()) * 31) + this.settings.hashCode();
    }

    public final void setAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.address = str;
    }

    public final void setAgpsType(int i) {
        this.agpsType = i;
    }

    public final void setExtraInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.extraInfo = str;
    }

    public final void setFirmwareFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.firmwareFlag = str;
    }

    public final void setName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.name = str;
    }

    public final void setPlatform(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.platform = str;
    }

    public final void setPrototype(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.prototype = str;
    }

    public final void setSettings(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.settings = str;
    }

    public final void setVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.version = str;
    }

    @OOXIXo
    public String toString() {
        return "BleDevice(name=" + this.name + ", address=" + this.address + ", platform=" + this.platform + ", prototype=" + this.prototype + ", firmwareFlag=" + this.firmwareFlag + ", agpsType=" + this.agpsType + ", version=" + this.version + ", extraInfo=" + this.extraInfo + ", settings=" + this.settings + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleDevice(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) == 0 ? str8 : "");
    }

    public BleDevice(@OOXIXo String name, @OOXIXo String address, @OOXIXo String platform, @OOXIXo String prototype, @OOXIXo String firmwareFlag, int i, @OOXIXo String version, @OOXIXo String extraInfo, @OOXIXo String settings) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(address, "address");
        IIX0o.x0xO0oo(platform, "platform");
        IIX0o.x0xO0oo(prototype, "prototype");
        IIX0o.x0xO0oo(firmwareFlag, "firmwareFlag");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(extraInfo, "extraInfo");
        IIX0o.x0xO0oo(settings, "settings");
        this.name = name;
        this.address = address;
        this.platform = platform;
        this.prototype = prototype;
        this.firmwareFlag = firmwareFlag;
        this.agpsType = i;
        this.version = version;
        this.extraInfo = extraInfo;
        this.settings = settings;
    }
}
