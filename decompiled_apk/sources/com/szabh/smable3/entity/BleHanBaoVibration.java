package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleHanBaoVibration extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 8;
    private int mBOValue;
    private int mIsSnore;
    private int mTime;
    private int mVibration;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleHanBaoVibration() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ BleHanBaoVibration copy$default(BleHanBaoVibration bleHanBaoVibration, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = bleHanBaoVibration.mTime;
        }
        if ((i5 & 2) != 0) {
            i2 = bleHanBaoVibration.mVibration;
        }
        if ((i5 & 4) != 0) {
            i3 = bleHanBaoVibration.mBOValue;
        }
        if ((i5 & 8) != 0) {
            i4 = bleHanBaoVibration.mIsSnore;
        }
        return bleHanBaoVibration.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mVibration;
    }

    public final int component3() {
        return this.mBOValue;
    }

    public final int component4() {
        return this.mIsSnore;
    }

    @OOXIXo
    public final BleHanBaoVibration copy(int i, int i2, int i3, int i4) {
        return new BleHanBaoVibration(i, i2, i3, i4);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = (int) BleReadable.readUInt32$default(this, null, 1, null);
        this.mVibration = readUInt8();
        this.mBOValue = readUInt8();
        this.mIsSnore = readUInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleHanBaoVibration)) {
            return false;
        }
        BleHanBaoVibration bleHanBaoVibration = (BleHanBaoVibration) obj;
        return this.mTime == bleHanBaoVibration.mTime && this.mVibration == bleHanBaoVibration.mVibration && this.mBOValue == bleHanBaoVibration.mBOValue && this.mIsSnore == bleHanBaoVibration.mIsSnore;
    }

    public final int getMBOValue() {
        return this.mBOValue;
    }

    public final int getMIsSnore() {
        return this.mIsSnore;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public final int getMVibration() {
        return this.mVibration;
    }

    public int hashCode() {
        return (((((this.mTime * 31) + this.mVibration) * 31) + this.mBOValue) * 31) + this.mIsSnore;
    }

    public final void setMBOValue(int i) {
        this.mBOValue = i;
    }

    public final void setMIsSnore(int i) {
        this.mIsSnore = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMVibration(int i) {
        this.mVibration = i;
    }

    @OOXIXo
    public String toString() {
        return "BleHanBaoVibration(mTime=" + this.mTime + ", mVibration=" + this.mVibration + ", mBOValue=" + this.mBOValue + ", mIsSnore=" + this.mIsSnore + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleHanBaoVibration(int i, int i2, int i3, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public BleHanBaoVibration(int i, int i2, int i3, int i4) {
        this.mTime = i;
        this.mVibration = i2;
        this.mBOValue = i3;
        this.mIsSnore = i4;
    }
}
