package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public class RecommendStopInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendStopInfo> CREATOR = new k();

    /* renamed from: a, reason: collision with root package name */
    private String f5944a;
    private LatLng b;
    private double c;
    private String d;
    private String e;

    public RecommendStopInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.e;
    }

    public double getDistance() {
        return this.c;
    }

    public String getId() {
        return this.d;
    }

    public LatLng getLocation() {
        return this.b;
    }

    public String getName() {
        return this.f5944a;
    }

    public void setAddress(String str) {
        this.e = str;
    }

    public void setDistance(double d) {
        this.c = d;
    }

    public void setId(String str) {
        this.d = str;
    }

    public void setLocation(LatLng latLng) {
        this.b = latLng;
    }

    public void setName(String str) {
        this.f5944a = str;
    }

    public String toString() {
        return "RecommendStopInfo{mName='" + this.f5944a + "', mLocation=" + this.b + ", mDistance=" + this.c + ", mId='" + this.d + "', mAddress='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5944a);
        parcel.writeParcelable(this.b, i);
        parcel.writeDouble(this.c);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
    }

    public RecommendStopInfo(Parcel parcel) {
        this.f5944a = parcel.readString();
        this.b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.c = parcel.readDouble();
        this.e = parcel.readString();
        this.d = parcel.readString();
    }
}
