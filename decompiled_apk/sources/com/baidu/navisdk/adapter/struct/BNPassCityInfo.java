package com.baidu.navisdk.adapter.struct;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class BNPassCityInfo implements Parcelable {
    public static final Parcelable.Creator<BNPassCityInfo> CREATOR = new Parcelable.Creator<BNPassCityInfo>() { // from class: com.baidu.navisdk.adapter.struct.BNPassCityInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BNPassCityInfo createFromParcel(Parcel parcel) {
            return new BNPassCityInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BNPassCityInfo[] newArray(int i) {
            return new BNPassCityInfo[i];
        }
    };
    private int cityCode;
    private String cityName;

    public BNPassCityInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityCode() {
        return this.cityCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityCode(int i) {
        this.cityCode = i;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.cityCode);
        parcel.writeString(this.cityName);
    }

    public BNPassCityInfo(Parcel parcel) {
        this.cityCode = parcel.readInt();
        this.cityName = parcel.readString();
    }
}
