package com.baidu.platform.comjni.tools;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes8.dex */
final class b implements Parcelable.Creator<ParcelItem> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelItem createFromParcel(Parcel parcel) {
        ParcelItem parcelItem = new ParcelItem();
        parcelItem.setBundle(parcel.readBundle());
        return parcelItem;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelItem[] newArray(int i) {
        return new ParcelItem[i];
    }
}
