package com.baidu.navisdk.module.nearbysearch.model;

import android.text.TextUtils;
import com.baidu.navisdk.j;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public class a extends RoutePlanNode {

    /* renamed from: a, reason: collision with root package name */
    private String f7210a;
    private String b;

    public a() {
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f7210a;
    }

    public boolean equals(Object obj) {
        GeoPoint geoPoint;
        GeoPoint geoPoint2;
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.mName;
            if (str == null ? aVar.mName != null : !str.equals(aVar.mName)) {
                return false;
            }
            String str2 = this.mUID;
            if (str2 == null ? aVar.mUID != null : !str2.equals(aVar.mUID)) {
                return false;
            }
            if (j.d()) {
                GeoPoint geoPoint3 = this.mGeoPoint;
                if (geoPoint3 != null && (geoPoint2 = aVar.mGeoPoint) != null && geoPoint3.equals(geoPoint2)) {
                    return true;
                }
                return false;
            }
            GeoPoint geoPoint4 = this.mGeoPoint;
            if (geoPoint4 != null && (geoPoint = aVar.mGeoPoint) != null && geoPoint4.equals(geoPoint) && this.mId == aVar.mId) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.navisdk.model.datastruct.RoutePlanNode
    public String toString() {
        return "ApproachPoi{" + super.toString() + "， mCategoryName='" + this.f7210a + "', mBrandName='" + this.b + "'}";
    }

    public a(RoutePlanNode routePlanNode) {
        super(routePlanNode);
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.f7210a = str;
    }

    public a(GeoPoint geoPoint) {
        this.mGeoPoint = new GeoPoint(geoPoint);
    }

    public boolean a(Object obj) {
        GeoPoint geoPoint;
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (!(TextUtils.isEmpty(this.mUID) && TextUtils.isEmpty(aVar.mUID)) && TextUtils.equals(this.mUID, aVar.mUID)) {
                return true;
            }
            String str = this.mName;
            if (str == null ? aVar.mName != null : !str.equals(aVar.mName)) {
                return false;
            }
            GeoPoint geoPoint2 = this.mGeoPoint;
            if (geoPoint2 != null && (geoPoint = aVar.mGeoPoint) != null) {
                return geoPoint2.approximate(geoPoint);
            }
        }
        return false;
    }

    @Override // com.baidu.navisdk.model.datastruct.RoutePlanNode
    /* renamed from: clone */
    public a mo81clone() {
        a aVar = new a(this);
        aVar.mId = this.mId;
        String str = this.mName;
        if (str == null) {
            str = "";
        }
        aVar.mName = str;
        String str2 = this.f7210a;
        if (str2 == null) {
            str2 = "";
        }
        aVar.f7210a = str2;
        String str3 = this.b;
        aVar.b = str3 != null ? str3 : "";
        GeoPoint geoPoint = this.mGeoPoint;
        aVar.mGeoPoint = geoPoint == null ? null : new GeoPoint(geoPoint.getLongitudeE6(), this.mGeoPoint.getLatitudeE6());
        return aVar;
    }

    public a(GeoPoint geoPoint, String str) {
        this.mGeoPoint = new GeoPoint(geoPoint);
        this.mUID = str == null ? "" : str;
    }

    public a(GeoPoint geoPoint, String str, int i) {
        this.mGeoPoint = new GeoPoint(geoPoint);
        this.mUID = str == null ? "" : str;
        this.mId = i;
    }

    public a(String str, GeoPoint geoPoint) {
        this.mName = str == null ? "" : str;
        this.mGeoPoint = new GeoPoint(geoPoint);
    }
}
