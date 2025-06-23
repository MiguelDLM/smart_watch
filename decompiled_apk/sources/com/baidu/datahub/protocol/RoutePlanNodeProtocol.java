package com.baidu.datahub.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes7.dex */
public class RoutePlanNodeProtocol implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RoutePlanNodeProtocol> CREATOR = new Parcelable.Creator<RoutePlanNodeProtocol>() { // from class: com.baidu.datahub.protocol.RoutePlanNodeProtocol.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoutePlanNodeProtocol createFromParcel(Parcel parcel) {
            return new RoutePlanNodeProtocol(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoutePlanNodeProtocol[] newArray(int i) {
            return new RoutePlanNodeProtocol[i];
        }
    };
    protected float mAltitude;
    protected String mDescription;
    protected int mDistrictID;
    protected int mFrom;
    protected float mGPSAccuracy;
    protected float mGPSAngle;
    protected float mGPSSpeed;
    protected String mId;
    protected double mLatitude;
    protected double mLongitude;
    protected String mName;

    /* loaded from: classes7.dex */
    public static class Builder {
        private String mDescription;
        private String mId;
        private double mLatitude;
        private double mLongitude;
        private String mName;
        private int mFrom = 1;
        private int mDistrictID = 0;
        private float mGPSAngle = -2.0f;
        private float mGPSAccuracy = -2.0f;
        private float mGPSSpeed = -2.0f;
        private float mAltitude = -1.0f;

        public Builder altitude(float f) {
            this.mAltitude = f;
            return this;
        }

        public RoutePlanNodeProtocol build() {
            return new RoutePlanNodeProtocol(this.mFrom, this.mId, this.mLongitude, this.mLatitude, this.mName, this.mDescription, this.mDistrictID, this.mGPSAngle, this.mGPSAccuracy, this.mGPSSpeed, this.mAltitude);
        }

        public Builder description(String str) {
            this.mDescription = str;
            return this;
        }

        public Builder districtID(int i) {
            this.mDistrictID = i;
            return this;
        }

        public Builder gpsAccuracy(float f) {
            this.mGPSAccuracy = f;
            return this;
        }

        public Builder gpsAngle(float f) {
            this.mGPSAngle = f;
            return this;
        }

        public Builder gpsSpeed(float f) {
            this.mGPSSpeed = f;
            return this;
        }

        public Builder id(String str) {
            this.mId = str;
            return this;
        }

        public Builder isMyLocation(boolean z) {
            if (z) {
                this.mFrom = 3;
            } else {
                this.mFrom = 1;
            }
            return this;
        }

        public Builder latitude(double d) {
            this.mLatitude = d;
            return this;
        }

        public Builder longitude(double d) {
            this.mLongitude = d;
            return this;
        }

        public Builder name(String str) {
            this.mName = str;
            return this;
        }
    }

    public RoutePlanNodeProtocol(int i, String str, double d, double d2, String str2, String str3, int i2, float f, float f2, float f3, float f4) {
        this.mFrom = i;
        this.mId = str;
        this.mLongitude = d;
        this.mLatitude = d2;
        this.mDistrictID = i2;
        this.mGPSAngle = f;
        this.mGPSAccuracy = f2;
        this.mGPSSpeed = f3;
        this.mAltitude = f4;
        if (str2 == null) {
            this.mName = "";
        } else {
            this.mName = str2;
        }
        if (str3 == null) {
            this.mDescription = "";
        } else {
            this.mDescription = str3;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RoutePlanNodeProtocol.class != obj.getClass()) {
            return false;
        }
        RoutePlanNodeProtocol routePlanNodeProtocol = (RoutePlanNodeProtocol) obj;
        if (this.mFrom != routePlanNodeProtocol.mFrom || this.mDistrictID != routePlanNodeProtocol.mDistrictID || Double.compare(routePlanNodeProtocol.mLatitude, this.mLatitude) != 0 || Double.compare(routePlanNodeProtocol.mLongitude, this.mLongitude) != 0 || Float.compare(routePlanNodeProtocol.mGPSAngle, this.mGPSAngle) != 0 || Float.compare(routePlanNodeProtocol.mGPSAccuracy, this.mGPSAccuracy) != 0 || Float.compare(routePlanNodeProtocol.mGPSSpeed, this.mGPSSpeed) != 0 || Float.compare(routePlanNodeProtocol.mAltitude, this.mAltitude) != 0 || !Objects.equals(this.mId, routePlanNodeProtocol.mId) || !Objects.equals(this.mName, routePlanNodeProtocol.mName)) {
            return false;
        }
        return Objects.equals(this.mDescription, routePlanNodeProtocol.mDescription);
    }

    public float getAltitude() {
        return this.mAltitude;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getDistrictID() {
        return this.mDistrictID;
    }

    public int getFrom() {
        return this.mFrom;
    }

    public float getGPSAccuracy() {
        return this.mGPSAccuracy;
    }

    public float getGPSAngle() {
        return this.mGPSAngle;
    }

    public float getGPSSpeed() {
        return this.mGPSSpeed;
    }

    public String getId() {
        return this.mId;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "RoutePlanNodeProtocol{mFrom=" + this.mFrom + ", mDistrictID=" + this.mDistrictID + ", mId='" + this.mId + "', mName='" + this.mName + "', mDescription='" + this.mDescription + "', mLatitude=" + this.mLatitude + ", mLongitude=" + this.mLongitude + ", mGPSAngle=" + this.mGPSAngle + ", mGPSAccuracy=" + this.mGPSAccuracy + ", mGPSSpeed=" + this.mGPSSpeed + ", mAltitude=" + this.mAltitude + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mFrom);
        parcel.writeInt(this.mDistrictID);
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mDescription);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
        parcel.writeFloat(this.mGPSAngle);
        parcel.writeFloat(this.mGPSAccuracy);
        parcel.writeFloat(this.mGPSSpeed);
        parcel.writeFloat(this.mAltitude);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RoutePlanNodeProtocol m50clone() throws CloneNotSupportedException {
        RoutePlanNodeProtocol routePlanNodeProtocol = (RoutePlanNodeProtocol) super.clone();
        String str = this.mId;
        if (str != null) {
            routePlanNodeProtocol.mId = str;
        }
        String str2 = this.mDescription;
        if (str2 == null) {
            routePlanNodeProtocol.mDescription = str2;
        }
        String str3 = this.mName;
        if (str3 == null) {
            routePlanNodeProtocol.mName = str3;
        }
        return routePlanNodeProtocol;
    }

    public RoutePlanNodeProtocol(Parcel parcel) {
        this.mFrom = 1;
        this.mDistrictID = 0;
        this.mGPSAngle = -1.0f;
        this.mGPSAccuracy = -1.0f;
        this.mGPSSpeed = -1.0f;
        this.mAltitude = -1.0f;
        this.mFrom = parcel.readInt();
        this.mDistrictID = parcel.readInt();
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mDescription = parcel.readString();
        this.mLatitude = parcel.readDouble();
        this.mLongitude = parcel.readDouble();
        this.mGPSAngle = parcel.readFloat();
        this.mGPSAccuracy = parcel.readFloat();
        this.mGPSSpeed = parcel.readFloat();
        this.mAltitude = parcel.readFloat();
    }

    public RoutePlanNodeProtocol() {
        this.mFrom = 1;
        this.mDistrictID = 0;
        this.mGPSAngle = -1.0f;
        this.mGPSAccuracy = -1.0f;
        this.mGPSSpeed = -1.0f;
        this.mAltitude = -1.0f;
    }
}
