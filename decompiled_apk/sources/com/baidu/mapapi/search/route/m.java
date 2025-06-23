package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class m implements Parcelable.Creator<PlanNode> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlanNode createFromParcel(Parcel parcel) {
        return new PlanNode(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlanNode[] newArray(int i) {
        return new PlanNode[i];
    }
}
