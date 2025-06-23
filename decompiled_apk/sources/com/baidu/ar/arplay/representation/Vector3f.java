package com.baidu.ar.arplay.representation;

/* loaded from: classes7.dex */
public class Vector3f extends Renderable {
    private static final long serialVersionUID = -4565578579900616220L;
    protected float[] points;

    public Vector3f() {
        this.points = new float[3];
    }

    public void add(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + f;
        fArr[1] = fArr[1] + f;
        fArr[2] = fArr[2] + f;
    }

    public void clone(Vector3f vector3f) {
        System.arraycopy(vector3f.points, 0, this.points, 0, 3);
    }

    public Vector3f crossProduct(Vector3f vector3f) {
        Vector3f vector3f2 = new Vector3f();
        crossProduct(vector3f, vector3f2);
        return vector3f2;
    }

    public float dotProduct(Vector3f vector3f) {
        float[] fArr = this.points;
        float f = fArr[0];
        float[] fArr2 = vector3f.points;
        return (f * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]);
    }

    public float getLength() {
        float[] fArr = this.points;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
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

    public void multiplyByScalar(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f;
        fArr[2] = fArr[2] * f;
    }

    public void normalize() {
        float[] fArr = this.points;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        float[] fArr2 = this.points;
        fArr2[0] = (float) (fArr2[0] / sqrt);
        fArr2[1] = (float) (fArr2[1] / sqrt);
        fArr2[2] = (float) (fArr2[2] / sqrt);
    }

    public void setX(float f) {
        this.points[0] = f;
    }

    public void setXYZ(float f, float f2, float f3) {
        float[] fArr = this.points;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
    }

    public void setY(float f) {
        this.points[1] = f;
    }

    public void setZ(float f) {
        this.points[2] = f;
    }

    public void subtract(Vector3f vector3f) {
        float[] fArr = this.points;
        float f = fArr[0];
        float[] fArr2 = vector3f.points;
        fArr[0] = f - fArr2[0];
        fArr[1] = fArr[1] - fArr2[1];
        fArr[2] = fArr[2] - fArr2[2];
    }

    public float[] toArray() {
        return this.points;
    }

    public String toString() {
        return "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2];
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

    public Vector3f(float f) {
        this.points = r0;
        float[] fArr = {f, f, f};
    }

    public void add(Vector3f vector3f) {
        float[] fArr = this.points;
        float f = fArr[0];
        float[] fArr2 = vector3f.points;
        fArr[0] = f + fArr2[0];
        fArr[1] = fArr[1] + fArr2[1];
        fArr[2] = fArr[2] + fArr2[2];
    }

    public void clone(float[] fArr) {
        System.arraycopy(fArr, 0, this.points, 0, 3);
    }

    public void crossProduct(Vector3f vector3f, Vector3f vector3f2) {
        float[] fArr = this.points;
        float f = fArr[1];
        float[] fArr2 = vector3f.points;
        vector3f2.setX((f * fArr2[2]) - (fArr[2] * fArr2[1]));
        float[] fArr3 = this.points;
        float f2 = fArr3[2];
        float[] fArr4 = vector3f.points;
        vector3f2.setY((f2 * fArr4[0]) - (fArr3[0] * fArr4[2]));
        float[] fArr5 = this.points;
        float f3 = fArr5[0];
        float[] fArr6 = vector3f.points;
        vector3f2.setZ((f3 * fArr6[1]) - (fArr5[1] * fArr6[0]));
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

    public Vector3f(float f, float f2, float f3) {
        this.points = r0;
        float[] fArr = {f, f2, f3};
    }

    public Vector3f(Vector3f vector3f) {
        this.points = r0;
        float[] fArr = vector3f.points;
        float[] fArr2 = {fArr[0], fArr[1], fArr[2]};
    }

    public Vector3f(Vector4f vector4f) {
        this.points = new float[3];
        if (vector4f.w() != 0.0f) {
            this.points[0] = vector4f.x() / vector4f.w();
            this.points[1] = vector4f.y() / vector4f.w();
            this.points[2] = vector4f.z() / vector4f.w();
        } else {
            this.points[0] = vector4f.x();
            this.points[1] = vector4f.y();
            this.points[2] = vector4f.z();
        }
    }
}
