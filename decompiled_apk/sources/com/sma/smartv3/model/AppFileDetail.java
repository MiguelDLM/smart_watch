package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AppFileDetail extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String appDetailImgs;

    @OOXIXo
    private final String appGroupId;

    @OOXIXo
    private final String appGroupName;

    @OOXIXo
    private final String appModuleName;

    @OOXIXo
    private final String appName;
    private final boolean appNewFlag;

    @oOoXoXO
    private final String appPack;

    @OOXIXo
    private final String appPackName;

    @OOXIXo
    private final String appPackVersion;

    @OOXIXo
    private final String appPreImg;
    private final double appSize;

    @OOXIXo
    private final String createdAt;
    private final long id;

    public AppFileDetail() {
        this(null, null, XIXIX.OOXIXo.f3760XO, 0L, null, null, null, null, null, null, null, null, false, 8191, null);
    }

    @OOXIXo
    public final String component1() {
        return this.appGroupId;
    }

    @OOXIXo
    public final String component10() {
        return this.appGroupName;
    }

    @OOXIXo
    public final String component11() {
        return this.appModuleName;
    }

    @OOXIXo
    public final String component12() {
        return this.appPackVersion;
    }

    public final boolean component13() {
        return this.appNewFlag;
    }

    @OOXIXo
    public final String component2() {
        return this.appName;
    }

    public final double component3() {
        return this.appSize;
    }

    public final long component4() {
        return this.id;
    }

    @OOXIXo
    public final String component5() {
        return this.createdAt;
    }

    @OOXIXo
    public final String component6() {
        return this.appPreImg;
    }

    @OOXIXo
    public final String component7() {
        return this.appDetailImgs;
    }

    @oOoXoXO
    public final String component8() {
        return this.appPack;
    }

    @OOXIXo
    public final String component9() {
        return this.appPackName;
    }

    @OOXIXo
    public final AppFileDetail copy(@OOXIXo String appGroupId, @OOXIXo String appName, double d, long j, @OOXIXo String createdAt, @OOXIXo String appPreImg, @OOXIXo String appDetailImgs, @oOoXoXO String str, @OOXIXo String appPackName, @OOXIXo String appGroupName, @OOXIXo String appModuleName, @OOXIXo String appPackVersion, boolean z) {
        IIX0o.x0xO0oo(appGroupId, "appGroupId");
        IIX0o.x0xO0oo(appName, "appName");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(appPreImg, "appPreImg");
        IIX0o.x0xO0oo(appDetailImgs, "appDetailImgs");
        IIX0o.x0xO0oo(appPackName, "appPackName");
        IIX0o.x0xO0oo(appGroupName, "appGroupName");
        IIX0o.x0xO0oo(appModuleName, "appModuleName");
        IIX0o.x0xO0oo(appPackVersion, "appPackVersion");
        return new AppFileDetail(appGroupId, appName, d, j, createdAt, appPreImg, appDetailImgs, str, appPackName, appGroupName, appModuleName, appPackVersion, z);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppFileDetail)) {
            return false;
        }
        AppFileDetail appFileDetail = (AppFileDetail) obj;
        return IIX0o.Oxx0IOOO(this.appGroupId, appFileDetail.appGroupId) && IIX0o.Oxx0IOOO(this.appName, appFileDetail.appName) && Double.compare(this.appSize, appFileDetail.appSize) == 0 && this.id == appFileDetail.id && IIX0o.Oxx0IOOO(this.createdAt, appFileDetail.createdAt) && IIX0o.Oxx0IOOO(this.appPreImg, appFileDetail.appPreImg) && IIX0o.Oxx0IOOO(this.appDetailImgs, appFileDetail.appDetailImgs) && IIX0o.Oxx0IOOO(this.appPack, appFileDetail.appPack) && IIX0o.Oxx0IOOO(this.appPackName, appFileDetail.appPackName) && IIX0o.Oxx0IOOO(this.appGroupName, appFileDetail.appGroupName) && IIX0o.Oxx0IOOO(this.appModuleName, appFileDetail.appModuleName) && IIX0o.Oxx0IOOO(this.appPackVersion, appFileDetail.appPackVersion) && this.appNewFlag == appFileDetail.appNewFlag;
    }

    @OOXIXo
    public final String getAppDetailImgs() {
        return this.appDetailImgs;
    }

    @OOXIXo
    public final String getAppGroupId() {
        return this.appGroupId;
    }

    @OOXIXo
    public final String getAppGroupName() {
        return this.appGroupName;
    }

    @OOXIXo
    public final String getAppModuleName() {
        return this.appModuleName;
    }

    @OOXIXo
    public final String getAppName() {
        return this.appName;
    }

    public final boolean getAppNewFlag() {
        return this.appNewFlag;
    }

    @oOoXoXO
    public final String getAppPack() {
        return this.appPack;
    }

    @OOXIXo
    public final String getAppPackName() {
        return this.appPackName;
    }

    @OOXIXo
    public final String getAppPackVersion() {
        return this.appPackVersion;
    }

    @OOXIXo
    public final String getAppPreImg() {
        return this.appPreImg;
    }

    public final double getAppSize() {
        return this.appSize;
    }

    @OOXIXo
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.appGroupId.hashCode() * 31) + this.appName.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.appSize)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.id)) * 31) + this.createdAt.hashCode()) * 31) + this.appPreImg.hashCode()) * 31) + this.appDetailImgs.hashCode()) * 31;
        String str = this.appPack;
        return ((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.appPackName.hashCode()) * 31) + this.appGroupName.hashCode()) * 31) + this.appModuleName.hashCode()) * 31) + this.appPackVersion.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.appNewFlag);
    }

    @OOXIXo
    public String toString() {
        return "AppFileDetail(appGroupId=" + this.appGroupId + ", appName=" + this.appName + ", appSize=" + this.appSize + ", id=" + this.id + ", createdAt=" + this.createdAt + ", appPreImg=" + this.appPreImg + ", appDetailImgs=" + this.appDetailImgs + ", appPack=" + this.appPack + ", appPackName=" + this.appPackName + ", appGroupName=" + this.appGroupName + ", appModuleName=" + this.appModuleName + ", appPackVersion=" + this.appPackVersion + ", appNewFlag=" + this.appNewFlag + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ AppFileDetail(String str, String str2, double d, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? XIXIX.OOXIXo.f3760XO : d, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? "" : str8, (i & 1024) != 0 ? "" : str9, (i & 2048) == 0 ? str10 : "", (i & 4096) != 0 ? false : z);
    }

    public AppFileDetail(@OOXIXo String appGroupId, @OOXIXo String appName, double d, long j, @OOXIXo String createdAt, @OOXIXo String appPreImg, @OOXIXo String appDetailImgs, @oOoXoXO String str, @OOXIXo String appPackName, @OOXIXo String appGroupName, @OOXIXo String appModuleName, @OOXIXo String appPackVersion, boolean z) {
        IIX0o.x0xO0oo(appGroupId, "appGroupId");
        IIX0o.x0xO0oo(appName, "appName");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(appPreImg, "appPreImg");
        IIX0o.x0xO0oo(appDetailImgs, "appDetailImgs");
        IIX0o.x0xO0oo(appPackName, "appPackName");
        IIX0o.x0xO0oo(appGroupName, "appGroupName");
        IIX0o.x0xO0oo(appModuleName, "appModuleName");
        IIX0o.x0xO0oo(appPackVersion, "appPackVersion");
        this.appGroupId = appGroupId;
        this.appName = appName;
        this.appSize = d;
        this.id = j;
        this.createdAt = createdAt;
        this.appPreImg = appPreImg;
        this.appDetailImgs = appDetailImgs;
        this.appPack = str;
        this.appPackName = appPackName;
        this.appGroupName = appGroupName;
        this.appModuleName = appModuleName;
        this.appPackVersion = appPackVersion;
        this.appNewFlag = z;
    }
}
