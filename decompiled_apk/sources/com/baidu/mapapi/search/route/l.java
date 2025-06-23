package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class l implements Parcelable.Creator<MassTransitRouteResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MassTransitRouteResult createFromParcel(Parcel parcel) {
        return new MassTransitRouteResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MassTransitRouteResult[] newArray(int i) {
        return new MassTransitRouteResult[i];
    }
}
