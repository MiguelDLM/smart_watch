package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AppVersion {

    @OOXIXo
    private String appName;

    @OOXIXo
    private String fileUrl;
    private int flag;
    private int id;

    @OOXIXo
    private String info;

    @OOXIXo
    private String platform;

    @OOXIXo
    private String version;

    public AppVersion() {
        this(0, null, null, null, null, null, 0, 127, null);
    }

    public static /* synthetic */ AppVersion copy$default(AppVersion appVersion, int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = appVersion.id;
        }
        if ((i3 & 2) != 0) {
            str = appVersion.appName;
        }
        String str6 = str;
        if ((i3 & 4) != 0) {
            str2 = appVersion.platform;
        }
        String str7 = str2;
        if ((i3 & 8) != 0) {
            str3 = appVersion.version;
        }
        String str8 = str3;
        if ((i3 & 16) != 0) {
            str4 = appVersion.fileUrl;
        }
        String str9 = str4;
        if ((i3 & 32) != 0) {
            str5 = appVersion.info;
        }
        String str10 = str5;
        if ((i3 & 64) != 0) {
            i2 = appVersion.flag;
        }
        return appVersion.copy(i, str6, str7, str8, str9, str10, i2);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.appName;
    }

    @OOXIXo
    public final String component3() {
        return this.platform;
    }

    @OOXIXo
    public final String component4() {
        return this.version;
    }

    @OOXIXo
    public final String component5() {
        return this.fileUrl;
    }

    @OOXIXo
    public final String component6() {
        return this.info;
    }

    public final int component7() {
        return this.flag;
    }

    @OOXIXo
    public final AppVersion copy(int i, @OOXIXo String appName, @OOXIXo String platform, @OOXIXo String version, @OOXIXo String fileUrl, @OOXIXo String info, int i2) {
        IIX0o.x0xO0oo(appName, "appName");
        IIX0o.x0xO0oo(platform, "platform");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(fileUrl, "fileUrl");
        IIX0o.x0xO0oo(info, "info");
        return new AppVersion(i, appName, platform, version, fileUrl, info, i2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppVersion)) {
            return false;
        }
        AppVersion appVersion = (AppVersion) obj;
        return this.id == appVersion.id && IIX0o.Oxx0IOOO(this.appName, appVersion.appName) && IIX0o.Oxx0IOOO(this.platform, appVersion.platform) && IIX0o.Oxx0IOOO(this.version, appVersion.version) && IIX0o.Oxx0IOOO(this.fileUrl, appVersion.fileUrl) && IIX0o.Oxx0IOOO(this.info, appVersion.info) && this.flag == appVersion.flag;
    }

    @OOXIXo
    public final String getAppName() {
        return this.appName;
    }

    @OOXIXo
    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final int getFlag() {
        return this.flag;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final String getInfo() {
        return this.info;
    }

    @OOXIXo
    public final String getPlatform() {
        return this.platform;
    }

    @OOXIXo
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((this.id * 31) + this.appName.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.version.hashCode()) * 31) + this.fileUrl.hashCode()) * 31) + this.info.hashCode()) * 31) + this.flag;
    }

    public final void setAppName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.appName = str;
    }

    public final void setFileUrl(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.fileUrl = str;
    }

    public final void setFlag(int i) {
        this.flag = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.info = str;
    }

    public final void setPlatform(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.platform = str;
    }

    public final void setVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.version = str;
    }

    @OOXIXo
    public String toString() {
        return "AppVersion(id=" + this.id + ", appName=" + this.appName + ", platform=" + this.platform + ", version=" + this.version + ", fileUrl=" + this.fileUrl + ", info=" + this.info + ", flag=" + this.flag + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AppVersion(int i, @OOXIXo String appName, @OOXIXo String platform, @OOXIXo String version, @OOXIXo String fileUrl, @OOXIXo String info, int i2) {
        IIX0o.x0xO0oo(appName, "appName");
        IIX0o.x0xO0oo(platform, "platform");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(fileUrl, "fileUrl");
        IIX0o.x0xO0oo(info, "info");
        this.id = i;
        this.appName = appName;
        this.platform = platform;
        this.version = version;
        this.fileUrl = fileUrl;
        this.info = info;
        this.flag = i2;
    }

    public /* synthetic */ AppVersion(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) == 0 ? str5 : "", (i3 & 64) != 0 ? 0 : i2);
    }
}
