package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleHmTime extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 2;
    private int mHour;
    private int mMinute;

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
    public BleHmTime() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleHmTime.<init>():void");
    }

    public static /* synthetic */ BleHmTime copy$default(BleHmTime bleHmTime, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleHmTime.mHour;
        }
        if ((i3 & 2) != 0) {
            i2 = bleHmTime.mMinute;
        }
        return bleHmTime.copy(i, i2);
    }

    public final int component1() {
        return this.mHour;
    }

    public final int component2() {
        return this.mMinute;
    }

    @OOXIXo
    public final BleHmTime copy(int i, int i2) {
        return new BleHmTime(i, i2);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mHour = readUInt8();
        this.mMinute = readUInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mHour);
        writeInt8(this.mMinute);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleHmTime)) {
            return false;
        }
        BleHmTime bleHmTime = (BleHmTime) obj;
        return this.mHour == bleHmTime.mHour && this.mMinute == bleHmTime.mMinute;
    }

    public final int getMHour() {
        return this.mHour;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 2;
    }

    public final int getMMinute() {
        return this.mMinute;
    }

    public int hashCode() {
        return (this.mHour * 31) + this.mMinute;
    }

    public final void setMHour(int i) {
        this.mHour = i;
    }

    public final void setMMinute(int i) {
        this.mMinute = i;
    }

    @OOXIXo
    public String toString() {
        return "BleHmTime(mHour=" + this.mHour + ", mMinute=" + this.mMinute + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleHmTime(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public BleHmTime(int i, int i2) {
        this.mHour = i;
        this.mMinute = i2;
    }
}
