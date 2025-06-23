package com.baidu.mapapi.search.recommendstop;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class a implements Parcelable.Creator<RecommendStopResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RecommendStopResult createFromParcel(Parcel parcel) {
        return new RecommendStopResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RecommendStopResult[] newArray(int i) {
        return new RecommendStopResult[i];
    }
}
