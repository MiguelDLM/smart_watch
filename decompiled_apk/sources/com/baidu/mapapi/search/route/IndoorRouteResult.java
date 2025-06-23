package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes7.dex */
public class IndoorRouteResult extends SearchResult {
    public static final Parcelable.Creator<IndoorRouteResult> CREATOR = new h();

    /* renamed from: a, reason: collision with root package name */
    private List<IndoorRouteLine> f5982a;

    public IndoorRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<IndoorRouteLine> getRouteLines() {
        return this.f5982a;
    }

    public void setRouteLines(List<IndoorRouteLine> list) {
        this.f5982a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f5982a);
    }

    public IndoorRouteResult(Parcel parcel) {
        super(parcel);
        this.f5982a = parcel.createTypedArrayList(IndoorRouteLine.CREATOR);
    }
}
