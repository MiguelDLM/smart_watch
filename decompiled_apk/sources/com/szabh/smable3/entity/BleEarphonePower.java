package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleEarphonePower extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 2;
    private int mLeftPower;
    private int mRightPower;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BleEarphonePower() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleEarphonePower.<init>():void");
    }

    public static /* synthetic */ BleEarphonePower copy$default(BleEarphonePower bleEarphonePower, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleEarphonePower.mLeftPower;
        }
        if ((i3 & 2) != 0) {
            i2 = bleEarphonePower.mRightPower;
        }
        return bleEarphonePower.copy(i, i2);
    }

    public final int component1() {
        return this.mLeftPower;
    }

    public final int component2() {
        return this.mRightPower;
    }

    @OOXIXo
    public final BleEarphonePower copy(int i, int i2) {
        return new BleEarphonePower(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mLeftPower = readInt8();
        this.mRightPower = readInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mLeftPower);
        writeInt8(this.mRightPower);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleEarphonePower)) {
            return false;
        }
        BleEarphonePower bleEarphonePower = (BleEarphonePower) obj;
        return this.mLeftPower == bleEarphonePower.mLeftPower && this.mRightPower == bleEarphonePower.mRightPower;
    }

    public final int getMLeftPower() {
        return this.mLeftPower;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 2;
    }

    public final int getMRightPower() {
        return this.mRightPower;
    }

    public int hashCode() {
        return (this.mLeftPower * 31) + this.mRightPower;
    }

    public final void setMLeftPower(int i) {
        this.mLeftPower = i;
    }

    public final void setMRightPower(int i) {
        this.mRightPower = i;
    }

    @OOXIXo
    public String toString() {
        return "BleEarphonePower(mLeftPower=" + this.mLeftPower + ", mRightPower=" + this.mRightPower + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleEarphonePower(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleEarphonePower(int i, int i2) {
        this.mLeftPower = i;
        this.mRightPower = i2;
    }
}
