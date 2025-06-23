package com.baidu.ar.arplay.core.pixel;

/* loaded from: classes7.dex */
public class FrameSize {
    private int mHeight;
    private int mWidth;

    public FrameSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public FrameSize(FrameSize frameSize) {
        this.mWidth = frameSize.getWidth();
        this.mHeight = frameSize.getHeight();
    }
}
