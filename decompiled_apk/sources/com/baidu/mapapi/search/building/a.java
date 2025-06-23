package com.baidu.mapapi.search.building;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class a implements Parcelable.Creator<BuildingResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BuildingResult createFromParcel(Parcel parcel) {
        return new BuildingResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BuildingResult[] newArray(int i) {
        return new BuildingResult[i];
    }
}
