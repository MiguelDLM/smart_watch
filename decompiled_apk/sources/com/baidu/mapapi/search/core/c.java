package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class c implements Parcelable.Creator<CityInfo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CityInfo[] newArray(int i) {
        return new CityInfo[i];
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CityInfo createFromParcel(Parcel parcel) {
        return new CityInfo(parcel);
    }
}
