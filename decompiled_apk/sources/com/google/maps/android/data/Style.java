package com.google.maps.android.data;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.Observable;

/* loaded from: classes10.dex */
public abstract class Style extends Observable {
    protected MarkerOptions mMarkerOptions = new MarkerOptions();
    protected PolygonOptions mPolygonOptions;
    protected PolylineOptions mPolylineOptions;

    public Style() {
        PolylineOptions polylineOptions = new PolylineOptions();
        this.mPolylineOptions = polylineOptions;
        polylineOptions.clickable(true);
        PolygonOptions polygonOptions = new PolygonOptions();
        this.mPolygonOptions = polygonOptions;
        polygonOptions.clickable(true);
    }

    public float getRotation() {
        return this.mMarkerOptions.getRotation();
    }

    public void setLineStringWidth(float f) {
        this.mPolylineOptions.width(f);
    }

    public void setMarkerHotSpot(float f, float f2, String str, String str2) {
        if (!str.equals("fraction")) {
            f = 0.5f;
        }
        if (!str2.equals("fraction")) {
            f2 = 1.0f;
        }
        this.mMarkerOptions.anchor(f, f2);
    }

    public void setMarkerRotation(float f) {
        this.mMarkerOptions.rotation(f);
    }

    public void setPolygonFillColor(int i) {
        this.mPolygonOptions.fillColor(i);
    }

    public void setPolygonStrokeWidth(float f) {
        this.mPolygonOptions.strokeWidth(f);
    }
}
