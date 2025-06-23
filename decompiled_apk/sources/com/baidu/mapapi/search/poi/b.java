package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class b implements Parcelable.Creator<PoiDetailSearchResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiDetailSearchResult createFromParcel(Parcel parcel) {
        return new PoiDetailSearchResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiDetailSearchResult[] newArray(int i) {
        return new PoiDetailSearchResult[i];
    }
}
