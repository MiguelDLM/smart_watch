package com.baidu.mapapi.search.busline;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class a implements Parcelable.Creator<BusLineResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BusLineResult[] newArray(int i) {
        return new BusLineResult[i];
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BusLineResult createFromParcel(Parcel parcel) {
        return new BusLineResult(parcel);
    }
}
