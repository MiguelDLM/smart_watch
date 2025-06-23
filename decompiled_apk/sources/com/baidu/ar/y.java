package com.baidu.ar;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class y implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new Parcelable.Creator() { // from class: com.baidu.ar.y.1
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            y yVar = new y();
            yVar.setId(parcel.readString());
            yVar.setPose(parcel.createFloatArray());
            return yVar;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public y[] newArray(int i) {
            return new y[i];
        }
    };
    public String id;
    public float[] pose;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float[] getPose() {
        return this.pose;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPose(float[] fArr) {
        this.pose = fArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeFloatArray(this.pose);
    }
}
