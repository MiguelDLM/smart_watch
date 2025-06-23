package com.baidu.ar.marker.model;

import java.util.List;

/* loaded from: classes7.dex */
public class Segments {
    private Existance uf;
    private int ug;
    private List<double[]> uh;

    public Existance getExistance() {
        return this.uf;
    }

    public List<double[]> getPoints() {
        return this.uh;
    }

    public int getPointsCount() {
        return this.ug;
    }

    public void setExistance(Existance existance) {
        this.uf = existance;
    }

    public void setPoints(List<double[]> list) {
        this.uh = list;
    }

    public void setPointsCount(int i) {
        this.ug = i;
    }

    public String toString() {
        return "Segments{existance=" + this.uf.toString() + ", pointsCount=" + this.ug + ", points=" + this.uh + '}';
    }
}
