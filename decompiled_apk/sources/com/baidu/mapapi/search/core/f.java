package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class f implements Parcelable.Creator<PoiChildrenInfo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiChildrenInfo createFromParcel(Parcel parcel) {
        return new PoiChildrenInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiChildrenInfo[] newArray(int i) {
        return new PoiChildrenInfo[i];
    }
}
