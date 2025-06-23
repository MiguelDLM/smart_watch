package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class DrivingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteResult> CREATOR = new f();

    /* renamed from: a, reason: collision with root package name */
    private List<DrivingRouteLine> f5979a;
    private List<TaxiInfo> b;
    private TaxiInfo c;
    private SuggestAddrInfo d;

    public DrivingRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivingRouteLine> getRouteLines() {
        return this.f5979a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.d;
    }

    @Deprecated
    public TaxiInfo getTaxiInfo() {
        return this.c;
    }

    public List<TaxiInfo> getTaxiInfos() {
        return this.b;
    }

    public void setRouteLines(List<DrivingRouteLine> list) {
        this.f5979a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.d = suggestAddrInfo;
    }

    public void setTaxiInfos(List<TaxiInfo> list) {
        this.b = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f5979a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.d, 1);
    }

    public DrivingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f5979a = arrayList;
        parcel.readTypedList(arrayList, DrivingRouteLine.CREATOR);
        ArrayList arrayList2 = new ArrayList();
        this.b = arrayList2;
        parcel.readTypedList(arrayList2, TaxiInfo.CREATOR);
        this.d = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }
}
