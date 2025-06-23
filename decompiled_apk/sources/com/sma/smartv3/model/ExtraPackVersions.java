package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ExtraPackVersions extends JsonFieldContainer implements Serializable {

    @oOoXoXO
    private FirmwareVersion brandPackVersion;

    @oOoXoXO
    private FirmwareVersion fontPackVersion;

    @oOoXoXO
    private FirmwareVersion gpsFirmwareVersion;

    @oOoXoXO
    private FirmwareVersion languagePackVersion;

    @oOoXoXO
    private FirmwareVersion networkFirmwareVersion;

    @oOoXoXO
    private FirmwareVersion uiPackVersion;

    public ExtraPackVersions() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ExtraPackVersions copy$default(ExtraPackVersions extraPackVersions, FirmwareVersion firmwareVersion, FirmwareVersion firmwareVersion2, FirmwareVersion firmwareVersion3, FirmwareVersion firmwareVersion4, FirmwareVersion firmwareVersion5, FirmwareVersion firmwareVersion6, int i, Object obj) {
        if ((i & 1) != 0) {
            firmwareVersion = extraPackVersions.uiPackVersion;
        }
        if ((i & 2) != 0) {
            firmwareVersion2 = extraPackVersions.languagePackVersion;
        }
        FirmwareVersion firmwareVersion7 = firmwareVersion2;
        if ((i & 4) != 0) {
            firmwareVersion3 = extraPackVersions.brandPackVersion;
        }
        FirmwareVersion firmwareVersion8 = firmwareVersion3;
        if ((i & 8) != 0) {
            firmwareVersion4 = extraPackVersions.fontPackVersion;
        }
        FirmwareVersion firmwareVersion9 = firmwareVersion4;
        if ((i & 16) != 0) {
            firmwareVersion5 = extraPackVersions.gpsFirmwareVersion;
        }
        FirmwareVersion firmwareVersion10 = firmwareVersion5;
        if ((i & 32) != 0) {
            firmwareVersion6 = extraPackVersions.networkFirmwareVersion;
        }
        return extraPackVersions.copy(firmwareVersion, firmwareVersion7, firmwareVersion8, firmwareVersion9, firmwareVersion10, firmwareVersion6);
    }

    @oOoXoXO
    public final FirmwareVersion component1() {
        return this.uiPackVersion;
    }

    @oOoXoXO
    public final FirmwareVersion component2() {
        return this.languagePackVersion;
    }

    @oOoXoXO
    public final FirmwareVersion component3() {
        return this.brandPackVersion;
    }

    @oOoXoXO
    public final FirmwareVersion component4() {
        return this.fontPackVersion;
    }

    @oOoXoXO
    public final FirmwareVersion component5() {
        return this.gpsFirmwareVersion;
    }

    @oOoXoXO
    public final FirmwareVersion component6() {
        return this.networkFirmwareVersion;
    }

    @OOXIXo
    public final ExtraPackVersions copy(@oOoXoXO FirmwareVersion firmwareVersion, @oOoXoXO FirmwareVersion firmwareVersion2, @oOoXoXO FirmwareVersion firmwareVersion3, @oOoXoXO FirmwareVersion firmwareVersion4, @oOoXoXO FirmwareVersion firmwareVersion5, @oOoXoXO FirmwareVersion firmwareVersion6) {
        return new ExtraPackVersions(firmwareVersion, firmwareVersion2, firmwareVersion3, firmwareVersion4, firmwareVersion5, firmwareVersion6);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraPackVersions)) {
            return false;
        }
        ExtraPackVersions extraPackVersions = (ExtraPackVersions) obj;
        return IIX0o.Oxx0IOOO(this.uiPackVersion, extraPackVersions.uiPackVersion) && IIX0o.Oxx0IOOO(this.languagePackVersion, extraPackVersions.languagePackVersion) && IIX0o.Oxx0IOOO(this.brandPackVersion, extraPackVersions.brandPackVersion) && IIX0o.Oxx0IOOO(this.fontPackVersion, extraPackVersions.fontPackVersion) && IIX0o.Oxx0IOOO(this.gpsFirmwareVersion, extraPackVersions.gpsFirmwareVersion) && IIX0o.Oxx0IOOO(this.networkFirmwareVersion, extraPackVersions.networkFirmwareVersion);
    }

    @oOoXoXO
    public final FirmwareVersion getBrandPackVersion() {
        return this.brandPackVersion;
    }

    @oOoXoXO
    public final FirmwareVersion getFontPackVersion() {
        return this.fontPackVersion;
    }

    @oOoXoXO
    public final FirmwareVersion getGpsFirmwareVersion() {
        return this.gpsFirmwareVersion;
    }

    @oOoXoXO
    public final FirmwareVersion getLanguagePackVersion() {
        return this.languagePackVersion;
    }

    @oOoXoXO
    public final FirmwareVersion getNetworkFirmwareVersion() {
        return this.networkFirmwareVersion;
    }

    @oOoXoXO
    public final FirmwareVersion getUiPackVersion() {
        return this.uiPackVersion;
    }

    public int hashCode() {
        FirmwareVersion firmwareVersion = this.uiPackVersion;
        int hashCode = (firmwareVersion == null ? 0 : firmwareVersion.hashCode()) * 31;
        FirmwareVersion firmwareVersion2 = this.languagePackVersion;
        int hashCode2 = (hashCode + (firmwareVersion2 == null ? 0 : firmwareVersion2.hashCode())) * 31;
        FirmwareVersion firmwareVersion3 = this.brandPackVersion;
        int hashCode3 = (hashCode2 + (firmwareVersion3 == null ? 0 : firmwareVersion3.hashCode())) * 31;
        FirmwareVersion firmwareVersion4 = this.fontPackVersion;
        int hashCode4 = (hashCode3 + (firmwareVersion4 == null ? 0 : firmwareVersion4.hashCode())) * 31;
        FirmwareVersion firmwareVersion5 = this.gpsFirmwareVersion;
        int hashCode5 = (hashCode4 + (firmwareVersion5 == null ? 0 : firmwareVersion5.hashCode())) * 31;
        FirmwareVersion firmwareVersion6 = this.networkFirmwareVersion;
        return hashCode5 + (firmwareVersion6 != null ? firmwareVersion6.hashCode() : 0);
    }

    public final void setBrandPackVersion(@oOoXoXO FirmwareVersion firmwareVersion) {
        this.brandPackVersion = firmwareVersion;
    }

    public final void setFontPackVersion(@oOoXoXO FirmwareVersion firmwareVersion) {
        this.fontPackVersion = firmwareVersion;
    }

    public final void setGpsFirmwareVersion(@oOoXoXO FirmwareVersion firmwareVersion) {
        this.gpsFirmwareVersion = firmwareVersion;
    }

    public final void setLanguagePackVersion(@oOoXoXO FirmwareVersion firmwareVersion) {
        this.languagePackVersion = firmwareVersion;
    }

    public final void setNetworkFirmwareVersion(@oOoXoXO FirmwareVersion firmwareVersion) {
        this.networkFirmwareVersion = firmwareVersion;
    }

    public final void setUiPackVersion(@oOoXoXO FirmwareVersion firmwareVersion) {
        this.uiPackVersion = firmwareVersion;
    }

    @OOXIXo
    public String toString() {
        return "ExtraPackVersions(uiPackVersion=" + this.uiPackVersion + ", languagePackVersion=" + this.languagePackVersion + ", brandPackVersion=" + this.brandPackVersion + ", fontPackVersion=" + this.fontPackVersion + ", gpsFirmwareVersion=" + this.gpsFirmwareVersion + ", networkFirmwareVersion=" + this.networkFirmwareVersion + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ ExtraPackVersions(FirmwareVersion firmwareVersion, FirmwareVersion firmwareVersion2, FirmwareVersion firmwareVersion3, FirmwareVersion firmwareVersion4, FirmwareVersion firmwareVersion5, FirmwareVersion firmwareVersion6, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : firmwareVersion, (i & 2) != 0 ? null : firmwareVersion2, (i & 4) != 0 ? null : firmwareVersion3, (i & 8) != 0 ? null : firmwareVersion4, (i & 16) != 0 ? null : firmwareVersion5, (i & 32) != 0 ? null : firmwareVersion6);
    }

    public ExtraPackVersions(@oOoXoXO FirmwareVersion firmwareVersion, @oOoXoXO FirmwareVersion firmwareVersion2, @oOoXoXO FirmwareVersion firmwareVersion3, @oOoXoXO FirmwareVersion firmwareVersion4, @oOoXoXO FirmwareVersion firmwareVersion5, @oOoXoXO FirmwareVersion firmwareVersion6) {
        this.uiPackVersion = firmwareVersion;
        this.languagePackVersion = firmwareVersion2;
        this.brandPackVersion = firmwareVersion3;
        this.fontPackVersion = firmwareVersion4;
        this.gpsFirmwareVersion = firmwareVersion5;
        this.networkFirmwareVersion = firmwareVersion6;
    }
}
