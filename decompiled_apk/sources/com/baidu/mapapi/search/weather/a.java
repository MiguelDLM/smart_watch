package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class a implements Parcelable.Creator<WeatherLifeIndexes> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherLifeIndexes createFromParcel(Parcel parcel) {
        return new WeatherLifeIndexes(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WeatherLifeIndexes[] newArray(int i) {
        return new WeatherLifeIndexes[i];
    }
}
