package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class WeatherSearchLocation implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchLocation> CREATOR = new f();

    /* renamed from: a, reason: collision with root package name */
    private String f6008a;
    private String b;
    private String c;
    private String d;
    private String e;

    public WeatherSearchLocation() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCity() {
        return this.c;
    }

    public String getCountry() {
        return this.f6008a;
    }

    public String getDistrictID() {
        return this.e;
    }

    public String getDistrictName() {
        return this.d;
    }

    public String getProvince() {
        return this.b;
    }

    public void setCity(String str) {
        this.c = str;
    }

    public void setCountry(String str) {
        this.f6008a = str;
    }

    public void setDistrictID(String str) {
        this.e = str;
    }

    public void setDistrictName(String str) {
        this.d = str;
    }

    public void setProvince(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6008a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }

    public WeatherSearchLocation(Parcel parcel) {
        this.f6008a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }
}
