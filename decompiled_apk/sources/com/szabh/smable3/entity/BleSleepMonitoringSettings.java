package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSleepMonitoringSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 5;
    private int mEnabled;
    private int mEndHour;
    private int mEndMinute;
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

    public BleSleepMonitoringSettings() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ BleSleepMonitoringSettings copy$default(BleSleepMonitoringSettings bleSleepMonitoringSettings, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = bleSleepMonitoringSettings.mEnabled;
        }
        if ((i6 & 2) != 0) {
            i2 = bleSleepMonitoringSettings.mStartHour;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = bleSleepMonitoringSettings.mStartMinute;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = bleSleepMonitoringSettings.mEndHour;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = bleSleepMonitoringSettings.mEndMinute;
        }
        return bleSleepMonitoringSettings.copy(i, i7, i8, i9, i5);
    }

    public final int component1() {
        return this.mEnabled;
    }

    public final int component2() {
        return this.mStartHour;
    }

    public final int component3() {
        return this.mStartMinute;
    }

    public final int component4() {
        return this.mEndHour;
    }

    public final int component5() {
        return this.mEndMinute;
    }

    @OOXIXo
    public final BleSleepMonitoringSettings copy(int i, int i2, int i3, int i4, int i5) {
        return new BleSleepMonitoringSettings(i, i2, i3, i4, i5);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mEnabled = readUInt8();
        this.mStartHour = readUInt8();
        this.mStartMinute = readUInt8();
        this.mEndHour = readUInt8();
        this.mEndMinute = readUInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mEnabled);
        writeInt8(this.mStartHour);
        writeInt8(this.mStartMinute);
        writeInt8(this.mEndHour);
        writeInt8(this.mEndMinute);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSleepMonitoringSettings)) {
            return false;
        }
        BleSleepMonitoringSettings bleSleepMonitoringSettings = (BleSleepMonitoringSettings) obj;
        return this.mEnabled == bleSleepMonitoringSettings.mEnabled && this.mStartHour == bleSleepMonitoringSettings.mStartHour && this.mStartMinute == bleSleepMonitoringSettings.mStartMinute && this.mEndHour == bleSleepMonitoringSettings.mEndHour && this.mEndMinute == bleSleepMonitoringSettings.mEndMinute;
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

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 5;
    }

    public final int getMStartHour() {
        return this.mStartHour;
    }

    public final int getMStartMinute() {
        return this.mStartMinute;
    }

    public int hashCode() {
        return (((((((this.mEnabled * 31) + this.mStartHour) * 31) + this.mStartMinute) * 31) + this.mEndHour) * 31) + this.mEndMinute;
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

    public final void setMStartHour(int i) {
        this.mStartHour = i;
    }

    public final void setMStartMinute(int i) {
        this.mStartMinute = i;
    }

    @OOXIXo
    public String toString() {
        return "BleSleepMonitoringSettings(mEnabled=" + this.mEnabled + ", mStartHour=" + this.mStartHour + ", mStartMinute=" + this.mStartMinute + ", mEndHour=" + this.mEndHour + ", mEndMinute=" + this.mEndMinute + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleSleepMonitoringSettings(int i, int i2, int i3, int i4, int i5, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5);
    }

    public BleSleepMonitoringSettings(int i, int i2, int i3, int i4, int i5) {
        this.mEnabled = i;
        this.mStartHour = i2;
        this.mStartMinute = i3;
        this.mEndHour = i4;
        this.mEndMinute = i5;
    }
}
