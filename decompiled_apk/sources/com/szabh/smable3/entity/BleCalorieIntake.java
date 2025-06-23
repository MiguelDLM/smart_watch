package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleCalorieIntake extends BleReadable {
    public static final int CATEGORY_BREAKFAST = 0;
    public static final int CATEGORY_DINNER = 2;
    public static final int CATEGORY_LUNCH = 1;
    public static final int CATEGORY_SNACK = 3;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 12;
    private int mCalorie;
    private int mMealCategoryFlag;
    private int mTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleCalorieIntake() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ BleCalorieIntake copy$default(BleCalorieIntake bleCalorieIntake, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleCalorieIntake.mTime;
        }
        if ((i4 & 2) != 0) {
            i2 = bleCalorieIntake.mMealCategoryFlag;
        }
        if ((i4 & 4) != 0) {
            i3 = bleCalorieIntake.mCalorie;
        }
        return bleCalorieIntake.copy(i, i2, i3);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mMealCategoryFlag;
    }

    public final int component3() {
        return this.mCalorie;
    }

    @OOXIXo
    public final BleCalorieIntake copy(int i, int i2, int i3) {
        return new BleCalorieIntake(i, i2, i3);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mMealCategoryFlag = readInt8();
        this.mCalorie = BleReadable.readInt32$default(this, null, 1, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleCalorieIntake)) {
            return false;
        }
        BleCalorieIntake bleCalorieIntake = (BleCalorieIntake) obj;
        return this.mTime == bleCalorieIntake.mTime && this.mMealCategoryFlag == bleCalorieIntake.mMealCategoryFlag && this.mCalorie == bleCalorieIntake.mCalorie;
    }

    public final int getMCalorie() {
        return this.mCalorie;
    }

    public final int getMMealCategoryFlag() {
        return this.mMealCategoryFlag;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((this.mTime * 31) + this.mMealCategoryFlag) * 31) + this.mCalorie;
    }

    public final void setMCalorie(int i) {
        this.mCalorie = i;
    }

    public final void setMMealCategoryFlag(int i) {
        this.mMealCategoryFlag = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleCalorieIntake(mTime=" + this.mTime + ", mMealCategoryFlag=" + this.mMealCategoryFlag + ", mCalorie=" + this.mCalorie + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleCalorieIntake(int i, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public BleCalorieIntake(int i, int i2, int i3) {
        this.mTime = i;
        this.mMealCategoryFlag = i2;
        this.mCalorie = i3;
    }
}
