package com.baidu.ar.face.algo;

/* loaded from: classes7.dex */
public class FAUFaceBox {
    float angle;
    float height;
    float width;
    float x;
    float y;

    public FAUFaceBox(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public float getAngle() {
        return this.angle;
    }

    public float getHeight() {
        return this.height;
    }

    public float getWidth() {
        return this.width;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public FAUFaceBox(float f, float f2, float f3, float f4, float f5) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
        this.angle = f5;
    }
}
