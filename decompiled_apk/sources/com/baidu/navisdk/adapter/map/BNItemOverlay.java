package com.baidu.navisdk.adapter.map;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.baidunavis.baseline.BNOuterMapViewManager;
import com.baidu.navisdk.util.common.o;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.ItemizedOverlay;
import com.baidu.platform.comapi.map.OverlayItem;

/* loaded from: classes7.dex */
public class BNItemOverlay extends ItemizedOverlay {
    private final OverlayItem mOverlayItem;

    /* loaded from: classes7.dex */
    public enum CoordinateType {
        BD09MC,
        BD09LL,
        GCJ02
    }

    public BNItemOverlay(double d, double d2, CoordinateType coordinateType, Drawable drawable) {
        super(drawable, BNOuterMapViewManager.getInstance().getGLSurfaceView());
        OverlayItem overlayItem = new OverlayItem(null, "", "");
        this.mOverlayItem = overlayItem;
        overlayItem.setGeoPoint(toGeoPoint(d, d2, coordinateType));
        addItem(overlayItem);
    }

    private GeoPoint toGeoPoint(double d, double d2, CoordinateType coordinateType) {
        if (coordinateType == CoordinateType.GCJ02) {
            Bundle b = o.b(d2, d);
            double d3 = b.getInt("MCx");
            double d4 = b.getInt("MCy");
            this.mOverlayItem.setCoordType(OverlayItem.CoordType.CoordType_BD09);
            return new GeoPoint(d4, d3);
        }
        if (coordinateType == CoordinateType.BD09LL) {
            this.mOverlayItem.setCoordType(OverlayItem.CoordType.CoordType_BD09LL);
            return new GeoPoint(d, d2);
        }
        this.mOverlayItem.setCoordType(OverlayItem.CoordType.CoordType_BD09);
        return new GeoPoint(d, d2);
    }
}
