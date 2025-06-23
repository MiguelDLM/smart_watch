package com.baidu.ar.arplay.core.engine.engine3d;

/* loaded from: classes7.dex */
public interface IARPCamera extends IARPNode {
    float getFieldOfView();

    float[] getViewMatrix();

    float getZFar();

    float getZNear();

    void setFieldOfView(float f);

    void setViewMatrix(float[] fArr);

    void setZFar(float f);

    void setZNear(float f);
}
