package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

/* loaded from: classes7.dex */
public class CoordinateConverter {

    /* renamed from: a, reason: collision with root package name */
    private LatLng f6013a;
    private CoordType b;

    /* loaded from: classes7.dex */
    public enum CoordType {
        GPS,
        COMMON,
        BD09LL,
        BD09MC
    }

    private static LatLng a(LatLng latLng) {
        return a(latLng, "wgs84");
    }

    private static LatLng b(LatLng latLng) {
        return a(latLng, "gcj02");
    }

    private static LatLng c(LatLng latLng) {
        return a(latLng, "bd09mc");
    }

    private static LatLng d(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return CoordTrans.baiduToGcj(latLng);
    }

    public LatLng convert() {
        if (this.f6013a == null) {
            return null;
        }
        if (this.b == null) {
            this.b = CoordType.GPS;
        }
        int i = a.f6014a[this.b.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return c(this.f6013a);
                }
                return d(this.f6013a);
            }
            return a(this.f6013a);
        }
        return b(this.f6013a);
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.f6013a = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.b = coordType;
        return this;
    }

    private static LatLng a(LatLng latLng, String str) {
        if (latLng == null) {
            return null;
        }
        return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }
}
