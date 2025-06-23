package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class k implements Parcelable.Creator<RecommendStopInfo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RecommendStopInfo createFromParcel(Parcel parcel) {
        return new RecommendStopInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RecommendStopInfo[] newArray(int i) {
        return new RecommendStopInfo[i];
    }
}
