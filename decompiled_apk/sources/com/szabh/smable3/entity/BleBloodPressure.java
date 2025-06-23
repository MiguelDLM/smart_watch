package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleBloodPressure extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 6;
    private int mDiastolic;
    private int mSystolic;
    private int mTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleBloodPressure() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ BleBloodPressure copy$default(BleBloodPressure bleBloodPressure, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleBloodPressure.mTime;
        }
        if ((i4 & 2) != 0) {
            i2 = bleBloodPressure.mSystolic;
        }
        if ((i4 & 4) != 0) {
            i3 = bleBloodPressure.mDiastolic;
        }
        return bleBloodPressure.copy(i, i2, i3);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mSystolic;
    }

    public final int component3() {
        return this.mDiastolic;
    }

    @OOXIXo
    public final BleBloodPressure copy(int i, int i2, int i3) {
        return new BleBloodPressure(i, i2, i3);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mSystolic = readUInt8();
        this.mDiastolic = readUInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleBloodPressure)) {
            return false;
        }
        BleBloodPressure bleBloodPressure = (BleBloodPressure) obj;
        return this.mTime == bleBloodPressure.mTime && this.mSystolic == bleBloodPressure.mSystolic && this.mDiastolic == bleBloodPressure.mDiastolic;
    }

    public final int getMDiastolic() {
        return this.mDiastolic;
    }

    public final int getMSystolic() {
        return this.mSystolic;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((this.mTime * 31) + this.mSystolic) * 31) + this.mDiastolic;
    }

    public final void setMDiastolic(int i) {
        this.mDiastolic = i;
    }

    public final void setMSystolic(int i) {
        this.mSystolic = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleBloodPressure(mTime=" + this.mTime + ", mSystolic=" + this.mSystolic + ", mDiastolic=" + this.mDiastolic + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleBloodPressure(int i, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public BleBloodPressure(int i, int i2, int i3) {
        this.mTime = i;
        this.mSystolic = i2;
        this.mDiastolic = i3;
    }
}
