package com.baidu.ar.bean;

/* loaded from: classes7.dex */
public enum RotationType {
    ROTATE_0(0),
    ROTATE_90(90),
    ROTATE_180(180),
    ROTATE_270(270);

    private final int mDegree;

    RotationType(int i) {
        this.mDegree = i;
    }

    public int getDegree() {
        return this.mDegree;
    }
}
