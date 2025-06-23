package com.baidu.ar.marker.model;

import java.util.Arrays;

/* loaded from: classes7.dex */
public class Existance {
    private String type;
    private double[] uc;
    private String ud;
    private String ue;

    public String getDirectionType() {
        return this.ue;
    }

    public double[] getLatlng() {
        return this.uc;
    }

    public String getStreetName() {
        return this.ud;
    }

    public String getType() {
        return this.type;
    }

    public void setDirectionType(String str) {
        this.ue = str;
    }

    public void setLatlng(double[] dArr) {
        this.uc = dArr;
    }

    public void setStreetName(String str) {
        this.ud = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "Existance{type='" + this.type + "', latlng=" + Arrays.toString(this.uc) + ", streetName='" + this.ud + "', directionType='" + this.ue + "'}";
    }
}
