package com.baidu.mapapi.walknavi.params;

import XIXIX.OOXIXo;
import android.text.TextUtils;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public abstract class a {
    protected String b;
    protected LatLng c;

    /* renamed from: a, reason: collision with root package name */
    protected RouteNodeType f6046a = RouteNodeType.LOCATION;
    protected int d = -1;
    protected String e = "";
    protected String f = "";

    public String getBuildingID() {
        return this.f;
    }

    public int getCitycode() {
        return this.d;
    }

    public String getFloorID() {
        return this.e;
    }

    public String getKeyword() {
        return this.b;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public RouteNodeType getType() {
        return this.f6046a;
    }

    public abstract void setBuildingID(String str);

    public void setCitycode(int i) {
        this.d = i;
    }

    public abstract void setFloorID(String str);

    public abstract void setKeyword(String str);

    public abstract void setLocation(LatLng latLng);

    public abstract void setType(RouteNodeType routeNodeType);

    public String toQuery() {
        com.baidu.platform.comapi.wnplatform.e.a.a aVar = new com.baidu.platform.comapi.wnplatform.e.a.a();
        aVar.a();
        aVar.a("type").a(this.f6046a.getNativeType());
        aVar.a("uid").b("");
        if (this.b != null) {
            aVar.a("keyword").b(this.b);
        } else {
            aVar.a("keyword").b("");
        }
        aVar.a("keyword2").b("");
        LatLng latLng = this.c;
        if (latLng != null) {
            if (latLng.longitude != OOXIXo.f3760XO && latLng.latitude != OOXIXo.f3760XO) {
                GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
                aVar.a("xy").b(String.format("%d,%d", Integer.valueOf((int) ll2mc.getLongitudeE6()), Integer.valueOf((int) ll2mc.getLatitudeE6())));
            } else {
                aVar.a("xy").b("");
            }
        } else {
            aVar.a("xy").b("");
        }
        if (!TextUtils.isEmpty(this.e)) {
            aVar.a("floor").b(this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
            aVar.a("building").b(this.f);
        }
        aVar.b();
        return aVar.toString();
    }
}
