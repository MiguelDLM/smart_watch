package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class FirmwareVersion extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private String fileName;

    @OOXIXo
    private String fileName2;
    private int fileSize;

    @OOXIXo
    private String fileUrl;

    @OOXIXo
    private String fileUrl2;
    private int flag;

    @OOXIXo
    private String info;

    @OOXIXo
    private String version;

    @OOXIXo
    private String version2;

    public FirmwareVersion() {
        this(null, 0, null, null, null, 0, null, null, null, 511, null);
    }

    @OOXIXo
    public final String component1() {
        return this.fileName;
    }

    public final int component2() {
        return this.fileSize;
    }

    @OOXIXo
    public final String component3() {
        return this.fileUrl;
    }

    @OOXIXo
    public final String component4() {
        return this.version;
    }

    @OOXIXo
    public final String component5() {
        return this.info;
    }

    public final int component6() {
        return this.flag;
    }

    @OOXIXo
    public final String component7() {
        return this.fileName2;
    }

    @OOXIXo
    public final String component8() {
        return this.fileUrl2;
    }

    @OOXIXo
    public final String component9() {
        return this.version2;
    }

    @OOXIXo
    public final FirmwareVersion copy(@OOXIXo String fileName, int i, @OOXIXo String fileUrl, @OOXIXo String version, @OOXIXo String info, int i2, @OOXIXo String fileName2, @OOXIXo String fileUrl2, @OOXIXo String version2) {
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(fileUrl, "fileUrl");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(info, "info");
        IIX0o.x0xO0oo(fileName2, "fileName2");
        IIX0o.x0xO0oo(fileUrl2, "fileUrl2");
        IIX0o.x0xO0oo(version2, "version2");
        return new FirmwareVersion(fileName, i, fileUrl, version, info, i2, fileName2, fileUrl2, version2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FirmwareVersion)) {
            return false;
        }
        FirmwareVersion firmwareVersion = (FirmwareVersion) obj;
        return IIX0o.Oxx0IOOO(this.fileName, firmwareVersion.fileName) && this.fileSize == firmwareVersion.fileSize && IIX0o.Oxx0IOOO(this.fileUrl, firmwareVersion.fileUrl) && IIX0o.Oxx0IOOO(this.version, firmwareVersion.version) && IIX0o.Oxx0IOOO(this.info, firmwareVersion.info) && this.flag == firmwareVersion.flag && IIX0o.Oxx0IOOO(this.fileName2, firmwareVersion.fileName2) && IIX0o.Oxx0IOOO(this.fileUrl2, firmwareVersion.fileUrl2) && IIX0o.Oxx0IOOO(this.version2, firmwareVersion.version2);
    }

    @OOXIXo
    public final String getFileName() {
        return this.fileName;
    }

    @OOXIXo
    public final String getFileName2() {
        return this.fileName2;
    }

    public final int getFileSize() {
        return this.fileSize;
    }

    @OOXIXo
    public final String getFileUrl() {
        return this.fileUrl;
    }

    @OOXIXo
    public final String getFileUrl2() {
        return this.fileUrl2;
    }

    public final int getFlag() {
        return this.flag;
    }

    @OOXIXo
    public final String getInfo() {
        return this.info;
    }

    @OOXIXo
    public final String getVersion() {
        return this.version;
    }

    @OOXIXo
    public final String getVersion2() {
        return this.version2;
    }

    public int hashCode() {
        return (((((((((((((((this.fileName.hashCode() * 31) + this.fileSize) * 31) + this.fileUrl.hashCode()) * 31) + this.version.hashCode()) * 31) + this.info.hashCode()) * 31) + this.flag) * 31) + this.fileName2.hashCode()) * 31) + this.fileUrl2.hashCode()) * 31) + this.version2.hashCode();
    }

    public final void setFileName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.fileName = str;
    }

    public final void setFileName2(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.fileName2 = str;
    }

    public final void setFileSize(int i) {
        this.fileSize = i;
    }

    public final void setFileUrl(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.fileUrl = str;
    }

    public final void setFileUrl2(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.fileUrl2 = str;
    }

    public final void setFlag(int i) {
        this.flag = i;
    }

    public final void setInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.info = str;
    }

    public final void setVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.version = str;
    }

    public final void setVersion2(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.version2 = str;
    }

    @OOXIXo
    public String toString() {
        return "FirmwareVersion(fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", fileUrl=" + this.fileUrl + ", version=" + this.version + ", info=" + this.info + ", flag=" + this.flag + ", fileName2=" + this.fileName2 + ", fileUrl2=" + this.fileUrl2 + ", version2=" + this.version2 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ FirmwareVersion(String str, int i, String str2, String str3, String str4, int i2, String str5, String str6, String str7, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? "" : str5, (i3 & 128) != 0 ? "" : str6, (i3 & 256) == 0 ? str7 : "");
    }

    public FirmwareVersion(@OOXIXo String fileName, int i, @OOXIXo String fileUrl, @OOXIXo String version, @OOXIXo String info, int i2, @OOXIXo String fileName2, @OOXIXo String fileUrl2, @OOXIXo String version2) {
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(fileUrl, "fileUrl");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(info, "info");
        IIX0o.x0xO0oo(fileName2, "fileName2");
        IIX0o.x0xO0oo(fileUrl2, "fileUrl2");
        IIX0o.x0xO0oo(version2, "version2");
        this.fileName = fileName;
        this.fileSize = i;
        this.fileUrl = fileUrl;
        this.version = version;
        this.info = info;
        this.flag = i2;
        this.fileName2 = fileName2;
        this.fileUrl2 = fileUrl2;
        this.version2 = version2;
    }
}
