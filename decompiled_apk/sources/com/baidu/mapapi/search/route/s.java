package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.route.WalkingRouteLine;

/* loaded from: classes7.dex */
final class s implements Parcelable.Creator<WalkingRouteLine.WalkingStep> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WalkingRouteLine.WalkingStep createFromParcel(Parcel parcel) {
        return new WalkingRouteLine.WalkingStep(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WalkingRouteLine.WalkingStep[] newArray(int i) {
        return new WalkingRouteLine.WalkingStep[i];
    }
}
