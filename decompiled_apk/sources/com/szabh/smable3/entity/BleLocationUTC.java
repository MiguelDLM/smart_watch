package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleLocationUTC extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 8;
    private int mHour;
    private int mMilli;
    private int mMinute;
    private int mSecond;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleLocationUTC() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ BleLocationUTC copy$default(BleLocationUTC bleLocationUTC, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = bleLocationUTC.mHour;
        }
        if ((i5 & 2) != 0) {
            i2 = bleLocationUTC.mMinute;
        }
        if ((i5 & 4) != 0) {
            i3 = bleLocationUTC.mSecond;
        }
        if ((i5 & 8) != 0) {
            i4 = bleLocationUTC.mMilli;
        }
        return bleLocationUTC.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.mHour;
    }

    public final int component2() {
        return this.mMinute;
    }

    public final int component3() {
        return this.mSecond;
    }

    public final int component4() {
        return this.mMilli;
    }

    @OOXIXo
    public final BleLocationUTC copy(int i, int i2, int i3, int i4) {
        return new BleLocationUTC(i, i2, i3, i4);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mHour = readUInt8();
        this.mMinute = readUInt8();
        this.mSecond = readUInt8();
        skip(8);
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mMilli = readUInt16(LITTLE_ENDIAN);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleLocationUTC)) {
            return false;
        }
        BleLocationUTC bleLocationUTC = (BleLocationUTC) obj;
        return this.mHour == bleLocationUTC.mHour && this.mMinute == bleLocationUTC.mMinute && this.mSecond == bleLocationUTC.mSecond && this.mMilli == bleLocationUTC.mMilli;
    }

    public final int getMHour() {
        return this.mHour;
    }

    public final int getMMilli() {
        return this.mMilli;
    }

    public final int getMMinute() {
        return this.mMinute;
    }

    public final int getMSecond() {
        return this.mSecond;
    }

    public int hashCode() {
        return (((((this.mHour * 31) + this.mMinute) * 31) + this.mSecond) * 31) + this.mMilli;
    }

    public final void setMHour(int i) {
        this.mHour = i;
    }

    public final void setMMilli(int i) {
        this.mMilli = i;
    }

    public final void setMMinute(int i) {
        this.mMinute = i;
    }

    public final void setMSecond(int i) {
        this.mSecond = i;
    }

    @OOXIXo
    public String toString() {
        return "BleLocationUTC(mHour=" + this.mHour + ", mMinute=" + this.mMinute + ", mSecond=" + this.mSecond + ", mMilli=" + this.mMilli + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleLocationUTC(int i, int i2, int i3, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public BleLocationUTC(int i, int i2, int i3, int i4) {
        this.mHour = i;
        this.mMinute = i2;
        this.mSecond = i3;
        this.mMilli = i4;
    }
}
