package com.google.maps.android.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* loaded from: classes10.dex */
public class Feature extends Observable {
    private Geometry mGeometry;
    protected String mId;
    private final Map<String, String> mProperties;

    public Feature(Geometry geometry, String str, Map<String, String> map) {
        this.mGeometry = geometry;
        this.mId = str;
        if (map == null) {
            this.mProperties = new HashMap();
        } else {
            this.mProperties = map;
        }
    }

    public Geometry getGeometry() {
        return this.mGeometry;
    }

    public String getId() {
        return this.mId;
    }

    public Iterable getProperties() {
        return this.mProperties.entrySet();
    }

    public String getProperty(String str) {
        return this.mProperties.get(str);
    }

    public Iterable<String> getPropertyKeys() {
        return this.mProperties.keySet();
    }

    public boolean hasGeometry() {
        if (this.mGeometry != null) {
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

    public String removeProperty(String str) {
        return this.mProperties.remove(str);
    }

    public void setGeometry(Geometry geometry) {
        this.mGeometry = geometry;
    }

    public String setProperty(String str, String str2) {
        return this.mProperties.put(str, str2);
    }
}
