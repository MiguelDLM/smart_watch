package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSedentarinessSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 6;
    private int mEnabled;
    private int mEndHour;
    private int mEndMinute;
    private int mInterval;
    private int mRepeat;
    private int mStartHour;
    private int mStartMinute;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleSedentarinessSettings() {
        this(0, 0, 0, 0, 0, 0, 0, 127, null);
    }

    public static /* synthetic */ BleSedentarinessSettings copy$default(BleSedentarinessSettings bleSedentarinessSettings, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i = bleSedentarinessSettings.mEnabled;
        }
        if ((i8 & 2) != 0) {
            i2 = bleSedentarinessSettings.mRepeat;
        }
        int i9 = i2;
        if ((i8 & 4) != 0) {
            i3 = bleSedentarinessSettings.mStartHour;
        }
        int i10 = i3;
        if ((i8 & 8) != 0) {
            i4 = bleSedentarinessSettings.mStartMinute;
        }
        int i11 = i4;
        if ((i8 & 16) != 0) {
            i5 = bleSedentarinessSettings.mEndHour;
        }
        int i12 = i5;
        if ((i8 & 32) != 0) {
            i6 = bleSedentarinessSettings.mEndMinute;
        }
        int i13 = i6;
        if ((i8 & 64) != 0) {
            i7 = bleSedentarinessSettings.mInterval;
        }
        return bleSedentarinessSettings.copy(i, i9, i10, i11, i12, i13, i7);
    }

    public final int component1() {
        return this.mEnabled;
    }

    public final int component2() {
        return this.mRepeat;
    }

    public final int component3() {
        return this.mStartHour;
    }

    public final int component4() {
        return this.mStartMinute;
    }

    public final int component5() {
        return this.mEndHour;
    }

    public final int component6() {
        return this.mEndMinute;
    }

    public final int component7() {
        return this.mInterval;
    }

    @OOXIXo
    public final BleSedentarinessSettings copy(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new BleSedentarinessSettings(i, i2, i3, i4, i5, i6, i7);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mEnabled = readIntN(1);
        this.mRepeat = readIntN(7);
        this.mStartHour = readUInt8();
        this.mStartMinute = readUInt8();
        this.mEndHour = readUInt8();
        this.mEndMinute = readUInt8();
        this.mInterval = readUInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeIntN(this.mEnabled, 1);
        writeIntN(this.mRepeat, 7);
        writeInt8(this.mStartHour);
        writeInt8(this.mStartMinute);
        writeInt8(this.mEndHour);
        writeInt8(this.mEndMinute);
        writeInt8(this.mInterval);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSedentarinessSettings)) {
            return false;
        }
        BleSedentarinessSettings bleSedentarinessSettings = (BleSedentarinessSettings) obj;
        return this.mEnabled == bleSedentarinessSettings.mEnabled && this.mRepeat == bleSedentarinessSettings.mRepeat && this.mStartHour == bleSedentarinessSettings.mStartHour && this.mStartMinute == bleSedentarinessSettings.mStartMinute && this.mEndHour == bleSedentarinessSettings.mEndHour && this.mEndMinute == bleSedentarinessSettings.mEndMinute && this.mInterval == bleSedentarinessSettings.mInterval;
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    public final int getMEndHour() {
        return this.mEndHour;
    }

    public final int getMEndMinute() {
        return this.mEndMinute;
    }

    public final int getMInterval() {
        return this.mInterval;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 6;
    }

    public final int getMRepeat() {
        return this.mRepeat;
    }

    public final int getMStartHour() {
        return this.mStartHour;
    }

    public final int getMStartMinute() {
        return this.mStartMinute;
    }

    public int hashCode() {
        return (((((((((((this.mEnabled * 31) + this.mRepeat) * 31) + this.mStartHour) * 31) + this.mStartMinute) * 31) + this.mEndHour) * 31) + this.mEndMinute) * 31) + this.mInterval;
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    public final void setMEndHour(int i) {
        this.mEndHour = i;
    }

    public final void setMEndMinute(int i) {
        this.mEndMinute = i;
    }

    public final void setMInterval(int i) {
        this.mInterval = i;
    }

    public final void setMRepeat(int i) {
        this.mRepeat = i;
    }

    public final void setMStartHour(int i) {
        this.mStartHour = i;
    }

    public final void setMStartMinute(int i) {
        this.mStartMinute = i;
    }

    @OOXIXo
    public String toString() {
        return "BleSedentarinessSettings(mEnabled=" + this.mEnabled + ", mRepeat=" + this.mRepeat + ", mStartHour=" + this.mStartHour + ", mStartMinute=" + this.mStartMinute + ", mEndHour=" + this.mEndHour + ", mEndMinute=" + this.mEndMinute + ", mInterval=" + this.mInterval + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleSedentarinessSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, IIXOooo iIXOooo) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) != 0 ? 0 : i7);
    }

    public BleSedentarinessSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mEnabled = i;
        this.mRepeat = i2;
        this.mStartHour = i3;
        this.mStartMinute = i4;
        this.mEndHour = i5;
        this.mEndMinute = i6;
        this.mInterval = i7;
    }
}
