package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.component.BleConstsKt;
import com.szabh.smable3.entity.BleBloodGlucose;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity(indices = {@Index(unique = true, value = {"mTime"})})
/* loaded from: classes12.dex */
public final class BloodGlucose {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private int mIsSync;

    @OOXIXo
    @ColumnInfo
    private String mLocalTime;

    @ColumnInfo
    private long mTime;

    @ColumnInfo
    private int mValue;

    public BloodGlucose() {
        this(0, 0L, null, 0, 0, 31, null);
    }

    public static /* synthetic */ BloodGlucose copy$default(BloodGlucose bloodGlucose, int i, long j, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bloodGlucose.mId;
        }
        if ((i4 & 2) != 0) {
            j = bloodGlucose.mTime;
        }
        long j2 = j;
        if ((i4 & 4) != 0) {
            str = bloodGlucose.mLocalTime;
        }
        String str2 = str;
        if ((i4 & 8) != 0) {
            i2 = bloodGlucose.mValue;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            i3 = bloodGlucose.mIsSync;
        }
        return bloodGlucose.copy(i, j2, str2, i5, i3);
    }

    public final int component1() {
        return this.mId;
    }

    public final long component2() {
        return this.mTime;
    }

    @OOXIXo
    public final String component3() {
        return this.mLocalTime;
    }

    public final int component4() {
        return this.mValue;
    }

    public final int component5() {
        return this.mIsSync;
    }

    @OOXIXo
    public final BloodGlucose copy(int i, long j, @OOXIXo String mLocalTime, int i2, int i3) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        return new BloodGlucose(i, j, mLocalTime, i2, i3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BloodGlucose)) {
            return false;
        }
        BloodGlucose bloodGlucose = (BloodGlucose) obj;
        return this.mId == bloodGlucose.mId && this.mTime == bloodGlucose.mTime && IIX0o.Oxx0IOOO(this.mLocalTime, bloodGlucose.mLocalTime) && this.mValue == bloodGlucose.mValue && this.mIsSync == bloodGlucose.mIsSync;
    }

    public final int getMId() {
        return this.mId;
    }

    public final int getMIsSync() {
        return this.mIsSync;
    }

    @OOXIXo
    public final String getMLocalTime() {
        return this.mLocalTime;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public final int getMValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mValue) * 31) + this.mIsSync;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMLocalTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLocalTime = str;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    public final void setMValue(int i) {
        this.mValue = i;
    }

    @OOXIXo
    public String toString() {
        return "BloodGlucose(mId=" + this.mId + ", mTime=" + this.mTime + ", mLocalTime=" + this.mLocalTime + ", mValue=" + this.mValue + ", mIsSync=" + this.mIsSync + HexStringBuilder.COMMENT_END_CHAR;
    }

    public BloodGlucose(int i, long j, @OOXIXo String mLocalTime, int i2, int i3) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        this.mId = i;
        this.mTime = j;
        this.mLocalTime = mLocalTime;
        this.mValue = i2;
        this.mIsSync = i3;
    }

    public /* synthetic */ BloodGlucose(int i, long j, String str, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0L : j, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BloodGlucose(@OOXIXo BleBloodGlucose bleBloodGlucose, long j) {
        this(0, ((bleBloodGlucose.getMTime() + BleConstsKt.DATA_EPOCH) * 1000) - j, null, bleBloodGlucose.getMValue(), 0, 21, null);
        IIX0o.x0xO0oo(bleBloodGlucose, "bleBloodGlucose");
    }
}
