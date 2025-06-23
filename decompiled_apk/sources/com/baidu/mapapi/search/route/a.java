package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class a implements Parcelable.Creator<BikingRouteLine> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BikingRouteLine createFromParcel(Parcel parcel) {
        return new BikingRouteLine(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BikingRouteLine[] newArray(int i) {
        return new BikingRouteLine[i];
    }
}
