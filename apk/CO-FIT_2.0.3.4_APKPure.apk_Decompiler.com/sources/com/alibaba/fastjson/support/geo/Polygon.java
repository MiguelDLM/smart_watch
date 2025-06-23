package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;
import com.google.maps.android.data.kml.KmlPolygon;

@JSONType(orders = {"type", "bbox", "coordinates"}, typeName = "Polygon")
public class Polygon extends Geometry {
    private double[][][] coordinates;

    public Polygon() {
        super(KmlPolygon.GEOMETRY_TYPE);
    }

    public double[][][] getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(double[][][] dArr) {
        this.coordinates = dArr;
    }
}
