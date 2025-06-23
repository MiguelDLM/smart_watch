package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleGameSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 9;
    private int mEnabled;
    private int mEndHour1;
    private int mEndHour2;
    private int mEndMinute1;
    private int mEndMinute2;
    private int mStartHour1;
    private int mStartHour2;
    private int mStartMinute1;
    private int mStartMinute2;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleGameSettings() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, null);
    }

    public final int component1() {
        return this.mEnabled;
    }

    public final int component2() {
        return this.mStartHour1;
    }

    public final int component3() {
        return this.mStartMinute1;
    }

    public final int component4() {
        return this.mEndHour1;
    }

    public final int component5() {
        return this.mEndMinute1;
    }

    public final int component6() {
        return this.mStartHour2;
    }

    public final int component7() {
        return this.mStartMinute2;
    }

    public final int component8() {
        return this.mEndHour2;
    }

    public final int component9() {
        return this.mEndMinute2;
    }

    @OOXIXo
    public final BleGameSettings copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return new BleGameSettings(i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mEnabled);
        writeInt8(this.mStartHour1);
        writeInt8(this.mStartMinute1);
        writeInt8(this.mEndHour1);
        writeInt8(this.mEndMinute1);
        writeInt8(this.mStartHour2);
        writeInt8(this.mStartMinute2);
        writeInt8(this.mEndHour2);
        writeInt8(this.mEndMinute2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleGameSettings)) {
            return false;
        }
        BleGameSettings bleGameSettings = (BleGameSettings) obj;
        return this.mEnabled == bleGameSettings.mEnabled && this.mStartHour1 == bleGameSettings.mStartHour1 && this.mStartMinute1 == bleGameSettings.mStartMinute1 && this.mEndHour1 == bleGameSettings.mEndHour1 && this.mEndMinute1 == bleGameSettings.mEndMinute1 && this.mStartHour2 == bleGameSettings.mStartHour2 && this.mStartMinute2 == bleGameSettings.mStartMinute2 && this.mEndHour2 == bleGameSettings.mEndHour2 && this.mEndMinute2 == bleGameSettings.mEndMinute2;
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    public final int getMEndHour1() {
        return this.mEndHour1;
    }

    public final int getMEndHour2() {
        return this.mEndHour2;
    }

    public final int getMEndMinute1() {
        return this.mEndMinute1;
    }

    public final int getMEndMinute2() {
        return this.mEndMinute2;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 9;
    }

    public final int getMStartHour1() {
        return this.mStartHour1;
    }

    public final int getMStartHour2() {
        return this.mStartHour2;
    }

    public final int getMStartMinute1() {
        return this.mStartMinute1;
    }

    public final int getMStartMinute2() {
        return this.mStartMinute2;
    }

    public int hashCode() {
        return (((((((((((((((this.mEnabled * 31) + this.mStartHour1) * 31) + this.mStartMinute1) * 31) + this.mEndHour1) * 31) + this.mEndMinute1) * 31) + this.mStartHour2) * 31) + this.mStartMinute2) * 31) + this.mEndHour2) * 31) + this.mEndMinute2;
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    public final void setMEndHour1(int i) {
        this.mEndHour1 = i;
    }

    public final void setMEndHour2(int i) {
        this.mEndHour2 = i;
    }

    public final void setMEndMinute1(int i) {
        this.mEndMinute1 = i;
    }

    public final void setMEndMinute2(int i) {
        this.mEndMinute2 = i;
    }

    public final void setMStartHour1(int i) {
        this.mStartHour1 = i;
    }

    public final void setMStartHour2(int i) {
        this.mStartHour2 = i;
    }

    public final void setMStartMinute1(int i) {
        this.mStartMinute1 = i;
    }

    public final void setMStartMinute2(int i) {
        this.mStartMinute2 = i;
    }

    @OOXIXo
    public String toString() {
        return "BleGameSettings(mEnabled=" + this.mEnabled + ", mStartHour1=" + this.mStartHour1 + ", mStartMinute1=" + this.mStartMinute1 + ", mEndHour1=" + this.mEndHour1 + ", mEndMinute1=" + this.mEndMinute1 + ", mStartHour2=" + this.mStartHour2 + ", mStartMinute2=" + this.mStartMinute2 + ", mEndHour2=" + this.mEndHour2 + ", mEndMinute2=" + this.mEndMinute2 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGameSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, IIXOooo iIXOooo) {
        this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? 0 : i2, (i10 & 4) != 0 ? 0 : i3, (i10 & 8) != 0 ? 0 : i4, (i10 & 16) != 0 ? 0 : i5, (i10 & 32) != 0 ? 0 : i6, (i10 & 64) != 0 ? 0 : i7, (i10 & 128) != 0 ? 0 : i8, (i10 & 256) == 0 ? i9 : 0);
    }

    public BleGameSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mEnabled = i;
        this.mStartHour1 = i2;
        this.mStartMinute1 = i3;
        this.mEndHour1 = i4;
        this.mEndMinute1 = i5;
        this.mStartHour2 = i6;
        this.mStartMinute2 = i7;
        this.mEndHour2 = i8;
        this.mEndMinute2 = i9;
    }
}
