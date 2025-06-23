package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;

/* loaded from: classes7.dex */
final class e implements Parcelable.Creator<ReverseGeoCodeResult.RoadInfo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ReverseGeoCodeResult.RoadInfo createFromParcel(Parcel parcel) {
        return new ReverseGeoCodeResult.RoadInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ReverseGeoCodeResult.RoadInfo[] newArray(int i) {
        return new ReverseGeoCodeResult.RoadInfo[i];
    }
}
