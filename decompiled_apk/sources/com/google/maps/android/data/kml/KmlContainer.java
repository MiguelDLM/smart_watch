package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.GroundOverlay;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class KmlContainer {
    private String mContainerId;
    private final ArrayList<KmlContainer> mContainers;
    private final HashMap<KmlGroundOverlay, GroundOverlay> mGroundOverlays;
    private final HashMap<KmlPlacemark, Object> mPlacemarks;
    private final HashMap<String, String> mProperties;
    private final HashMap<String, String> mStyleMap;
    private HashMap<String, KmlStyle> mStyles;

    public KmlContainer(HashMap<String, String> hashMap, HashMap<String, KmlStyle> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, HashMap<String, String> hashMap4, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap5, String str) {
        this.mProperties = hashMap;
        this.mPlacemarks = hashMap3;
        this.mStyles = hashMap2;
        this.mStyleMap = hashMap4;
        this.mContainers = arrayList;
        this.mGroundOverlays = hashMap5;
        this.mContainerId = str;
    }

    public String getContainerId() {
        return this.mContainerId;
    }

    public Iterable<KmlContainer> getContainers() {
        return this.mContainers;
    }

    public HashMap<KmlGroundOverlay, GroundOverlay> getGroundOverlayHashMap() {
        return this.mGroundOverlays;
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return this.mGroundOverlays.keySet();
    }

    public Iterable<KmlPlacemark> getPlacemarks() {
        return this.mPlacemarks.keySet();
    }

    public HashMap<KmlPlacemark, Object> getPlacemarksHashMap() {
        return this.mPlacemarks;
    }

    public Iterable<String> getProperties() {
        return this.mProperties.keySet();
    }

    public String getProperty(String str) {
        return this.mProperties.get(str);
    }

    public KmlStyle getStyle(String str) {
        return this.mStyles.get(str);
    }

    public String getStyleIdFromMap(String str) {
        return this.mStyleMap.get(str);
    }

    public HashMap<String, String> getStyleMap() {
        return this.mStyleMap;
    }

    public HashMap<String, KmlStyle> getStyles() {
        return this.mStyles;
    }

    public boolean hasContainers() {
        if (this.mContainers.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean hasPlacemarks() {
        if (this.mPlacemarks.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean hasProperties() {
        if (this.mProperties.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean hasProperty(String str) {
        return this.mProperties.containsKey(str);
    }

    public void setPlacemark(KmlPlacemark kmlPlacemark, Object obj) {
        this.mPlacemarks.put(kmlPlacemark, obj);
    }

    public String toString() {
        return "Container{\n properties=" + this.mProperties + ",\n placemarks=" + this.mPlacemarks + ",\n containers=" + this.mContainers + ",\n ground overlays=" + this.mGroundOverlays + ",\n style maps=" + this.mStyleMap + ",\n styles=" + this.mStyles + "\n}\n";
    }
}
