package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class WeatherSearchAlerts implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchAlerts> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    private String f6005a;
    private String b;
    private String c;
    private String d;

    public WeatherSearchAlerts() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.d;
    }

    public String getLevel() {
        return this.b;
    }

    public String getTitle() {
        return this.c;
    }

    public String getType() {
        return this.f6005a;
    }

    public void setDesc(String str) {
        this.d = str;
    }

    public void setLevel(String str) {
        this.b = str;
    }

    public void setTitle(String str) {
        this.c = str;
    }

    public void setType(String str) {
        this.f6005a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6005a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    public WeatherSearchAlerts(Parcel parcel) {
        this.f6005a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
