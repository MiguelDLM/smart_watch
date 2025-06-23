package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: classes11.dex */
public class Throughput implements Parcelable {
    public static final Parcelable.Creator<Throughput> CREATOR = new Parcelable.Creator<Throughput>() { // from class: com.realsil.sdk.dfu.model.Throughput.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Throughput createFromParcel(Parcel parcel) {
            return new Throughput(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Throughput[] newArray(int i) {
            return new Throughput[i];
        }
    };
    public long dataSize;
    public long deltaTime;
    public long packetSize;
    public float realSpeed;
    public float speed;

    public Throughput(long j, long j2) {
        this(j, j2, 0L, 0.0f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "packetSize=%d, deltaTime=%d ms, speed=%f, realSpeed=%f", Long.valueOf(this.packetSize), Long.valueOf(this.deltaTime), Float.valueOf(this.speed), Float.valueOf(this.realSpeed));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.packetSize);
        parcel.writeLong(this.dataSize);
        parcel.writeLong(this.deltaTime);
        parcel.writeFloat(this.speed);
        parcel.writeFloat(this.realSpeed);
    }

    public Throughput(long j, long j2, long j3, float f) {
        this(j, j2, j3, f, 0.0f);
    }

    public Throughput(long j, long j2, long j3, float f, float f2) {
        this.packetSize = j;
        this.dataSize = j2;
        this.deltaTime = j3;
        this.speed = f;
        this.realSpeed = f2;
    }

    public Throughput(Parcel parcel) {
        this.packetSize = parcel.readLong();
        this.dataSize = parcel.readLong();
        this.deltaTime = parcel.readLong();
        this.speed = parcel.readFloat();
        this.realSpeed = parcel.readFloat();
    }
}
