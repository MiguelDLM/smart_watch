package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleSchedule;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import oOXoIIIo.II0xO0;

@Entity
/* loaded from: classes12.dex */
public final class Schedule {

    @ColumnInfo
    private int mAdvance;

    @OOXIXo
    @ColumnInfo
    private String mContent;

    @ColumnInfo
    private int mDay;

    @ColumnInfo
    private int mHour;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private int mMinute;

    @ColumnInfo
    private int mMonth;

    @ColumnInfo
    private int mScheduleId;

    @OOXIXo
    @ColumnInfo
    private String mTitle;

    @ColumnInfo
    private int mYear;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final Calendar CALENDAR = Calendar.getInstance();

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public Schedule() {
        this(0, 0, 0, 0, 0, 0, 0, 0, null, null, 1023, null);
    }

    public final int component1() {
        return this.mId;
    }

    @OOXIXo
    public final String component10() {
        return this.mContent;
    }

    public final int component2() {
        return this.mScheduleId;
    }

    public final int component3() {
        return this.mYear;
    }

    public final int component4() {
        return this.mMonth;
    }

    public final int component5() {
        return this.mDay;
    }

    public final int component6() {
        return this.mHour;
    }

    public final int component7() {
        return this.mMinute;
    }

    public final int component8() {
        return this.mAdvance;
    }

    @OOXIXo
    public final String component9() {
        return this.mTitle;
    }

    @OOXIXo
    public final Schedule copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, @OOXIXo String mTitle, @OOXIXo String mContent) {
        IIX0o.x0xO0oo(mTitle, "mTitle");
        IIX0o.x0xO0oo(mContent, "mContent");
        return new Schedule(i, i2, i3, i4, i5, i6, i7, i8, mTitle, mContent);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Schedule)) {
            return false;
        }
        Schedule schedule = (Schedule) obj;
        return this.mId == schedule.mId && this.mScheduleId == schedule.mScheduleId && this.mYear == schedule.mYear && this.mMonth == schedule.mMonth && this.mDay == schedule.mDay && this.mHour == schedule.mHour && this.mMinute == schedule.mMinute && this.mAdvance == schedule.mAdvance && IIX0o.Oxx0IOOO(this.mTitle, schedule.mTitle) && IIX0o.Oxx0IOOO(this.mContent, schedule.mContent);
    }

    public final int getMAdvance() {
        return this.mAdvance;
    }

    @OOXIXo
    public final BleSchedule getMBleSchedule() {
        return new BleSchedule(this.mYear, this.mMonth, this.mDay, this.mHour, this.mMinute, this.mAdvance, this.mTitle, this.mContent);
    }

    @OOXIXo
    public final String getMContent() {
        return this.mContent;
    }

    @OOXIXo
    public final Date getMDate() {
        Calendar calendar = CALENDAR;
        IIX0o.ooOOo0oXI(calendar);
        II0xO0.XI0IXoo(calendar, this.mYear);
        II0xO0.o00(calendar, this.mMonth);
        II0xO0.IXxxXO(calendar, this.mDay);
        II0xO0.oI0IIXIo(calendar, this.mHour);
        II0xO0.IIXOooo(calendar, this.mMinute);
        Date time = calendar.getTime();
        IIX0o.oO(time, "getTime(...)");
        return time;
    }

    public final int getMDay() {
        return this.mDay;
    }

    public final int getMHour() {
        return this.mHour;
    }

    public final int getMId() {
        return this.mId;
    }

    public final int getMMinute() {
        return this.mMinute;
    }

    public final int getMMonth() {
        return this.mMonth;
    }

    public final int getMScheduleId() {
        return this.mScheduleId;
    }

    @OOXIXo
    public final String getMTitle() {
        return this.mTitle;
    }

    public final int getMYear() {
        return this.mYear;
    }

    public int hashCode() {
        return (((((((((((((((((this.mId * 31) + this.mScheduleId) * 31) + this.mYear) * 31) + this.mMonth) * 31) + this.mDay) * 31) + this.mHour) * 31) + this.mMinute) * 31) + this.mAdvance) * 31) + this.mTitle.hashCode()) * 31) + this.mContent.hashCode();
    }

    public final void setMAdvance(int i) {
        this.mAdvance = i;
    }

    public final void setMContent(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mContent = str;
    }

    public final void setMDay(int i) {
        this.mDay = i;
    }

    public final void setMHour(int i) {
        this.mHour = i;
    }

    public final void setMMinute(int i) {
        this.mMinute = i;
    }

    public final void setMMonth(int i) {
        this.mMonth = i;
    }

    public final void setMScheduleId(int i) {
        this.mScheduleId = i;
    }

    public final void setMTitle(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mTitle = str;
    }

    public final void setMYear(int i) {
        this.mYear = i;
    }

    @OOXIXo
    public String toString() {
        return "Schedule(mId=" + this.mId + ", mScheduleId=" + this.mScheduleId + ", mYear=" + this.mYear + ", mMonth=" + this.mMonth + ", mDay=" + this.mDay + ", mHour=" + this.mHour + ", mMinute=" + this.mMinute + ", mAdvance=" + this.mAdvance + ", mTitle=" + this.mTitle + ", mContent=" + this.mContent + HexStringBuilder.COMMENT_END_CHAR;
    }

    public Schedule(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, @OOXIXo String mTitle, @OOXIXo String mContent) {
        IIX0o.x0xO0oo(mTitle, "mTitle");
        IIX0o.x0xO0oo(mContent, "mContent");
        this.mId = i;
        this.mScheduleId = i2;
        this.mYear = i3;
        this.mMonth = i4;
        this.mDay = i5;
        this.mHour = i6;
        this.mMinute = i7;
        this.mAdvance = i8;
        this.mTitle = mTitle;
        this.mContent = mContent;
    }

    public /* synthetic */ Schedule(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, int i9, IIXOooo iIXOooo) {
        this((i9 & 1) != 0 ? 0 : i, (i9 & 2) != 0 ? 0 : i2, (i9 & 4) != 0 ? 0 : i3, (i9 & 8) != 0 ? 0 : i4, (i9 & 16) != 0 ? 0 : i5, (i9 & 32) != 0 ? 0 : i6, (i9 & 64) != 0 ? 0 : i7, (i9 & 128) == 0 ? i8 : 0, (i9 & 256) != 0 ? "" : str, (i9 & 512) == 0 ? str2 : "");
    }
}
