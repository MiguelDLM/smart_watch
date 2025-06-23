package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

@Entity(indices = {@Index(unique = true, value = {"mEndTime"}), @Index({"mSyncStatus"})})
/* loaded from: classes12.dex */
public final class WorkoutIndex {
    public static final int ALL_SYNCED = 1;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int FITBIT_SYNCED = 2;
    public static final int FROM_ACTIVITY = 1;
    public static final int FROM_WORKOUT = 2;
    public static final int STRAVA_SYNCED = 1;

    @ColumnInfo
    private long mEndTime;

    @ColumnInfo
    private int mFrom;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private int mMode;

    @ColumnInfo
    private int mSyncStatus;

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public WorkoutIndex() {
        this(0, 0, 0L, 0, 0, 31, null);
    }

    public static /* synthetic */ WorkoutIndex copy$default(WorkoutIndex workoutIndex, int i, int i2, long j, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = workoutIndex.mId;
        }
        if ((i5 & 2) != 0) {
            i2 = workoutIndex.mFrom;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            j = workoutIndex.mEndTime;
        }
        long j2 = j;
        if ((i5 & 8) != 0) {
            i3 = workoutIndex.mMode;
        }
        int i7 = i3;
        if ((i5 & 16) != 0) {
            i4 = workoutIndex.mSyncStatus;
        }
        return workoutIndex.copy(i, i6, j2, i7, i4);
    }

    public final int component1() {
        return this.mId;
    }

    public final int component2() {
        return this.mFrom;
    }

    public final long component3() {
        return this.mEndTime;
    }

    public final int component4() {
        return this.mMode;
    }

    public final int component5() {
        return this.mSyncStatus;
    }

    @OOXIXo
    public final WorkoutIndex copy(int i, int i2, long j, int i3, int i4) {
        return new WorkoutIndex(i, i2, j, i3, i4);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkoutIndex)) {
            return false;
        }
        WorkoutIndex workoutIndex = (WorkoutIndex) obj;
        return this.mId == workoutIndex.mId && this.mFrom == workoutIndex.mFrom && this.mEndTime == workoutIndex.mEndTime && this.mMode == workoutIndex.mMode && this.mSyncStatus == workoutIndex.mSyncStatus;
    }

    public final long getMEndTime() {
        return this.mEndTime;
    }

    public final int getMFrom() {
        return this.mFrom;
    }

    public final int getMId() {
        return this.mId;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMSyncStatus() {
        return this.mSyncStatus;
    }

    public int hashCode() {
        return (((((((this.mId * 31) + this.mFrom) * 31) + oIX0oI.oIX0oI(this.mEndTime)) * 31) + this.mMode) * 31) + this.mSyncStatus;
    }

    public final void setMEndTime(long j) {
        this.mEndTime = j;
    }

    public final void setMFrom(int i) {
        this.mFrom = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMSyncStatus(int i) {
        this.mSyncStatus = i;
    }

    @OOXIXo
    public String toString() {
        return "WorkoutIndex(mId=" + this.mId + ", mFrom=" + this.mFrom + ", mEndTime=" + this.mEndTime + ", mMode=" + this.mMode + ", mSyncStatus=" + this.mSyncStatus + HexStringBuilder.COMMENT_END_CHAR;
    }

    public WorkoutIndex(int i, int i2, long j, int i3, int i4) {
        this.mId = i;
        this.mFrom = i2;
        this.mEndTime = j;
        this.mMode = i3;
        this.mSyncStatus = i4;
    }

    public /* synthetic */ WorkoutIndex(int i, int i2, long j, int i3, int i4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0L : j, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 0 : i4);
    }
}
