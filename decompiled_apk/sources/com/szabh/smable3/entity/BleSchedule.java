package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleSchedule extends BleIdObject {
    public static final int CONTENT_MAX_LENGTH = 250;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int TITLE_LENGTH = 32;
    private int mAdvance;

    @OOXIXo
    private String mContent;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int mMonth;

    @OOXIXo
    private String mTitle;
    private int mYear;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleSchedule() {
        this(0, 0, 0, 0, 0, 0, null, null, 255, null);
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
        return this.mAdvance;
    }

    @OOXIXo
    public final String component7() {
        return this.mTitle;
    }

    @OOXIXo
    public final String component8() {
        return this.mContent;
    }

    @OOXIXo
    public final BleSchedule copy(int i, int i2, int i3, int i4, int i5, int i6, @OOXIXo String mTitle, @OOXIXo String mContent) {
        IIX0o.x0xO0oo(mTitle, "mTitle");
        IIX0o.x0xO0oo(mContent, "mContent");
        return new BleSchedule(i, i2, i3, i4, i5, i6, mTitle, mContent);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(getMId());
        writeInt8(this.mYear - 2000);
        writeInt8(this.mMonth);
        writeInt8(this.mDay);
        writeInt8(this.mHour);
        writeInt8(this.mMinute);
        BleWritable.writeInt16$default(this, this.mAdvance, null, 2, null);
        BleWritable.writeStringWithFix$default(this, this.mTitle, 32, null, 4, null);
        BleWritable.writeStringWithLimit$default(this, this.mContent, 250, null, false, 12, null);
        writeInt8(0);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSchedule)) {
            return false;
        }
        BleSchedule bleSchedule = (BleSchedule) obj;
        return this.mYear == bleSchedule.mYear && this.mMonth == bleSchedule.mMonth && this.mDay == bleSchedule.mDay && this.mHour == bleSchedule.mHour && this.mMinute == bleSchedule.mMinute && this.mAdvance == bleSchedule.mAdvance && IIX0o.Oxx0IOOO(this.mTitle, bleSchedule.mTitle) && IIX0o.Oxx0IOOO(this.mContent, bleSchedule.mContent);
    }

    public final int getMAdvance() {
        return this.mAdvance;
    }

    @OOXIXo
    public final String getMContent() {
        return this.mContent;
    }

    public final int getMDay() {
        return this.mDay;
    }

    public final int getMHour() {
        return this.mHour;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        byte[] bytes = this.mContent.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        return Math.min(bytes.length, 250) + 40;
    }

    public final int getMMinute() {
        return this.mMinute;
    }

    public final int getMMonth() {
        return this.mMonth;
    }

    @OOXIXo
    public final String getMTitle() {
        return this.mTitle;
    }

    public final int getMYear() {
        return this.mYear;
    }

    public int hashCode() {
        return (((((((((((((this.mYear * 31) + this.mMonth) * 31) + this.mDay) * 31) + this.mHour) * 31) + this.mMinute) * 31) + this.mAdvance) * 31) + this.mTitle.hashCode()) * 31) + this.mContent.hashCode();
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

    public final void setMTitle(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mTitle = str;
    }

    public final void setMYear(int i) {
        this.mYear = i;
    }

    @OOXIXo
    public String toString() {
        return "BleSchedule(mYear=" + this.mYear + ", mMonth=" + this.mMonth + ", mDay=" + this.mDay + ", mHour=" + this.mHour + ", mMinute=" + this.mMinute + ", mAdvance=" + this.mAdvance + ", mTitle=" + this.mTitle + ", mContent=" + this.mContent + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleSchedule(int i, int i2, int i3, int i4, int i5, int i6, String str, String str2, int i7, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? 0 : i2, (i7 & 4) != 0 ? 0 : i3, (i7 & 8) != 0 ? 0 : i4, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) == 0 ? i6 : 0, (i7 & 64) != 0 ? "" : str, (i7 & 128) == 0 ? str2 : "");
    }

    public BleSchedule(int i, int i2, int i3, int i4, int i5, int i6, @OOXIXo String mTitle, @OOXIXo String mContent) {
        IIX0o.x0xO0oo(mTitle, "mTitle");
        IIX0o.x0xO0oo(mContent, "mContent");
        this.mYear = i;
        this.mMonth = i2;
        this.mDay = i3;
        this.mHour = i4;
        this.mMinute = i5;
        this.mAdvance = i6;
        this.mTitle = mTitle;
        this.mContent = mContent;
    }
}
