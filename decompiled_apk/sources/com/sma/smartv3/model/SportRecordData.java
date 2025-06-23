package com.sma.smartv3.model;

import OXOo.OOXIXo;
import android.os.Parcel;
import android.os.Parcelable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class SportRecordData implements Parcelable {

    @OOXIXo
    public static final CREATOR CREATOR = new CREATOR(null);
    private int mCalorie;
    private int mDistance;
    private int mDuration;
    private long mEndTime;
    private boolean mIsLocationEmpty;
    private int mMode;
    private int mPace;

    @OOXIXo
    private String mPlatform;
    private int mSource;
    private int mSpeed;
    private long mStartTime;
    private int mWorkoutId;

    /* loaded from: classes12.dex */
    public static final class CREATOR implements Parcelable.Creator<SportRecordData> {
        public /* synthetic */ CREATOR(IIXOooo iIXOooo) {
            this();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public SportRecordData createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new SportRecordData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public SportRecordData[] newArray(int i) {
            return new SportRecordData[i];
        }
    }

    public SportRecordData() {
        this.mIsLocationEmpty = true;
        this.mPlatform = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public final long getMEndTime() {
        return this.mEndTime;
    }

    public final boolean getMIsLocationEmpty() {
        return this.mIsLocationEmpty;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMPace() {
        return this.mPace;
    }

    @OOXIXo
    public final String getMPlatform() {
        return this.mPlatform;
    }

    public final int getMSource() {
        return this.mSource;
    }

    public final int getMSpeed() {
        return this.mSpeed;
    }

    public final long getMStartTime() {
        return this.mStartTime;
    }

    public final int getMWorkoutId() {
        return this.mWorkoutId;
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

    public final void setMEndTime(long j) {
        this.mEndTime = j;
    }

    public final void setMIsLocationEmpty(boolean z) {
        this.mIsLocationEmpty = z;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMPace(int i) {
        this.mPace = i;
    }

    public final void setMPlatform(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPlatform = str;
    }

    public final void setMSource(int i) {
        this.mSource = i;
    }

    public final void setMSpeed(int i) {
        this.mSpeed = i;
    }

    public final void setMStartTime(long j) {
        this.mStartTime = j;
    }

    public final void setMWorkoutId(int i) {
        this.mWorkoutId = i;
    }

    @OOXIXo
    public String toString() {
        return "SportRecordData(mStartTime=" + this.mStartTime + ", mEndTime=" + this.mEndTime + ", mMode=" + this.mMode + ", mSource=" + this.mSource + ", mIsLocationEmpty=" + this.mIsLocationEmpty + ", mWorkoutId=" + this.mWorkoutId + ", mDistance=" + this.mDistance + ", mPace=" + this.mPace + " ,mCalorie=" + this.mCalorie + " ,mDuration=" + this.mDuration + HexStringBuilder.COMMENT_END_CHAR;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel parcel, int i) {
        IIX0o.x0xO0oo(parcel, "parcel");
        parcel.writeLong(this.mStartTime);
        parcel.writeLong(this.mEndTime);
        parcel.writeInt(this.mMode);
        parcel.writeInt(this.mSource);
        parcel.writeByte(this.mIsLocationEmpty ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mWorkoutId);
        parcel.writeInt(this.mDistance);
        parcel.writeInt(this.mPace);
        parcel.writeInt(this.mCalorie);
        parcel.writeInt(this.mDuration);
        parcel.writeString(this.mPlatform);
        parcel.writeInt(this.mSpeed);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SportRecordData(@OOXIXo Parcel parcel) {
        this();
        IIX0o.x0xO0oo(parcel, "parcel");
        this.mStartTime = parcel.readLong();
        this.mEndTime = parcel.readLong();
        this.mMode = parcel.readInt();
        this.mSource = parcel.readInt();
        this.mIsLocationEmpty = parcel.readByte() != 0;
        this.mWorkoutId = parcel.readInt();
        this.mDistance = parcel.readInt();
        this.mPace = parcel.readInt();
        this.mCalorie = parcel.readInt();
        this.mDuration = parcel.readInt();
        this.mPlatform = String.valueOf(parcel.readString());
        this.mSpeed = parcel.readInt();
    }
}
