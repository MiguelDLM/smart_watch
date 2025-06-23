package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleRealTimeMeasurement extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 1;
    public static final int STATE_DONE = 0;
    public static final int STATE_PAUSE = 1;
    public static final int STATE_START = 2;
    private int mBOSwitch;
    private int mBPSwitch;
    private int mHRSwitch;
    private int mState;
    private int mStressSwitch;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleRealTimeMeasurement() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ BleRealTimeMeasurement copy$default(BleRealTimeMeasurement bleRealTimeMeasurement, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = bleRealTimeMeasurement.mHRSwitch;
        }
        if ((i6 & 2) != 0) {
            i2 = bleRealTimeMeasurement.mBOSwitch;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = bleRealTimeMeasurement.mBPSwitch;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = bleRealTimeMeasurement.mStressSwitch;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = bleRealTimeMeasurement.mState;
        }
        return bleRealTimeMeasurement.copy(i, i7, i8, i9, i5);
    }

    public final int component1() {
        return this.mHRSwitch;
    }

    public final int component2() {
        return this.mBOSwitch;
    }

    public final int component3() {
        return this.mBPSwitch;
    }

    public final int component4() {
        return this.mStressSwitch;
    }

    public final int component5() {
        return this.mState;
    }

    @OOXIXo
    public final BleRealTimeMeasurement copy(int i, int i2, int i3, int i4, int i5) {
        return new BleRealTimeMeasurement(i, i2, i3, i4, i5);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mState = readIntN(2);
        readIntN(2);
        this.mStressSwitch = readIntN(1);
        this.mBPSwitch = readIntN(1);
        this.mBOSwitch = readIntN(1);
        this.mHRSwitch = readIntN(1);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeIntN(this.mState, 2);
        writeIntN(0, 2);
        writeIntN(this.mStressSwitch, 1);
        writeIntN(this.mBPSwitch, 1);
        writeIntN(this.mBOSwitch, 1);
        writeIntN(this.mHRSwitch, 1);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleRealTimeMeasurement)) {
            return false;
        }
        BleRealTimeMeasurement bleRealTimeMeasurement = (BleRealTimeMeasurement) obj;
        return this.mHRSwitch == bleRealTimeMeasurement.mHRSwitch && this.mBOSwitch == bleRealTimeMeasurement.mBOSwitch && this.mBPSwitch == bleRealTimeMeasurement.mBPSwitch && this.mStressSwitch == bleRealTimeMeasurement.mStressSwitch && this.mState == bleRealTimeMeasurement.mState;
    }

    public final int getMBOSwitch() {
        return this.mBOSwitch;
    }

    public final int getMBPSwitch() {
        return this.mBPSwitch;
    }

    public final int getMHRSwitch() {
        return this.mHRSwitch;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 1;
    }

    public final int getMState() {
        return this.mState;
    }

    public final int getMStressSwitch() {
        return this.mStressSwitch;
    }

    public int hashCode() {
        return (((((((this.mHRSwitch * 31) + this.mBOSwitch) * 31) + this.mBPSwitch) * 31) + this.mStressSwitch) * 31) + this.mState;
    }

    public final void setMBOSwitch(int i) {
        this.mBOSwitch = i;
    }

    public final void setMBPSwitch(int i) {
        this.mBPSwitch = i;
    }

    public final void setMHRSwitch(int i) {
        this.mHRSwitch = i;
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    public final void setMStressSwitch(int i) {
        this.mStressSwitch = i;
    }

    @OOXIXo
    public String toString() {
        return "BleRealTimeMeasurement(mState=" + this.mState + ", mHRSwitch=" + this.mHRSwitch + ", mBOSwitch=" + this.mBOSwitch + ", mBPSwitch=" + this.mBPSwitch + ", mStressSwitch=" + this.mStressSwitch + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleRealTimeMeasurement(int i, int i2, int i3, int i4, int i5, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5);
    }

    public BleRealTimeMeasurement(int i, int i2, int i3, int i4, int i5) {
        this.mHRSwitch = i;
        this.mBOSwitch = i2;
        this.mBPSwitch = i3;
        this.mStressSwitch = i4;
        this.mState = i5;
    }
}
