package com.baidu.navisdk.adapter.struct;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.navisdk.util.common.l0;

/* loaded from: classes7.dex */
public class BNRoutePlanItem implements Parcelable {
    public static final Parcelable.Creator<BNRoutePlanItem> CREATOR = new Parcelable.Creator<BNRoutePlanItem>() { // from class: com.baidu.navisdk.adapter.struct.BNRoutePlanItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BNRoutePlanItem createFromParcel(Parcel parcel) {
            return new BNRoutePlanItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BNRoutePlanItem[] newArray(int i) {
            return new BNRoutePlanItem[i];
        }
    };
    private double mLength;
    private int mLights;
    private double mPassTime;
    private int mToll;
    private String pusLabelName;

    public BNRoutePlanItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getLength() {
        return this.mLength;
    }

    public String getLengthStr() {
        StringBuilder sb = new StringBuilder();
        l0.a((int) this.mLength, l0.a.ZH, sb);
        return sb.toString();
    }

    public int getLights() {
        return this.mLights;
    }

    public double getPassTime() {
        return this.mPassTime;
    }

    public String getPassTimeStr() {
        return l0.a((int) this.mPassTime, 2);
    }

    public String getPusLabelName() {
        return this.pusLabelName;
    }

    public int getToll() {
        return this.mToll;
    }

    public void setLength(double d) {
        this.mLength = d;
    }

    public void setLights(int i) {
        this.mLights = i;
    }

    public void setPassTime(double d) {
        this.mPassTime = d;
    }

    public void setPusLabelName(String str) {
        this.pusLabelName = str;
    }

    public void setToll(int i) {
        this.mToll = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mLength);
        parcel.writeDouble(this.mPassTime);
        parcel.writeInt(this.mToll);
        parcel.writeInt(this.mLights);
        parcel.writeString(this.pusLabelName);
    }

    public BNRoutePlanItem(Parcel parcel) {
        this.mLength = parcel.readDouble();
        this.mPassTime = parcel.readDouble();
        this.mToll = parcel.readInt();
        this.mLights = parcel.readInt();
        this.pusLabelName = parcel.readString();
    }
}
