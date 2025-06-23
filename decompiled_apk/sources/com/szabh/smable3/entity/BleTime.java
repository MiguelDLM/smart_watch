package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

/* loaded from: classes13.dex */
public final class BleTime extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 6;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int mMonth;
    private int mSecond;
    private int mYear;

    @XX({"SMAP\nBleTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleTime.kt\ncom/szabh/smable3/entity/BleTime$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final TimeZone getUtcTimeZone() {
            TimeZone timeZone = TimeZone.getTimeZone("GMT+0");
            IIX0o.oO(timeZone, "getTimeZone(...)");
            return timeZone;
        }

        @OOXIXo
        public final BleTime local() {
            Calendar calendar = Calendar.getInstance();
            IIX0o.ooOOo0oXI(calendar);
            return new BleTime(calendar, null);
        }

        @OOXIXo
        public final BleTime ofLocal(long j) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            IIX0o.ooOOo0oXI(calendar);
            return new BleTime(calendar, null);
        }

        @OOXIXo
        public final BleTime utc() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeZone(BleTime.Companion.getUtcTimeZone());
            IIX0o.ooOOo0oXI(calendar);
            return new BleTime(calendar, null);
        }

        private Companion() {
        }
    }

    public BleTime() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ BleTime copy$default(BleTime bleTime, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = bleTime.mYear;
        }
        if ((i7 & 2) != 0) {
            i2 = bleTime.mMonth;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = bleTime.mDay;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = bleTime.mHour;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = bleTime.mMinute;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = bleTime.mSecond;
        }
        return bleTime.copy(i, i8, i9, i10, i11, i6);
    }

    public final int component1() {
        return this.mYear;
    }

    public final int component2() {
        return this.mMonth;
    }

    public final int component3() {
        return this.mDay;
    }

    public final int component4() {
        return this.mHour;
    }

    public final int component5() {
        return this.mMinute;
    }

    public final int component6() {
        return this.mSecond;
    }

    @OOXIXo
    public final BleTime copy(int i, int i2, int i3, int i4, int i5, int i6) {
        return new BleTime(i, i2, i3, i4, i5, i6);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mYear = readUInt8() + 2000;
        this.mMonth = readUInt8();
        this.mDay = readUInt8();
        this.mHour = readUInt8();
        this.mMinute = readUInt8();
        this.mSecond = readUInt8();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mYear - 2000);
        writeInt8(this.mMonth);
        writeInt8(this.mDay);
        writeInt8(this.mHour);
        writeInt8(this.mMinute);
        writeInt8(this.mSecond);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleTime)) {
            return false;
        }
        BleTime bleTime = (BleTime) obj;
        return this.mYear == bleTime.mYear && this.mMonth == bleTime.mMonth && this.mDay == bleTime.mDay && this.mHour == bleTime.mHour && this.mMinute == bleTime.mMinute && this.mSecond == bleTime.mSecond;
    }

    public final int getMDay() {
        return this.mDay;
    }

    public final int getMHour() {
        return this.mHour;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 6;
    }

    public final int getMMinute() {
        return this.mMinute;
    }

    public final int getMMonth() {
        return this.mMonth;
    }

    public final int getMSecond() {
        return this.mSecond;
    }

    public final int getMYear() {
        return this.mYear;
    }

    public int hashCode() {
        return (((((((((this.mYear * 31) + this.mMonth) * 31) + this.mDay) * 31) + this.mHour) * 31) + this.mMinute) * 31) + this.mSecond;
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

    public final void setMSecond(int i) {
        this.mSecond = i;
    }

    public final void setMYear(int i) {
        this.mYear = i;
    }

    @OOXIXo
    public String toString() {
        return "BleTime(mYear=" + this.mYear + ", mMonth=" + this.mMonth + ", mDay=" + this.mDay + ", mHour=" + this.mHour + ", mMinute=" + this.mMinute + ", mSecond=" + this.mSecond + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleTime(Calendar calendar, IIXOooo iIXOooo) {
        this(calendar);
    }

    public /* synthetic */ BleTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? 0 : i2, (i7 & 4) != 0 ? 0 : i3, (i7 & 8) != 0 ? 0 : i4, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) != 0 ? 0 : i6);
    }

    public BleTime(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mYear = i;
        this.mMonth = i2;
        this.mDay = i3;
        this.mHour = i4;
        this.mMinute = i5;
        this.mSecond = i6;
    }

    private BleTime(Calendar calendar) {
        this(calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13));
    }
}
