package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class VideoFile extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String businessId;

    @OOXIXo
    private final String businessType;

    @OOXIXo
    private final String fileName;

    @OOXIXo
    private final String filePath;

    @OOXIXo
    private final String fileSize;

    @OOXIXo
    private final String fileType;

    @OOXIXo
    private final String id;

    @OOXIXo
    private final String version;

    public VideoFile() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @OOXIXo
    public final String component1() {
        return this.fileName;
    }

    @OOXIXo
    public final String component2() {
        return this.fileSize;
    }

    @OOXIXo
    public final String component3() {
        return this.fileType;
    }

    @OOXIXo
    public final String component4() {
        return this.filePath;
    }

    @OOXIXo
    public final String component5() {
        return this.businessId;
    }

    @OOXIXo
    public final String component6() {
        return this.businessType;
    }

    @OOXIXo
    public final String component7() {
        return this.id;
    }

    @OOXIXo
    public final String component8() {
        return this.version;
    }

    @OOXIXo
    public final VideoFile copy(@OOXIXo String fileName, @OOXIXo String fileSize, @OOXIXo String fileType, @OOXIXo String filePath, @OOXIXo String businessId, @OOXIXo String businessType, @OOXIXo String id, @OOXIXo String version) {
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(fileSize, "fileSize");
        IIX0o.x0xO0oo(fileType, "fileType");
        IIX0o.x0xO0oo(filePath, "filePath");
        IIX0o.x0xO0oo(businessId, "businessId");
        IIX0o.x0xO0oo(businessType, "businessType");
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(version, "version");
        return new VideoFile(fileName, fileSize, fileType, filePath, businessId, businessType, id, version);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoFile)) {
            return false;
        }
        VideoFile videoFile = (VideoFile) obj;
        return IIX0o.Oxx0IOOO(this.fileName, videoFile.fileName) && IIX0o.Oxx0IOOO(this.fileSize, videoFile.fileSize) && IIX0o.Oxx0IOOO(this.fileType, videoFile.fileType) && IIX0o.Oxx0IOOO(this.filePath, videoFile.filePath) && IIX0o.Oxx0IOOO(this.businessId, videoFile.businessId) && IIX0o.Oxx0IOOO(this.businessType, videoFile.businessType) && IIX0o.Oxx0IOOO(this.id, videoFile.id) && IIX0o.Oxx0IOOO(this.version, videoFile.version);
    }

    @OOXIXo
    public final String getBusinessId() {
        return this.businessId;
    }

    @OOXIXo
    public final String getBusinessType() {
        return this.businessType;
    }

    @OOXIXo
    public final String getFileName() {
        return this.fileName;
    }

    @OOXIXo
    public final String getFilePath() {
        return this.filePath;
    }

    @OOXIXo
    public final String getFileSize() {
        return this.fileSize;
    }

    @OOXIXo
    public final String getFileType() {
        return this.fileType;
    }

    @OOXIXo
    public final String getId() {
        return this.id;
    }

    @OOXIXo
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((this.fileName.hashCode() * 31) + this.fileSize.hashCode()) * 31) + this.fileType.hashCode()) * 31) + this.filePath.hashCode()) * 31) + this.businessId.hashCode()) * 31) + this.businessType.hashCode()) * 31) + this.id.hashCode()) * 31) + this.version.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "VideoFile(fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", fileType=" + this.fileType + ", filePath=" + this.filePath + ", businessId=" + this.businessId + ", businessType=" + this.businessType + ", id=" + this.id + ", version=" + this.version + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ VideoFile(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) == 0 ? str8 : "");
    }

    public VideoFile(@OOXIXo String fileName, @OOXIXo String fileSize, @OOXIXo String fileType, @OOXIXo String filePath, @OOXIXo String businessId, @OOXIXo String businessType, @OOXIXo String id, @OOXIXo String version) {
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(fileSize, "fileSize");
        IIX0o.x0xO0oo(fileType, "fileType");
        IIX0o.x0xO0oo(filePath, "filePath");
        IIX0o.x0xO0oo(businessId, "businessId");
        IIX0o.x0xO0oo(businessType, "businessType");
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(version, "version");
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.filePath = filePath;
        this.businessId = businessId;
        this.businessType = businessType;
        this.id = id;
        this.version = version;
    }
}
