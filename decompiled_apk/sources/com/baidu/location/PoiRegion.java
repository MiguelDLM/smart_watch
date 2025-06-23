package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public final class PoiRegion implements Parcelable {
    public static final Parcelable.Creator<PoiRegion> CREATOR = new h();
    private final String mDirectionDesc;
    private final String mName;
    private final String mTag;

    public PoiRegion(PoiRegion poiRegion) {
        this.mName = poiRegion.getName();
        this.mDirectionDesc = poiRegion.getDerectionDesc();
        this.mTag = poiRegion.getTags();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDerectionDesc() {
        return this.mDirectionDesc;
    }

    public String getName() {
        return this.mName;
    }

    public String getTags() {
        return this.mTag;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mDirectionDesc);
        parcel.writeString(this.mTag);
    }

    public PoiRegion(String str, String str2, String str3) {
        this.mName = str2;
        this.mDirectionDesc = str;
        this.mTag = str3;
    }
}
