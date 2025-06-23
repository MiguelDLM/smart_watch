package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class m implements Parcelable.Creator<RouteStep> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RouteStep createFromParcel(Parcel parcel) {
        return new RouteStep(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RouteStep[] newArray(int i) {
        return new RouteStep[i];
    }
}
