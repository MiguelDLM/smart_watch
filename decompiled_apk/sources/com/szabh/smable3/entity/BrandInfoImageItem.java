package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BrandInfoImageItem {
    private int mAnchor;

    @OOXIXo
    private BrandInfoImage[] mImageInfos;
    private int mPlayInterval;
    private int mX;
    private int mY;

    public BrandInfoImageItem() {
        this(0, 0, 0, 0, null, 31, null);
    }

    public static /* synthetic */ BrandInfoImageItem copy$default(BrandInfoImageItem brandInfoImageItem, int i, int i2, int i3, int i4, BrandInfoImage[] brandInfoImageArr, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = brandInfoImageItem.mX;
        }
        if ((i5 & 2) != 0) {
            i2 = brandInfoImageItem.mY;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = brandInfoImageItem.mAnchor;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = brandInfoImageItem.mPlayInterval;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            brandInfoImageArr = brandInfoImageItem.mImageInfos;
        }
        return brandInfoImageItem.copy(i, i6, i7, i8, brandInfoImageArr);
    }

    public final int component1() {
        return this.mX;
    }

    public final int component2() {
        return this.mY;
    }

    public final int component3() {
        return this.mAnchor;
    }

    public final int component4() {
        return this.mPlayInterval;
    }

    @OOXIXo
    public final BrandInfoImage[] component5() {
        return this.mImageInfos;
    }

    @OOXIXo
    public final BrandInfoImageItem copy(int i, int i2, int i3, int i4, @OOXIXo BrandInfoImage[] mImageInfos) {
        IIX0o.x0xO0oo(mImageInfos, "mImageInfos");
        return new BrandInfoImageItem(i, i2, i3, i4, mImageInfos);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrandInfoImageItem)) {
            return false;
        }
        BrandInfoImageItem brandInfoImageItem = (BrandInfoImageItem) obj;
        return this.mX == brandInfoImageItem.mX && this.mY == brandInfoImageItem.mY && this.mAnchor == brandInfoImageItem.mAnchor && this.mPlayInterval == brandInfoImageItem.mPlayInterval && IIX0o.Oxx0IOOO(this.mImageInfos, brandInfoImageItem.mImageInfos);
    }

    public final int getMAnchor() {
        return this.mAnchor;
    }

    @OOXIXo
    public final BrandInfoImage[] getMImageInfos() {
        return this.mImageInfos;
    }

    public final int getMPlayInterval() {
        return this.mPlayInterval;
    }

    public final int getMX() {
        return this.mX;
    }

    public final int getMY() {
        return this.mY;
    }

    public int hashCode() {
        return (((((((this.mX * 31) + this.mY) * 31) + this.mAnchor) * 31) + this.mPlayInterval) * 31) + Arrays.hashCode(this.mImageInfos);
    }

    public final void setMAnchor(int i) {
        this.mAnchor = i;
    }

    public final void setMImageInfos(@OOXIXo BrandInfoImage[] brandInfoImageArr) {
        IIX0o.x0xO0oo(brandInfoImageArr, "<set-?>");
        this.mImageInfos = brandInfoImageArr;
    }

    public final void setMPlayInterval(int i) {
        this.mPlayInterval = i;
    }

    public final void setMX(int i) {
        this.mX = i;
    }

    public final void setMY(int i) {
        this.mY = i;
    }

    @OOXIXo
    public String toString() {
        return "BrandInfoImageItem(mX=" + this.mX + ", mY=" + this.mY + ", mAnchor=" + this.mAnchor + ", mPlayInterval=" + this.mPlayInterval + ", mImageInfos=" + Arrays.toString(this.mImageInfos) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public BrandInfoImageItem(int i, int i2, int i3, int i4, @OOXIXo BrandInfoImage[] mImageInfos) {
        IIX0o.x0xO0oo(mImageInfos, "mImageInfos");
        this.mX = i;
        this.mY = i2;
        this.mAnchor = i3;
        this.mPlayInterval = i4;
        this.mImageInfos = mImageInfos;
    }

    public /* synthetic */ BrandInfoImageItem(int i, int i2, int i3, int i4, BrandInfoImage[] brandInfoImageArr, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? new BrandInfoImage[0] : brandInfoImageArr);
    }
}
