package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAvgHeartRate extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 8;
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BleAvgHeartRate() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleAvgHeartRate.<init>():void");
    }

    public static /* synthetic */ BleAvgHeartRate copy$default(BleAvgHeartRate bleAvgHeartRate, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleAvgHeartRate.mTime;
        }
        if ((i3 & 2) != 0) {
            i2 = bleAvgHeartRate.mValue;
        }
        return bleAvgHeartRate.copy(i, i2);
    }

    public final int component1() {
        return this.mTime;
    }

    public final int component2() {
        return this.mValue;
    }

    @OOXIXo
    public final BleAvgHeartRate copy(int i, int i2) {
        return new BleAvgHeartRate(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mTime = BleReadable.readInt32$default(this, null, 1, null);
        this.mValue = BleReadable.readInt32$default(this, null, 1, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAvgHeartRate)) {
            return false;
        }
        BleAvgHeartRate bleAvgHeartRate = (BleAvgHeartRate) obj;
        return this.mTime == bleAvgHeartRate.mTime && this.mValue == bleAvgHeartRate.mValue;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public final int getMValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (this.mTime * 31) + this.mValue;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMValue(int i) {
        this.mValue = i;
    }

    @OOXIXo
    public String toString() {
        return "BleAvgHeartRate(mTime=" + this.mTime + ", mValue=" + this.mValue + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAvgHeartRate(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleAvgHeartRate(int i, int i2) {
        this.mTime = i;
        this.mValue = i2;
    }
}
