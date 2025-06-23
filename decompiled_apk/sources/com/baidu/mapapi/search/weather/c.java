package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class c implements Parcelable.Creator<WeatherSearchAlerts> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherSearchAlerts createFromParcel(Parcel parcel) {
        return new WeatherSearchAlerts(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherSearchAlerts[] newArray(int i) {
        return new WeatherSearchAlerts[i];
    }
}
