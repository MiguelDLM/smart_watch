package com.baidu.navisdk.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes7.dex */
public class BNRoutePlanNode implements Parcelable, Cloneable {
    public static final Parcelable.Creator<BNRoutePlanNode> CREATOR = new Parcelable.Creator<BNRoutePlanNode>() { // from class: com.baidu.navisdk.adapter.BNRoutePlanNode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BNRoutePlanNode createFromParcel(Parcel parcel) {
            return new BNRoutePlanNode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BNRoutePlanNode[] newArray(int i) {
            return new BNRoutePlanNode[i];
        }
    };
    private float mAltitude;
    private String mBuildingId;
    private String mDescription;
    private int mDistrictID;
    private String mFloorId;
    private int mFrom;
    private float mGPSAccuracy;
    private float mGPSAngle;
    private float mGPSSpeed;
    private String mId;
    private double mLatitude;
    private double mLongitude;
    private String mName;
    private int mNodePrefer;

    /* loaded from: classes7.dex */
    public static class Builder {
        private String mBuildingId;
        private String mDescription;
        private String mFloorId;
        private double mLatitude;
        private double mLongitude;
        private String mName;
        private int mFrom = 1;
        private int mDistrictID = 0;
        private String mId = "";
        private float mGPSAngle = -2.0f;
        private float mGPSAccuracy = -2.0f;
        private float mGPSSpeed = -2.0f;
        private float mAltitude = -1.0f;
        private int mNodePrefer = 1;

        public Builder altitude(float f) {
            this.mAltitude = f;
            return this;
        }

        public BNRoutePlanNode build() {
            return new BNRoutePlanNode(this.mFrom, this.mId, this.mLongitude, this.mLatitude, this.mName, this.mDescription, this.mDistrictID, this.mGPSAngle, this.mGPSAccuracy, this.mGPSSpeed, this.mAltitude, this.mBuildingId, this.mFloorId, this.mNodePrefer);
        }

        public Builder buildingID(String str) {
            this.mBuildingId = str;
            return this;
        }

        public Builder description(String str) {
            this.mDescription = str;
            return this;
        }

        public Builder districtID(int i) {
            this.mDistrictID = i;
            return this;
        }

        public Builder floorId(String str) {
            this.mFloorId = str;
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
                this.mName = "我的位置";
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

        public Builder nodePrefer(int i) {
            this.mNodePrefer = i;
            return this;
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
        if (obj == null || BNRoutePlanNode.class != obj.getClass()) {
            return false;
        }
        BNRoutePlanNode bNRoutePlanNode = (BNRoutePlanNode) obj;
        if (this.mFrom != bNRoutePlanNode.mFrom || this.mDistrictID != bNRoutePlanNode.mDistrictID || Double.compare(bNRoutePlanNode.mLatitude, this.mLatitude) != 0 || Double.compare(bNRoutePlanNode.mLongitude, this.mLongitude) != 0 || Float.compare(bNRoutePlanNode.mGPSAngle, this.mGPSAngle) != 0 || Float.compare(bNRoutePlanNode.mGPSAccuracy, this.mGPSAccuracy) != 0 || Float.compare(bNRoutePlanNode.mGPSSpeed, this.mGPSSpeed) != 0 || Float.compare(bNRoutePlanNode.mAltitude, this.mAltitude) != 0 || this.mNodePrefer != bNRoutePlanNode.mNodePrefer || !Objects.equals(this.mId, bNRoutePlanNode.mId) || !Objects.equals(this.mName, bNRoutePlanNode.mName)) {
            return false;
        }
        return Objects.equals(this.mDescription, bNRoutePlanNode.mDescription);
    }

    public float getAltitude() {
        return this.mAltitude;
    }

    public String getBuildingId() {
        return this.mBuildingId;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getDistrictID() {
        return this.mDistrictID;
    }

    public String getFloorId() {
        return this.mFloorId;
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

    public int getNodePrefer() {
        return this.mNodePrefer;
    }

    public void setNodePrefer(int i) {
        this.mNodePrefer = i;
    }

    public String toString() {
        return "BNRoutePlanNode{mFrom=" + this.mFrom + ", mDistrictID=" + this.mDistrictID + ", mId='" + this.mId + "', mName='" + this.mName + "', mDescription='" + this.mDescription + "', mLatitude=" + this.mLatitude + ", mLongitude=" + this.mLongitude + ", mGPSAngle=" + this.mGPSAngle + ", mGPSAccuracy=" + this.mGPSAccuracy + ", mGPSSpeed=" + this.mGPSSpeed + ", mAltitude=" + this.mAltitude + ", mBuildingID=" + this.mBuildingId + ", mFloorId=" + this.mFloorId + ", mNodePrefer=" + this.mNodePrefer + '}';
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
        parcel.writeInt(this.mNodePrefer);
    }

    private BNRoutePlanNode(int i, String str, double d, double d2, String str2, String str3, int i2, float f, float f2, float f3, float f4, String str4, String str5, int i3) {
        this.mFrom = i;
        this.mId = str;
        this.mLongitude = d;
        this.mLatitude = d2;
        this.mDistrictID = i2;
        this.mGPSAngle = f;
        this.mGPSAccuracy = f2;
        this.mGPSSpeed = f3;
        this.mAltitude = f4;
        this.mBuildingId = str4;
        this.mFloorId = str5;
        this.mNodePrefer = i3;
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

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BNRoutePlanNode m80clone() throws CloneNotSupportedException {
        BNRoutePlanNode bNRoutePlanNode = (BNRoutePlanNode) super.clone();
        String str = this.mId;
        if (str != null) {
            bNRoutePlanNode.mId = str;
        }
        String str2 = this.mDescription;
        if (str2 != null) {
            bNRoutePlanNode.mDescription = str2;
        }
        String str3 = this.mName;
        if (str3 != null) {
            bNRoutePlanNode.mName = str3;
        }
        int i = this.mNodePrefer;
        if (i != 1) {
            bNRoutePlanNode.mNodePrefer = i;
        }
        return bNRoutePlanNode;
    }

    public BNRoutePlanNode(Parcel parcel) {
        this.mFrom = 1;
        this.mGPSAngle = -1.0f;
        this.mGPSAccuracy = -1.0f;
        this.mGPSSpeed = -1.0f;
        this.mAltitude = -1.0f;
        this.mNodePrefer = 1;
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
        this.mNodePrefer = parcel.readInt();
    }
}
