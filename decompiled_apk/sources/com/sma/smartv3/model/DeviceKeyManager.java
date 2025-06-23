package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class DeviceKeyManager extends JsonFieldContainer {

    @OOXIXo
    private String first;

    @OOXIXo
    private String second;

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceKeyManager() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DeviceKeyManager copy$default(DeviceKeyManager deviceKeyManager, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceKeyManager.first;
        }
        if ((i & 2) != 0) {
            str2 = deviceKeyManager.second;
        }
        return deviceKeyManager.copy(str, str2);
    }

    @OOXIXo
    public final String component1() {
        return this.first;
    }

    @OOXIXo
    public final String component2() {
        return this.second;
    }

    @OOXIXo
    public final DeviceKeyManager copy(@OOXIXo String first, @OOXIXo String second) {
        IIX0o.x0xO0oo(first, "first");
        IIX0o.x0xO0oo(second, "second");
        return new DeviceKeyManager(first, second);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceKeyManager)) {
            return false;
        }
        DeviceKeyManager deviceKeyManager = (DeviceKeyManager) obj;
        return IIX0o.Oxx0IOOO(this.first, deviceKeyManager.first) && IIX0o.Oxx0IOOO(this.second, deviceKeyManager.second);
    }

    @OOXIXo
    public final String getFirst() {
        return this.first;
    }

    @OOXIXo
    public final String getSecond() {
        return this.second;
    }

    public int hashCode() {
        return (this.first.hashCode() * 31) + this.second.hashCode();
    }

    public final void setFirst(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.first = str;
    }

    public final void setSecond(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.second = str;
    }

    @OOXIXo
    public String toString() {
        return "DeviceKeyManager(first=" + this.first + ", second=" + this.second + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ DeviceKeyManager(String str, String str2, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public DeviceKeyManager(@OOXIXo String first, @OOXIXo String second) {
        IIX0o.x0xO0oo(first, "first");
        IIX0o.x0xO0oo(second, "second");
        this.first = first;
        this.second = second;
    }
}
