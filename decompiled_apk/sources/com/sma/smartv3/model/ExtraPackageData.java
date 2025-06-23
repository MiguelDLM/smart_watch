package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ExtraPackageData extends JsonFieldContainer {
    private long createTime;

    @OOXIXo
    private String fileName;
    private int fileSize;

    @OOXIXo
    private String fileUrl;

    @OOXIXo
    private String firmwareVersion;
    private int id;

    @OOXIXo
    private String info;
    private int type;

    @OOXIXo
    private String version;

    public ExtraPackageData() {
        this(0, null, 0, null, null, 0, null, null, 0L, 511, null);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.firmwareVersion;
    }

    public final int component3() {
        return this.type;
    }

    @OOXIXo
    public final String component4() {
        return this.version;
    }

    @OOXIXo
    public final String component5() {
        return this.fileName;
    }

    public final int component6() {
        return this.fileSize;
    }

    @OOXIXo
    public final String component7() {
        return this.fileUrl;
    }

    @OOXIXo
    public final String component8() {
        return this.info;
    }

    public final long component9() {
        return this.createTime;
    }

    @OOXIXo
    public final ExtraPackageData copy(int i, @OOXIXo String firmwareVersion, int i2, @OOXIXo String version, @OOXIXo String fileName, int i3, @OOXIXo String fileUrl, @OOXIXo String info, long j) {
        IIX0o.x0xO0oo(firmwareVersion, "firmwareVersion");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(fileUrl, "fileUrl");
        IIX0o.x0xO0oo(info, "info");
        return new ExtraPackageData(i, firmwareVersion, i2, version, fileName, i3, fileUrl, info, j);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraPackageData)) {
            return false;
        }
        ExtraPackageData extraPackageData = (ExtraPackageData) obj;
        return this.id == extraPackageData.id && IIX0o.Oxx0IOOO(this.firmwareVersion, extraPackageData.firmwareVersion) && this.type == extraPackageData.type && IIX0o.Oxx0IOOO(this.version, extraPackageData.version) && IIX0o.Oxx0IOOO(this.fileName, extraPackageData.fileName) && this.fileSize == extraPackageData.fileSize && IIX0o.Oxx0IOOO(this.fileUrl, extraPackageData.fileUrl) && IIX0o.Oxx0IOOO(this.info, extraPackageData.info) && this.createTime == extraPackageData.createTime;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @OOXIXo
    public final String getFileName() {
        return this.fileName;
    }

    public final int getFileSize() {
        return this.fileSize;
    }

    @OOXIXo
    public final String getFileUrl() {
        return this.fileUrl;
    }

    @OOXIXo
    public final String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final String getInfo() {
        return this.info;
    }

    public final int getType() {
        return this.type;
    }

    @OOXIXo
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((this.id * 31) + this.firmwareVersion.hashCode()) * 31) + this.type) * 31) + this.version.hashCode()) * 31) + this.fileName.hashCode()) * 31) + this.fileSize) * 31) + this.fileUrl.hashCode()) * 31) + this.info.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.createTime);
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final void setFileName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.fileName = str;
    }

    public final void setFileSize(int i) {
        this.fileSize = i;
    }

    public final void setFileUrl(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.fileUrl = str;
    }

    public final void setFirmwareVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.firmwareVersion = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.info = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.version = str;
    }

    @OOXIXo
    public String toString() {
        return "ExtraPackageData(id=" + this.id + ", firmwareVersion=" + this.firmwareVersion + ", type=" + this.type + ", version=" + this.version + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", fileUrl=" + this.fileUrl + ", info=" + this.info + ", createTime=" + this.createTime + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ ExtraPackageData(int i, String str, int i2, String str2, String str3, int i3, String str4, String str5, long j, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? "" : str3, (i4 & 32) == 0 ? i3 : 0, (i4 & 64) != 0 ? "" : str4, (i4 & 128) == 0 ? str5 : "", (i4 & 256) != 0 ? 0L : j);
    }

    public ExtraPackageData(int i, @OOXIXo String firmwareVersion, int i2, @OOXIXo String version, @OOXIXo String fileName, int i3, @OOXIXo String fileUrl, @OOXIXo String info, long j) {
        IIX0o.x0xO0oo(firmwareVersion, "firmwareVersion");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(fileUrl, "fileUrl");
        IIX0o.x0xO0oo(info, "info");
        this.id = i;
        this.firmwareVersion = firmwareVersion;
        this.type = i2;
        this.version = version;
        this.fileName = fileName;
        this.fileSize = i3;
        this.fileUrl = fileUrl;
        this.info = info;
        this.createTime = j;
    }
}
