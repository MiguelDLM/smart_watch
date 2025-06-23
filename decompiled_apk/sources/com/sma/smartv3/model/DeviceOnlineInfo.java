package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class DeviceOnlineInfo extends JsonFieldContainer {

    @OOXIXo
    private String bleName;
    private int supportAutoBinding;

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceOnlineInfo() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DeviceOnlineInfo copy$default(DeviceOnlineInfo deviceOnlineInfo, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = deviceOnlineInfo.bleName;
        }
        if ((i2 & 2) != 0) {
            i = deviceOnlineInfo.supportAutoBinding;
        }
        return deviceOnlineInfo.copy(str, i);
    }

    @OOXIXo
    public final String component1() {
        return this.bleName;
    }

    public final int component2() {
        return this.supportAutoBinding;
    }

    @OOXIXo
    public final DeviceOnlineInfo copy(@OOXIXo String bleName, int i) {
        IIX0o.x0xO0oo(bleName, "bleName");
        return new DeviceOnlineInfo(bleName, i);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceOnlineInfo)) {
            return false;
        }
        DeviceOnlineInfo deviceOnlineInfo = (DeviceOnlineInfo) obj;
        return IIX0o.Oxx0IOOO(this.bleName, deviceOnlineInfo.bleName) && this.supportAutoBinding == deviceOnlineInfo.supportAutoBinding;
    }

    @OOXIXo
    public final String getBleName() {
        return this.bleName;
    }

    public final int getSupportAutoBinding() {
        return this.supportAutoBinding;
    }

    public int hashCode() {
        return (this.bleName.hashCode() * 31) + this.supportAutoBinding;
    }

    public final void setBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.bleName = str;
    }

    public final void setSupportAutoBinding(int i) {
        this.supportAutoBinding = i;
    }

    @OOXIXo
    public String toString() {
        return "DeviceOnlineInfo(bleName=" + this.bleName + ", supportAutoBinding=" + this.supportAutoBinding + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ DeviceOnlineInfo(String str, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    public DeviceOnlineInfo(@OOXIXo String bleName, int i) {
        IIX0o.x0xO0oo(bleName, "bleName");
        this.bleName = bleName;
        this.supportAutoBinding = i;
    }
}
