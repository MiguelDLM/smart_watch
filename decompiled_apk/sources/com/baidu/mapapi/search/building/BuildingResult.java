package com.baidu.mapapi.search.building;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes7.dex */
public class BuildingResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BuildingResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<BuildingInfo> f5930a;
    private int b;

    public BuildingResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BuildingInfo> getBuildingList() {
        return this.f5930a;
    }

    public int getRelation() {
        return this.b;
    }

    public void setBuildingList(List<BuildingInfo> list) {
        this.f5930a = list;
    }

    public void setRelation(int i) {
        this.b = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("BuidingResult: ");
        List<BuildingInfo> list = this.f5930a;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f5930a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                BuildingInfo buildingInfo = this.f5930a.get(i);
                if (buildingInfo == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append(buildingInfo.toString());
                }
            }
        } else {
            stringBuffer.append("null");
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f5930a);
    }

    public BuildingResult(Parcel parcel) {
        this.f5930a = parcel.createTypedArrayList(BuildingInfo.CREATOR);
    }
}
