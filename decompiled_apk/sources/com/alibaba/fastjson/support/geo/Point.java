package com.alibaba.fastjson.support.geo;

import XIXIX.OOXIXo;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = {"type", "bbox", "coordinates"}, typeName = "Point")
/* loaded from: classes.dex */
public class Point extends Geometry {
    private double latitude;
    private double longitude;

    public Point() {
        super("Point");
    }

    public double[] getCoordinates() {
        return new double[]{this.longitude, this.latitude};
    }

    @JSONField(serialize = false)
    public double getLatitude() {
        return this.latitude;
    }

    @JSONField(serialize = false)
    public double getLongitude() {
        return this.longitude;
    }

    public void setCoordinates(double[] dArr) {
        if (dArr != null && dArr.length != 0) {
            if (dArr.length == 1) {
                this.longitude = dArr[0];
                return;
            } else {
                this.longitude = dArr[0];
                this.latitude = dArr[1];
                return;
            }
        }
        this.longitude = OOXIXo.f3760XO;
        this.latitude = OOXIXo.f3760XO;
    }

    @JSONField(deserialize = false)
    public void setLatitude(double d) {
        this.latitude = d;
    }

    @JSONField(deserialize = false)
    public void setLongitude(double d) {
        this.longitude = d;
    }
}
