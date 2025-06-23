package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.garmin.fit.OOxOOxIO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleMatchLog;
import com.szabh.smable3.entity.BleMatchLog2;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity
/* loaded from: classes12.dex */
public final class MatchLog implements Serializable {

    @ColumnInfo
    private int mCancelType;

    @ColumnInfo
    private int mCount;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int mId;

    @ColumnInfo
    private int mIsDelete;

    @ColumnInfo
    private int mIsSync;

    @ColumnInfo
    private int mMatchRecordId;

    @ColumnInfo
    private int mOtherType;

    @ColumnInfo
    private int mPeriodNumber;

    @ColumnInfo
    private int mPeriodTime;

    @ColumnInfo
    private int mPlayer;

    @ColumnInfo
    private int mStopWatchTotal;

    @ColumnInfo
    private int mTeam;

    @ColumnInfo
    private int mTime;

    @ColumnInfo
    private int mType;

    public MatchLog() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, OOxOOxIO.f12624oIX0oI, null);
    }

    public final int component1() {
        return this.mId;
    }

    public final int component10() {
        return this.mPlayer;
    }

    public final int component11() {
        return this.mOtherType;
    }

    public final int component12() {
        return this.mStopWatchTotal;
    }

    public final int component13() {
        return this.mIsSync;
    }

    public final int component14() {
        return this.mIsDelete;
    }

    public final int component2() {
        return this.mMatchRecordId;
    }

    public final int component3() {
        return this.mTime;
    }

    public final int component4() {
        return this.mPeriodTime;
    }

    public final int component5() {
        return this.mPeriodNumber;
    }

    public final int component6() {
        return this.mType;
    }

    public final int component7() {
        return this.mCount;
    }

    public final int component8() {
        return this.mCancelType;
    }

    public final int component9() {
        return this.mTeam;
    }

    @OOXIXo
    public final MatchLog copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        return new MatchLog(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchLog)) {
            return false;
        }
        MatchLog matchLog = (MatchLog) obj;
        return this.mId == matchLog.mId && this.mMatchRecordId == matchLog.mMatchRecordId && this.mTime == matchLog.mTime && this.mPeriodTime == matchLog.mPeriodTime && this.mPeriodNumber == matchLog.mPeriodNumber && this.mType == matchLog.mType && this.mCount == matchLog.mCount && this.mCancelType == matchLog.mCancelType && this.mTeam == matchLog.mTeam && this.mPlayer == matchLog.mPlayer && this.mOtherType == matchLog.mOtherType && this.mStopWatchTotal == matchLog.mStopWatchTotal && this.mIsSync == matchLog.mIsSync && this.mIsDelete == matchLog.mIsDelete;
    }

    public final int getMCancelType() {
        return this.mCancelType;
    }

    public final int getMCount() {
        return this.mCount;
    }

    public final int getMId() {
        return this.mId;
    }

    public final int getMIsDelete() {
        return this.mIsDelete;
    }

    public final int getMIsSync() {
        return this.mIsSync;
    }

    public final int getMMatchRecordId() {
        return this.mMatchRecordId;
    }

    public final int getMOtherType() {
        return this.mOtherType;
    }

    public final int getMPeriodNumber() {
        return this.mPeriodNumber;
    }

    public final int getMPeriodTime() {
        return this.mPeriodTime;
    }

    public final int getMPlayer() {
        return this.mPlayer;
    }

    public final int getMStopWatchTotal() {
        return this.mStopWatchTotal;
    }

    public final int getMTeam() {
        return this.mTeam;
    }

    public final int getMTime() {
        return this.mTime;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.mId * 31) + this.mMatchRecordId) * 31) + this.mTime) * 31) + this.mPeriodTime) * 31) + this.mPeriodNumber) * 31) + this.mType) * 31) + this.mCount) * 31) + this.mCancelType) * 31) + this.mTeam) * 31) + this.mPlayer) * 31) + this.mOtherType) * 31) + this.mStopWatchTotal) * 31) + this.mIsSync) * 31) + this.mIsDelete;
    }

    public final void setMCancelType(int i) {
        this.mCancelType = i;
    }

    public final void setMCount(int i) {
        this.mCount = i;
    }

    public final void setMId(int i) {
        this.mId = i;
    }

    public final void setMIsDelete(int i) {
        this.mIsDelete = i;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMMatchRecordId(int i) {
        this.mMatchRecordId = i;
    }

    public final void setMOtherType(int i) {
        this.mOtherType = i;
    }

    public final void setMPeriodNumber(int i) {
        this.mPeriodNumber = i;
    }

    public final void setMPeriodTime(int i) {
        this.mPeriodTime = i;
    }

    public final void setMPlayer(int i) {
        this.mPlayer = i;
    }

    public final void setMStopWatchTotal(int i) {
        this.mStopWatchTotal = i;
    }

    public final void setMTeam(int i) {
        this.mTeam = i;
    }

    public final void setMTime(int i) {
        this.mTime = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        return "MatchLog(mId=" + this.mId + ", mMatchRecordId=" + this.mMatchRecordId + ", mTime=" + this.mTime + ", mPeriodTime=" + this.mPeriodTime + ", mPeriodNumber=" + this.mPeriodNumber + ", mType=" + this.mType + ", mCount=" + this.mCount + ", mCancelType=" + this.mCancelType + ", mTeam=" + this.mTeam + ", mPlayer=" + this.mPlayer + ", mOtherType=" + this.mOtherType + ", mStopWatchTotal=" + this.mStopWatchTotal + ", mIsSync=" + this.mIsSync + ", mIsDelete=" + this.mIsDelete + HexStringBuilder.COMMENT_END_CHAR;
    }

    public MatchLog(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        this.mId = i;
        this.mMatchRecordId = i2;
        this.mTime = i3;
        this.mPeriodTime = i4;
        this.mPeriodNumber = i5;
        this.mType = i6;
        this.mCount = i7;
        this.mCancelType = i8;
        this.mTeam = i9;
        this.mPlayer = i10;
        this.mOtherType = i11;
        this.mStopWatchTotal = i12;
        this.mIsSync = i13;
        this.mIsDelete = i14;
    }

    public /* synthetic */ MatchLog(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, IIXOooo iIXOooo) {
        this((i15 & 1) != 0 ? 0 : i, (i15 & 2) != 0 ? 0 : i2, (i15 & 4) != 0 ? 0 : i3, (i15 & 8) != 0 ? 0 : i4, (i15 & 16) != 0 ? 0 : i5, (i15 & 32) != 0 ? 0 : i6, (i15 & 64) != 0 ? 0 : i7, (i15 & 128) != 0 ? 0 : i8, (i15 & 256) != 0 ? 0 : i9, (i15 & 512) != 0 ? 0 : i10, (i15 & 1024) != 0 ? 0 : i11, (i15 & 2048) != 0 ? 0 : i12, (i15 & 4096) != 0 ? 0 : i13, (i15 & 8192) == 0 ? i14 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MatchLog(@OOXIXo BleMatchLog bleMatchLog, long j) {
        this(0, 0, bleMatchLog.getMTime(), bleMatchLog.getMPeriodTime(), bleMatchLog.getMPeriodNumber(), bleMatchLog.getMType(), bleMatchLog.getMCount(), bleMatchLog.getMCancelType(), 0, 0, 0, 0, 0, 0, 16131, null);
        IIX0o.x0xO0oo(bleMatchLog, "bleMatchLog");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MatchLog(@OOXIXo BleMatchLog2 bleMatchLog, long j) {
        this(0, 0, bleMatchLog.getMTime(), bleMatchLog.getMPeriodTime(), bleMatchLog.getMPeriodNumber(), bleMatchLog.getMType(), bleMatchLog.getMCount(), bleMatchLog.getMCancelType(), bleMatchLog.getMTeam(), bleMatchLog.getMPlayer(), bleMatchLog.getMOtherType(), bleMatchLog.getMStopWatchTotal(), 0, 0, 12291, null);
        IIX0o.x0xO0oo(bleMatchLog, "bleMatchLog");
    }
}
