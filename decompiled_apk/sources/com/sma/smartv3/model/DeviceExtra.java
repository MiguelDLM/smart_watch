package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class DeviceExtra extends JsonField {

    @OOXIXo
    private String languagePackVersion;

    @OOXIXo
    private String uiPackVersion;

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceExtra() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DeviceExtra copy$default(DeviceExtra deviceExtra, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceExtra.uiPackVersion;
        }
        if ((i & 2) != 0) {
            str2 = deviceExtra.languagePackVersion;
        }
        return deviceExtra.copy(str, str2);
    }

    @OOXIXo
    public final String component1() {
        return this.uiPackVersion;
    }

    @OOXIXo
    public final String component2() {
        return this.languagePackVersion;
    }

    @OOXIXo
    public final DeviceExtra copy(@OOXIXo String uiPackVersion, @OOXIXo String languagePackVersion) {
        IIX0o.x0xO0oo(uiPackVersion, "uiPackVersion");
        IIX0o.x0xO0oo(languagePackVersion, "languagePackVersion");
        return new DeviceExtra(uiPackVersion, languagePackVersion);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceExtra)) {
            return false;
        }
        DeviceExtra deviceExtra = (DeviceExtra) obj;
        return IIX0o.Oxx0IOOO(this.uiPackVersion, deviceExtra.uiPackVersion) && IIX0o.Oxx0IOOO(this.languagePackVersion, deviceExtra.languagePackVersion);
    }

    @OOXIXo
    public final String getLanguagePackVersion() {
        return this.languagePackVersion;
    }

    @OOXIXo
    public final String getUiPackVersion() {
        return this.uiPackVersion;
    }

    public int hashCode() {
        return (this.uiPackVersion.hashCode() * 31) + this.languagePackVersion.hashCode();
    }

    public final void setLanguagePackVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.languagePackVersion = str;
    }

    public final void setUiPackVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.uiPackVersion = str;
    }

    @OOXIXo
    public String toString() {
        return "DeviceExtra(uiPackVersion=" + this.uiPackVersion + ", languagePackVersion=" + this.languagePackVersion + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ DeviceExtra(String str, String str2, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public DeviceExtra(@OOXIXo String uiPackVersion, @OOXIXo String languagePackVersion) {
        IIX0o.x0xO0oo(uiPackVersion, "uiPackVersion");
        IIX0o.x0xO0oo(languagePackVersion, "languagePackVersion");
        this.uiPackVersion = uiPackVersion;
        this.languagePackVersion = languagePackVersion;
    }
}
