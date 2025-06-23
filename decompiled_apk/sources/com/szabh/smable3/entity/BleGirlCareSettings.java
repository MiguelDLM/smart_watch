package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleGirlCareSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 10;
    private int mEnabled;
    private int mLatestDay;
    private int mLatestMonth;
    private int mLatestYear;
    private int mMenstruationDuration;
    private int mMenstruationPeriod;
    private int mMenstruationReminderAdvance;
    private int mOvulationReminderAdvance;
    private int mReminderEnable;
    private int mReminderHour;
    private int mReminderMinute;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleGirlCareSettings() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, null);
    }

    public final int component1() {
        return this.mEnabled;
    }

    public final int component10() {
        return this.mMenstruationDuration;
    }

    public final int component11() {
        return this.mMenstruationPeriod;
    }

    public final int component2() {
        return this.mReminderEnable;
    }

    public final int component3() {
        return this.mReminderHour;
    }

    public final int component4() {
        return this.mReminderMinute;
    }

    public final int component5() {
        return this.mMenstruationReminderAdvance;
    }

    public final int component6() {
        return this.mOvulationReminderAdvance;
    }

    public final int component7() {
        return this.mLatestYear;
    }

    public final int component8() {
        return this.mLatestMonth;
    }

    public final int component9() {
        return this.mLatestDay;
    }

    @OOXIXo
    public final BleGirlCareSettings copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        return new BleGirlCareSettings(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mReminderEnable = readIntN(1);
        readIntN(6);
        this.mEnabled = readIntN(1);
        this.mReminderHour = readInt8();
        this.mReminderMinute = readInt8();
        this.mMenstruationReminderAdvance = readInt8();
        this.mOvulationReminderAdvance = readInt8();
        this.mLatestYear = readInt8() + 2000;
        this.mLatestMonth = readInt8();
        this.mLatestDay = readInt8();
        this.mMenstruationDuration = readInt8();
        this.mMenstruationPeriod = readInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeIntN(this.mReminderEnable, 1);
        writeIntN(0, 6);
        writeIntN(this.mEnabled, 1);
        writeInt8(this.mReminderHour);
        writeInt8(this.mReminderMinute);
        writeInt8(this.mMenstruationReminderAdvance);
        writeInt8(this.mOvulationReminderAdvance);
        writeInt8(this.mLatestYear - 2000);
        writeInt8(this.mLatestMonth);
        writeInt8(this.mLatestDay);
        writeInt8(this.mMenstruationDuration);
        writeInt8(this.mMenstruationPeriod);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleGirlCareSettings)) {
            return false;
        }
        BleGirlCareSettings bleGirlCareSettings = (BleGirlCareSettings) obj;
        return this.mEnabled == bleGirlCareSettings.mEnabled && this.mReminderEnable == bleGirlCareSettings.mReminderEnable && this.mReminderHour == bleGirlCareSettings.mReminderHour && this.mReminderMinute == bleGirlCareSettings.mReminderMinute && this.mMenstruationReminderAdvance == bleGirlCareSettings.mMenstruationReminderAdvance && this.mOvulationReminderAdvance == bleGirlCareSettings.mOvulationReminderAdvance && this.mLatestYear == bleGirlCareSettings.mLatestYear && this.mLatestMonth == bleGirlCareSettings.mLatestMonth && this.mLatestDay == bleGirlCareSettings.mLatestDay && this.mMenstruationDuration == bleGirlCareSettings.mMenstruationDuration && this.mMenstruationPeriod == bleGirlCareSettings.mMenstruationPeriod;
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    public final int getMLatestDay() {
        return this.mLatestDay;
    }

    public final int getMLatestMonth() {
        return this.mLatestMonth;
    }

    public final int getMLatestYear() {
        return this.mLatestYear;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 10;
    }

    public final int getMMenstruationDuration() {
        return this.mMenstruationDuration;
    }

    public final int getMMenstruationPeriod() {
        return this.mMenstruationPeriod;
    }

    public final int getMMenstruationReminderAdvance() {
        return this.mMenstruationReminderAdvance;
    }

    public final int getMOvulationReminderAdvance() {
        return this.mOvulationReminderAdvance;
    }

    public final int getMReminderEnable() {
        return this.mReminderEnable;
    }

    public final int getMReminderHour() {
        return this.mReminderHour;
    }

    public final int getMReminderMinute() {
        return this.mReminderMinute;
    }

    public int hashCode() {
        return (((((((((((((((((((this.mEnabled * 31) + this.mReminderEnable) * 31) + this.mReminderHour) * 31) + this.mReminderMinute) * 31) + this.mMenstruationReminderAdvance) * 31) + this.mOvulationReminderAdvance) * 31) + this.mLatestYear) * 31) + this.mLatestMonth) * 31) + this.mLatestDay) * 31) + this.mMenstruationDuration) * 31) + this.mMenstruationPeriod;
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    public final void setMLatestDay(int i) {
        this.mLatestDay = i;
    }

    public final void setMLatestMonth(int i) {
        this.mLatestMonth = i;
    }

    public final void setMLatestYear(int i) {
        this.mLatestYear = i;
    }

    public final void setMMenstruationDuration(int i) {
        this.mMenstruationDuration = i;
    }

    public final void setMMenstruationPeriod(int i) {
        this.mMenstruationPeriod = i;
    }

    public final void setMMenstruationReminderAdvance(int i) {
        this.mMenstruationReminderAdvance = i;
    }

    public final void setMOvulationReminderAdvance(int i) {
        this.mOvulationReminderAdvance = i;
    }

    public final void setMReminderEnable(int i) {
        this.mReminderEnable = i;
    }

    public final void setMReminderHour(int i) {
        this.mReminderHour = i;
    }

    public final void setMReminderMinute(int i) {
        this.mReminderMinute = i;
    }

    @OOXIXo
    public String toString() {
        return "BleGirlCareSettings(mEnabled=" + this.mEnabled + ", mReminderEnable=" + this.mReminderEnable + ", mReminderHour=" + this.mReminderHour + ", mReminderMinute=" + this.mReminderMinute + ", mMenstruationReminderAdvance=" + this.mMenstruationReminderAdvance + ", mOvulationReminderAdvance=" + this.mOvulationReminderAdvance + ", mLatestYear=" + this.mLatestYear + ", mLatestMonth=" + this.mLatestMonth + ", mLatestDay=" + this.mLatestDay + ", mMenstruationDuration=" + this.mMenstruationDuration + ", mMenstruationPeriod=" + this.mMenstruationPeriod + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleGirlCareSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, IIXOooo iIXOooo) {
        this((i12 & 1) != 0 ? 0 : i, (i12 & 2) != 0 ? 0 : i2, (i12 & 4) != 0 ? 0 : i3, (i12 & 8) != 0 ? 0 : i4, (i12 & 16) != 0 ? 0 : i5, (i12 & 32) != 0 ? 0 : i6, (i12 & 64) != 0 ? 0 : i7, (i12 & 128) != 0 ? 0 : i8, (i12 & 256) != 0 ? 0 : i9, (i12 & 512) != 0 ? 0 : i10, (i12 & 1024) == 0 ? i11 : 0);
    }

    public BleGirlCareSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.mEnabled = i;
        this.mReminderEnable = i2;
        this.mReminderHour = i3;
        this.mReminderMinute = i4;
        this.mMenstruationReminderAdvance = i5;
        this.mOvulationReminderAdvance = i6;
        this.mLatestYear = i7;
        this.mLatestMonth = i8;
        this.mLatestDay = i9;
        this.mMenstruationDuration = i10;
        this.mMenstruationPeriod = i11;
    }
}
