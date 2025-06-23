package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleMedicationReminder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleMedicationReminder.kt\ncom/szabh/smable3/entity/BleMedicationReminder\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,117:1\n222#2,4:118\n222#2,4:122\n222#2,4:126\n222#2,4:130\n222#2,4:134\n222#2,4:138\n*S KotlinDebug\n*F\n+ 1 BleMedicationReminder.kt\ncom/szabh/smable3/entity/BleMedicationReminder\n*L\n61#1:118,4\n62#1:122,4\n63#1:126,4\n64#1:130,4\n65#1:134,4\n66#1:138,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleMedicationReminder extends BleIdObject {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 72;
    private static final int LABLE_LENGTH = 21;
    private static final int NAME_LENGTH = 24;
    public static final int TYPE_CAPSULE = 1;
    public static final int TYPE_CREAM = 3;
    public static final int TYPE_DROPS = 2;
    public static final int TYPE_INJECTABLE = 6;
    public static final int TYPE_SOLUTION = 5;
    public static final int TYPE_SPRAY = 4;
    public static final int TYPE_TABLET = 0;
    public static final int UNIT_GRAM = 2;
    public static final int UNIT_INTERNATIONAL = 6;
    public static final int UNIT_MICROGRAM = 1;
    public static final int UNIT_MILLICURIE = 7;
    public static final int UNIT_MILLIEQUIVALENT = 8;
    public static final int UNIT_MILLIGRAM = 0;
    public static final int UNIT_MILLILITER = 3;
    public static final int UNIT_PERCENTAGE = 4;
    public static final int UNIT_PIECE = 5;
    private int mDosage;
    private int mEndDay;
    private int mEndMonth;
    private int mEndYear;

    @OOXIXo
    private String mLabel;

    @OOXIXo
    private String mName;

    @OOXIXo
    private BleHmTime mRemindTime1;

    @OOXIXo
    private BleHmTime mRemindTime2;

    @OOXIXo
    private BleHmTime mRemindTime3;

    @OOXIXo
    private BleHmTime mRemindTime4;

    @OOXIXo
    private BleHmTime mRemindTime5;

    @OOXIXo
    private BleHmTime mRemindTime6;
    private int mRemindTimes;
    private int mRepeat;
    private int mStartDay;
    private int mStartMonth;
    private int mStartYear;
    private int mType;
    private int mUnit;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleMedicationReminder() {
        this(0, 0, 0, 0, 0, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null, null, 524287, null);
    }

    public final int component1() {
        return this.mType;
    }

    @OOXIXo
    public final BleHmTime component10() {
        return this.mRemindTime5;
    }

    @OOXIXo
    public final BleHmTime component11() {
        return this.mRemindTime6;
    }

    public final int component12() {
        return this.mStartYear;
    }

    public final int component13() {
        return this.mStartMonth;
    }

    public final int component14() {
        return this.mStartDay;
    }

    public final int component15() {
        return this.mEndYear;
    }

    public final int component16() {
        return this.mEndMonth;
    }

    public final int component17() {
        return this.mEndDay;
    }

    @OOXIXo
    public final String component18() {
        return this.mName;
    }

    @OOXIXo
    public final String component19() {
        return this.mLabel;
    }

    public final int component2() {
        return this.mUnit;
    }

    public final int component3() {
        return this.mDosage;
    }

    public final int component4() {
        return this.mRepeat;
    }

    public final int component5() {
        return this.mRemindTimes;
    }

    @OOXIXo
    public final BleHmTime component6() {
        return this.mRemindTime1;
    }

    @OOXIXo
    public final BleHmTime component7() {
        return this.mRemindTime2;
    }

    @OOXIXo
    public final BleHmTime component8() {
        return this.mRemindTime3;
    }

    @OOXIXo
    public final BleHmTime component9() {
        return this.mRemindTime4;
    }

    @OOXIXo
    public final BleMedicationReminder copy(int i, int i2, int i3, int i4, int i5, @OOXIXo BleHmTime mRemindTime1, @OOXIXo BleHmTime mRemindTime2, @OOXIXo BleHmTime mRemindTime3, @OOXIXo BleHmTime mRemindTime4, @OOXIXo BleHmTime mRemindTime5, @OOXIXo BleHmTime mRemindTime6, int i6, int i7, int i8, int i9, int i10, int i11, @OOXIXo String mName, @OOXIXo String mLabel) {
        IIX0o.x0xO0oo(mRemindTime1, "mRemindTime1");
        IIX0o.x0xO0oo(mRemindTime2, "mRemindTime2");
        IIX0o.x0xO0oo(mRemindTime3, "mRemindTime3");
        IIX0o.x0xO0oo(mRemindTime4, "mRemindTime4");
        IIX0o.x0xO0oo(mRemindTime5, "mRemindTime5");
        IIX0o.x0xO0oo(mRemindTime6, "mRemindTime6");
        IIX0o.x0xO0oo(mName, "mName");
        IIX0o.x0xO0oo(mLabel, "mLabel");
        return new BleMedicationReminder(i, i2, i3, i4, i5, mRemindTime1, mRemindTime2, mRemindTime3, mRemindTime4, mRemindTime5, mRemindTime6, i6, i7, i8, i9, i10, i11, mName, mLabel);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        setMId(readUInt8());
        this.mType = readUInt8();
        this.mUnit = readUInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mDosage = (int) readUInt32(LITTLE_ENDIAN);
        this.mRepeat = readUInt8();
        this.mRemindTimes = readUInt8();
        BleReadable bleReadable = (BleReadable) BleHmTime.class.newInstance();
        bleReadable.setMBytes(readBytes(2));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mRemindTime1 = (BleHmTime) bleReadable;
        BleReadable bleReadable2 = (BleReadable) BleHmTime.class.newInstance();
        bleReadable2.setMBytes(readBytes(2));
        bleReadable2.decode();
        IIX0o.ooOOo0oXI(bleReadable2);
        this.mRemindTime2 = (BleHmTime) bleReadable2;
        BleReadable bleReadable3 = (BleReadable) BleHmTime.class.newInstance();
        bleReadable3.setMBytes(readBytes(2));
        bleReadable3.decode();
        IIX0o.ooOOo0oXI(bleReadable3);
        this.mRemindTime3 = (BleHmTime) bleReadable3;
        BleReadable bleReadable4 = (BleReadable) BleHmTime.class.newInstance();
        bleReadable4.setMBytes(readBytes(2));
        bleReadable4.decode();
        IIX0o.ooOOo0oXI(bleReadable4);
        this.mRemindTime4 = (BleHmTime) bleReadable4;
        BleReadable bleReadable5 = (BleReadable) BleHmTime.class.newInstance();
        bleReadable5.setMBytes(readBytes(2));
        bleReadable5.decode();
        IIX0o.ooOOo0oXI(bleReadable5);
        this.mRemindTime5 = (BleHmTime) bleReadable5;
        BleReadable bleReadable6 = (BleReadable) BleHmTime.class.newInstance();
        bleReadable6.setMBytes(readBytes(2));
        bleReadable6.decode();
        IIX0o.ooOOo0oXI(bleReadable6);
        this.mRemindTime6 = (BleHmTime) bleReadable6;
        this.mStartYear = readUInt8() + 2000;
        this.mStartMonth = readUInt8();
        this.mStartDay = readUInt8();
        this.mEndYear = readUInt8() + 2000;
        this.mEndMonth = readUInt8();
        this.mEndDay = readUInt8();
        this.mName = BleReadable.readString$default(this, 24, null, 2, null);
        this.mLabel = BleReadable.readString$default(this, 21, null, 2, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(getMId());
        writeInt8(this.mType);
        writeInt8(this.mUnit);
        int i = this.mDosage;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt32(i, LITTLE_ENDIAN);
        writeInt8(this.mRepeat);
        writeInt8(this.mRemindTimes);
        writeObject(this.mRemindTime1);
        writeObject(this.mRemindTime2);
        writeObject(this.mRemindTime3);
        writeObject(this.mRemindTime4);
        writeObject(this.mRemindTime5);
        writeObject(this.mRemindTime6);
        writeInt8(this.mStartYear - 2000);
        writeInt8(this.mStartMonth);
        writeInt8(this.mStartDay);
        writeInt8(this.mEndYear - 2000);
        writeInt8(this.mEndMonth);
        writeInt8(this.mEndDay);
        BleWritable.writeStringWithFix$default(this, this.mName, 24, null, 4, null);
        BleWritable.writeStringWithFix$default(this, this.mLabel, 21, null, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMedicationReminder)) {
            return false;
        }
        BleMedicationReminder bleMedicationReminder = (BleMedicationReminder) obj;
        return this.mType == bleMedicationReminder.mType && this.mUnit == bleMedicationReminder.mUnit && this.mDosage == bleMedicationReminder.mDosage && this.mRepeat == bleMedicationReminder.mRepeat && this.mRemindTimes == bleMedicationReminder.mRemindTimes && IIX0o.Oxx0IOOO(this.mRemindTime1, bleMedicationReminder.mRemindTime1) && IIX0o.Oxx0IOOO(this.mRemindTime2, bleMedicationReminder.mRemindTime2) && IIX0o.Oxx0IOOO(this.mRemindTime3, bleMedicationReminder.mRemindTime3) && IIX0o.Oxx0IOOO(this.mRemindTime4, bleMedicationReminder.mRemindTime4) && IIX0o.Oxx0IOOO(this.mRemindTime5, bleMedicationReminder.mRemindTime5) && IIX0o.Oxx0IOOO(this.mRemindTime6, bleMedicationReminder.mRemindTime6) && this.mStartYear == bleMedicationReminder.mStartYear && this.mStartMonth == bleMedicationReminder.mStartMonth && this.mStartDay == bleMedicationReminder.mStartDay && this.mEndYear == bleMedicationReminder.mEndYear && this.mEndMonth == bleMedicationReminder.mEndMonth && this.mEndDay == bleMedicationReminder.mEndDay && IIX0o.Oxx0IOOO(this.mName, bleMedicationReminder.mName) && IIX0o.Oxx0IOOO(this.mLabel, bleMedicationReminder.mLabel);
    }

    public final int getMDosage() {
        return this.mDosage;
    }

    public final int getMEndDay() {
        return this.mEndDay;
    }

    public final int getMEndMonth() {
        return this.mEndMonth;
    }

    public final int getMEndYear() {
        return this.mEndYear;
    }

    @OOXIXo
    public final String getMLabel() {
        return this.mLabel;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 72;
    }

    @OOXIXo
    public final String getMName() {
        return this.mName;
    }

    @OOXIXo
    public final BleHmTime getMRemindTime1() {
        return this.mRemindTime1;
    }

    @OOXIXo
    public final BleHmTime getMRemindTime2() {
        return this.mRemindTime2;
    }

    @OOXIXo
    public final BleHmTime getMRemindTime3() {
        return this.mRemindTime3;
    }

    @OOXIXo
    public final BleHmTime getMRemindTime4() {
        return this.mRemindTime4;
    }

    @OOXIXo
    public final BleHmTime getMRemindTime5() {
        return this.mRemindTime5;
    }

    @OOXIXo
    public final BleHmTime getMRemindTime6() {
        return this.mRemindTime6;
    }

    public final int getMRemindTimes() {
        return this.mRemindTimes;
    }

    public final int getMRepeat() {
        return this.mRepeat;
    }

    public final int getMStartDay() {
        return this.mStartDay;
    }

    public final int getMStartMonth() {
        return this.mStartMonth;
    }

    public final int getMStartYear() {
        return this.mStartYear;
    }

    public final int getMType() {
        return this.mType;
    }

    public final int getMUnit() {
        return this.mUnit;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((this.mType * 31) + this.mUnit) * 31) + this.mDosage) * 31) + this.mRepeat) * 31) + this.mRemindTimes) * 31) + this.mRemindTime1.hashCode()) * 31) + this.mRemindTime2.hashCode()) * 31) + this.mRemindTime3.hashCode()) * 31) + this.mRemindTime4.hashCode()) * 31) + this.mRemindTime5.hashCode()) * 31) + this.mRemindTime6.hashCode()) * 31) + this.mStartYear) * 31) + this.mStartMonth) * 31) + this.mStartDay) * 31) + this.mEndYear) * 31) + this.mEndMonth) * 31) + this.mEndDay) * 31) + this.mName.hashCode()) * 31) + this.mLabel.hashCode();
    }

    public final void setMDosage(int i) {
        this.mDosage = i;
    }

    public final void setMEndDay(int i) {
        this.mEndDay = i;
    }

    public final void setMEndMonth(int i) {
        this.mEndMonth = i;
    }

    public final void setMEndYear(int i) {
        this.mEndYear = i;
    }

    public final void setMLabel(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLabel = str;
    }

    public final void setMName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mName = str;
    }

    public final void setMRemindTime1(@OOXIXo BleHmTime bleHmTime) {
        IIX0o.x0xO0oo(bleHmTime, "<set-?>");
        this.mRemindTime1 = bleHmTime;
    }

    public final void setMRemindTime2(@OOXIXo BleHmTime bleHmTime) {
        IIX0o.x0xO0oo(bleHmTime, "<set-?>");
        this.mRemindTime2 = bleHmTime;
    }

    public final void setMRemindTime3(@OOXIXo BleHmTime bleHmTime) {
        IIX0o.x0xO0oo(bleHmTime, "<set-?>");
        this.mRemindTime3 = bleHmTime;
    }

    public final void setMRemindTime4(@OOXIXo BleHmTime bleHmTime) {
        IIX0o.x0xO0oo(bleHmTime, "<set-?>");
        this.mRemindTime4 = bleHmTime;
    }

    public final void setMRemindTime5(@OOXIXo BleHmTime bleHmTime) {
        IIX0o.x0xO0oo(bleHmTime, "<set-?>");
        this.mRemindTime5 = bleHmTime;
    }

    public final void setMRemindTime6(@OOXIXo BleHmTime bleHmTime) {
        IIX0o.x0xO0oo(bleHmTime, "<set-?>");
        this.mRemindTime6 = bleHmTime;
    }

    public final void setMRemindTimes(int i) {
        this.mRemindTimes = i;
    }

    public final void setMRepeat(int i) {
        this.mRepeat = i;
    }

    public final void setMStartDay(int i) {
        this.mStartDay = i;
    }

    public final void setMStartMonth(int i) {
        this.mStartMonth = i;
    }

    public final void setMStartYear(int i) {
        this.mStartYear = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setMUnit(int i) {
        this.mUnit = i;
    }

    @OOXIXo
    public String toString() {
        return "BleMedicationReminder(mId=" + getMId() + ", mType=" + this.mType + ", mUnit=" + this.mUnit + ", mDosage=" + this.mDosage + ", mRepeat=" + this.mRepeat + ", mRemindTimes=" + this.mRemindTimes + ", mRemindTime1=" + this.mRemindTime1 + ", mRemindTime2=" + this.mRemindTime2 + ", mRemindTime3=" + this.mRemindTime3 + ", mRemindTime4=" + this.mRemindTime4 + ", mRemindTime5=" + this.mRemindTime5 + ", mRemindTime6=" + this.mRemindTime6 + ", mStartYear=" + this.mStartYear + ", mStartMonth=" + this.mStartMonth + ", mStartDay=" + this.mStartDay + ", mEndYear=" + this.mEndYear + ", mEndMonth=" + this.mEndMonth + ", mEndDay=" + this.mEndDay + ", mName='" + this.mName + "', mLabel='" + this.mLabel + "')";
    }

    public /* synthetic */ BleMedicationReminder(int i, int i2, int i3, int i4, int i5, BleHmTime bleHmTime, BleHmTime bleHmTime2, BleHmTime bleHmTime3, BleHmTime bleHmTime4, BleHmTime bleHmTime5, BleHmTime bleHmTime6, int i6, int i7, int i8, int i9, int i10, int i11, String str, String str2, int i12, IIXOooo iIXOooo) {
        this((i12 & 1) != 0 ? 0 : i, (i12 & 2) != 0 ? 0 : i2, (i12 & 4) != 0 ? 0 : i3, (i12 & 8) != 0 ? 0 : i4, (i12 & 16) != 0 ? 0 : i5, (i12 & 32) != 0 ? new BleHmTime(0, 0, 3, null) : bleHmTime, (i12 & 64) != 0 ? new BleHmTime(0, 0, 3, null) : bleHmTime2, (i12 & 128) != 0 ? new BleHmTime(0, 0, 3, null) : bleHmTime3, (i12 & 256) != 0 ? new BleHmTime(0, 0, 3, null) : bleHmTime4, (i12 & 512) != 0 ? new BleHmTime(0, 0, 3, null) : bleHmTime5, (i12 & 1024) != 0 ? new BleHmTime(0, 0, 3, null) : bleHmTime6, (i12 & 2048) != 0 ? 0 : i6, (i12 & 4096) != 0 ? 0 : i7, (i12 & 8192) != 0 ? 0 : i8, (i12 & 16384) != 0 ? 0 : i9, (i12 & 32768) != 0 ? 0 : i10, (i12 & 65536) != 0 ? 0 : i11, (i12 & 131072) != 0 ? "" : str, (i12 & 262144) == 0 ? str2 : "");
    }

    public BleMedicationReminder(int i, int i2, int i3, int i4, int i5, @OOXIXo BleHmTime mRemindTime1, @OOXIXo BleHmTime mRemindTime2, @OOXIXo BleHmTime mRemindTime3, @OOXIXo BleHmTime mRemindTime4, @OOXIXo BleHmTime mRemindTime5, @OOXIXo BleHmTime mRemindTime6, int i6, int i7, int i8, int i9, int i10, int i11, @OOXIXo String mName, @OOXIXo String mLabel) {
        IIX0o.x0xO0oo(mRemindTime1, "mRemindTime1");
        IIX0o.x0xO0oo(mRemindTime2, "mRemindTime2");
        IIX0o.x0xO0oo(mRemindTime3, "mRemindTime3");
        IIX0o.x0xO0oo(mRemindTime4, "mRemindTime4");
        IIX0o.x0xO0oo(mRemindTime5, "mRemindTime5");
        IIX0o.x0xO0oo(mRemindTime6, "mRemindTime6");
        IIX0o.x0xO0oo(mName, "mName");
        IIX0o.x0xO0oo(mLabel, "mLabel");
        this.mType = i;
        this.mUnit = i2;
        this.mDosage = i3;
        this.mRepeat = i4;
        this.mRemindTimes = i5;
        this.mRemindTime1 = mRemindTime1;
        this.mRemindTime2 = mRemindTime2;
        this.mRemindTime3 = mRemindTime3;
        this.mRemindTime4 = mRemindTime4;
        this.mRemindTime5 = mRemindTime5;
        this.mRemindTime6 = mRemindTime6;
        this.mStartYear = i6;
        this.mStartMonth = i7;
        this.mStartDay = i8;
        this.mEndYear = i9;
        this.mEndMonth = i10;
        this.mEndDay = i11;
        this.mName = mName;
        this.mLabel = mLabel;
    }
}
