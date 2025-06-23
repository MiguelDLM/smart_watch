package com.baidu.platform.comapi.wnplatform.walkmap;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.platform.comjni.map.basemap.NABaseMap;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.util.GmsVersion;

/* loaded from: classes8.dex */
public class WNaviBaiduMap {
    private static long b;
    private static WNaviBaiduMap c;

    /* renamed from: a, reason: collision with root package name */
    private NABaseMap f9971a = new NABaseMap();

    public static void clearOverlay(Overlay overlay) {
        if (overlay instanceof Marker) {
            overlay.remove();
        }
    }

    public static void clearOverlays() {
    }

    public static long getId() {
        return b;
    }

    public static synchronized WNaviBaiduMap getInstance() {
        WNaviBaiduMap wNaviBaiduMap;
        synchronized (WNaviBaiduMap.class) {
            try {
                if (c == null) {
                    c = new WNaviBaiduMap();
                }
                wNaviBaiduMap = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wNaviBaiduMap;
    }

    public static int getScaleDis(int i) {
        switch (i) {
            case 1:
                return 10000000;
            case 2:
                return GmsVersion.VERSION_LONGHORN;
            case 3:
                return 2000000;
            case 4:
                return 1000000;
            case 5:
                return 500000;
            case 6:
                return 200000;
            case 7:
                return 100000;
            case 8:
                return 50000;
            case 9:
                return 25000;
            case 10:
                return 20000;
            case 11:
                return 10000;
            case 12:
                return 5000;
            case 13:
                return 2000;
            case 14:
                return 1000;
            case 15:
                return 500;
            case 16:
                return 200;
            case 17:
                return 100;
            case 18:
                return 50;
            case 19:
                return 20;
            case 20:
                return 10;
            case 21:
                return 5;
            case 22:
                return 2;
            default:
                return 0;
        }
    }

    public static void setCompassPosition(Point point) {
    }

    public static void showMapPoi(boolean z) {
    }

    public void SetStyleMode(int i) {
    }

    public float getZoomLevel() {
        return 3.0f;
    }

    public float getZoomToBound(Bundle bundle, int i, int i2) {
        bundle.putInt("hasHW", 1);
        bundle.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i);
        bundle.putInt("height", i2);
        return this.f9971a.getZoomToBound(b, bundle, i, i2);
    }

    public double getZoomUnitsInMeter() {
        return Math.pow(2.0d, 18.0f - getZoomLevel());
    }

    public void setId(long j) {
        b = j;
    }

    public void setSatellite(boolean z) {
    }
}
