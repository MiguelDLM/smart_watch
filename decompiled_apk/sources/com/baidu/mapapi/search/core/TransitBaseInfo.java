package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new q();

    /* renamed from: a, reason: collision with root package name */
    private String f5951a;
    private String b;
    private String c;
    private String d;
    private String e;

    public TransitBaseInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.c;
    }

    public String getArriveTime() {
        return this.e;
    }

    public String getDepartureStation() {
        return this.b;
    }

    public String getDepartureTime() {
        return this.d;
    }

    public String getName() {
        return this.f5951a;
    }

    public void setArriveStation(String str) {
        this.c = str;
    }

    public void setArriveTime(String str) {
        this.e = str;
    }

    public void setDepartureStation(String str) {
        this.b = str;
    }

    public void setDepartureTime(String str) {
        this.d = str;
    }

    public void setName(String str) {
        this.f5951a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5951a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }

    public TransitBaseInfo(Parcel parcel) {
        this.f5951a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }
}
