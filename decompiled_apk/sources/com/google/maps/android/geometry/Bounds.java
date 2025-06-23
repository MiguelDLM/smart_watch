package com.google.maps.android.geometry;

/* loaded from: classes10.dex */
public class Bounds {
    public final double maxX;
    public final double maxY;
    public final double midX;
    public final double midY;
    public final double minX;
    public final double minY;

    public Bounds(double d, double d2, double d3, double d4) {
        this.minX = d;
        this.minY = d3;
        this.maxX = d2;
        this.maxY = d4;
        this.midX = (d + d2) / 2.0d;
        this.midY = (d3 + d4) / 2.0d;
    }

    public boolean contains(double d, double d2) {
        return this.minX <= d && d <= this.maxX && this.minY <= d2 && d2 <= this.maxY;
    }

    public boolean intersects(double d, double d2, double d3, double d4) {
        return d < this.maxX && this.minX < d2 && d3 < this.maxY && this.minY < d4;
    }

    public boolean contains(Point point) {
        return contains(point.x, point.y);
    }

    public boolean intersects(Bounds bounds) {
        return intersects(bounds.minX, bounds.maxX, bounds.minY, bounds.maxY);
    }

    public boolean contains(Bounds bounds) {
        return bounds.minX >= this.minX && bounds.maxX <= this.maxX && bounds.minY >= this.minY && bounds.maxY <= this.maxY;
    }
}
