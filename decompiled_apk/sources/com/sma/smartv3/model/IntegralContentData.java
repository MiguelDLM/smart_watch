package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class IntegralContentData extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private String accountId;
    private int changeFlag;

    @OOXIXo
    private String createdAt;

    @OOXIXo
    private String createdBy;

    @OOXIXo
    private String id;

    @OOXIXo
    private String pointsChange;

    @OOXIXo
    private String recordItem;

    @OOXIXo
    private String updateAt;

    @OOXIXo
    private String updateBy;
    private float version;

    public IntegralContentData() {
        this(null, null, null, null, 0.0f, null, 0, null, null, null, 1023, null);
    }

    @OOXIXo
    public final String component1() {
        return this.accountId;
    }

    @OOXIXo
    public final String component10() {
        return this.updateAt;
    }

    @OOXIXo
    public final String component2() {
        return this.recordItem;
    }

    @OOXIXo
    public final String component3() {
        return this.pointsChange;
    }

    @OOXIXo
    public final String component4() {
        return this.id;
    }

    public final float component5() {
        return this.version;
    }

    @OOXIXo
    public final String component6() {
        return this.createdBy;
    }

    public final int component7() {
        return this.changeFlag;
    }

    @OOXIXo
    public final String component8() {
        return this.createdAt;
    }

    @OOXIXo
    public final String component9() {
        return this.updateBy;
    }

    @OOXIXo
    public final IntegralContentData copy(@OOXIXo String accountId, @OOXIXo String recordItem, @OOXIXo String pointsChange, @OOXIXo String id, float f, @OOXIXo String createdBy, int i, @OOXIXo String createdAt, @OOXIXo String updateBy, @OOXIXo String updateAt) {
        IIX0o.x0xO0oo(accountId, "accountId");
        IIX0o.x0xO0oo(recordItem, "recordItem");
        IIX0o.x0xO0oo(pointsChange, "pointsChange");
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(createdBy, "createdBy");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(updateBy, "updateBy");
        IIX0o.x0xO0oo(updateAt, "updateAt");
        return new IntegralContentData(accountId, recordItem, pointsChange, id, f, createdBy, i, createdAt, updateBy, updateAt);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntegralContentData)) {
            return false;
        }
        IntegralContentData integralContentData = (IntegralContentData) obj;
        return IIX0o.Oxx0IOOO(this.accountId, integralContentData.accountId) && IIX0o.Oxx0IOOO(this.recordItem, integralContentData.recordItem) && IIX0o.Oxx0IOOO(this.pointsChange, integralContentData.pointsChange) && IIX0o.Oxx0IOOO(this.id, integralContentData.id) && Float.compare(this.version, integralContentData.version) == 0 && IIX0o.Oxx0IOOO(this.createdBy, integralContentData.createdBy) && this.changeFlag == integralContentData.changeFlag && IIX0o.Oxx0IOOO(this.createdAt, integralContentData.createdAt) && IIX0o.Oxx0IOOO(this.updateBy, integralContentData.updateBy) && IIX0o.Oxx0IOOO(this.updateAt, integralContentData.updateAt);
    }

    @OOXIXo
    public final String getAccountId() {
        return this.accountId;
    }

    public final int getChangeFlag() {
        return this.changeFlag;
    }

    @OOXIXo
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @OOXIXo
    public final String getCreatedBy() {
        return this.createdBy;
    }

    @OOXIXo
    public final String getId() {
        return this.id;
    }

    @OOXIXo
    public final String getPointsChange() {
        return this.pointsChange;
    }

    @OOXIXo
    public final String getRecordItem() {
        return this.recordItem;
    }

    @OOXIXo
    public final String getUpdateAt() {
        return this.updateAt;
    }

    @OOXIXo
    public final String getUpdateBy() {
        return this.updateBy;
    }

    public final float getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((this.accountId.hashCode() * 31) + this.recordItem.hashCode()) * 31) + this.pointsChange.hashCode()) * 31) + this.id.hashCode()) * 31) + Float.floatToIntBits(this.version)) * 31) + this.createdBy.hashCode()) * 31) + this.changeFlag) * 31) + this.createdAt.hashCode()) * 31) + this.updateBy.hashCode()) * 31) + this.updateAt.hashCode();
    }

    public final void setAccountId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.accountId = str;
    }

    public final void setChangeFlag(int i) {
        this.changeFlag = i;
    }

    public final void setCreatedAt(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.createdAt = str;
    }

    public final void setCreatedBy(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.createdBy = str;
    }

    public final void setId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.id = str;
    }

    public final void setPointsChange(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.pointsChange = str;
    }

    public final void setRecordItem(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.recordItem = str;
    }

    public final void setUpdateAt(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.updateAt = str;
    }

    public final void setUpdateBy(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.updateBy = str;
    }

    public final void setVersion(float f) {
        this.version = f;
    }

    @OOXIXo
    public String toString() {
        return "IntegralContentData(accountId=" + this.accountId + ", recordItem=" + this.recordItem + ", pointsChange=" + this.pointsChange + ", id=" + this.id + ", version=" + this.version + ", createdBy=" + this.createdBy + ", changeFlag=" + this.changeFlag + ", createdAt=" + this.createdAt + ", updateBy=" + this.updateBy + ", updateAt=" + this.updateAt + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ IntegralContentData(String str, String str2, String str3, String str4, float f, String str5, int i, String str6, String str7, String str8, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? 0.0f : f, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) == 0 ? str8 : "");
    }

    public IntegralContentData(@OOXIXo String accountId, @OOXIXo String recordItem, @OOXIXo String pointsChange, @OOXIXo String id, float f, @OOXIXo String createdBy, int i, @OOXIXo String createdAt, @OOXIXo String updateBy, @OOXIXo String updateAt) {
        IIX0o.x0xO0oo(accountId, "accountId");
        IIX0o.x0xO0oo(recordItem, "recordItem");
        IIX0o.x0xO0oo(pointsChange, "pointsChange");
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(createdBy, "createdBy");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(updateBy, "updateBy");
        IIX0o.x0xO0oo(updateAt, "updateAt");
        this.accountId = accountId;
        this.recordItem = recordItem;
        this.pointsChange = pointsChange;
        this.id = id;
        this.version = f;
        this.createdBy = createdBy;
        this.changeFlag = i;
        this.createdAt = createdAt;
        this.updateBy = updateBy;
        this.updateAt = updateAt;
    }
}
