package com.baidu.navisdk.adapter.struct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public class BNSearchPoi {
    public String mAddress;
    public int mDistrictId;
    public GeoPoint mGuidePoint;
    public String mName;
    public String mPhone;
    public GeoPoint mViewPoint;
    public int unCurPosDistance;
    public String mUid = null;
    public String mPoiTag = null;
    public String mRouteCost = null;

    public BNSearchPoi(BNSearchPoi bNSearchPoi) {
        copy(bNSearchPoi);
    }

    public void copy(BNSearchPoi bNSearchPoi) {
        if (bNSearchPoi == null) {
            return;
        }
        String str = bNSearchPoi.mName;
        if (str != null) {
            this.mName = new String(str);
        } else {
            this.mName = "";
        }
        String str2 = bNSearchPoi.mAddress;
        if (str2 != null) {
            this.mAddress = new String(str2);
        } else {
            this.mAddress = "";
        }
        int i = bNSearchPoi.unCurPosDistance;
        if (i > 0) {
            this.unCurPosDistance = i;
        } else {
            this.unCurPosDistance = 0;
        }
        String str3 = bNSearchPoi.mPhone;
        if (str3 != null) {
            this.mPhone = new String(str3);
        } else {
            this.mPhone = "";
        }
        GeoPoint geoPoint = bNSearchPoi.mGuidePoint;
        if (geoPoint != null) {
            this.mGuidePoint = new GeoPoint(geoPoint.getLongitudeE6(), bNSearchPoi.mGuidePoint.getLatitudeE6());
        } else {
            this.mGuidePoint = new GeoPoint();
        }
        GeoPoint geoPoint2 = bNSearchPoi.mViewPoint;
        if (geoPoint2 != null) {
            this.mViewPoint = new GeoPoint(geoPoint2.getLongitudeE6(), bNSearchPoi.mViewPoint.getLatitudeE6());
        } else {
            this.mViewPoint = new GeoPoint();
        }
        this.mDistrictId = bNSearchPoi.mDistrictId;
        String str4 = bNSearchPoi.mUid;
        if (str4 != null) {
            this.mUid = new String(str4);
        } else {
            this.mUid = null;
        }
        this.mPoiTag = bNSearchPoi.mPoiTag;
        this.mRouteCost = bNSearchPoi.mRouteCost;
    }

    public String toString() {
        String geoPoint;
        StringBuilder sb = new StringBuilder();
        sb.append("a: ");
        sb.append(this.mAddress);
        sb.append("n: ");
        sb.append(this.mName);
        sb.append("p: ");
        GeoPoint geoPoint2 = this.mViewPoint;
        if (geoPoint2 == null) {
            geoPoint = "null";
        } else {
            geoPoint = geoPoint2.toString();
        }
        sb.append(geoPoint);
        return sb.toString();
    }

    public BNSearchPoi() {
    }
}
