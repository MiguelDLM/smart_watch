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
import com.szabh.smable3.entity.BleBloodPressure;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity(indices = {@Index(unique = true, value = {"mTime"})})
/* loaded from: classes12.dex */
public final class BloodPressure {

    @ColumnInfo
    private int mDiastolic;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private int mIsSync;

    @OOXIXo
    @ColumnInfo
    private String mLocalTime;

    @ColumnInfo
    private int mSystolic;

    @ColumnInfo
    private long mTime;

    public BloodPressure() {
        this(0, 0L, null, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ BloodPressure copy$default(BloodPressure bloodPressure, int i, long j, String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = bloodPressure.mId;
        }
        if ((i5 & 2) != 0) {
            j = bloodPressure.mTime;
        }
        long j2 = j;
        if ((i5 & 4) != 0) {
            str = bloodPressure.mLocalTime;
        }
        String str2 = str;
        if ((i5 & 8) != 0) {
            i2 = bloodPressure.mSystolic;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = bloodPressure.mDiastolic;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = bloodPressure.mIsSync;
        }
        return bloodPressure.copy(i, j2, str2, i6, i7, i4);
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
        return this.mSystolic;
    }

    public final int component5() {
        return this.mDiastolic;
    }

    public final int component6() {
        return this.mIsSync;
    }

    @OOXIXo
    public final BloodPressure copy(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        return new BloodPressure(i, j, mLocalTime, i2, i3, i4);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BloodPressure)) {
            return false;
        }
        BloodPressure bloodPressure = (BloodPressure) obj;
        return this.mId == bloodPressure.mId && this.mTime == bloodPressure.mTime && IIX0o.Oxx0IOOO(this.mLocalTime, bloodPressure.mLocalTime) && this.mSystolic == bloodPressure.mSystolic && this.mDiastolic == bloodPressure.mDiastolic && this.mIsSync == bloodPressure.mIsSync;
    }

    public final int getMDiastolic() {
        return this.mDiastolic;
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

    public final int getMSystolic() {
        return this.mSystolic;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mSystolic) * 31) + this.mDiastolic) * 31) + this.mIsSync;
    }

    public final void setMDiastolic(int i) {
        this.mDiastolic = i;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMLocalTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLocalTime = str;
    }

    public final void setMSystolic(int i) {
        this.mSystolic = i;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    @OOXIXo
    public String toString() {
        return "BloodPressure(mId=" + this.mId + ", mTime=" + this.mTime + ", mLocalTime=" + this.mLocalTime + ", mSystolic=" + this.mSystolic + ", mDiastolic=" + this.mDiastolic + ", mIsSync=" + this.mIsSync + HexStringBuilder.COMMENT_END_CHAR;
    }

    public BloodPressure(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        this.mId = i;
        this.mTime = j;
        this.mLocalTime = mLocalTime;
        this.mSystolic = i2;
        this.mDiastolic = i3;
        this.mIsSync = i4;
    }

    public /* synthetic */ BloodPressure(int i, long j, String str, int i2, int i3, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0L : j, (i5 & 4) != 0 ? "" : str, (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? 0 : i4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BloodPressure(@OOXIXo BleBloodPressure bleBloodPressure, long j) {
        this(0, ((bleBloodPressure.getMTime() + BleConstsKt.DATA_EPOCH) * 1000) - j, null, bleBloodPressure.getMSystolic(), bleBloodPressure.getMDiastolic(), 0, 37, null);
        IIX0o.x0xO0oo(bleBloodPressure, "bleBloodPressure");
    }
}
