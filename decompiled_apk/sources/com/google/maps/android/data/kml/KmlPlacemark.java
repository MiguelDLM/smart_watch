package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import java.util.Map;

/* loaded from: classes10.dex */
public class KmlPlacemark extends Feature {
    private final KmlStyle mInlineStyle;
    private final String mStyle;

    public KmlPlacemark(Geometry geometry, String str, KmlStyle kmlStyle, Map<String, String> map) {
        super(geometry, str, map);
        this.mStyle = str;
        this.mInlineStyle = kmlStyle;
    }

    public KmlStyle getInlineStyle() {
        return this.mInlineStyle;
    }

    public MarkerOptions getMarkerOptions() {
        KmlStyle kmlStyle = this.mInlineStyle;
        if (kmlStyle == null) {
            return null;
        }
        return kmlStyle.getMarkerOptions();
    }

    public PolygonOptions getPolygonOptions() {
        KmlStyle kmlStyle = this.mInlineStyle;
        if (kmlStyle == null) {
            return null;
        }
        return kmlStyle.getPolygonOptions();
    }

    public PolylineOptions getPolylineOptions() {
        KmlStyle kmlStyle = this.mInlineStyle;
        if (kmlStyle == null) {
            return null;
        }
        return kmlStyle.getPolylineOptions();
    }

    public String getStyleId() {
        return super.getId();
    }

    public String toString() {
        return "Placemark{\n style id=" + this.mStyle + ",\n inline style=" + this.mInlineStyle + "\n}\n";
    }
}
