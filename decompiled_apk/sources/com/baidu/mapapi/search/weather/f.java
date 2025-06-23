package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class f implements Parcelable.Creator<WeatherSearchLocation> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherSearchLocation createFromParcel(Parcel parcel) {
        return new WeatherSearchLocation(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherSearchLocation[] newArray(int i) {
        return new WeatherSearchLocation[i];
    }
}
