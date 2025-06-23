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
import com.szabh.smable3.entity.BleHeartRate;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity(indices = {@Index(unique = true, value = {"mTime"})})
/* loaded from: classes12.dex */
public final class HeartRate {

    @ColumnInfo
    private int mBpm;

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

    public HeartRate() {
        this(0, 0L, null, 0, 0, 31, null);
    }

    public static /* synthetic */ HeartRate copy$default(HeartRate heartRate, int i, long j, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = heartRate.mId;
        }
        if ((i4 & 2) != 0) {
            j = heartRate.mTime;
        }
        long j2 = j;
        if ((i4 & 4) != 0) {
            str = heartRate.mLocalTime;
        }
        String str2 = str;
        if ((i4 & 8) != 0) {
            i2 = heartRate.mBpm;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            i3 = heartRate.mIsSync;
        }
        return heartRate.copy(i, j2, str2, i5, i3);
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
        return this.mBpm;
    }

    public final int component5() {
        return this.mIsSync;
    }

    @OOXIXo
    public final HeartRate copy(int i, long j, @OOXIXo String mLocalTime, int i2, int i3) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        return new HeartRate(i, j, mLocalTime, i2, i3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeartRate)) {
            return false;
        }
        HeartRate heartRate = (HeartRate) obj;
        return this.mId == heartRate.mId && this.mTime == heartRate.mTime && IIX0o.Oxx0IOOO(this.mLocalTime, heartRate.mLocalTime) && this.mBpm == heartRate.mBpm && this.mIsSync == heartRate.mIsSync;
    }

    public final int getMBpm() {
        return this.mBpm;
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

    public int hashCode() {
        return (((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mBpm) * 31) + this.mIsSync;
    }

    public final void setMBpm(int i) {
        this.mBpm = i;
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

    @OOXIXo
    public String toString() {
        return "HeartRate(mId=" + this.mId + ", mTime=" + this.mTime + ", mLocalTime=" + this.mLocalTime + ", mBpm=" + this.mBpm + ", mIsSync=" + this.mIsSync + HexStringBuilder.COMMENT_END_CHAR;
    }

    public HeartRate(int i, long j, @OOXIXo String mLocalTime, int i2, int i3) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        this.mId = i;
        this.mTime = j;
        this.mLocalTime = mLocalTime;
        this.mBpm = i2;
        this.mIsSync = i3;
    }

    public /* synthetic */ HeartRate(int i, long j, String str, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0L : j, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeartRate(@OOXIXo BleHeartRate bleHeartRate, long j) {
        this(0, ((bleHeartRate.getMTime() + BleConstsKt.DATA_EPOCH) * 1000) - j, null, bleHeartRate.getMBpm(), 0, 21, null);
        IIX0o.x0xO0oo(bleHeartRate, "bleHeartRate");
    }
}
