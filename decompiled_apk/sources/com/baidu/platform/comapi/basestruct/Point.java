package com.baidu.platform.comapi.basestruct;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class Point implements Serializable {
    public double doubleX;
    public double doubleY;
    public int x;
    public int y;

    public Point() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        if (getDoubleX() == point.getDoubleX() && getIntX() == point.getIntX() && getDoubleY() == point.getDoubleY() && getIntY() == point.getIntY() && getDoubleY() == point.getDoubleY()) {
            return true;
        }
        return false;
    }

    public double getDoubleX() {
        return this.doubleX;
    }

    public double getDoubleY() {
        return this.doubleY;
    }

    public int getIntX() {
        return this.x;
    }

    public int getIntY() {
        return this.y;
    }

    public int getmPtx() {
        return this.x;
    }

    public int getmPty() {
        return this.y;
    }

    public int hashCode() {
        return ((getIntX() + 31) * 31) + getIntY();
    }

    public void setDoubleX(double d) {
        this.doubleX = d;
    }

    public void setDoubleY(double d) {
        this.doubleY = d;
    }

    public void setIntX(int i) {
        this.x = i;
    }

    public void setIntY(int i) {
        this.y = i;
    }

    public void setTo(double d, double d2) {
        setDoubleX(d);
        setDoubleY(d2);
    }

    public void setmPtx(int i) {
        this.x = i;
    }

    public void setmPty(int i) {
        this.y = i;
    }

    public String toQuery() {
        return String.format("(%d,%d)", Integer.valueOf(getIntX()), Integer.valueOf(getIntY()));
    }

    public String toString() {
        return "Point [x=" + getDoubleX() + ", y=" + getDoubleY() + "]";
    }

    public Point(int i, int i2) {
        this.x = i;
        this.y = i2;
        this.doubleX = i;
        this.doubleY = i2;
    }

    public void setTo(Point point) {
        if (point != null) {
            setDoubleX(point.getDoubleX());
            setDoubleY(point.getDoubleY());
        }
    }

    public Point(double d, double d2) {
        this.x = (int) d;
        this.y = (int) d2;
        this.doubleX = d;
        this.doubleY = d2;
    }

    public Point(Point point) {
        if (point != null) {
            this.doubleX = point.getDoubleX();
            this.doubleY = point.getDoubleY();
            this.x = point.getIntX();
            this.y = point.getIntY();
        }
    }
}
