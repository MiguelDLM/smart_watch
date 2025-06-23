package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.TransitResultNode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class MassTransitRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<MassTransitRouteResult> CREATOR = new l();

    /* renamed from: a, reason: collision with root package name */
    private TransitResultNode f5988a;
    private TransitResultNode b;
    private TaxiInfo c;
    private int d;
    private List<MassTransitRouteLine> e;
    private SuggestAddrInfo f;

    public MassTransitRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransitResultNode getDestination() {
        return this.b;
    }

    public TransitResultNode getOrigin() {
        return this.f5988a;
    }

    public List<MassTransitRouteLine> getRouteLines() {
        return this.e;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f;
    }

    public TaxiInfo getTaxiInfo() {
        return this.c;
    }

    public int getTotal() {
        return this.d;
    }

    public void setDestination(TransitResultNode transitResultNode) {
        this.b = transitResultNode;
    }

    public void setOrigin(TransitResultNode transitResultNode) {
        this.f5988a = transitResultNode;
    }

    public void setRoutelines(List<MassTransitRouteLine> list) {
        this.e = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.c = taxiInfo;
    }

    public void setTotal(int i) {
        this.d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5988a, 1);
        parcel.writeParcelable(this.b, 1);
        parcel.writeParcelable(this.c, 1);
        parcel.writeInt(this.d);
        parcel.writeList(this.e);
        parcel.writeParcelable(this.f, 1);
    }

    public MassTransitRouteResult(Parcel parcel) {
        this.f5988a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.d = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        parcel.readList(arrayList, MassTransitRouteLine.class.getClassLoader());
        this.f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }
}
