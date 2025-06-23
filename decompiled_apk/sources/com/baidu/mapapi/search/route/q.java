package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class q implements Parcelable.Creator<TransitRouteResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TransitRouteResult createFromParcel(Parcel parcel) {
        return new TransitRouteResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TransitRouteResult[] newArray(int i) {
        return new TransitRouteResult[i];
    }
}
