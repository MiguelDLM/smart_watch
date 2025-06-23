package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new d();

    /* renamed from: a, reason: collision with root package name */
    private double f5936a;
    private String b;
    private String c;
    private String d;

    public CoachInfo() {
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.b;
    }

    public double getPrice() {
        return this.f5936a;
    }

    public String getProviderName() {
        return this.c;
    }

    public String getProviderUrl() {
        return this.d;
    }

    public void setBooking(String str) {
        this.b = str;
    }

    public void setPrice(double d) {
        this.f5936a = d;
    }

    public void setProviderName(String str) {
        this.c = str;
    }

    public void setProviderUrl(String str) {
        this.d = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f5936a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f5936a = parcel.readDouble();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
