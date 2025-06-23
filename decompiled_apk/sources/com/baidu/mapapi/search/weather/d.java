package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class d implements Parcelable.Creator<WeatherSearchForecastForHours> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherSearchForecastForHours createFromParcel(Parcel parcel) {
        return new WeatherSearchForecastForHours(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherSearchForecastForHours[] newArray(int i) {
        return new WeatherSearchForecastForHours[i];
    }
}
