package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class d implements Parcelable.Creator<CoachInfo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CoachInfo createFromParcel(Parcel parcel) {
        return new CoachInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CoachInfo[] newArray(int i) {
        return new CoachInfo[i];
    }
}
