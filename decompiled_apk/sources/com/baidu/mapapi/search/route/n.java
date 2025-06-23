package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
final class n implements Parcelable.Creator<SuggestAddrInfo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SuggestAddrInfo[] newArray(int i) {
        return new SuggestAddrInfo[i];
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SuggestAddrInfo createFromParcel(Parcel parcel) {
        return new SuggestAddrInfo(parcel);
    }
}
