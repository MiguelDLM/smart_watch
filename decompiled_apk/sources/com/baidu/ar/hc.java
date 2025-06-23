package com.baidu.ar;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class hc {
    private int mHeight;
    private long mTimestamp;
    private int mWidth;
    private ByteBuffer vT;

    public hc(ByteBuffer byteBuffer, long j) {
        this.vT = byteBuffer;
        this.mTimestamp = j;
    }

    public ByteBuffer getData() {
        return this.vT;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public long getTimestamp() {
        return this.mTimestamp;
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
}
