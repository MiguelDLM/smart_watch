package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class g implements Parcelable.Creator<IndoorRouteLine> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IndoorRouteLine createFromParcel(Parcel parcel) {
        return new IndoorRouteLine(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IndoorRouteLine[] newArray(int i) {
        return new IndoorRouteLine[i];
    }
}
