package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class WatchFaceDetail extends JsonFieldContainer implements Serializable {
    private final float amount;
    private float amountDis;

    @OOXIXo
    private final String binUrl;
    private final int dialType;

    @OOXIXo
    private String discount;
    private final float dollar;

    @OOXIXo
    private String dollarCodeDis;
    private float dollarDis;

    @OOXIXo
    private final String fileSize;
    private final int id;
    private boolean limitFreeFlag;

    @OOXIXo
    private String memberAttr;
    private final boolean newFlag;

    @oOoXoXO
    private final String payStatus;

    @OOXIXo
    private final String previewUrl;

    public WatchFaceDetail() {
        this(0, null, null, null, null, 0, 0.0f, 0.0f, false, null, false, null, 0.0f, 0.0f, null, 32767, null);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final String component10() {
        return this.memberAttr;
    }

    public final boolean component11() {
        return this.newFlag;
    }

    @OOXIXo
    public final String component12() {
        return this.discount;
    }

    public final float component13() {
        return this.amountDis;
    }

    public final float component14() {
        return this.dollarDis;
    }

    @OOXIXo
    public final String component15() {
        return this.dollarCodeDis;
    }

    @OOXIXo
    public final String component2() {
        return this.previewUrl;
    }

    @OOXIXo
    public final String component3() {
        return this.binUrl;
    }

    @OOXIXo
    public final String component4() {
        return this.fileSize;
    }

    @oOoXoXO
    public final String component5() {
        return this.payStatus;
    }

    public final int component6() {
        return this.dialType;
    }

    public final float component7() {
        return this.amount;
    }

    public final float component8() {
        return this.dollar;
    }

    public final boolean component9() {
        return this.limitFreeFlag;
    }

    @OOXIXo
    public final WatchFaceDetail copy(int i, @OOXIXo String previewUrl, @OOXIXo String binUrl, @OOXIXo String fileSize, @oOoXoXO String str, int i2, float f, float f2, boolean z, @OOXIXo String memberAttr, boolean z2, @OOXIXo String discount, float f3, float f4, @OOXIXo String dollarCodeDis) {
        IIX0o.x0xO0oo(previewUrl, "previewUrl");
        IIX0o.x0xO0oo(binUrl, "binUrl");
        IIX0o.x0xO0oo(fileSize, "fileSize");
        IIX0o.x0xO0oo(memberAttr, "memberAttr");
        IIX0o.x0xO0oo(discount, "discount");
        IIX0o.x0xO0oo(dollarCodeDis, "dollarCodeDis");
        return new WatchFaceDetail(i, previewUrl, binUrl, fileSize, str, i2, f, f2, z, memberAttr, z2, discount, f3, f4, dollarCodeDis);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchFaceDetail)) {
            return false;
        }
        WatchFaceDetail watchFaceDetail = (WatchFaceDetail) obj;
        return this.id == watchFaceDetail.id && IIX0o.Oxx0IOOO(this.previewUrl, watchFaceDetail.previewUrl) && IIX0o.Oxx0IOOO(this.binUrl, watchFaceDetail.binUrl) && IIX0o.Oxx0IOOO(this.fileSize, watchFaceDetail.fileSize) && IIX0o.Oxx0IOOO(this.payStatus, watchFaceDetail.payStatus) && this.dialType == watchFaceDetail.dialType && Float.compare(this.amount, watchFaceDetail.amount) == 0 && Float.compare(this.dollar, watchFaceDetail.dollar) == 0 && this.limitFreeFlag == watchFaceDetail.limitFreeFlag && IIX0o.Oxx0IOOO(this.memberAttr, watchFaceDetail.memberAttr) && this.newFlag == watchFaceDetail.newFlag && IIX0o.Oxx0IOOO(this.discount, watchFaceDetail.discount) && Float.compare(this.amountDis, watchFaceDetail.amountDis) == 0 && Float.compare(this.dollarDis, watchFaceDetail.dollarDis) == 0 && IIX0o.Oxx0IOOO(this.dollarCodeDis, watchFaceDetail.dollarCodeDis);
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

    public final int getDialType() {
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

    @OOXIXo
    public final String getFileSize() {
        return this.fileSize;
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

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.id * 31) + this.previewUrl.hashCode()) * 31) + this.binUrl.hashCode()) * 31) + this.fileSize.hashCode()) * 31;
        String str = this.payStatus;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((((((((((((((((((hashCode2 + hashCode) * 31) + this.dialType) * 31) + Float.floatToIntBits(this.amount)) * 31) + Float.floatToIntBits(this.dollar)) * 31) + androidx.work.oIX0oI.oIX0oI(this.limitFreeFlag)) * 31) + this.memberAttr.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.newFlag)) * 31) + this.discount.hashCode()) * 31) + Float.floatToIntBits(this.amountDis)) * 31) + Float.floatToIntBits(this.dollarDis)) * 31) + this.dollarCodeDis.hashCode();
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

    @OOXIXo
    public String toString() {
        return "WatchFaceDetail(id=" + this.id + ", previewUrl=" + this.previewUrl + ", binUrl=" + this.binUrl + ", fileSize=" + this.fileSize + ", payStatus=" + this.payStatus + ", dialType=" + this.dialType + ", amount=" + this.amount + ", dollar=" + this.dollar + ", limitFreeFlag=" + this.limitFreeFlag + ", memberAttr=" + this.memberAttr + ", newFlag=" + this.newFlag + ", discount=" + this.discount + ", amountDis=" + this.amountDis + ", dollarDis=" + this.dollarDis + ", dollarCodeDis=" + this.dollarCodeDis + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ WatchFaceDetail(int i, String str, String str2, String str3, String str4, int i2, float f, float f2, boolean z, String str5, boolean z2, String str6, float f3, float f4, String str7, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? 0 : i2, (i3 & 64) != 0 ? 0.0f : f, (i3 & 128) != 0 ? 0.0f : f2, (i3 & 256) != 0 ? false : z, (i3 & 512) != 0 ? "" : str5, (i3 & 1024) == 0 ? z2 : false, (i3 & 2048) != 0 ? "" : str6, (i3 & 4096) != 0 ? 0.0f : f3, (i3 & 8192) != 0 ? 0.0f : f4, (i3 & 16384) == 0 ? str7 : "");
    }

    public WatchFaceDetail(int i, @OOXIXo String previewUrl, @OOXIXo String binUrl, @OOXIXo String fileSize, @oOoXoXO String str, int i2, float f, float f2, boolean z, @OOXIXo String memberAttr, boolean z2, @OOXIXo String discount, float f3, float f4, @OOXIXo String dollarCodeDis) {
        IIX0o.x0xO0oo(previewUrl, "previewUrl");
        IIX0o.x0xO0oo(binUrl, "binUrl");
        IIX0o.x0xO0oo(fileSize, "fileSize");
        IIX0o.x0xO0oo(memberAttr, "memberAttr");
        IIX0o.x0xO0oo(discount, "discount");
        IIX0o.x0xO0oo(dollarCodeDis, "dollarCodeDis");
        this.id = i;
        this.previewUrl = previewUrl;
        this.binUrl = binUrl;
        this.fileSize = fileSize;
        this.payStatus = str;
        this.dialType = i2;
        this.amount = f;
        this.dollar = f2;
        this.limitFreeFlag = z;
        this.memberAttr = memberAttr;
        this.newFlag = z2;
        this.discount = discount;
        this.amountDis = f3;
        this.dollarDis = f4;
        this.dollarCodeDis = dollarCodeDis;
    }
}
