package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public class PlanNode implements Parcelable {
    public static final Parcelable.Creator<PlanNode> CREATOR = new m();

    /* renamed from: a, reason: collision with root package name */
    private LatLng f5989a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public PlanNode(LatLng latLng, String str, String str2, String str3) {
        this.b = null;
        this.e = null;
        this.f = null;
        this.f5989a = latLng;
        this.d = str;
        this.c = str2;
        if (str2 != null) {
            this.b = str2;
        }
        if (str != null) {
            this.b = str;
        }
        this.e = str3;
    }

    public static PlanNode withCityCodeAndPlaceName(int i, String str) {
        return new PlanNode(null, null, String.valueOf(i), str);
    }

    public static PlanNode withCityCodeAndPlaceNameAndPoiId(int i, String str, String str2) {
        return new PlanNode(null, null, String.valueOf(i), str, str2);
    }

    public static PlanNode withCityNameAndPlaceName(String str, String str2) {
        return new PlanNode(null, str, null, str2);
    }

    public static PlanNode withCityNameAndPlaceNameAndPoiId(String str, String str2, String str3) {
        return new PlanNode(null, str, null, str2, str3);
    }

    public static PlanNode withLocation(LatLng latLng) {
        return new PlanNode(latLng, null, null, null);
    }

    public static PlanNode withLocationAndPoiId(LatLng latLng, String str) {
        return new PlanNode(latLng, null, null, null, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCity() {
        return this.b;
    }

    public String getCityCode() {
        return this.c;
    }

    public String getCityName() {
        return this.d;
    }

    public LatLng getLocation() {
        return this.f5989a;
    }

    public String getName() {
        return this.e;
    }

    public String getPoiId() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f5989a);
        parcel.writeString(this.b);
        parcel.writeString(this.e);
    }

    public PlanNode(LatLng latLng, String str, String str2, String str3, String str4) {
        this.b = null;
        this.e = null;
        this.f = null;
        this.f5989a = latLng;
        this.d = str;
        this.c = str2;
        if (str2 != null) {
            this.b = str2;
        }
        if (str != null) {
            this.b = str;
        }
        this.e = str3;
        this.f = str4;
    }

    public PlanNode(Parcel parcel) {
        this.f5989a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f5989a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.b = parcel.readString();
        this.e = parcel.readString();
    }
}
