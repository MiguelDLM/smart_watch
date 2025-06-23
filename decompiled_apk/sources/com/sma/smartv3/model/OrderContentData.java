package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class OrderContentData extends JsonFieldContainer implements Serializable {
    private float amount;

    @OOXIXo
    private String createdAt;

    @OOXIXo
    private String createdBy;

    @OOXIXo
    private String eleId;

    @OOXIXo
    private String elePath;

    @OOXIXo
    private String id;

    @OOXIXo
    private String orderNum;

    @OOXIXo
    private String orderType;

    @OOXIXo
    private String payStatus;

    @OOXIXo
    private String payType;

    @OOXIXo
    private String priceUnit;

    @OOXIXo
    private String remark;

    @OOXIXo
    private String subject;

    @OOXIXo
    private String updateAt;

    @OOXIXo
    private String updateBy;

    @OOXIXo
    private String userId;

    @OOXIXo
    private String version;

    public OrderContentData() {
        this(null, null, null, null, null, null, null, null, 0.0f, null, null, null, null, null, null, null, null, 131071, null);
    }

    @OOXIXo
    public final String component1() {
        return this.orderNum;
    }

    @OOXIXo
    public final String component10() {
        return this.priceUnit;
    }

    @OOXIXo
    public final String component11() {
        return this.remark;
    }

    @OOXIXo
    public final String component12() {
        return this.id;
    }

    @OOXIXo
    public final String component13() {
        return this.version;
    }

    @OOXIXo
    public final String component14() {
        return this.createdBy;
    }

    @OOXIXo
    public final String component15() {
        return this.createdAt;
    }

    @OOXIXo
    public final String component16() {
        return this.updateBy;
    }

    @OOXIXo
    public final String component17() {
        return this.updateAt;
    }

    @OOXIXo
    public final String component2() {
        return this.userId;
    }

    @OOXIXo
    public final String component3() {
        return this.orderType;
    }

    @OOXIXo
    public final String component4() {
        return this.eleId;
    }

    @OOXIXo
    public final String component5() {
        return this.elePath;
    }

    @OOXIXo
    public final String component6() {
        return this.subject;
    }

    @OOXIXo
    public final String component7() {
        return this.payType;
    }

    @OOXIXo
    public final String component8() {
        return this.payStatus;
    }

    public final float component9() {
        return this.amount;
    }

    @OOXIXo
    public final OrderContentData copy(@OOXIXo String orderNum, @OOXIXo String userId, @OOXIXo String orderType, @OOXIXo String eleId, @OOXIXo String elePath, @OOXIXo String subject, @OOXIXo String payType, @OOXIXo String payStatus, float f, @OOXIXo String priceUnit, @OOXIXo String remark, @OOXIXo String id, @OOXIXo String version, @OOXIXo String createdBy, @OOXIXo String createdAt, @OOXIXo String updateBy, @OOXIXo String updateAt) {
        IIX0o.x0xO0oo(orderNum, "orderNum");
        IIX0o.x0xO0oo(userId, "userId");
        IIX0o.x0xO0oo(orderType, "orderType");
        IIX0o.x0xO0oo(eleId, "eleId");
        IIX0o.x0xO0oo(elePath, "elePath");
        IIX0o.x0xO0oo(subject, "subject");
        IIX0o.x0xO0oo(payType, "payType");
        IIX0o.x0xO0oo(payStatus, "payStatus");
        IIX0o.x0xO0oo(priceUnit, "priceUnit");
        IIX0o.x0xO0oo(remark, "remark");
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(createdBy, "createdBy");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(updateBy, "updateBy");
        IIX0o.x0xO0oo(updateAt, "updateAt");
        return new OrderContentData(orderNum, userId, orderType, eleId, elePath, subject, payType, payStatus, f, priceUnit, remark, id, version, createdBy, createdAt, updateBy, updateAt);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderContentData)) {
            return false;
        }
        OrderContentData orderContentData = (OrderContentData) obj;
        return IIX0o.Oxx0IOOO(this.orderNum, orderContentData.orderNum) && IIX0o.Oxx0IOOO(this.userId, orderContentData.userId) && IIX0o.Oxx0IOOO(this.orderType, orderContentData.orderType) && IIX0o.Oxx0IOOO(this.eleId, orderContentData.eleId) && IIX0o.Oxx0IOOO(this.elePath, orderContentData.elePath) && IIX0o.Oxx0IOOO(this.subject, orderContentData.subject) && IIX0o.Oxx0IOOO(this.payType, orderContentData.payType) && IIX0o.Oxx0IOOO(this.payStatus, orderContentData.payStatus) && Float.compare(this.amount, orderContentData.amount) == 0 && IIX0o.Oxx0IOOO(this.priceUnit, orderContentData.priceUnit) && IIX0o.Oxx0IOOO(this.remark, orderContentData.remark) && IIX0o.Oxx0IOOO(this.id, orderContentData.id) && IIX0o.Oxx0IOOO(this.version, orderContentData.version) && IIX0o.Oxx0IOOO(this.createdBy, orderContentData.createdBy) && IIX0o.Oxx0IOOO(this.createdAt, orderContentData.createdAt) && IIX0o.Oxx0IOOO(this.updateBy, orderContentData.updateBy) && IIX0o.Oxx0IOOO(this.updateAt, orderContentData.updateAt);
    }

    public final float getAmount() {
        return this.amount;
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
    public final String getEleId() {
        return this.eleId;
    }

    @OOXIXo
    public final String getElePath() {
        return this.elePath;
    }

    @OOXIXo
    public final String getId() {
        return this.id;
    }

    @OOXIXo
    public final String getOrderNum() {
        return this.orderNum;
    }

    @OOXIXo
    public final String getOrderType() {
        return this.orderType;
    }

    @OOXIXo
    public final String getPayStatus() {
        return this.payStatus;
    }

    @OOXIXo
    public final String getPayType() {
        return this.payType;
    }

    @OOXIXo
    public final String getPriceUnit() {
        return this.priceUnit;
    }

    @OOXIXo
    public final String getRemark() {
        return this.remark;
    }

    @OOXIXo
    public final String getSubject() {
        return this.subject;
    }

    @OOXIXo
    public final String getUpdateAt() {
        return this.updateAt;
    }

    @OOXIXo
    public final String getUpdateBy() {
        return this.updateBy;
    }

    @OOXIXo
    public final String getUserId() {
        return this.userId;
    }

    @OOXIXo
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.orderNum.hashCode() * 31) + this.userId.hashCode()) * 31) + this.orderType.hashCode()) * 31) + this.eleId.hashCode()) * 31) + this.elePath.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.payType.hashCode()) * 31) + this.payStatus.hashCode()) * 31) + Float.floatToIntBits(this.amount)) * 31) + this.priceUnit.hashCode()) * 31) + this.remark.hashCode()) * 31) + this.id.hashCode()) * 31) + this.version.hashCode()) * 31) + this.createdBy.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.updateBy.hashCode()) * 31) + this.updateAt.hashCode();
    }

    public final void setAmount(float f) {
        this.amount = f;
    }

    public final void setCreatedAt(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.createdAt = str;
    }

    public final void setCreatedBy(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.createdBy = str;
    }

    public final void setEleId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.eleId = str;
    }

    public final void setElePath(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.elePath = str;
    }

    public final void setId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.id = str;
    }

    public final void setOrderNum(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.orderNum = str;
    }

    public final void setOrderType(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.orderType = str;
    }

    public final void setPayStatus(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.payStatus = str;
    }

    public final void setPayType(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.payType = str;
    }

    public final void setPriceUnit(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.priceUnit = str;
    }

    public final void setRemark(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.remark = str;
    }

    public final void setSubject(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.subject = str;
    }

    public final void setUpdateAt(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.updateAt = str;
    }

    public final void setUpdateBy(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.updateBy = str;
    }

    public final void setUserId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.userId = str;
    }

    public final void setVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.version = str;
    }

    @OOXIXo
    public String toString() {
        return "OrderContentData(orderNum=" + this.orderNum + ", userId=" + this.userId + ", orderType=" + this.orderType + ", eleId=" + this.eleId + ", elePath=" + this.elePath + ", subject=" + this.subject + ", payType=" + this.payType + ", payStatus=" + this.payStatus + ", amount=" + this.amount + ", priceUnit=" + this.priceUnit + ", remark=" + this.remark + ", id=" + this.id + ", version=" + this.version + ", createdBy=" + this.createdBy + ", createdAt=" + this.createdAt + ", updateBy=" + this.updateBy + ", updateAt=" + this.updateAt + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ OrderContentData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, float f, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "0" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? 0.0f : f, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? "" : str11, (i & 4096) != 0 ? "" : str12, (i & 8192) != 0 ? "" : str13, (i & 16384) != 0 ? "" : str14, (i & 32768) != 0 ? "" : str15, (i & 65536) != 0 ? "" : str16);
    }

    public OrderContentData(@OOXIXo String orderNum, @OOXIXo String userId, @OOXIXo String orderType, @OOXIXo String eleId, @OOXIXo String elePath, @OOXIXo String subject, @OOXIXo String payType, @OOXIXo String payStatus, float f, @OOXIXo String priceUnit, @OOXIXo String remark, @OOXIXo String id, @OOXIXo String version, @OOXIXo String createdBy, @OOXIXo String createdAt, @OOXIXo String updateBy, @OOXIXo String updateAt) {
        IIX0o.x0xO0oo(orderNum, "orderNum");
        IIX0o.x0xO0oo(userId, "userId");
        IIX0o.x0xO0oo(orderType, "orderType");
        IIX0o.x0xO0oo(eleId, "eleId");
        IIX0o.x0xO0oo(elePath, "elePath");
        IIX0o.x0xO0oo(subject, "subject");
        IIX0o.x0xO0oo(payType, "payType");
        IIX0o.x0xO0oo(payStatus, "payStatus");
        IIX0o.x0xO0oo(priceUnit, "priceUnit");
        IIX0o.x0xO0oo(remark, "remark");
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(createdBy, "createdBy");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(updateBy, "updateBy");
        IIX0o.x0xO0oo(updateAt, "updateAt");
        this.orderNum = orderNum;
        this.userId = userId;
        this.orderType = orderType;
        this.eleId = eleId;
        this.elePath = elePath;
        this.subject = subject;
        this.payType = payType;
        this.payStatus = payStatus;
        this.amount = f;
        this.priceUnit = priceUnit;
        this.remark = remark;
        this.id = id;
        this.version = version;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updateBy = updateBy;
        this.updateAt = updateAt;
    }
}
