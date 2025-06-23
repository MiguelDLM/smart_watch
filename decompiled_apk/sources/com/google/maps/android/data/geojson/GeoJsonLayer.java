package com.google.maps.android.data.geojson;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Layer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class GeoJsonLayer extends Layer {
    private LatLngBounds mBoundingBox;

    /* loaded from: classes10.dex */
    public interface GeoJsonOnFeatureClickListener extends Layer.OnFeatureClickListener {
    }

    public GeoJsonLayer(GoogleMap googleMap, JSONObject jSONObject, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        if (jSONObject != null) {
            this.mBoundingBox = null;
            GeoJsonParser geoJsonParser = new GeoJsonParser(jSONObject);
            this.mBoundingBox = geoJsonParser.getBoundingBox();
            HashMap hashMap = new HashMap();
            Iterator<GeoJsonFeature> it = geoJsonParser.getFeatures().iterator();
            while (it.hasNext()) {
                hashMap.put(it.next(), null);
            }
            storeRenderer(new GeoJsonRenderer(googleMap, hashMap, markerManager, polygonManager, polylineManager, groundOverlayManager));
            return;
        }
        throw new IllegalArgumentException("GeoJSON file cannot be null");
    }

    private static JSONObject createJsonFileObject(InputStream inputStream) throws IOException, JSONException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                bufferedReader.close();
                return new JSONObject(sb.toString());
            }
        }
    }

    public void addFeature(GeoJsonFeature geoJsonFeature) {
        if (geoJsonFeature != null) {
            super.addFeature((Feature) geoJsonFeature);
            return;
        }
        throw new IllegalArgumentException("Feature cannot be null");
    }

    @Override // com.google.maps.android.data.Layer
    public void addLayerToMap() {
        super.addGeoJsonToMap();
    }

    public LatLngBounds getBoundingBox() {
        return this.mBoundingBox;
    }

    @Override // com.google.maps.android.data.Layer
    public Iterable<GeoJsonFeature> getFeatures() {
        return super.getFeatures();
    }

    public void removeFeature(GeoJsonFeature geoJsonFeature) {
        if (geoJsonFeature != null) {
            super.removeFeature((Feature) geoJsonFeature);
            return;
        }
        throw new IllegalArgumentException("Feature cannot be null");
    }

    public String toString() {
        return "Collection{\n Bounding box=" + this.mBoundingBox + "\n}\n";
    }

    public GeoJsonLayer(GoogleMap googleMap, int i, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) throws IOException, JSONException {
        this(googleMap, createJsonFileObject(context.getResources().openRawResource(i)), markerManager, polygonManager, polylineManager, groundOverlayManager);
    }

    public GeoJsonLayer(GoogleMap googleMap, JSONObject jSONObject) {
        this(googleMap, jSONObject, null, null, null, null);
    }

    public GeoJsonLayer(GoogleMap googleMap, int i, Context context) throws IOException, JSONException {
        this(googleMap, createJsonFileObject(context.getResources().openRawResource(i)), null, null, null, null);
    }
}
