package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class b implements Parcelable.Creator<WeatherResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherResult createFromParcel(Parcel parcel) {
        return new WeatherResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherResult[] newArray(int i) {
        return new WeatherResult[i];
    }
}
