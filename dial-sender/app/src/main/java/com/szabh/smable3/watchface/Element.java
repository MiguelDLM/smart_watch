package com.szabh.smable3.watchface;

import java.util.Arrays;

public final class Element {
    private final int bottomOffset;
    private final int gravity;
    private final int h;
    private final int hasAlpha;
    private final int ignoreBlack;
    private final byte[][] imageBuffers;
    private final int leftOffset;
    private final int playInterval;
    private final int type;
    private final int w;
    private final int x;
    private final int y;

    public Element(int type, int hasAlpha, int w, int h, int gravity, int ignoreBlack, int x, int y, int playInterval, int bottomOffset, int leftOffset, byte[][] imageBuffers) {
        this.type = type;
        this.hasAlpha = hasAlpha;
        this.w = w;
        this.h = h;
        this.gravity = gravity;
        this.ignoreBlack = ignoreBlack;
        this.x = x;
        this.y = y;
        this.playInterval = playInterval;
        this.bottomOffset = bottomOffset;
        this.leftOffset = leftOffset;
        this.imageBuffers = imageBuffers;
    }
}
