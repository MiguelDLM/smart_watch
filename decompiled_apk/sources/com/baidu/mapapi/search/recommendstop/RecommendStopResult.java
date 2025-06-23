package com.baidu.mapapi.search.recommendstop;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RecommendStationStopInfo;
import com.baidu.mapapi.search.core.RecommendStopInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes7.dex */
public class RecommendStopResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<RecommendStopResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<RecommendStopInfo> f5972a;
    private List<RecommendStationStopInfo> b;

    public RecommendStopResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RecommendStopInfo> getRecommendStopInfoList() {
        return this.f5972a;
    }

    public List<RecommendStationStopInfo> getStationInfoList() {
        return this.b;
    }

    public void setRecommendStopInfoList(List<RecommendStopInfo> list) {
        this.f5972a = list;
    }

    public void setStationInfoList(List<RecommendStationStopInfo> list) {
        this.b = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RecommendStopResult: ");
        List<RecommendStopInfo> list = this.f5972a;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f5972a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                RecommendStopInfo recommendStopInfo = this.f5972a.get(i);
                if (recommendStopInfo == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append(recommendStopInfo.toString());
                }
            }
        } else {
            stringBuffer.append("null");
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f5972a);
    }

    public RecommendStopResult(Parcel parcel) {
        super(parcel);
        this.f5972a = parcel.createTypedArrayList(RecommendStopInfo.CREATOR);
    }
}
