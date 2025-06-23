package com.baidu.ar.algo;

/* loaded from: classes7.dex */
public enum FrameType {
    TYPE_YUV(0),
    TYPE_RGB(1),
    TYPE_BGR(2),
    TYPE_RGBA(3),
    TYPE_GRAY(4);

    private int value;

    FrameType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
