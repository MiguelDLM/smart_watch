package com.baidu.ar.rotate;

/* loaded from: classes7.dex */
public enum Orientation {
    UNKNOWN(-1),
    PORTRAIT(0),
    PORTRAIT_REVERSE(180),
    LANDSCAPE(90),
    LANDSCAPE_REVERSE(-90);

    private int mDegree;

    Orientation(int i) {
        this.mDegree = i;
    }

    public static Orientation valueOf(int i) {
        Orientation orientation = PORTRAIT;
        if (i == orientation.getDegree()) {
            return orientation;
        }
        Orientation orientation2 = PORTRAIT_REVERSE;
        if (i == orientation2.getDegree()) {
            return orientation2;
        }
        Orientation orientation3 = LANDSCAPE;
        if (i == orientation3.getDegree()) {
            return orientation3;
        }
        Orientation orientation4 = LANDSCAPE_REVERSE;
        return i == orientation4.getDegree() ? orientation4 : UNKNOWN;
    }

    public int getDegree() {
        return this.mDegree;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.mDegree);
    }
}
