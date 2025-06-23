package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AccountCreateOrder extends JsonFieldContainer implements Serializable {
    private double amount;

    @OOXIXo
    private String createdAt;

    @OOXIXo
    private String createdBy;

    @OOXIXo
    private String eleId;

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
    private String remark;

    @OOXIXo
    private String updateAt;

    @OOXIXo
    private String updateBy;

    @OOXIXo
    private String userId;

    @OOXIXo
    private String valid;

    @OOXIXo
    private String version;

    public AccountCreateOrder() {
        this(null, null, null, null, null, null, XIXIX.OOXIXo.f3760XO, null, null, null, null, null, null, null, null, 32767, null);
    }

    @OOXIXo
    public final String component1() {
        return this.orderNum;
    }

    @OOXIXo
    public final String component10() {
        return this.id;
    }

    @OOXIXo
    public final String component11() {
        return this.version;
    }

    @OOXIXo
    public final String component12() {
        return this.createdBy;
    }

    @OOXIXo
    public final String component13() {
        return this.createdAt;
    }

    @OOXIXo
    public final String component14() {
        return this.updateBy;
    }

    @OOXIXo
    public final String component15() {
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
        return this.payType;
    }

    @OOXIXo
    public final String component6() {
        return this.payStatus;
    }

    public final double component7() {
        return this.amount;
    }

    @OOXIXo
    public final String component8() {
        return this.remark;
    }

    @OOXIXo
    public final String component9() {
        return this.valid;
    }

    @OOXIXo
    public final AccountCreateOrder copy(@OOXIXo String orderNum, @OOXIXo String userId, @OOXIXo String orderType, @OOXIXo String eleId, @OOXIXo String payType, @OOXIXo String payStatus, double d, @OOXIXo String remark, @OOXIXo String valid, @OOXIXo String id, @OOXIXo String version, @OOXIXo String createdBy, @OOXIXo String createdAt, @OOXIXo String updateBy, @OOXIXo String updateAt) {
        IIX0o.x0xO0oo(orderNum, "orderNum");
        IIX0o.x0xO0oo(userId, "userId");
        IIX0o.x0xO0oo(orderType, "orderType");
        IIX0o.x0xO0oo(eleId, "eleId");
        IIX0o.x0xO0oo(payType, "payType");
        IIX0o.x0xO0oo(payStatus, "payStatus");
        IIX0o.x0xO0oo(remark, "remark");
        IIX0o.x0xO0oo(valid, "valid");
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(version, "version");
        IIX0o.x0xO0oo(createdBy, "createdBy");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(updateBy, "updateBy");
        IIX0o.x0xO0oo(updateAt, "updateAt");
        return new AccountCreateOrder(orderNum, userId, orderType, eleId, payType, payStatus, d, remark, valid, id, version, createdBy, createdAt, updateBy, updateAt);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountCreateOrder)) {
            return false;
        }
        AccountCreateOrder accountCreateOrder = (AccountCreateOrder) obj;
        return IIX0o.Oxx0IOOO(this.orderNum, accountCreateOrder.orderNum) && IIX0o.Oxx0IOOO(this.userId, accountCreateOrder.userId) && IIX0o.Oxx0IOOO(this.orderType, accountCreateOrder.orderType) && IIX0o.Oxx0IOOO(this.eleId, accountCreateOrder.eleId) && IIX0o.Oxx0IOOO(this.payType, accountCreateOrder.payType) && IIX0o.Oxx0IOOO(this.payStatus, accountCreateOrder.payStatus) && Double.compare(this.amount, accountCreateOrder.amount) == 0 && IIX0o.Oxx0IOOO(this.remark, accountCreateOrder.remark) && IIX0o.Oxx0IOOO(this.valid, accountCreateOrder.valid) && IIX0o.Oxx0IOOO(this.id, accountCreateOrder.id) && IIX0o.Oxx0IOOO(this.version, accountCreateOrder.version) && IIX0o.Oxx0IOOO(this.createdBy, accountCreateOrder.createdBy) && IIX0o.Oxx0IOOO(this.createdAt, accountCreateOrder.createdAt) && IIX0o.Oxx0IOOO(this.updateBy, accountCreateOrder.updateBy) && IIX0o.Oxx0IOOO(this.updateAt, accountCreateOrder.updateAt);
    }

    public final double getAmount() {
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
    public final String getRemark() {
        return this.remark;
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
    public final String getValid() {
        return this.valid;
    }

    @OOXIXo
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.orderNum.hashCode() * 31) + this.userId.hashCode()) * 31) + this.orderType.hashCode()) * 31) + this.eleId.hashCode()) * 31) + this.payType.hashCode()) * 31) + this.payStatus.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.amount)) * 31) + this.remark.hashCode()) * 31) + this.valid.hashCode()) * 31) + this.id.hashCode()) * 31) + this.version.hashCode()) * 31) + this.createdBy.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.updateBy.hashCode()) * 31) + this.updateAt.hashCode();
    }

    public final void setAmount(double d) {
        this.amount = d;
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

    public final void setRemark(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.remark = str;
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

    public final void setValid(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.valid = str;
    }

    public final void setVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.version = str;
    }

    @OOXIXo
    public String toString() {
        return "AccountCreateOrder(orderNum=" + this.orderNum + ", userId=" + this.userId + ", orderType=" + this.orderType + ", eleId=" + this.eleId + ", payType=" + this.payType + ", payStatus=" + this.payStatus + ", amount=" + this.amount + ", remark=" + this.remark + ", valid=" + this.valid + ", id=" + this.id + ", version=" + this.version + ", createdBy=" + this.createdBy + ", createdAt=" + this.createdAt + ", updateBy=" + this.updateBy + ", updateAt=" + this.updateAt + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ AccountCreateOrder(String str, String str2, String str3, String str4, String str5, String str6, double d, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? XIXIX.OOXIXo.f3760XO : d, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? "" : str11, (i & 4096) != 0 ? "" : str12, (i & 8192) != 0 ? "" : str13, (i & 16384) != 0 ? "" : str14);
    }

    public AccountCreateOrder(@OOXIXo String orderNum, @OOXIXo String userId, @OOXIXo String orderType, @OOXIXo String eleId, @OOXIXo String payType, @OOXIXo String payStatus, double d, @OOXIXo String remark, @OOXIXo String valid, @OOXIXo String id, @OOXIXo String version, @OOXIXo String createdBy, @OOXIXo String createdAt, @OOXIXo String updateBy, @OOXIXo String updateAt) {
        IIX0o.x0xO0oo(orderNum, "orderNum");
        IIX0o.x0xO0oo(userId, "userId");
        IIX0o.x0xO0oo(orderType, "orderType");
        IIX0o.x0xO0oo(eleId, "eleId");
        IIX0o.x0xO0oo(payType, "payType");
        IIX0o.x0xO0oo(payStatus, "payStatus");
        IIX0o.x0xO0oo(remark, "remark");
        IIX0o.x0xO0oo(valid, "valid");
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
        this.payType = payType;
        this.payStatus = payStatus;
        this.amount = d;
        this.remark = remark;
        this.valid = valid;
        this.id = id;
        this.version = version;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updateBy = updateBy;
        this.updateAt = updateAt;
    }
}
