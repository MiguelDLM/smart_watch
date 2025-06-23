package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class g implements Parcelable.Creator<WeatherSearchRealTime> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherSearchRealTime createFromParcel(Parcel parcel) {
        return new WeatherSearchRealTime(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherSearchRealTime[] newArray(int i) {
        return new WeatherSearchRealTime[i];
    }
}
