package com.baidu.ar.slam;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class TrackModel implements Parcelable {
    public static final Parcelable.Creator<TrackModel> CREATOR = new Parcelable.Creator() { // from class: com.baidu.ar.slam.TrackModel.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public TrackModel[] newArray(int i) {
            return new TrackModel[i];
        }

        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            TrackModel trackModel = new TrackModel();
            trackModel.setId(parcel.readString());
            trackModel.setPose(parcel.createFloatArray());
            return trackModel;
        }
    };
    public String id;
    public float[] pose;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.id;
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
