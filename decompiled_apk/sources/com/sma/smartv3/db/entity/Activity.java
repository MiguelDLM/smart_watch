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
import com.szabh.smable3.entity.BleActivity;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity(indices = {@Index(unique = true, value = {"mTime"})})
/* loaded from: classes12.dex */
public final class Activity {

    @ColumnInfo
    private int mCalorie;

    @ColumnInfo
    private int mDistance;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private int mIsDelete;

    @ColumnInfo
    private int mIsSync;

    @OOXIXo
    @ColumnInfo
    private String mLocalTime;

    @ColumnInfo
    private int mMode;

    @ColumnInfo
    private int mState;

    @ColumnInfo
    private int mStep;

    @ColumnInfo
    private long mTime;

    public Activity() {
        this(0, 0L, null, 0, 0, 0, 0, 0, 0, 0, 1023, null);
    }

    public final int component1() {
        return this.mId;
    }

    public final int component10() {
        return this.mIsDelete;
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
        return this.mState;
    }

    public final int component6() {
        return this.mStep;
    }

    public final int component7() {
        return this.mCalorie;
    }

    public final int component8() {
        return this.mDistance;
    }

    public final int component9() {
        return this.mIsSync;
    }

    @OOXIXo
    public final Activity copy(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        return new Activity(i, j, mLocalTime, i2, i3, i4, i5, i6, i7, i8);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) obj;
        return this.mId == activity.mId && this.mTime == activity.mTime && IIX0o.Oxx0IOOO(this.mLocalTime, activity.mLocalTime) && this.mMode == activity.mMode && this.mState == activity.mState && this.mStep == activity.mStep && this.mCalorie == activity.mCalorie && this.mDistance == activity.mDistance && this.mIsSync == activity.mIsSync && this.mIsDelete == activity.mIsDelete;
    }

    public final int getMCalorie() {
        return this.mCalorie;
    }

    public final int getMDistance() {
        return this.mDistance;
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

    @OOXIXo
    public final String getMLocalTime() {
        return this.mLocalTime;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMState() {
        return this.mState;
    }

    public final int getMStep() {
        return this.mStep;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((((((((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mMode) * 31) + this.mState) * 31) + this.mStep) * 31) + this.mCalorie) * 31) + this.mDistance) * 31) + this.mIsSync) * 31) + this.mIsDelete;
    }

    public final void setMCalorie(int i) {
        this.mCalorie = i;
    }

    public final void setMDistance(int i) {
        this.mDistance = i;
    }

    public final void setMIsDelete(int i) {
        this.mIsDelete = i;
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

    public final void setMState(int i) {
        this.mState = i;
    }

    public final void setMStep(int i) {
        this.mStep = i;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    @OOXIXo
    public String toString() {
        return "Activity(mId=" + this.mId + ", mTime=" + this.mTime + ", mLocalTime=" + this.mLocalTime + ", mMode=" + this.mMode + ", mState=" + this.mState + ", mStep=" + this.mStep + ", mCalorie=" + this.mCalorie + ", mDistance=" + this.mDistance + ", mIsSync=" + this.mIsSync + ", mIsDelete=" + this.mIsDelete + HexStringBuilder.COMMENT_END_CHAR;
    }

    public Activity(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        this.mId = i;
        this.mTime = j;
        this.mLocalTime = mLocalTime;
        this.mMode = i2;
        this.mState = i3;
        this.mStep = i4;
        this.mCalorie = i5;
        this.mDistance = i6;
        this.mIsSync = i7;
        this.mIsDelete = i8;
    }

    public /* synthetic */ Activity(int i, long j, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, IIXOooo iIXOooo) {
        this((i9 & 1) != 0 ? 0 : i, (i9 & 2) != 0 ? 0L : j, (i9 & 4) != 0 ? "" : str, (i9 & 8) != 0 ? 0 : i2, (i9 & 16) != 0 ? 0 : i3, (i9 & 32) != 0 ? 0 : i4, (i9 & 64) != 0 ? 0 : i5, (i9 & 128) != 0 ? 0 : i6, (i9 & 256) != 0 ? 0 : i7, (i9 & 512) == 0 ? i8 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Activity(@OOXIXo BleActivity bleActivity, long j) {
        this(0, (((bleActivity.getMTime() + BleConstsKt.DATA_EPOCH) * 1000) - j) + bleActivity.getMState() + 1, null, bleActivity.getMMode(), bleActivity.getMState(), bleActivity.getMStep(), bleActivity.getMCalorie(), bleActivity.getMDistance(), 0, 0, 773, null);
        IIX0o.x0xO0oo(bleActivity, "bleActivity");
    }
}
