package com.baidu.ar.arplay.representation;

/* loaded from: classes7.dex */
public class EulerAngles {
    private float pitch;
    private float roll;
    private float yaw;

    public EulerAngles(float f, float f2, float f3) {
        this.yaw = f;
        this.pitch = f2;
        this.roll = f3;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getRoll() {
        return this.roll;
    }

    public float getYaw() {
        return this.yaw;
    }
}
