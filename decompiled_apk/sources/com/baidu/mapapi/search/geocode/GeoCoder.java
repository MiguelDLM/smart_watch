package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;

/* loaded from: classes7.dex */
public class GeoCoder extends n {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.platform.core.c.d f5956a = new com.baidu.platform.core.c.a();
    private boolean b;

    private GeoCoder() {
    }

    public static GeoCoder newInstance() {
        BMapManager.init();
        return new GeoCoder();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f5956a.a();
        BMapManager.destroy();
    }

    public boolean geocode(GeoCodeOption geoCodeOption) {
        com.baidu.platform.core.c.d dVar = this.f5956a;
        if (dVar != null) {
            if (geoCodeOption != null && geoCodeOption.mAddress != null && geoCodeOption.mCity != null) {
                return dVar.a(geoCodeOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or address or city can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
    }

    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (this.f5956a != null) {
            if (reverseGeoCodeOption != null && reverseGeoCodeOption.getLocation() != null) {
                return this.f5956a.a(reverseGeoCodeOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or mLocation can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
    }

    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        com.baidu.platform.core.c.d dVar = this.f5956a;
        if (dVar != null) {
            if (onGetGeoCoderResultListener != null) {
                dVar.a(onGetGeoCoderResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
    }
}
