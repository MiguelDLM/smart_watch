package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class e implements Parcelable.Creator<WeatherSearchForecasts> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherSearchForecasts createFromParcel(Parcel parcel) {
        return new WeatherSearchForecasts(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherSearchForecasts[] newArray(int i) {
        return new WeatherSearchForecasts[i];
    }
}
