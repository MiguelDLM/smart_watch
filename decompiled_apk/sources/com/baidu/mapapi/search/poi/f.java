package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class f implements Parcelable.Creator<PoiResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiResult createFromParcel(Parcel parcel) {
        return new PoiResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiResult[] newArray(int i) {
        return new PoiResult[i];
    }
}
