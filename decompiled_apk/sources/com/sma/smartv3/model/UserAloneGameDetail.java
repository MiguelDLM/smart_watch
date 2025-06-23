package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class UserAloneGameDetail extends JsonFieldContainer implements Serializable {
    private float amount;
    private float dollar;

    @OOXIXo
    private String gid;
    private float originalAmount;

    @OOXIXo
    private String payStatus;

    @OOXIXo
    private String priceUnit;

    public UserAloneGameDetail() {
        this(null, 0.0f, 0.0f, 0.0f, null, null, 63, null);
    }

    public static /* synthetic */ UserAloneGameDetail copy$default(UserAloneGameDetail userAloneGameDetail, String str, float f, float f2, float f3, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAloneGameDetail.gid;
        }
        if ((i & 2) != 0) {
            f = userAloneGameDetail.amount;
        }
        float f4 = f;
        if ((i & 4) != 0) {
            f2 = userAloneGameDetail.dollar;
        }
        float f5 = f2;
        if ((i & 8) != 0) {
            f3 = userAloneGameDetail.originalAmount;
        }
        float f6 = f3;
        if ((i & 16) != 0) {
            str2 = userAloneGameDetail.priceUnit;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            str3 = userAloneGameDetail.payStatus;
        }
        return userAloneGameDetail.copy(str, f4, f5, f6, str4, str3);
    }

    @OOXIXo
    public final String component1() {
        return this.gid;
    }

    public final float component2() {
        return this.amount;
    }

    public final float component3() {
        return this.dollar;
    }

    public final float component4() {
        return this.originalAmount;
    }

    @OOXIXo
    public final String component5() {
        return this.priceUnit;
    }

    @OOXIXo
    public final String component6() {
        return this.payStatus;
    }

    @OOXIXo
    public final UserAloneGameDetail copy(@OOXIXo String gid, float f, float f2, float f3, @OOXIXo String priceUnit, @OOXIXo String payStatus) {
        IIX0o.x0xO0oo(gid, "gid");
        IIX0o.x0xO0oo(priceUnit, "priceUnit");
        IIX0o.x0xO0oo(payStatus, "payStatus");
        return new UserAloneGameDetail(gid, f, f2, f3, priceUnit, payStatus);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserAloneGameDetail)) {
            return false;
        }
        UserAloneGameDetail userAloneGameDetail = (UserAloneGameDetail) obj;
        return IIX0o.Oxx0IOOO(this.gid, userAloneGameDetail.gid) && Float.compare(this.amount, userAloneGameDetail.amount) == 0 && Float.compare(this.dollar, userAloneGameDetail.dollar) == 0 && Float.compare(this.originalAmount, userAloneGameDetail.originalAmount) == 0 && IIX0o.Oxx0IOOO(this.priceUnit, userAloneGameDetail.priceUnit) && IIX0o.Oxx0IOOO(this.payStatus, userAloneGameDetail.payStatus);
    }

    public final float getAmount() {
        return this.amount;
    }

    public final float getDollar() {
        return this.dollar;
    }

    @OOXIXo
    public final String getGid() {
        return this.gid;
    }

    public final float getOriginalAmount() {
        return this.originalAmount;
    }

    @OOXIXo
    public final String getPayStatus() {
        return this.payStatus;
    }

    @OOXIXo
    public final String getPriceUnit() {
        return this.priceUnit;
    }

    public int hashCode() {
        return (((((((((this.gid.hashCode() * 31) + Float.floatToIntBits(this.amount)) * 31) + Float.floatToIntBits(this.dollar)) * 31) + Float.floatToIntBits(this.originalAmount)) * 31) + this.priceUnit.hashCode()) * 31) + this.payStatus.hashCode();
    }

    public final void setAmount(float f) {
        this.amount = f;
    }

    public final void setDollar(float f) {
        this.dollar = f;
    }

    public final void setGid(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.gid = str;
    }

    public final void setOriginalAmount(float f) {
        this.originalAmount = f;
    }

    public final void setPayStatus(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.payStatus = str;
    }

    public final void setPriceUnit(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.priceUnit = str;
    }

    @OOXIXo
    public String toString() {
        return "UserAloneGameDetail(gid=" + this.gid + ", amount=" + this.amount + ", dollar=" + this.dollar + ", originalAmount=" + this.originalAmount + ", priceUnit=" + this.priceUnit + ", payStatus=" + this.payStatus + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ UserAloneGameDetail(String str, float f, float f2, float f3, String str2, String str3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 6.0f : f, (i & 4) != 0 ? 0.99f : f2, (i & 8) != 0 ? 9.0f : f3, (i & 16) == 0 ? str2 : "", (i & 32) != 0 ? "Undefined" : str3);
    }

    public UserAloneGameDetail(@OOXIXo String gid, float f, float f2, float f3, @OOXIXo String priceUnit, @OOXIXo String payStatus) {
        IIX0o.x0xO0oo(gid, "gid");
        IIX0o.x0xO0oo(priceUnit, "priceUnit");
        IIX0o.x0xO0oo(payStatus, "payStatus");
        this.gid = gid;
        this.amount = f;
        this.dollar = f2;
        this.originalAmount = f3;
        this.priceUnit = priceUnit;
        this.payStatus = payStatus;
    }
}
