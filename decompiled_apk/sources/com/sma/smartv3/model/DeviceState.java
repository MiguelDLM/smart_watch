package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class DeviceState extends JsonFieldContainer {
    private long createTime;
    private int deviceState;
    private int id;

    @OOXIXo
    private String info;

    @OOXIXo
    private String oldAddress;

    @OOXIXo
    private String payAddress;
    private int platform;

    @OOXIXo
    private String updateTime;

    public DeviceState() {
        this(0, null, null, 0, 0, null, 0L, null, 255, null);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.payAddress;
    }

    @OOXIXo
    public final String component3() {
        return this.oldAddress;
    }

    public final int component4() {
        return this.platform;
    }

    public final int component5() {
        return this.deviceState;
    }

    @OOXIXo
    public final String component6() {
        return this.info;
    }

    public final long component7() {
        return this.createTime;
    }

    @OOXIXo
    public final String component8() {
        return this.updateTime;
    }

    @OOXIXo
    public final DeviceState copy(int i, @OOXIXo String payAddress, @OOXIXo String oldAddress, int i2, int i3, @OOXIXo String info, long j, @OOXIXo String updateTime) {
        IIX0o.x0xO0oo(payAddress, "payAddress");
        IIX0o.x0xO0oo(oldAddress, "oldAddress");
        IIX0o.x0xO0oo(info, "info");
        IIX0o.x0xO0oo(updateTime, "updateTime");
        return new DeviceState(i, payAddress, oldAddress, i2, i3, info, j, updateTime);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceState)) {
            return false;
        }
        DeviceState deviceState = (DeviceState) obj;
        return this.id == deviceState.id && IIX0o.Oxx0IOOO(this.payAddress, deviceState.payAddress) && IIX0o.Oxx0IOOO(this.oldAddress, deviceState.oldAddress) && this.platform == deviceState.platform && this.deviceState == deviceState.deviceState && IIX0o.Oxx0IOOO(this.info, deviceState.info) && this.createTime == deviceState.createTime && IIX0o.Oxx0IOOO(this.updateTime, deviceState.updateTime);
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final int getDeviceState() {
        return this.deviceState;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final String getInfo() {
        return this.info;
    }

    @OOXIXo
    public final String getOldAddress() {
        return this.oldAddress;
    }

    @OOXIXo
    public final String getPayAddress() {
        return this.payAddress;
    }

    public final int getPlatform() {
        return this.platform;
    }

    @OOXIXo
    public final String getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        return (((((((((((((this.id * 31) + this.payAddress.hashCode()) * 31) + this.oldAddress.hashCode()) * 31) + this.platform) * 31) + this.deviceState) * 31) + this.info.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.createTime)) * 31) + this.updateTime.hashCode();
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final void setDeviceState(int i) {
        this.deviceState = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.info = str;
    }

    public final void setOldAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.oldAddress = str;
    }

    public final void setPayAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.payAddress = str;
    }

    public final void setPlatform(int i) {
        this.platform = i;
    }

    public final void setUpdateTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.updateTime = str;
    }

    @OOXIXo
    public String toString() {
        return "DeviceState(id=" + this.id + ", payAddress=" + this.payAddress + ", oldAddress=" + this.oldAddress + ", platform=" + this.platform + ", deviceState=" + this.deviceState + ", info=" + this.info + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ DeviceState(int i, String str, String str2, int i2, int i3, String str3, long j, String str4, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) == 0 ? i3 : 0, (i4 & 32) != 0 ? "" : str3, (i4 & 64) != 0 ? 0L : j, (i4 & 128) == 0 ? str4 : "");
    }

    public DeviceState(int i, @OOXIXo String payAddress, @OOXIXo String oldAddress, int i2, int i3, @OOXIXo String info, long j, @OOXIXo String updateTime) {
        IIX0o.x0xO0oo(payAddress, "payAddress");
        IIX0o.x0xO0oo(oldAddress, "oldAddress");
        IIX0o.x0xO0oo(info, "info");
        IIX0o.x0xO0oo(updateTime, "updateTime");
        this.id = i;
        this.payAddress = payAddress;
        this.oldAddress = oldAddress;
        this.platform = i2;
        this.deviceState = i3;
        this.info = info;
        this.createTime = j;
        this.updateTime = updateTime;
    }
}
