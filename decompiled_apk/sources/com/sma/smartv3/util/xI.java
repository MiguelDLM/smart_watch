package com.sma.smartv3.util;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.sma.smartv3.model.CustomLatLng;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes12.dex */
public final class xI {
    @OXOo.OOXIXo
    public static final Pair<CustomLatLng, CustomLatLng> I0Io(@OXOo.OOXIXo List<CustomLatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        CustomLatLng customLatLng = new CustomLatLng(points.get(0).getLatitude(), points.get(0).getLongitude(), 0L, 0, 0, 28, null);
        CustomLatLng customLatLng2 = new CustomLatLng(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0L, 0, 0, 28, null);
        for (CustomLatLng customLatLng3 : points) {
            if (customLatLng2.getLatitude() < customLatLng3.getLatitude() || (customLatLng3.getLatitude() < XIXIX.OOXIXo.f3760XO && customLatLng2.getLatitude() == XIXIX.OOXIXo.f3760XO)) {
                customLatLng2.setLatitude(customLatLng3.getLatitude());
            }
            if (customLatLng2.getLongitude() < customLatLng3.getLongitude()) {
                customLatLng2.setLongitude(customLatLng3.getLongitude());
            }
            if (customLatLng.getLatitude() > customLatLng3.getLatitude()) {
                customLatLng.setLatitude(customLatLng3.getLatitude());
            }
            if (customLatLng.getLongitude() > customLatLng3.getLongitude()) {
                customLatLng.setLongitude(customLatLng3.getLongitude());
            }
        }
        return new Pair<>(customLatLng, customLatLng2);
    }

    public static final float II0xO0(@OXOo.OOXIXo List<CustomLatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        if (!points.isEmpty()) {
            List X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 25000, 50000, 100000, 200000, 500000, 1000000, 2000000);
            double latitude = points.get(0).getLatitude();
            double longitude = points.get(0).getLongitude();
            double d = 0.0d;
            double d2 = 0.0d;
            for (CustomLatLng customLatLng : points) {
                if (d < customLatLng.getLatitude() || (customLatLng.getLatitude() < XIXIX.OOXIXo.f3760XO && d == XIXIX.OOXIXo.f3760XO)) {
                    d = customLatLng.getLatitude();
                }
                if (d2 < customLatLng.getLongitude()) {
                    d2 = customLatLng.getLongitude();
                }
                if (latitude > customLatLng.getLatitude()) {
                    latitude = customLatLng.getLatitude();
                }
                if (longitude > customLatLng.getLongitude()) {
                    longitude = customLatLng.getLongitude();
                }
            }
            double distance = DistanceUtil.getDistance(new LatLng(d, d2), new LatLng(latitude, longitude)) / 10;
            int size = X00IoxXI2.size();
            for (int i = 0; i < size; i++) {
                if (((Number) X00IoxXI2.get(i)).doubleValue() - distance > XIXIX.OOXIXo.f3760XO) {
                    return 20 - i;
                }
            }
            return 6.0f;
        }
        return 6.0f;
    }

    public static final void oIX0oI(@OXOo.OOXIXo List<CustomLatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        for (CustomLatLng customLatLng : points) {
        }
    }
}
