package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleFoodBalance extends BleReadable {
    public static final int AMOUNT_A_LITTLE = 1;
    public static final int AMOUNT_A_LOT = 3;
    public static final int AMOUNT_NONE = 0;
    public static final int AMOUNT_NORMAL = 2;
    public static final int CATEGORY_BREAKFAST = 0;
    public static final int CATEGORY_DINNER = 2;
    public static final int CATEGORY_LUNCH = 1;
    public static final int CATEGORY_SNACK = 3;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 12;
    private int mFishAmount;
    private int mLiquorAmount;
    private int mMealCategoryFlag;
    private int mMeatAmount;
    private int mRiceAmount;
    private int mTime;
    private int mVegetableAmount;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleFoodBalance() {
        this(0, 0, 0, 0, 0, 0, 0, 127, null);
    }

    public static /* synthetic */ BleFoodBalance copy$default(BleFoodBalance bleFoodBalance, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = bleFoodBalance.mTime;
        }
        if ((i8 & 2) != 0) {
            i2 = bleFoodBalance.mMealCategoryFlag;
        }
        int i9 = i2;
        if ((i8 & 4) != 0) {
            i3 = bleFoodBalance.mRiceAmount;
        }
        int i10 = i3;
        if ((i8 & 8) != 0) {
            i4 = bleFoodBalance.mFishAmount;
        }
        int i11 = i4;
        if ((i8 & 16) != 0) {
            i5 = bleFoodBalance.mMeatAmount;
        }
        int i12 = i5;
        if ((i8 & 32) != 0) {
            i6 = bleFoodBalance.mVegetableAmount;
        }
        int i13 = i6;
        if ((i8 & 64) != 0) {
            i7 = bleFoodBalance.mLiquorAmount;
        }
        return bleFoodBalance.copy(i, i9, i10, i11, i12, i13, i7);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mMealCategoryFlag;
    }

    public final int component3() {
        return this.mRiceAmount;
    }

    public final int component4() {
        return this.mFishAmount;
    }

    public final int component5() {
        return this.mMeatAmount;
    }

    public final int component6() {
        return this.mVegetableAmount;
    }

    public final int component7() {
        return this.mLiquorAmount;
    }

    @OOXIXo
    public final BleFoodBalance copy(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new BleFoodBalance(i, i2, i3, i4, i5, i6, i7);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mMealCategoryFlag = readInt8();
        this.mRiceAmount = readInt8();
        this.mFishAmount = readInt8();
        this.mMeatAmount = readInt8();
        this.mVegetableAmount = readInt8();
        this.mLiquorAmount = readInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleFoodBalance)) {
            return false;
        }
        BleFoodBalance bleFoodBalance = (BleFoodBalance) obj;
        return this.mTime == bleFoodBalance.mTime && this.mMealCategoryFlag == bleFoodBalance.mMealCategoryFlag && this.mRiceAmount == bleFoodBalance.mRiceAmount && this.mFishAmount == bleFoodBalance.mFishAmount && this.mMeatAmount == bleFoodBalance.mMeatAmount && this.mVegetableAmount == bleFoodBalance.mVegetableAmount && this.mLiquorAmount == bleFoodBalance.mLiquorAmount;
    }

    public final int getMFishAmount() {
        return this.mFishAmount;
    }

    public final int getMLiquorAmount() {
        return this.mLiquorAmount;
    }

    public final int getMMealCategoryFlag() {
        return this.mMealCategoryFlag;
    }

    public final int getMMeatAmount() {
        return this.mMeatAmount;
    }

    public final int getMRiceAmount() {
        return this.mRiceAmount;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public final int getMVegetableAmount() {
        return this.mVegetableAmount;
    }

    public int hashCode() {
        return (((((((((((this.mTime * 31) + this.mMealCategoryFlag) * 31) + this.mRiceAmount) * 31) + this.mFishAmount) * 31) + this.mMeatAmount) * 31) + this.mVegetableAmount) * 31) + this.mLiquorAmount;
    }

    public final void setMFishAmount(int i) {
        this.mFishAmount = i;
    }

    public final void setMLiquorAmount(int i) {
        this.mLiquorAmount = i;
    }

    public final void setMMealCategoryFlag(int i) {
        this.mMealCategoryFlag = i;
    }

    public final void setMMeatAmount(int i) {
        this.mMeatAmount = i;
    }

    public final void setMRiceAmount(int i) {
        this.mRiceAmount = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMVegetableAmount(int i) {
        this.mVegetableAmount = i;
    }

    @OOXIXo
    public String toString() {
        return "BleFoodBalance(mTime=" + this.mTime + ", mMealCategoryFlag=" + this.mMealCategoryFlag + ", mRiceAmount=" + this.mRiceAmount + ", mFishAmount=" + this.mFishAmount + ", mMeatAmount=" + this.mMeatAmount + ", mVegetableAmount=" + this.mVegetableAmount + ", mLiquorAmount=" + this.mLiquorAmount + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleFoodBalance(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, IIXOooo iIXOooo) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) != 0 ? 0 : i7);
    }

    public BleFoodBalance(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mTime = i;
        this.mMealCategoryFlag = i2;
        this.mRiceAmount = i3;
        this.mFishAmount = i4;
        this.mMeatAmount = i5;
        this.mVegetableAmount = i6;
        this.mLiquorAmount = i7;
    }
}
