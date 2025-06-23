package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    private int f5935a;
    private int b;

    public BusInfo() {
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getStopNum() {
        return this.b;
    }

    public int getType() {
        return this.f5935a;
    }

    public void setStopNum(int i) {
        this.b = i;
    }

    public void setType(int i) {
        this.f5935a = i;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f5935a);
        parcel.writeInt(this.b);
    }

    public BusInfo(Parcel parcel) {
        super(parcel);
        this.f5935a = parcel.readInt();
        this.b = parcel.readInt();
    }
}
