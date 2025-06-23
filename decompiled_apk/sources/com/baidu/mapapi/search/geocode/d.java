package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;

/* loaded from: classes7.dex */
final class d implements Parcelable.Creator<ReverseGeoCodeResult.PoiRegionsInfo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ReverseGeoCodeResult.PoiRegionsInfo createFromParcel(Parcel parcel) {
        return new ReverseGeoCodeResult.PoiRegionsInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ReverseGeoCodeResult.PoiRegionsInfo[] newArray(int i) {
        return new ReverseGeoCodeResult.PoiRegionsInfo[i];
    }
}
