package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes7.dex */
public class PoiDetailSearchResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiDetailSearchResult> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    private List<PoiDetailInfo> f5960a;

    public PoiDetailSearchResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiDetailInfo> getPoiDetailInfoList() {
        return this.f5960a;
    }

    public void setPoiDetailInfoList(List<PoiDetailInfo> list) {
        this.f5960a = list;
    }

    public String toString() {
        List<PoiDetailInfo> list = this.f5960a;
        if (list != null && !list.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer("PoiDetailSearchResult:");
            for (int i = 0; i < this.f5960a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                PoiDetailInfo poiDetailInfo = this.f5960a.get(i);
                if (poiDetailInfo != null) {
                    stringBuffer.append(poiDetailInfo.toString());
                } else {
                    stringBuffer.append("null");
                }
            }
            return stringBuffer.toString();
        }
        return "PoiDetailSearchResult is null";
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f5960a);
    }

    public PoiDetailSearchResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    public PoiDetailSearchResult(Parcel parcel) {
        super(parcel);
        this.f5960a = parcel.createTypedArrayList(PoiDetailInfo.CREATOR);
    }
}
