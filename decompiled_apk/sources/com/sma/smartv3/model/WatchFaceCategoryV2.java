package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class WatchFaceCategoryV2 extends JsonFieldContainer implements Serializable {
    private final float amount;
    private float amountDis;

    @OOXIXo
    private final String binUrl;

    @OOXIXo
    private final String createdAt;

    @oOoXoXO
    private final String dialType;

    @OOXIXo
    private String discount;
    private final float dollar;

    @OOXIXo
    private String dollarCodeDis;
    private float dollarDis;
    private final int id;
    private boolean limitFreeFlag;

    @OOXIXo
    private String memberAttr;
    private boolean newFlag;

    @oOoXoXO
    private String payStatus;

    @OOXIXo
    private final String previewUrl;

    @OOXIXo
    private final String resolutionType;

    @OOXIXo
    private final String screenType;

    @OOXIXo
    private final String updateAt;
    private final int version;

    public WatchFaceCategoryV2() {
        this(null, 0, null, null, false, null, null, null, null, null, 0, 0.0f, 0.0f, null, false, null, 0.0f, 0.0f, null, 524287, null);
    }

    @OOXIXo
    public final String component1() {
        return this.screenType;
    }

    @OOXIXo
    public final String component10() {
        return this.updateAt;
    }

    public final int component11() {
        return this.version;
    }

    public final float component12() {
        return this.amount;
    }

    public final float component13() {
        return this.dollar;
    }

    @oOoXoXO
    public final String component14() {
        return this.payStatus;
    }

    public final boolean component15() {
        return this.newFlag;
    }

    @OOXIXo
    public final String component16() {
        return this.discount;
    }

    public final float component17() {
        return this.amountDis;
    }

    public final float component18() {
        return this.dollarDis;
    }

    @OOXIXo
    public final String component19() {
        return this.dollarCodeDis;
    }

    public final int component2() {
        return this.id;
    }

    @oOoXoXO
    public final String component3() {
        return this.dialType;
    }

    @OOXIXo
    public final String component4() {
        return this.resolutionType;
    }

    public final boolean component5() {
        return this.limitFreeFlag;
    }

    @OOXIXo
    public final String component6() {
        return this.memberAttr;
    }

    @OOXIXo
    public final String component7() {
        return this.binUrl;
    }

    @OOXIXo
    public final String component8() {
        return this.previewUrl;
    }

    @OOXIXo
    public final String component9() {
        return this.createdAt;
    }

    @OOXIXo
    public final WatchFaceCategoryV2 copy(@OOXIXo String screenType, int i, @oOoXoXO String str, @OOXIXo String resolutionType, boolean z, @OOXIXo String memberAttr, @OOXIXo String binUrl, @OOXIXo String previewUrl, @OOXIXo String createdAt, @OOXIXo String updateAt, int i2, float f, float f2, @oOoXoXO String str2, boolean z2, @OOXIXo String discount, float f3, float f4, @OOXIXo String dollarCodeDis) {
        IIX0o.x0xO0oo(screenType, "screenType");
        IIX0o.x0xO0oo(resolutionType, "resolutionType");
        IIX0o.x0xO0oo(memberAttr, "memberAttr");
        IIX0o.x0xO0oo(binUrl, "binUrl");
        IIX0o.x0xO0oo(previewUrl, "previewUrl");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(updateAt, "updateAt");
        IIX0o.x0xO0oo(discount, "discount");
        IIX0o.x0xO0oo(dollarCodeDis, "dollarCodeDis");
        return new WatchFaceCategoryV2(screenType, i, str, resolutionType, z, memberAttr, binUrl, previewUrl, createdAt, updateAt, i2, f, f2, str2, z2, discount, f3, f4, dollarCodeDis);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchFaceCategoryV2)) {
            return false;
        }
        WatchFaceCategoryV2 watchFaceCategoryV2 = (WatchFaceCategoryV2) obj;
        return IIX0o.Oxx0IOOO(this.screenType, watchFaceCategoryV2.screenType) && this.id == watchFaceCategoryV2.id && IIX0o.Oxx0IOOO(this.dialType, watchFaceCategoryV2.dialType) && IIX0o.Oxx0IOOO(this.resolutionType, watchFaceCategoryV2.resolutionType) && this.limitFreeFlag == watchFaceCategoryV2.limitFreeFlag && IIX0o.Oxx0IOOO(this.memberAttr, watchFaceCategoryV2.memberAttr) && IIX0o.Oxx0IOOO(this.binUrl, watchFaceCategoryV2.binUrl) && IIX0o.Oxx0IOOO(this.previewUrl, watchFaceCategoryV2.previewUrl) && IIX0o.Oxx0IOOO(this.createdAt, watchFaceCategoryV2.createdAt) && IIX0o.Oxx0IOOO(this.updateAt, watchFaceCategoryV2.updateAt) && this.version == watchFaceCategoryV2.version && Float.compare(this.amount, watchFaceCategoryV2.amount) == 0 && Float.compare(this.dollar, watchFaceCategoryV2.dollar) == 0 && IIX0o.Oxx0IOOO(this.payStatus, watchFaceCategoryV2.payStatus) && this.newFlag == watchFaceCategoryV2.newFlag && IIX0o.Oxx0IOOO(this.discount, watchFaceCategoryV2.discount) && Float.compare(this.amountDis, watchFaceCategoryV2.amountDis) == 0 && Float.compare(this.dollarDis, watchFaceCategoryV2.dollarDis) == 0 && IIX0o.Oxx0IOOO(this.dollarCodeDis, watchFaceCategoryV2.dollarCodeDis);
    }

    public final float getAmount() {
        return this.amount;
    }

    public final float getAmountDis() {
        return this.amountDis;
    }

    @OOXIXo
    public final String getBinUrl() {
        return this.binUrl;
    }

    @OOXIXo
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @oOoXoXO
    public final String getDialType() {
        return this.dialType;
    }

    @OOXIXo
    public final String getDiscount() {
        return this.discount;
    }

    public final float getDollar() {
        return this.dollar;
    }

    @OOXIXo
    public final String getDollarCodeDis() {
        return this.dollarCodeDis;
    }

    public final float getDollarDis() {
        return this.dollarDis;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getLimitFreeFlag() {
        return this.limitFreeFlag;
    }

    @OOXIXo
    public final String getMemberAttr() {
        return this.memberAttr;
    }

    public final boolean getNewFlag() {
        return this.newFlag;
    }

    @oOoXoXO
    public final String getPayStatus() {
        return this.payStatus;
    }

    @OOXIXo
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    @OOXIXo
    public final String getResolutionType() {
        return this.resolutionType;
    }

    @OOXIXo
    public final String getScreenType() {
        return this.screenType;
    }

    @OOXIXo
    public final String getUpdateAt() {
        return this.updateAt;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.screenType.hashCode() * 31) + this.id) * 31;
        String str = this.dialType;
        int i = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = (((((((((((((((((((((hashCode2 + hashCode) * 31) + this.resolutionType.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.limitFreeFlag)) * 31) + this.memberAttr.hashCode()) * 31) + this.binUrl.hashCode()) * 31) + this.previewUrl.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.updateAt.hashCode()) * 31) + this.version) * 31) + Float.floatToIntBits(this.amount)) * 31) + Float.floatToIntBits(this.dollar)) * 31;
        String str2 = this.payStatus;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((((((hashCode3 + i) * 31) + androidx.work.oIX0oI.oIX0oI(this.newFlag)) * 31) + this.discount.hashCode()) * 31) + Float.floatToIntBits(this.amountDis)) * 31) + Float.floatToIntBits(this.dollarDis)) * 31) + this.dollarCodeDis.hashCode();
    }

    public final void setAmountDis(float f) {
        this.amountDis = f;
    }

    public final void setDiscount(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.discount = str;
    }

    public final void setDollarCodeDis(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.dollarCodeDis = str;
    }

    public final void setDollarDis(float f) {
        this.dollarDis = f;
    }

    public final void setLimitFreeFlag(boolean z) {
        this.limitFreeFlag = z;
    }

    public final void setMemberAttr(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.memberAttr = str;
    }

    public final void setNewFlag(boolean z) {
        this.newFlag = z;
    }

    public final void setPayStatus(@oOoXoXO String str) {
        this.payStatus = str;
    }

    @OOXIXo
    public String toString() {
        return "WatchFaceCategoryV2(screenType=" + this.screenType + ", id=" + this.id + ", dialType=" + this.dialType + ", resolutionType=" + this.resolutionType + ", limitFreeFlag=" + this.limitFreeFlag + ", memberAttr=" + this.memberAttr + ", binUrl=" + this.binUrl + ", previewUrl=" + this.previewUrl + ", createdAt=" + this.createdAt + ", updateAt=" + this.updateAt + ", version=" + this.version + ", amount=" + this.amount + ", dollar=" + this.dollar + ", payStatus=" + this.payStatus + ", newFlag=" + this.newFlag + ", discount=" + this.discount + ", amountDis=" + this.amountDis + ", dollarDis=" + this.dollarDis + ", dollarCodeDis=" + this.dollarCodeDis + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ WatchFaceCategoryV2(String str, int i, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, int i2, float f, float f2, String str9, boolean z2, String str10, float f3, float f4, String str11, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "0" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? "" : str4, (i3 & 64) != 0 ? "" : str5, (i3 & 128) != 0 ? "" : str6, (i3 & 256) != 0 ? "" : str7, (i3 & 512) != 0 ? "" : str8, (i3 & 1024) != 0 ? 0 : i2, (i3 & 2048) != 0 ? 0.0f : f, (i3 & 4096) != 0 ? 0.0f : f2, (i3 & 8192) != 0 ? "" : str9, (i3 & 16384) != 0 ? false : z2, (i3 & 32768) != 0 ? "" : str10, (i3 & 65536) != 0 ? 0.0f : f3, (i3 & 131072) != 0 ? 0.0f : f4, (i3 & 262144) != 0 ? "" : str11);
    }

    public WatchFaceCategoryV2(@OOXIXo String screenType, int i, @oOoXoXO String str, @OOXIXo String resolutionType, boolean z, @OOXIXo String memberAttr, @OOXIXo String binUrl, @OOXIXo String previewUrl, @OOXIXo String createdAt, @OOXIXo String updateAt, int i2, float f, float f2, @oOoXoXO String str2, boolean z2, @OOXIXo String discount, float f3, float f4, @OOXIXo String dollarCodeDis) {
        IIX0o.x0xO0oo(screenType, "screenType");
        IIX0o.x0xO0oo(resolutionType, "resolutionType");
        IIX0o.x0xO0oo(memberAttr, "memberAttr");
        IIX0o.x0xO0oo(binUrl, "binUrl");
        IIX0o.x0xO0oo(previewUrl, "previewUrl");
        IIX0o.x0xO0oo(createdAt, "createdAt");
        IIX0o.x0xO0oo(updateAt, "updateAt");
        IIX0o.x0xO0oo(discount, "discount");
        IIX0o.x0xO0oo(dollarCodeDis, "dollarCodeDis");
        this.screenType = screenType;
        this.id = i;
        this.dialType = str;
        this.resolutionType = resolutionType;
        this.limitFreeFlag = z;
        this.memberAttr = memberAttr;
        this.binUrl = binUrl;
        this.previewUrl = previewUrl;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.version = i2;
        this.amount = f;
        this.dollar = f2;
        this.payStatus = str2;
        this.newFlag = z2;
        this.discount = discount;
        this.amountDis = f3;
        this.dollarDis = f4;
        this.dollarCodeDis = dollarCodeDis;
    }
}
