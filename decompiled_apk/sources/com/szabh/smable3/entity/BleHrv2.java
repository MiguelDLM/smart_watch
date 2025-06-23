package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleHrv2 extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 10;
    private int mMaximumBaselineValue;
    private int mMinimumBaselineValue;
    private int mStatus;
    private int mTime;
    private int mValue;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleHrv2() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ BleHrv2 copy$default(BleHrv2 bleHrv2, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = bleHrv2.mTime;
        }
        if ((i6 & 2) != 0) {
            i2 = bleHrv2.mMinimumBaselineValue;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = bleHrv2.mMaximumBaselineValue;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = bleHrv2.mStatus;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = bleHrv2.mValue;
        }
        return bleHrv2.copy(i, i7, i8, i9, i5);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mMinimumBaselineValue;
    }

    public final int component3() {
        return this.mMaximumBaselineValue;
    }

    public final int component4() {
        return this.mStatus;
    }

    public final int component5() {
        return this.mValue;
    }

    @OOXIXo
    public final BleHrv2 copy(int i, int i2, int i3, int i4, int i5) {
        return new BleHrv2(i, i2, i3, i4, i5);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mTime = readInt32(LITTLE_ENDIAN);
        this.mMinimumBaselineValue = readInt8();
        this.mMaximumBaselineValue = readInt8();
        this.mStatus = readInt8();
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mValue = readInt16(LITTLE_ENDIAN);
        readBytes(8);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleHrv2)) {
            return false;
        }
        BleHrv2 bleHrv2 = (BleHrv2) obj;
        return this.mTime == bleHrv2.mTime && this.mMinimumBaselineValue == bleHrv2.mMinimumBaselineValue && this.mMaximumBaselineValue == bleHrv2.mMaximumBaselineValue && this.mStatus == bleHrv2.mStatus && this.mValue == bleHrv2.mValue;
    }

    public final int getMMaximumBaselineValue() {
        return this.mMaximumBaselineValue;
    }

    public final int getMMinimumBaselineValue() {
        return this.mMinimumBaselineValue;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public final int getMValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (((((((this.mTime * 31) + this.mMinimumBaselineValue) * 31) + this.mMaximumBaselineValue) * 31) + this.mStatus) * 31) + this.mValue;
    }

    public final void setMMaximumBaselineValue(int i) {
        this.mMaximumBaselineValue = i;
    }

    public final void setMMinimumBaselineValue(int i) {
        this.mMinimumBaselineValue = i;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMValue(int i) {
        this.mValue = i;
    }

    @OOXIXo
    public String toString() {
        return "BleHrv2(mTime=" + this.mTime + ", mMinimumBaselineValue=" + this.mMinimumBaselineValue + ", mMaximumBaselineValue=" + this.mMaximumBaselineValue + ", mStatus=" + this.mStatus + ", mValue=" + this.mValue + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleHrv2(int i, int i2, int i3, int i4, int i5, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5);
    }

    public BleHrv2(int i, int i2, int i3, int i4, int i5) {
        this.mTime = i;
        this.mMinimumBaselineValue = i2;
        this.mMaximumBaselineValue = i3;
        this.mStatus = i4;
        this.mValue = i5;
    }
}
