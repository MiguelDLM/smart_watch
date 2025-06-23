package com.baidu.platform.comapi.map.b;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapViewInterface;
import java.util.IllegalFormatException;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private float f9651a;
    private StringBuffer b = new StringBuffer();
    private StringBuffer c = new StringBuffer();
    private MapController d;

    /* loaded from: classes8.dex */
    public enum a {
        ZOOM_OUT,
        ZOOM_IN,
        FLING,
        MOVE,
        ROTATE,
        DOUBLE_CLICK_ZOOM_IN,
        TWO_CLICK_ZOOM_OUT,
        MOVE_OVERLOOK
    }

    public d(MapController mapController) {
        this.d = mapController;
    }

    private void d(float f) {
        this.f9651a = f;
    }

    private boolean e(float f) {
        if (f > this.f9651a) {
            return true;
        }
        return false;
    }

    private boolean f(float f) {
        if (f < this.f9651a) {
            return true;
        }
        return false;
    }

    public void a() {
        a(a.FLING);
    }

    public void b(float f) {
        a(a.DOUBLE_CLICK_ZOOM_IN);
        d(f);
    }

    public void c(float f) {
        a(a.TWO_CLICK_ZOOM_OUT);
        d(f);
    }

    public void a(float f) {
        if (e(f)) {
            a(a.ZOOM_OUT);
        }
        if (f(f)) {
            a(a.ZOOM_IN);
        }
        d(f);
    }

    public void d() {
        a(a.MOVE_OVERLOOK);
    }

    public void b() {
        a(a.MOVE);
    }

    public void c() {
        a(a.ROTATE);
    }

    private String b(a aVar) {
        switch (e.f9653a[aVar.ordinal()]) {
            case 1:
            case 2:
                return "0";
            case 3:
                return "1";
            case 4:
                return "2";
            case 5:
                return "3";
            case 6:
                return "4";
            case 7:
                return "5";
            case 8:
                return "6";
            default:
                return "";
        }
    }

    private void a(a aVar) {
        MapViewInterface mapView;
        String b;
        MapController mapController = this.d;
        if (mapController == null || (mapView = mapController.getMapView()) == null) {
            return;
        }
        GeoPoint mapCenter = mapView.getMapCenter();
        try {
            b = String.format("(%s,%d,%d,%d,%d)", b(aVar), Double.valueOf(mapCenter.getLongitudeE6()), Double.valueOf(mapCenter.getLatitudeE6()), Integer.valueOf((int) mapView.getZoomLevel()), Long.valueOf(System.currentTimeMillis()));
        } catch (IllegalFormatException unused) {
            b = b(aVar);
        }
        StringBuffer stringBuffer = this.b;
        if (stringBuffer == null) {
            return;
        }
        stringBuffer.append(b);
        StringBuffer stringBuffer2 = this.c;
        if (stringBuffer2 == null) {
            return;
        }
        stringBuffer2.append(b(aVar));
    }
}
