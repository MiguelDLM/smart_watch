package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;

/* loaded from: classes7.dex */
final class c implements Parcelable.Creator<ReverseGeoCodeResult.AddressComponent> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ReverseGeoCodeResult.AddressComponent createFromParcel(Parcel parcel) {
        return new ReverseGeoCodeResult.AddressComponent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ReverseGeoCodeResult.AddressComponent[] newArray(int i) {
        return new ReverseGeoCodeResult.AddressComponent[i];
    }
}
