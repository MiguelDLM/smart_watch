package com.baidu.ar.arplay.representation;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class Vector4f extends Renderable implements Serializable {
    private static final long serialVersionUID = 1;
    protected float[] points;

    public Vector4f() {
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.points = fArr;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
    }

    public void add(Vector3f vector3f, float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + vector3f.x();
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] + vector3f.y();
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] + vector3f.z();
        float[] fArr4 = this.points;
        fArr4[3] = fArr4[3] + f;
    }

    public boolean compareTo(Vector4f vector4f) {
        float[] fArr = this.points;
        float f = fArr[0];
        float[] fArr2 = vector4f.points;
        return f == fArr2[0] && fArr[1] == fArr2[1] && fArr[2] == fArr2[2] && fArr[3] == fArr2[3];
    }

    public void copyFromV3f(Vector3f vector3f, float f) {
        this.points[0] = vector3f.x();
        this.points[1] = vector3f.y();
        this.points[2] = vector3f.z();
        this.points[3] = f;
    }

    public void copyVec4(Vector4f vector4f) {
        float[] fArr = this.points;
        float[] fArr2 = vector4f.points;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = fArr2[3];
    }

    public float dotProduct(Vector4f vector4f) {
        float[] fArr = this.points;
        float f = fArr[0];
        float[] fArr2 = vector4f.points;
        return (f * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]) + (fArr[3] * fArr2[3]);
    }

    public float getW() {
        return this.points[3];
    }

    public float getX() {
        return this.points[0];
    }

    public float getY() {
        return this.points[1];
    }

    public float getZ() {
        return this.points[2];
    }

    public void lerp(Vector4f vector4f, Vector4f vector4f2, float f) {
        float[] fArr = vector4f2.points;
        float[] fArr2 = this.points;
        float f2 = 1.0f * f;
        float f3 = fArr2[0] * f2;
        float[] fArr3 = vector4f.points;
        fArr[0] = f3 + (fArr3[0] * f);
        fArr[1] = (fArr2[1] * f2) + (fArr3[1] * f);
        fArr[2] = (fArr2[2] * f2) + (fArr3[2] * f);
        fArr[3] = (fArr2[3] * f2) + (fArr3[3] * f);
    }

    public void multiplyByScalar(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f;
        fArr[2] = fArr[2] * f;
        fArr[3] = fArr[3] * f;
    }

    public void normalize() {
        float[] fArr = this.points;
        float f = fArr[3];
        if (f == 0.0f) {
            return;
        }
        fArr[0] = fArr[0] / f;
        fArr[1] = fArr[1] / f;
        fArr[2] = fArr[2] / f;
        double sqrt = Math.sqrt((r3 * r3) + (r5 * r5) + (r7 * r7));
        float[] fArr2 = this.points;
        fArr2[0] = (float) (fArr2[0] / sqrt);
        fArr2[1] = (float) (fArr2[1] / sqrt);
        fArr2[2] = (float) (fArr2[2] / sqrt);
    }

    public void setW(float f) {
        this.points[3] = f;
    }

    public void setX(float f) {
        this.points[0] = f;
    }

    public void setXYZW(float f, float f2, float f3, float f4) {
        float[] fArr = this.points;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
    }

    public void setY(float f) {
        this.points[1] = f;
    }

    public void setZ(float f) {
        this.points[2] = f;
    }

    public void subdivide(Vector4f vector4f) {
        float[] fArr = this.points;
        float f = fArr[0];
        float[] fArr2 = vector4f.points;
        fArr[0] = f / fArr2[0];
        fArr[1] = fArr[1] / fArr2[1];
        fArr[2] = fArr[2] / fArr2[2];
        fArr[3] = fArr[3] / fArr2[3];
    }

    public void subtract(Vector4f vector4f) {
        float[] fArr = this.points;
        float f = fArr[0];
        float[] fArr2 = vector4f.points;
        fArr[0] = f - fArr2[0];
        fArr[1] = fArr[1] - fArr2[1];
        fArr[2] = fArr[2] - fArr2[2];
        fArr[3] = fArr[3] - fArr2[3];
    }

    public float[] toArray() {
        return this.points;
    }

    public String toString() {
        return "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2] + " W:" + this.points[3];
    }

    public float w() {
        return this.points[3];
    }

    public float x() {
        return this.points[0];
    }

    public float y() {
        return this.points[1];
    }

    public float z() {
        return this.points[2];
    }

    public Vector4f(float f, float f2, float f3, float f4) {
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.points = fArr;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
    }

    public void add(Vector4f vector4f) {
        float[] fArr = this.points;
        float f = fArr[0];
        float[] fArr2 = vector4f.points;
        fArr[0] = f + fArr2[0];
        fArr[1] = fArr[1] + fArr2[1];
        fArr[2] = fArr[2] + fArr2[2];
        fArr[3] = fArr[3] + fArr2[3];
    }

    public void subtract(Vector4f vector4f, Vector4f vector4f2) {
        float[] fArr = this.points;
        float f = fArr[0];
        float[] fArr2 = vector4f.points;
        vector4f2.setXYZW(f - fArr2[0], fArr[1] - fArr2[1], fArr[2] - fArr2[2], fArr[3] - fArr2[3]);
    }

    public void w(float f) {
        this.points[3] = f;
    }

    public void x(float f) {
        this.points[0] = f;
    }

    public void y(float f) {
        this.points[1] = f;
    }

    public void z(float f) {
        this.points[2] = f;
    }

    public Vector4f(Vector3f vector3f, float f) {
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.points = fArr;
        fArr[0] = vector3f.x();
        this.points[1] = vector3f.y();
        this.points[2] = vector3f.z();
        this.points[3] = f;
    }
}
