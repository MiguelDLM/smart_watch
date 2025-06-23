package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class h implements Parcelable.Creator<PoiInfo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiInfo[] newArray(int i) {
        return new PoiInfo[i];
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiInfo createFromParcel(Parcel parcel) {
        return new PoiInfo(parcel);
    }
}
