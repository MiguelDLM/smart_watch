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
import com.szabh.smable3.entity.BleHrv;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity(indices = {@Index(unique = true, value = {"mTime"})})
/* loaded from: classes12.dex */
public final class Hrv {

    @ColumnInfo
    private int mAvgValue;

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

    public Hrv() {
        this(0, 0L, null, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ Hrv copy$default(Hrv hrv, int i, long j, String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = hrv.mId;
        }
        if ((i5 & 2) != 0) {
            j = hrv.mTime;
        }
        long j2 = j;
        if ((i5 & 4) != 0) {
            str = hrv.mLocalTime;
        }
        String str2 = str;
        if ((i5 & 8) != 0) {
            i2 = hrv.mValue;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = hrv.mAvgValue;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = hrv.mIsSync;
        }
        return hrv.copy(i, j2, str2, i6, i7, i4);
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
        return this.mAvgValue;
    }

    public final int component6() {
        return this.mIsSync;
    }

    @OOXIXo
    public final Hrv copy(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        return new Hrv(i, j, mLocalTime, i2, i3, i4);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Hrv)) {
            return false;
        }
        Hrv hrv = (Hrv) obj;
        return this.mId == hrv.mId && this.mTime == hrv.mTime && IIX0o.Oxx0IOOO(this.mLocalTime, hrv.mLocalTime) && this.mValue == hrv.mValue && this.mAvgValue == hrv.mAvgValue && this.mIsSync == hrv.mIsSync;
    }

    public final int getMAvgValue() {
        return this.mAvgValue;
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
        return (((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mValue) * 31) + this.mAvgValue) * 31) + this.mIsSync;
    }

    public final void setMAvgValue(int i) {
        this.mAvgValue = i;
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
        return "Hrv(mId=" + this.mId + ", mTime=" + this.mTime + ", mLocalTime=" + this.mLocalTime + ", mValue=" + this.mValue + ", mAvgValue=" + this.mAvgValue + ", mIsSync=" + this.mIsSync + HexStringBuilder.COMMENT_END_CHAR;
    }

    public Hrv(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        this.mId = i;
        this.mTime = j;
        this.mLocalTime = mLocalTime;
        this.mValue = i2;
        this.mAvgValue = i3;
        this.mIsSync = i4;
    }

    public /* synthetic */ Hrv(int i, long j, String str, int i2, int i3, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0L : j, (i5 & 4) != 0 ? "" : str, (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? 0 : i4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Hrv(@OOXIXo BleHrv bleHrv, long j) {
        this(0, ((bleHrv.getMTime() + BleConstsKt.DATA_EPOCH) * 1000) - j, null, bleHrv.getMValue(), bleHrv.getMAvgValue(), 0, 37, null);
        IIX0o.x0xO0oo(bleHrv, "bleHrv");
    }
}
