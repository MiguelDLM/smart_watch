package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.garmin.fit.xxXXXxIxo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleMatchPeriod;
import com.szabh.smable3.entity.BleMatchPeriod2;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity
/* loaded from: classes12.dex */
public final class MatchPeriod implements Serializable {

    @ColumnInfo
    private int mAvgBpm;

    @ColumnInfo
    private int mCalorie;

    @ColumnInfo
    private int mDistance;

    @ColumnInfo
    private int mDuration;

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
    private int mMaxBpm;

    @ColumnInfo
    private int mMaxSpeed;

    @ColumnInfo
    private int mSpeed;

    @ColumnInfo
    private int mStep;

    public MatchPeriod() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, xxXXXxIxo.f15726I0Io, null);
    }

    public final int component1() {
        return this.mId;
    }

    public final int component10() {
        return this.mMaxSpeed;
    }

    public final int component11() {
        return this.mIsSync;
    }

    public final int component12() {
        return this.mIsDelete;
    }

    public final int component2() {
        return this.mMatchRecordId;
    }

    public final int component3() {
        return this.mDuration;
    }

    public final int component4() {
        return this.mDistance;
    }

    public final int component5() {
        return this.mStep;
    }

    public final int component6() {
        return this.mCalorie;
    }

    public final int component7() {
        return this.mSpeed;
    }

    public final int component8() {
        return this.mAvgBpm;
    }

    public final int component9() {
        return this.mMaxBpm;
    }

    @OOXIXo
    public final MatchPeriod copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        return new MatchPeriod(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchPeriod)) {
            return false;
        }
        MatchPeriod matchPeriod = (MatchPeriod) obj;
        return this.mId == matchPeriod.mId && this.mMatchRecordId == matchPeriod.mMatchRecordId && this.mDuration == matchPeriod.mDuration && this.mDistance == matchPeriod.mDistance && this.mStep == matchPeriod.mStep && this.mCalorie == matchPeriod.mCalorie && this.mSpeed == matchPeriod.mSpeed && this.mAvgBpm == matchPeriod.mAvgBpm && this.mMaxBpm == matchPeriod.mMaxBpm && this.mMaxSpeed == matchPeriod.mMaxSpeed && this.mIsSync == matchPeriod.mIsSync && this.mIsDelete == matchPeriod.mIsDelete;
    }

    public final int getMAvgBpm() {
        return this.mAvgBpm;
    }

    public final int getMCalorie() {
        return this.mCalorie;
    }

    public final int getMDistance() {
        return this.mDistance;
    }

    public final int getMDuration() {
        return this.mDuration;
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

    public final int getMMaxBpm() {
        return this.mMaxBpm;
    }

    public final int getMMaxSpeed() {
        return this.mMaxSpeed;
    }

    public final int getMSpeed() {
        return this.mSpeed;
    }

    public final int getMStep() {
        return this.mStep;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.mId * 31) + this.mMatchRecordId) * 31) + this.mDuration) * 31) + this.mDistance) * 31) + this.mStep) * 31) + this.mCalorie) * 31) + this.mSpeed) * 31) + this.mAvgBpm) * 31) + this.mMaxBpm) * 31) + this.mMaxSpeed) * 31) + this.mIsSync) * 31) + this.mIsDelete;
    }

    public final void setMAvgBpm(int i) {
        this.mAvgBpm = i;
    }

    public final void setMCalorie(int i) {
        this.mCalorie = i;
    }

    public final void setMDistance(int i) {
        this.mDistance = i;
    }

    public final void setMDuration(int i) {
        this.mDuration = i;
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

    public final void setMMaxBpm(int i) {
        this.mMaxBpm = i;
    }

    public final void setMMaxSpeed(int i) {
        this.mMaxSpeed = i;
    }

    public final void setMSpeed(int i) {
        this.mSpeed = i;
    }

    public final void setMStep(int i) {
        this.mStep = i;
    }

    @OOXIXo
    public String toString() {
        return "MatchPeriod(mId=" + this.mId + ", mMatchRecordId=" + this.mMatchRecordId + ", mDuration=" + this.mDuration + ", mDistance=" + this.mDistance + ", mStep=" + this.mStep + ", mCalorie=" + this.mCalorie + ", mSpeed=" + this.mSpeed + ", mAvgBpm=" + this.mAvgBpm + ", mMaxBpm=" + this.mMaxBpm + ", mMaxSpeed=" + this.mMaxSpeed + ", mIsSync=" + this.mIsSync + ", mIsDelete=" + this.mIsDelete + HexStringBuilder.COMMENT_END_CHAR;
    }

    public MatchPeriod(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.mId = i;
        this.mMatchRecordId = i2;
        this.mDuration = i3;
        this.mDistance = i4;
        this.mStep = i5;
        this.mCalorie = i6;
        this.mSpeed = i7;
        this.mAvgBpm = i8;
        this.mMaxBpm = i9;
        this.mMaxSpeed = i10;
        this.mIsSync = i11;
        this.mIsDelete = i12;
    }

    public /* synthetic */ MatchPeriod(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, IIXOooo iIXOooo) {
        this((i13 & 1) != 0 ? 0 : i, (i13 & 2) != 0 ? 0 : i2, (i13 & 4) != 0 ? 0 : i3, (i13 & 8) != 0 ? 0 : i4, (i13 & 16) != 0 ? 0 : i5, (i13 & 32) != 0 ? 0 : i6, (i13 & 64) != 0 ? 0 : i7, (i13 & 128) != 0 ? 0 : i8, (i13 & 256) != 0 ? 0 : i9, (i13 & 512) != 0 ? 0 : i10, (i13 & 1024) != 0 ? 0 : i11, (i13 & 2048) == 0 ? i12 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MatchPeriod(@OOXIXo BleMatchPeriod bleMatchPeriod, long j) {
        this(0, 0, bleMatchPeriod.getMDuration(), bleMatchPeriod.getMDistance(), bleMatchPeriod.getMStep(), bleMatchPeriod.getMCalorie(), bleMatchPeriod.getMSpeed(), bleMatchPeriod.getMAvgBpm(), bleMatchPeriod.getMMaxBpm(), 0, 0, 0, 3587, null);
        IIX0o.x0xO0oo(bleMatchPeriod, "bleMatchPeriod");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MatchPeriod(@OOXIXo BleMatchPeriod2 bleMatchPeriod, long j) {
        this(0, 0, bleMatchPeriod.getMDuration(), bleMatchPeriod.getMDistance(), bleMatchPeriod.getMStep(), bleMatchPeriod.getMCalorie(), bleMatchPeriod.getMSpeed(), bleMatchPeriod.getMAvgBpm(), bleMatchPeriod.getMMaxBpm(), bleMatchPeriod.getMMaxSpeed(), 0, 0, 3075, null);
        IIX0o.x0xO0oo(bleMatchPeriod, "bleMatchPeriod");
    }
}
