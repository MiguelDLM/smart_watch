package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class a implements Parcelable.Creator<GeoCodeResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GeoCodeResult createFromParcel(Parcel parcel) {
        return new GeoCodeResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GeoCodeResult[] newArray(int i) {
        return new GeoCodeResult[i];
    }
}
