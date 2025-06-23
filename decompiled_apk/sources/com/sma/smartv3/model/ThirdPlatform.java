package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ThirdPlatform {

    @OOXIXo
    private String accessToken;
    private long createTime;

    @OOXIXo
    private String extInfo;

    @OOXIXo
    private String id;

    @OOXIXo
    private String openId;

    @OOXIXo
    private String platform;
    private int projectId;
    private int replaced;
    private long updateTime;

    public ThirdPlatform() {
        this(null, 0, null, 0, null, null, null, 0L, 0L, 511, null);
    }

    @OOXIXo
    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.projectId;
    }

    @OOXIXo
    public final String component3() {
        return this.platform;
    }

    public final int component4() {
        return this.replaced;
    }

    @OOXIXo
    public final String component5() {
        return this.openId;
    }

    @OOXIXo
    public final String component6() {
        return this.accessToken;
    }

    @OOXIXo
    public final String component7() {
        return this.extInfo;
    }

    public final long component8() {
        return this.createTime;
    }

    public final long component9() {
        return this.updateTime;
    }

    @OOXIXo
    public final ThirdPlatform copy(@OOXIXo String id, int i, @OOXIXo String platform, int i2, @OOXIXo String openId, @OOXIXo String accessToken, @OOXIXo String extInfo, long j, long j2) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(platform, "platform");
        IIX0o.x0xO0oo(openId, "openId");
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(extInfo, "extInfo");
        return new ThirdPlatform(id, i, platform, i2, openId, accessToken, extInfo, j, j2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThirdPlatform)) {
            return false;
        }
        ThirdPlatform thirdPlatform = (ThirdPlatform) obj;
        return IIX0o.Oxx0IOOO(this.id, thirdPlatform.id) && this.projectId == thirdPlatform.projectId && IIX0o.Oxx0IOOO(this.platform, thirdPlatform.platform) && this.replaced == thirdPlatform.replaced && IIX0o.Oxx0IOOO(this.openId, thirdPlatform.openId) && IIX0o.Oxx0IOOO(this.accessToken, thirdPlatform.accessToken) && IIX0o.Oxx0IOOO(this.extInfo, thirdPlatform.extInfo) && this.createTime == thirdPlatform.createTime && this.updateTime == thirdPlatform.updateTime;
    }

    @OOXIXo
    public final String getAccessToken() {
        return this.accessToken;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @OOXIXo
    public final String getExtInfo() {
        return this.extInfo;
    }

    @OOXIXo
    public final String getId() {
        return this.id;
    }

    @OOXIXo
    public final String getOpenId() {
        return this.openId;
    }

    @OOXIXo
    public final String getPlatform() {
        return this.platform;
    }

    public final int getProjectId() {
        return this.projectId;
    }

    public final int getReplaced() {
        return this.replaced;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        return (((((((((((((((this.id.hashCode() * 31) + this.projectId) * 31) + this.platform.hashCode()) * 31) + this.replaced) * 31) + this.openId.hashCode()) * 31) + this.accessToken.hashCode()) * 31) + this.extInfo.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.createTime)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.updateTime);
    }

    public final void setAccessToken(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.accessToken = str;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final void setExtInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.extInfo = str;
    }

    public final void setId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.id = str;
    }

    public final void setOpenId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.openId = str;
    }

    public final void setPlatform(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.platform = str;
    }

    public final void setProjectId(int i) {
        this.projectId = i;
    }

    public final void setReplaced(int i) {
        this.replaced = i;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }

    @OOXIXo
    public String toString() {
        return "ThirdPlatform(id=" + this.id + ", projectId=" + this.projectId + ", platform=" + this.platform + ", replaced=" + this.replaced + ", openId=" + this.openId + ", accessToken=" + this.accessToken + ", extInfo=" + this.extInfo + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + HexStringBuilder.COMMENT_END_CHAR;
    }

    public ThirdPlatform(@OOXIXo String id, int i, @OOXIXo String platform, int i2, @OOXIXo String openId, @OOXIXo String accessToken, @OOXIXo String extInfo, long j, long j2) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(platform, "platform");
        IIX0o.x0xO0oo(openId, "openId");
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(extInfo, "extInfo");
        this.id = id;
        this.projectId = i;
        this.platform = platform;
        this.replaced = i2;
        this.openId = openId;
        this.accessToken = accessToken;
        this.extInfo = extInfo;
        this.createTime = j;
        this.updateTime = j2;
    }

    public /* synthetic */ ThirdPlatform(String str, int i, String str2, int i2, String str3, String str4, String str5, long j, long j2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "" : str2, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? "" : str4, (i3 & 64) == 0 ? str5 : "", (i3 & 128) != 0 ? 0L : j, (i3 & 256) == 0 ? j2 : 0L);
    }
}
