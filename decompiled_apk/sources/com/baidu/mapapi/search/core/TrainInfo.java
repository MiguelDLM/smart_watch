package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class TrainInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<TrainInfo> CREATOR = new p();

    /* renamed from: a, reason: collision with root package name */
    private double f5950a;
    private String b;

    public TrainInfo() {
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.b;
    }

    public double getPrice() {
        return this.f5950a;
    }

    public void setBooking(String str) {
        this.b = str;
    }

    public void setPrice(double d) {
        this.f5950a = d;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f5950a);
        parcel.writeString(this.b);
    }

    public TrainInfo(Parcel parcel) {
        super(parcel);
        this.f5950a = parcel.readDouble();
        this.b = parcel.readString();
    }
}
