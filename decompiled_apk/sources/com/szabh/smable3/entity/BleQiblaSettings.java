package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleQiblaSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleQiblaSettings.kt\ncom/szabh/smable3/entity/BleQiblaSettings\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,122:1\n232#2,3:123\n222#2,15:126\n*S KotlinDebug\n*F\n+ 1 BleQiblaSettings.kt\ncom/szabh/smable3/entity/BleQiblaSettings\n*L\n101#1:123,3\n101#1:126,15\n*E\n"})
/* loaded from: classes13.dex */
public final class BleQiblaSettings extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 452;
    public static final int METHOD_DUBAI = 4;
    public static final int METHOD_EGYPTIAN = 1;
    public static final int METHOD_KARACHI = 2;
    public static final int METHOD_KUWAIT = 7;
    public static final int METHOD_MOON_SIGHTING_COMMITTEE = 5;
    public static final int METHOD_MUSLIM_WORLD_LEAGUE = 0;
    public static final int METHOD_NORTH_AMERICA = 6;
    public static final int METHOD_OTHER = 11;
    public static final int METHOD_QATAR = 8;
    public static final int METHOD_SIHAT_KEMENAG = 12;
    public static final int METHOD_SINGAPORE = 9;
    public static final int METHOD_TURKEY = 10;
    public static final int METHOD_UMM_AL_QURA = 3;
    private int mEnabled;
    private int mHijriDay;
    private int mHijriMonth;
    private int mHijriYear;
    private int mMethod;

    @OOXIXo
    private List<BlePrayerTimes> mPrayerTimes;
    private int mReminderMinute;
    private int mStartTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleQiblaSettings() {
        this(0, 0, 0, 0, 0, 0, 0, null, 255, null);
    }

    public final int component1() {
        return this.mEnabled;
    }

    public final int component2() {
        return this.mMethod;
    }

    public final int component3() {
        return this.mReminderMinute;
    }

    public final int component4() {
        return this.mHijriYear;
    }

    public final int component5() {
        return this.mHijriMonth;
    }

    public final int component6() {
        return this.mHijriDay;
    }

    public final int component7() {
        return this.mStartTime;
    }

    @OOXIXo
    public final List<BlePrayerTimes> component8() {
        return this.mPrayerTimes;
    }

    @OOXIXo
    public final BleQiblaSettings copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, @OOXIXo List<BlePrayerTimes> mPrayerTimes) {
        IIX0o.x0xO0oo(mPrayerTimes, "mPrayerTimes");
        return new BleQiblaSettings(i, i2, i3, i4, i5, i6, i7, mPrayerTimes);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        int i;
        super.decode();
        this.mEnabled = readInt8();
        this.mMethod = readInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mReminderMinute = readInt16(LITTLE_ENDIAN);
        byte readInt8 = readInt8();
        if (readInt8 == 0) {
            i = 0;
        } else {
            i = readInt8 + 1400;
        }
        this.mHijriYear = i;
        this.mHijriMonth = readInt8();
        this.mHijriDay = readInt8();
        readBytes(7);
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mStartTime = readInt32(LITTLE_ENDIAN);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 31; i2++) {
            BleReadable bleReadable = (BleReadable) BlePrayerTimes.class.newInstance();
            bleReadable.setMBytes(readBytes(14));
            bleReadable.decode();
            IIX0o.ooOOo0oXI(bleReadable);
            arrayList.add(bleReadable);
        }
        this.mPrayerTimes = arrayList;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        int i;
        super.encode();
        writeInt8(this.mEnabled);
        writeInt8(this.mMethod);
        int i2 = this.mReminderMinute;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i2, LITTLE_ENDIAN);
        int i3 = this.mHijriYear;
        if (i3 == 0) {
            i = 0;
        } else {
            i = i3 - 1400;
        }
        writeInt8(i);
        writeInt8(this.mHijriMonth);
        writeInt8(this.mHijriDay);
        BleWritable.writeBytes$default(this, new byte[7], null, 2, null);
        int i4 = this.mStartTime;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i4, LITTLE_ENDIAN);
        writeList(this.mPrayerTimes);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleQiblaSettings)) {
            return false;
        }
        BleQiblaSettings bleQiblaSettings = (BleQiblaSettings) obj;
        return this.mEnabled == bleQiblaSettings.mEnabled && this.mMethod == bleQiblaSettings.mMethod && this.mReminderMinute == bleQiblaSettings.mReminderMinute && this.mHijriYear == bleQiblaSettings.mHijriYear && this.mHijriMonth == bleQiblaSettings.mHijriMonth && this.mHijriDay == bleQiblaSettings.mHijriDay && this.mStartTime == bleQiblaSettings.mStartTime && IIX0o.Oxx0IOOO(this.mPrayerTimes, bleQiblaSettings.mPrayerTimes);
    }

    public final int getMEnabled() {
        return this.mEnabled;
    }

    public final int getMHijriDay() {
        return this.mHijriDay;
    }

    public final int getMHijriMonth() {
        return this.mHijriMonth;
    }

    public final int getMHijriYear() {
        return this.mHijriYear;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return ITEM_LENGTH;
    }

    public final int getMMethod() {
        return this.mMethod;
    }

    @OOXIXo
    public final List<BlePrayerTimes> getMPrayerTimes() {
        return this.mPrayerTimes;
    }

    public final int getMReminderMinute() {
        return this.mReminderMinute;
    }

    public final int getMStartTime() {
        return this.mStartTime;
    }

    public int hashCode() {
        return (((((((((((((this.mEnabled * 31) + this.mMethod) * 31) + this.mReminderMinute) * 31) + this.mHijriYear) * 31) + this.mHijriMonth) * 31) + this.mHijriDay) * 31) + this.mStartTime) * 31) + this.mPrayerTimes.hashCode();
    }

    public final void setMEnabled(int i) {
        this.mEnabled = i;
    }

    public final void setMHijriDay(int i) {
        this.mHijriDay = i;
    }

    public final void setMHijriMonth(int i) {
        this.mHijriMonth = i;
    }

    public final void setMHijriYear(int i) {
        this.mHijriYear = i;
    }

    public final void setMMethod(int i) {
        this.mMethod = i;
    }

    public final void setMPrayerTimes(@OOXIXo List<BlePrayerTimes> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mPrayerTimes = list;
    }

    public final void setMReminderMinute(int i) {
        this.mReminderMinute = i;
    }

    public final void setMStartTime(int i) {
        this.mStartTime = i;
    }

    @OOXIXo
    public String toString() {
        return "BleQiblaSettings(mEnabled=" + this.mEnabled + ", mMethod=" + this.mMethod + ", mReminderMinute=" + this.mReminderMinute + ", mHijriYear=" + this.mHijriYear + ", mHijriMonth=" + this.mHijriMonth + ", mHijriDay=" + this.mHijriDay + ", mStartTime=" + this.mStartTime + ", mPrayerTimes=" + this.mPrayerTimes + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleQiblaSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, List list, int i8, IIXOooo iIXOooo) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) == 0 ? i7 : 0, (i8 & 128) != 0 ? new ArrayList() : list);
    }

    public BleQiblaSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, @OOXIXo List<BlePrayerTimes> mPrayerTimes) {
        IIX0o.x0xO0oo(mPrayerTimes, "mPrayerTimes");
        this.mEnabled = i;
        this.mMethod = i2;
        this.mReminderMinute = i3;
        this.mHijriYear = i4;
        this.mHijriMonth = i5;
        this.mHijriDay = i6;
        this.mStartTime = i7;
        this.mPrayerTimes = mPrayerTimes;
    }
}
