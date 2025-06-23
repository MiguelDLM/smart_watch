package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;
import java.util.LinkedHashMap;
import java.util.Map;
import o0oIxXOx.XIxXXX0x0;

@JSONType(orders = {"type", "id", "bbox", "coordinates", XIxXXX0x0.f31177x0xO0oo}, typeName = "Feature")
/* loaded from: classes.dex */
public class Feature extends Geometry {
    private Geometry geometry;
    private String id;
    private Map<String, String> properties;

    public Feature() {
        super("Feature");
        this.properties = new LinkedHashMap();
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    public String getId() {
        return this.id;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }
}
