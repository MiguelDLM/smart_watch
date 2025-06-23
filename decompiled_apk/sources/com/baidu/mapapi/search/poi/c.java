package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class c implements Parcelable.Creator<PoiFilter> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiFilter createFromParcel(Parcel parcel) {
        return new PoiFilter(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiFilter[] newArray(int i) {
        return new PoiFilter[i];
    }
}
