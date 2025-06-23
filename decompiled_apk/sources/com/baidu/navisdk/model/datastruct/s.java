package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public int f6941a;
    public int b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public int h;
    public String i;
    public GeoPoint j;
    public GeoPoint k;
    public int l;
    public int m;
    public String n;
    public int o;
    public int q;
    public int r;
    public int s;
    public int x;
    public String y;
    public String p = null;
    public String t = null;
    public String u = null;
    public int v = 0;
    public boolean w = false;
    public int z = 0;

    public void a(s sVar) {
        if (sVar == null) {
            return;
        }
        String str = sVar.e;
        if (str != null) {
            this.e = str;
        } else {
            this.e = "";
        }
        String str2 = sVar.g;
        if (str2 != null) {
            this.g = str2;
        } else {
            this.g = "";
        }
        int i = sVar.h;
        if (i > 0) {
            this.h = i;
        } else {
            this.h = 0;
        }
        String str3 = sVar.i;
        if (str3 != null) {
            this.i = str3;
        } else {
            this.i = "";
        }
        GeoPoint geoPoint = sVar.j;
        if (geoPoint != null) {
            this.j = new GeoPoint(geoPoint.getLongitudeE6(), sVar.j.getLatitudeE6());
        } else {
            this.j = new GeoPoint();
        }
        GeoPoint geoPoint2 = sVar.k;
        if (geoPoint2 != null) {
            this.k = new GeoPoint(geoPoint2.getLongitudeE6(), sVar.k.getLatitudeE6());
        } else {
            this.k = new GeoPoint();
        }
        this.l = sVar.l;
        this.m = sVar.m;
        String str4 = sVar.n;
        if (str4 != null) {
            this.n = str4;
        } else {
            this.n = null;
        }
        String str5 = sVar.p;
        if (str5 != null) {
            this.p = str5;
        } else {
            this.p = null;
        }
        this.o = sVar.o;
        this.s = sVar.s;
        this.t = sVar.t;
        this.u = sVar.u;
        this.x = sVar.x;
        this.y = sVar.y;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SearchPoi{");
        stringBuffer.append("mChildCnt=");
        stringBuffer.append(this.f6941a);
        stringBuffer.append(", mFCType=");
        stringBuffer.append(this.b);
        stringBuffer.append(", mShowCatalog=");
        stringBuffer.append(this.c);
        stringBuffer.append(", mPoiCount=");
        stringBuffer.append(this.d);
        stringBuffer.append(", mName='");
        stringBuffer.append(this.e);
        stringBuffer.append('\'');
        stringBuffer.append(", mAliasName='");
        stringBuffer.append(this.f);
        stringBuffer.append('\'');
        stringBuffer.append(", mAddress='");
        stringBuffer.append(this.g);
        stringBuffer.append('\'');
        stringBuffer.append(", unCurPosDistance=");
        stringBuffer.append(this.h);
        stringBuffer.append(", mPhone='");
        stringBuffer.append(this.i);
        stringBuffer.append('\'');
        stringBuffer.append(", mGuidePoint=");
        stringBuffer.append(this.j);
        stringBuffer.append(", mViewPoint=");
        stringBuffer.append(this.k);
        stringBuffer.append(", mDistrictId=");
        stringBuffer.append(this.l);
        stringBuffer.append(", mType=");
        stringBuffer.append(this.m);
        stringBuffer.append(", mStreetId='");
        stringBuffer.append(this.n);
        stringBuffer.append('\'');
        stringBuffer.append(", mId=");
        stringBuffer.append(this.o);
        stringBuffer.append(", mUid='");
        stringBuffer.append(this.p);
        stringBuffer.append('\'');
        stringBuffer.append(", mWeight=");
        stringBuffer.append(this.q);
        stringBuffer.append(", mWanda=");
        stringBuffer.append(this.r);
        stringBuffer.append(", mPoiBrandIdType=");
        stringBuffer.append(this.s);
        stringBuffer.append(", mPoiTag='");
        stringBuffer.append(this.t);
        stringBuffer.append('\'');
        stringBuffer.append(", mRouteCost='");
        stringBuffer.append(this.u);
        stringBuffer.append('\'');
        stringBuffer.append(", mBkgShowType=");
        stringBuffer.append(this.v);
        stringBuffer.append(", isBkgViaFastLabel=");
        stringBuffer.append(this.w);
        stringBuffer.append(", mShopOpenTimeColor=");
        stringBuffer.append(this.x);
        stringBuffer.append(", mShopOpenTime='");
        stringBuffer.append(this.y);
        stringBuffer.append('\'');
        stringBuffer.append(", mIconType=");
        stringBuffer.append(this.z);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
