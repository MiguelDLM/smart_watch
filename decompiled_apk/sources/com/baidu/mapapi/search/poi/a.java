package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class a implements Parcelable.Creator<PoiDetailResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiDetailResult createFromParcel(Parcel parcel) {
        return new PoiDetailResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiDetailResult[] newArray(int i) {
        return new PoiDetailResult[i];
    }
}
