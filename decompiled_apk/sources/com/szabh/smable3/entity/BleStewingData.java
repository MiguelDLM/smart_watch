package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleReadable;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleStewingData extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 13;
    private long mDuration;
    private float mEndVoltage;
    private float mStartVoltage;
    private int mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleStewingData() {
        this(0, 0.0f, 0.0f, 0L, 15, null);
    }

    public static /* synthetic */ BleStewingData copy$default(BleStewingData bleStewingData, int i, float f, float f2, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleStewingData.mType;
        }
        if ((i2 & 2) != 0) {
            f = bleStewingData.mStartVoltage;
        }
        float f3 = f;
        if ((i2 & 4) != 0) {
            f2 = bleStewingData.mEndVoltage;
        }
        float f4 = f2;
        if ((i2 & 8) != 0) {
            j = bleStewingData.mDuration;
        }
        return bleStewingData.copy(i, f3, f4, j);
    }

    public final int component1() {
        return this.mType;
    }

    public final float component2() {
        return this.mStartVoltage;
    }

    public final float component3() {
        return this.mEndVoltage;
    }

    public final long component4() {
        return this.mDuration;
    }

    @OOXIXo
    public final BleStewingData copy(int i, float f, float f2, long j) {
        return new BleStewingData(i, f, f2, j);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = readInt8();
        this.mStartVoltage = ((float) BleReadable.readUInt32$default(this, null, 1, null)) / 10000.0f;
        this.mEndVoltage = ((float) BleReadable.readUInt32$default(this, null, 1, null)) / 10000.0f;
        this.mDuration = BleReadable.readUInt32$default(this, null, 1, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleStewingData)) {
            return false;
        }
        BleStewingData bleStewingData = (BleStewingData) obj;
        return this.mType == bleStewingData.mType && Float.compare(this.mStartVoltage, bleStewingData.mStartVoltage) == 0 && Float.compare(this.mEndVoltage, bleStewingData.mEndVoltage) == 0 && this.mDuration == bleStewingData.mDuration;
    }

    public final long getMDuration() {
        return this.mDuration;
    }

    public final float getMEndVoltage() {
        return this.mEndVoltage;
    }

    public final float getMStartVoltage() {
        return this.mStartVoltage;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (((((this.mType * 31) + Float.floatToIntBits(this.mStartVoltage)) * 31) + Float.floatToIntBits(this.mEndVoltage)) * 31) + oIX0oI.oIX0oI(this.mDuration);
    }

    public final void setMDuration(long j) {
        this.mDuration = j;
    }

    public final void setMEndVoltage(float f) {
        this.mEndVoltage = f;
    }

    public final void setMStartVoltage(float f) {
        this.mStartVoltage = f;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "BleStewingData(mType=" + this.mType + ", mStartVoltage=" + this.mStartVoltage + ", mEndVoltage=" + this.mEndVoltage + ", mDuration=" + this.mDuration + "s)";
    }

    public /* synthetic */ BleStewingData(int i, float f, float f2, long j, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f, (i2 & 4) == 0 ? f2 : 0.0f, (i2 & 8) != 0 ? 0L : j);
    }

    public BleStewingData(int i, float f, float f2, long j) {
        this.mType = i;
        this.mStartVoltage = f;
        this.mEndVoltage = f2;
        this.mDuration = j;
    }
}
