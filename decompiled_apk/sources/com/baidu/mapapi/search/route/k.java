package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.route.MassTransitRouteLine;

/* loaded from: classes7.dex */
final class k implements Parcelable.Creator<MassTransitRouteLine.TransitStep.TrafficCondition> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MassTransitRouteLine.TransitStep.TrafficCondition createFromParcel(Parcel parcel) {
        return new MassTransitRouteLine.TransitStep.TrafficCondition(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MassTransitRouteLine.TransitStep.TrafficCondition[] newArray(int i) {
        return new MassTransitRouteLine.TransitStep.TrafficCondition[i];
    }
}
