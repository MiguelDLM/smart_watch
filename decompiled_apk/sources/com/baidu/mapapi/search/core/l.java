package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class l implements Parcelable.Creator<RouteNode> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RouteNode createFromParcel(Parcel parcel) {
        return new RouteNode(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RouteNode[] newArray(int i) {
        return new RouteNode[i];
    }
}
