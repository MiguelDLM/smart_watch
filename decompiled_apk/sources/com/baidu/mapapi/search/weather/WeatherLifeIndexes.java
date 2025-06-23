package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class WeatherLifeIndexes implements Parcelable {
    public static final Parcelable.Creator<WeatherLifeIndexes> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6002a;
    private String b;
    private String c;

    public WeatherLifeIndexes() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBrief() {
        return this.b;
    }

    public String getDetail() {
        return this.c;
    }

    public String getName() {
        return this.f6002a;
    }

    public void setBrief(String str) {
        this.b = str;
    }

    public void setDetail(String str) {
        this.c = str;
    }

    public void setName(String str) {
        this.f6002a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeString(getBrief());
        parcel.writeString(getDetail());
    }

    public WeatherLifeIndexes(Parcel parcel) {
        setName(parcel.readString());
        setBrief(parcel.readString());
        setDetail(parcel.readString());
    }
}
