package com.baidu.ar.face.algo;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class FAUImage {
    public ByteBuffer data;
    public int format;
    public int height;
    public int width;
    public int rotation = 0;
    public int flip = 0;
    public float scale = 1.0f;
    public float timestamp = 0.0f;

    public FAUImage(ByteBuffer byteBuffer, int i, int i2, int i3) {
        this.width = i;
        this.height = i2;
        this.format = i3;
        this.data = byteBuffer;
    }

    public void setData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    public void setFormat(int i) {
        this.format = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setScale(float f) {
        this.scale = f;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
