package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BatchOtaConfig extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private BleFirmwareInfo bleFirmwareInfo;

    @OOXIXo
    private String bleName;

    @OOXIXo
    private ExtraPackVersions extraPackageDatas;

    @OOXIXo
    private FirmwareVersion firmwareVersion;
    private boolean isLocalOta;
    private int platform;

    public BatchOtaConfig() {
        this(0, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ BatchOtaConfig copy$default(BatchOtaConfig batchOtaConfig, int i, BleFirmwareInfo bleFirmwareInfo, FirmwareVersion firmwareVersion, ExtraPackVersions extraPackVersions, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = batchOtaConfig.platform;
        }
        if ((i2 & 2) != 0) {
            bleFirmwareInfo = batchOtaConfig.bleFirmwareInfo;
        }
        BleFirmwareInfo bleFirmwareInfo2 = bleFirmwareInfo;
        if ((i2 & 4) != 0) {
            firmwareVersion = batchOtaConfig.firmwareVersion;
        }
        FirmwareVersion firmwareVersion2 = firmwareVersion;
        if ((i2 & 8) != 0) {
            extraPackVersions = batchOtaConfig.extraPackageDatas;
        }
        ExtraPackVersions extraPackVersions2 = extraPackVersions;
        if ((i2 & 16) != 0) {
            str = batchOtaConfig.bleName;
        }
        String str2 = str;
        if ((i2 & 32) != 0) {
            z = batchOtaConfig.isLocalOta;
        }
        return batchOtaConfig.copy(i, bleFirmwareInfo2, firmwareVersion2, extraPackVersions2, str2, z);
    }

    public final int component1() {
        return this.platform;
    }

    @OOXIXo
    public final BleFirmwareInfo component2() {
        return this.bleFirmwareInfo;
    }

    @OOXIXo
    public final FirmwareVersion component3() {
        return this.firmwareVersion;
    }

    @OOXIXo
    public final ExtraPackVersions component4() {
        return this.extraPackageDatas;
    }

    @OOXIXo
    public final String component5() {
        return this.bleName;
    }

    public final boolean component6() {
        return this.isLocalOta;
    }

    @OOXIXo
    public final BatchOtaConfig copy(int i, @OOXIXo BleFirmwareInfo bleFirmwareInfo, @OOXIXo FirmwareVersion firmwareVersion, @OOXIXo ExtraPackVersions extraPackageDatas, @OOXIXo String bleName, boolean z) {
        IIX0o.x0xO0oo(bleFirmwareInfo, "bleFirmwareInfo");
        IIX0o.x0xO0oo(firmwareVersion, "firmwareVersion");
        IIX0o.x0xO0oo(extraPackageDatas, "extraPackageDatas");
        IIX0o.x0xO0oo(bleName, "bleName");
        return new BatchOtaConfig(i, bleFirmwareInfo, firmwareVersion, extraPackageDatas, bleName, z);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BatchOtaConfig)) {
            return false;
        }
        BatchOtaConfig batchOtaConfig = (BatchOtaConfig) obj;
        return this.platform == batchOtaConfig.platform && IIX0o.Oxx0IOOO(this.bleFirmwareInfo, batchOtaConfig.bleFirmwareInfo) && IIX0o.Oxx0IOOO(this.firmwareVersion, batchOtaConfig.firmwareVersion) && IIX0o.Oxx0IOOO(this.extraPackageDatas, batchOtaConfig.extraPackageDatas) && IIX0o.Oxx0IOOO(this.bleName, batchOtaConfig.bleName) && this.isLocalOta == batchOtaConfig.isLocalOta;
    }

    @OOXIXo
    public final BleFirmwareInfo getBleFirmwareInfo() {
        return this.bleFirmwareInfo;
    }

    @OOXIXo
    public final String getBleName() {
        return this.bleName;
    }

    @OOXIXo
    public final ExtraPackVersions getExtraPackageDatas() {
        return this.extraPackageDatas;
    }

    @OOXIXo
    public final FirmwareVersion getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public final int getPlatform() {
        return this.platform;
    }

    public int hashCode() {
        return (((((((((this.platform * 31) + this.bleFirmwareInfo.hashCode()) * 31) + this.firmwareVersion.hashCode()) * 31) + this.extraPackageDatas.hashCode()) * 31) + this.bleName.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.isLocalOta);
    }

    public final boolean isLocalOta() {
        return this.isLocalOta;
    }

    public final void setBleFirmwareInfo(@OOXIXo BleFirmwareInfo bleFirmwareInfo) {
        IIX0o.x0xO0oo(bleFirmwareInfo, "<set-?>");
        this.bleFirmwareInfo = bleFirmwareInfo;
    }

    public final void setBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.bleName = str;
    }

    public final void setExtraPackageDatas(@OOXIXo ExtraPackVersions extraPackVersions) {
        IIX0o.x0xO0oo(extraPackVersions, "<set-?>");
        this.extraPackageDatas = extraPackVersions;
    }

    public final void setFirmwareVersion(@OOXIXo FirmwareVersion firmwareVersion) {
        IIX0o.x0xO0oo(firmwareVersion, "<set-?>");
        this.firmwareVersion = firmwareVersion;
    }

    public final void setLocalOta(boolean z) {
        this.isLocalOta = z;
    }

    public final void setPlatform(int i) {
        this.platform = i;
    }

    @OOXIXo
    public String toString() {
        return "BatchOtaConfig(platform=" + this.platform + ", bleFirmwareInfo=" + this.bleFirmwareInfo + ", firmwareVersion=" + this.firmwareVersion + ", extraPackageDatas=" + this.extraPackageDatas + ", bleName=" + this.bleName + ", isLocalOta=" + this.isLocalOta + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BatchOtaConfig(int i, BleFirmwareInfo bleFirmwareInfo, FirmwareVersion firmwareVersion, ExtraPackVersions extraPackVersions, String str, boolean z, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new BleFirmwareInfo(0, 0, null, null, null, 31, null) : bleFirmwareInfo, (i2 & 4) != 0 ? new FirmwareVersion(null, 0, null, null, null, 0, null, null, null, 511, null) : firmwareVersion, (i2 & 8) != 0 ? new ExtraPackVersions(null, null, null, null, null, null, 63, null) : extraPackVersions, (i2 & 16) != 0 ? "" : str, (i2 & 32) == 0 ? z : false);
    }

    public BatchOtaConfig(int i, @OOXIXo BleFirmwareInfo bleFirmwareInfo, @OOXIXo FirmwareVersion firmwareVersion, @OOXIXo ExtraPackVersions extraPackageDatas, @OOXIXo String bleName, boolean z) {
        IIX0o.x0xO0oo(bleFirmwareInfo, "bleFirmwareInfo");
        IIX0o.x0xO0oo(firmwareVersion, "firmwareVersion");
        IIX0o.x0xO0oo(extraPackageDatas, "extraPackageDatas");
        IIX0o.x0xO0oo(bleName, "bleName");
        this.platform = i;
        this.bleFirmwareInfo = bleFirmwareInfo;
        this.firmwareVersion = firmwareVersion;
        this.extraPackageDatas = extraPackageDatas;
        this.bleName = bleName;
        this.isLocalOta = z;
    }
}
