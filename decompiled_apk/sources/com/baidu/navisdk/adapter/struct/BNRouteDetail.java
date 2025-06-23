package com.baidu.navisdk.adapter.struct;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes7.dex */
public class BNRouteDetail implements Parcelable {
    public static final Parcelable.Creator<BNRouteDetail> CREATOR = new Parcelable.Creator<BNRouteDetail>() { // from class: com.baidu.navisdk.adapter.struct.BNRouteDetail.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BNRouteDetail createFromParcel(Parcel parcel) {
            return new BNRouteDetail(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BNRouteDetail[] newArray(int i) {
            return new BNRouteDetail[i];
        }
    };
    private String description;
    private int iconId;
    private int index;
    private List<RoadCondition> roadConditions;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public int getIconId() {
        return this.iconId;
    }

    public int getIndex() {
        return this.index;
    }

    public List<RoadCondition> getRoadConditions() {
        return this.roadConditions;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIconId(int i) {
        this.iconId = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setRoadConditions(List<RoadCondition> list) {
        this.roadConditions = list;
    }

    public String toString() {
        return "BNRouteDetail{index=" + this.index + ", iconId=" + this.iconId + ", description=" + this.description + ", roadConditions=" + this.roadConditions + ooOOo0oXI.f33074oOoXoXO;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.index);
        parcel.writeInt(this.iconId);
        parcel.writeString(this.description);
        parcel.writeTypedList(this.roadConditions);
    }

    public BNRouteDetail() {
    }

    /* loaded from: classes7.dex */
    public static class RoadCondition implements Parcelable {
        public static final Parcelable.Creator<RoadCondition> CREATOR = new Parcelable.Creator<RoadCondition>() { // from class: com.baidu.navisdk.adapter.struct.BNRouteDetail.RoadCondition.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RoadCondition createFromParcel(Parcel parcel) {
                return new RoadCondition(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RoadCondition[] newArray(int i) {
                return new RoadCondition[i];
            }
        };
        private static final int ROAD_CONDITION_TYPE_INVALID = 0;
        private static final int ROAD_CONDITION_TYPE_OBSTRUCTION = 3;
        private static final int ROAD_CONDITION_TYPE_SLOW = 2;
        private static final int ROAD_CONDITION_TYPE_STRAIGHTWAY = 1;
        private static final int ROAD_CONDITION_TYPE_VERY_OBSTRUCTION = 4;
        public List<LatLng> points;
        public int status;

        public RoadCondition(List<LatLng> list, int i) {
            this.points = list;
            this.status = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RoadCondition{status=" + this.status + ", points[");
            Iterator<LatLng> it = this.points.iterator();
            while (it.hasNext()) {
                sb.append("{" + it.next() + "},");
            }
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]}");
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.points);
            parcel.writeInt(this.status);
        }

        public RoadCondition(Parcel parcel) {
            this.points = parcel.createTypedArrayList(LatLng.CREATOR);
            this.status = parcel.readInt();
        }
    }

    private BNRouteDetail(Parcel parcel) {
        this.index = parcel.readInt();
        this.iconId = parcel.readInt();
        this.description = parcel.readString();
        this.roadConditions = parcel.createTypedArrayList(RoadCondition.CREATOR);
    }
}
