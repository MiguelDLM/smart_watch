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
import com.szabh.smable3.entity.BleSleep;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity(indices = {@Index(unique = true, value = {"mTime"})})
/* loaded from: classes12.dex */
public final class Sleep {

    @ColumnInfo
    private int mAlgorithmType;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private int mIsSync;

    @OOXIXo
    @ColumnInfo
    private String mLocalTime;

    @ColumnInfo
    private int mMode;

    @ColumnInfo
    private int mSoft;

    @ColumnInfo
    private int mStrong;

    @ColumnInfo
    private long mTime;

    public Sleep() {
        this(0, 0L, null, 0, 0, 0, 0, 0, 255, null);
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
        return this.mMode;
    }

    public final int component5() {
        return this.mSoft;
    }

    public final int component6() {
        return this.mStrong;
    }

    public final int component7() {
        return this.mIsSync;
    }

    public final int component8() {
        return this.mAlgorithmType;
    }

    @OOXIXo
    public final Sleep copy(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4, int i5, int i6) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        return new Sleep(i, j, mLocalTime, i2, i3, i4, i5, i6);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sleep)) {
            return false;
        }
        Sleep sleep = (Sleep) obj;
        return this.mId == sleep.mId && this.mTime == sleep.mTime && IIX0o.Oxx0IOOO(this.mLocalTime, sleep.mLocalTime) && this.mMode == sleep.mMode && this.mSoft == sleep.mSoft && this.mStrong == sleep.mStrong && this.mIsSync == sleep.mIsSync && this.mAlgorithmType == sleep.mAlgorithmType;
    }

    public final int getMAlgorithmType() {
        return this.mAlgorithmType;
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

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMSoft() {
        return this.mSoft;
    }

    public final int getMStrong() {
        return this.mStrong;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mMode) * 31) + this.mSoft) * 31) + this.mStrong) * 31) + this.mIsSync) * 31) + this.mAlgorithmType;
    }

    public final void setMAlgorithmType(int i) {
        this.mAlgorithmType = i;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMLocalTime(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLocalTime = str;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMSoft(int i) {
        this.mSoft = i;
    }

    public final void setMStrong(int i) {
        this.mStrong = i;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    @OOXIXo
    public String toString() {
        return "Sleep(mId=" + this.mId + ", mTime=" + this.mTime + ", mLocalTime=" + this.mLocalTime + ", mMode=" + this.mMode + ", mSoft=" + this.mSoft + ", mStrong=" + this.mStrong + ", mIsSync=" + this.mIsSync + ", mAlgorithmType=" + this.mAlgorithmType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public Sleep(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4, int i5, int i6) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        this.mId = i;
        this.mTime = j;
        this.mLocalTime = mLocalTime;
        this.mMode = i2;
        this.mSoft = i3;
        this.mStrong = i4;
        this.mIsSync = i5;
        this.mAlgorithmType = i6;
    }

    public /* synthetic */ Sleep(int i, long j, String str, int i2, int i3, int i4, int i5, int i6, int i7, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? 0L : j, (i7 & 4) != 0 ? "" : str, (i7 & 8) != 0 ? 0 : i2, (i7 & 16) != 0 ? 0 : i3, (i7 & 32) != 0 ? 0 : i4, (i7 & 64) != 0 ? 0 : i5, (i7 & 128) == 0 ? i6 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Sleep(@OOXIXo BleSleep bleSleep, long j) {
        this(0, ((bleSleep.getMTime() + BleConstsKt.DATA_EPOCH) * 1000) - j, null, bleSleep.getMMode(), bleSleep.getMSoft(), bleSleep.getMStrong(), 0, 0, 197, null);
        IIX0o.x0xO0oo(bleSleep, "bleSleep");
    }
}
