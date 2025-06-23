package com.baidu.mapapi.map;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class r implements Parcelable.Creator<MapStatus> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MapStatus createFromParcel(Parcel parcel) {
        return new MapStatus(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MapStatus[] newArray(int i) {
        return new MapStatus[i];
    }
}
